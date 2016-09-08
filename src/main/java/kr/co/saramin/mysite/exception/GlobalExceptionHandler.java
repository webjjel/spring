package kr.co.saramin.mysite.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserDaoException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleUserDaoException(HttpServletRequest request, Exception ex) {
		//String accept = request.getHeader("Accept");
		System.out.println("logging:" + ex);
		return "error/500";
	}
}
