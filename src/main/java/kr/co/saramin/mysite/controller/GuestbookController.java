package kr.co.saramin.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.getList();
		
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@RequestMapping("/ajax")
	public String ajax() {
		return "guestbook/ajax";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo guestbookVo) {
		guestbookService.insert(guestbookVo);
		
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no) {
		
		return "guestbook/deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		guestbookService.delete(guestbookVo);
		
		return "redirect:/guestbook";
	}
}
