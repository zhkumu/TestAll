package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/getJson")
	@ResponseBody
	public Object getJson(){
		Gson gson=new Gson();
		return gson.toJson("this is json");
	}
}
