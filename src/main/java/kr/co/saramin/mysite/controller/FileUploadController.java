package kr.co.saramin.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saramin.mysite.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("/form")
	public String form() {
		return "fileupload/form";
	}
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("email") String email, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, Model model) {
		System.out.println(email);
		
		String saveFileName1 = fileUploadService.saveFile(file1);
		String url1 = "/upload-images/" + saveFileName1;
		model.addAttribute("urlImage1", url1);
		
		String saveFileName2 = fileUploadService.saveFile(file2);
		String url2 = "/upload-images/" + saveFileName2;
		model.addAttribute("urlImage2", url2);
		
		return "fileupload/result";
	}
}
