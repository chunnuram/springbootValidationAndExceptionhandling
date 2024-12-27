package com.validations.dto.response;

import org.springframework.http.HttpStatus;

public class SuccessReponse {
  
	String message;
	HttpStatus status;
	Object Data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	
}
