package web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import web.view.bean.UserInfo;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.gson.Gson;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private Producer captchaProducer;
	
	// 不指定为则/main对应这个方法
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpSession session) {
		session.setAttribute("userName", "mu");
		
		return "index";
	}
	
	@RequestMapping(value = "/getSession", method = RequestMethod.GET)
	public String getSession(HttpSession session) {
		System.out.println(session.getAttribute("userName"));
		return "index";
	}
	
	// 返回json视图
	@RequestMapping("/getJson")
	@ResponseBody
	public Object getJson(Map map) {
		map.put("data", "json测试");
		throw new RuntimeException();
		//return 1;
	}

	// 返回excel视图
	@RequestMapping("/getExcel")
	public String getExcel(ModelMap map) {
		List<String> title = new ArrayList<String>();
		title.add("姓名");
		title.add("性别");
		title.add("备注");
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> d1 = new ArrayList<String>();
		d1.add("mu");
		d1.add("男");
		d1.add("备注1");
		List<String> d2 = new ArrayList<String>();
		d2.add("smell");
		d2.add("女");
		d2.add("备注2");
		data.add(d1);
		data.add(d2);
		map.put("title", title);
		map.put("data", data);
		return "excel";
	}

	// 返回json视图
	@RequestMapping("/getUser")
	public String getUser(Map map,UserInfo userInfo) {
		map.put("data", userInfo);
		return "json";
	}
	
	// 返回json视图
	@RequestMapping("/getUser2")
	@ResponseBody
	public Object getUser2(Map map,@RequestBody UserInfo userInfo) {
		return userInfo;
	}

	// 上传文件
	@RequestMapping("upload")
	public String upload() {
		return "upload";
	}

	// 处理文件
	// 要指定@RequestParam参数名，否则会初始化不了MultipartFile类型参数
	@RequestMapping("saveFile")
	public String saveFile(@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			File toFile = new File("D:/temp/" + file.getOriginalFilename());
			file.transferTo(toFile);
		}
		return "saveFile";
	}
	
	@RequestMapping("/getParam")
	public Object getParam(@RequestParam("id") int id){
		return "1";
	}
	
	@RequestMapping("/valimg")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		System.out.println(capText);
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
}
