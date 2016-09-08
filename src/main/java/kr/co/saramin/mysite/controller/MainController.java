package kr.co.saramin.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String index() {
		return "main/index";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "안녕";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public Object ajax() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "안대혁");
		map.put("value", new Integer(1));
		
		return map;
	}
}
