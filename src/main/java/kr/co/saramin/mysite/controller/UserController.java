package kr.co.saramin.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.saramin.mysite.service.UserService;
import kr.co.saramin.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "/WEB-INF/views/user/joinform.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);
		return "redirect:/user/loginform";
	}
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "/WEB-INF/views/user/loginform.jsp";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		UserVo authUser = userService.login(userVo);
		if (authUser == null) {
			return "redirect:/user/loginform?result=fail";
		}
		
		// 인증처리
		session.setAttribute("authUser", authUser);
		
		// 리디렉션
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/index";
	}
}
