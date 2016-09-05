package kr.co.saramin.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.vo.GuestbookVo;
import kr.co.saramin.mysite.vo.UserVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/guestbook/list.jsp";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform(Model model, @RequestParam("no") int no) {
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/guestbook/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		guestbookService.delete(guestbookVo);
		
		return "redirect:/guestbook/list";
	}
}
