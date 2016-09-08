package kr.co.saramin.mysite.dto;

public class JSONResult {
	private String result;		// success or fail
	private String message;		// fail message
	private Object data;		// data
	
	public JSONResult(Boolean result, String message, Object data) {
		this.result = result ? "success" : "fail";
		this.message = message;
		this.data = data;
	}
	
	public JSONResult(Boolean result, Object data) {
		this.result = result ? "success" : "fail";
		this.data = data;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
