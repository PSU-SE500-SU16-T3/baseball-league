package com.team3.business.models;

public class Response<T> {
	private String status;
	private String redirectTo;
	private T t;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRedirectTo() {
		return redirectTo;
	}
	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}
	public T getBody() {
		return t;
	}
	public void setBody(T t) {
		this.t = t;
	}
	
	
}
