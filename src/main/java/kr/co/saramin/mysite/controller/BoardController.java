package kr.co.saramin.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.saramin.mysite.service.BoardService;
import kr.co.saramin.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("")
	public String list(Model model, @RequestParam(value="kwd", required=false) String kwd) {
		List<BoardVo> list = boardService.getList(kwd);
		
		model.addAttribute("kwd", kwd);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("/view")
	public String view(Model model, @RequestParam("no") Long no) {
		BoardVo vo = boardService.view(no);
		model.addAttribute("no", no);
		model.addAttribute("title", vo.getTitle());
		model.addAttribute("content", vo.getContent());
		return "board/view";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(Model model, @RequestParam("no") Long no) {
		BoardVo vo = boardService.view(no);
		model.addAttribute("no", no);
		model.addAttribute("title", vo.getTitle());
		model.addAttribute("content", vo.getContent());
		return "board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute BoardVo boardVo) {
		boardService.modify(boardVo);
		return "redirect:/board";
	}
	
	@RequestMapping("/writeform")
	public String writeform() {
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo) {
		// 임시 데이터
		boardVo.setUserNo((long) 1);
		boardService.write(boardVo);
		return "redirect:/board";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute BoardVo boardVo) {
		boardService.delete(boardVo);
		return "redirect:/board";
	}
}
