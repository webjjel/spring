package kr.co.saramin.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite.dto.JSONResult;
import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.UserVo;

@Controller("UserApiController")
@RequestMapping("/user/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkEmail(@RequestParam(value="email", required=false, defaultValue="") String email) {
		
		UserVo userVo = userService.getUser(email);
		Boolean result = userVo == null; // true -> 사용중이 아님, false -> 사용중임
		
		return new JSONResult(true, result);
	}
}
