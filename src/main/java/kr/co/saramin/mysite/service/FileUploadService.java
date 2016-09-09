package kr.co.saramin.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saramin.mysite.exception.FileUploadServiceException;

@Service
public class FileUploadService {
	
	public String saveFile(MultipartFile multipartFile) {
		if (multipartFile.isEmpty()) {
			throw new FileUploadServiceException("Upload File Empty");
		}
		
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length());
		String saveFileName = genSaveFileName(extName);
		
		System.out.println(originalFileName);
		System.out.println(extName);
		System.out.println(saveFileName);
		
		writeFile(multipartFile, saveFileName);
		
		return saveFileName;
	}
	
	private void writeFile(MultipartFile file, String fileName) throws FileUploadServiceException {
		String savePath = "/upload/" + fileName;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(savePath);
			
			byte[] data = file.getBytes();
			fos.write(data);
		} catch (IOException e) {
			throw new FileUploadServiceException("error" + e);
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				throw new FileUploadServiceException("error" + e);
			}
		}
	}
	
	private String genSaveFileName(String extName) {
		Calendar calendar = Calendar.getInstance();
		
		String saveFileName = "";
		saveFileName += calendar.get(Calendar.YEAR);
		saveFileName += calendar.get(Calendar.MONTH);
		saveFileName += calendar.get(Calendar.DATE);
		saveFileName += calendar.get(Calendar.HOUR);
		saveFileName += calendar.get(Calendar.MINUTE);
		saveFileName += calendar.get(Calendar.SECOND);
		saveFileName += calendar.get(Calendar.MILLISECOND);
		
		return saveFileName + "." + extName;
	}
}
