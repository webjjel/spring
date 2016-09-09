package kr.co.saramin.mysite.exception;

public class FileUploadServiceException extends RuntimeException {
	private static final long serialVersionUID = -1208115281300393503L;
	
	public FileUploadServiceException(String message) {
		super(message);
	}
	
	public FileUploadServiceException() {
		super("FileUploadServiceException Occurs");
	}
}
