package kr.co.saramin.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.saramin.mysite.dto.JSONResult;
import kr.co.saramin.mysite.service.GuestbookService;
import kr.co.saramin.mysite.vo.GuestbookVo;

@Controller("GuestbookApiController")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(@RequestBody GuestbookVo vo) {
		System.out.println(vo);
		guestbookService.insert(vo);
		System.out.println(vo);
//		guestbookService.getMessage(vo.getNo());
		
		return new JSONResult(true, null);
	}
}
