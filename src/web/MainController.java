package web;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
@RequestMapping("/main")
public class MainController {
	
	//不指定为则/main对应这个方法
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping("/getJson")
	public String getJson(Map map){
		map.put("data", "json测试");
		return "json";
	}
	
	//上传文件
	@RequestMapping("upload")
	public String upload(){
		return "upload";
	}
	
	//处理文件
	//要指定@RequestParam参数名，否则会初始化不了MultipartFile类型参数
	@RequestMapping("saveFile")
	public String saveFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		if(!file.isEmpty()){
			File toFile=new File("D:/temp/"+file.getOriginalFilename());
			file.transferTo(toFile);
		}
		return "saveFile";
	}
}
