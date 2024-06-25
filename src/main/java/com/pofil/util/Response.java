package com.pofil.util;

public class Response {
	private String message;
	private boolean status;
	private Object data;
	
	public Response() {
	}
	public Response(String message, boolean status, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}