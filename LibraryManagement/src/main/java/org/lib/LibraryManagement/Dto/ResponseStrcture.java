package org.lib.LibraryManagement.Dto;

public class ResponseStrcture<T> {
	private  int StatusCode;
	private String  message;
	private T data;
	
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
