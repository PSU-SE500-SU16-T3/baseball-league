package com.team3.business.exception;

@SuppressWarnings("serial")
public class BaseballLeagueException extends Exception {
	
	private String message;
	private String title;
	
	public BaseballLeagueException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public BaseballLeagueException(String message, String title) {
		super(message + " - "+title);
		this.setMessage(message);
		this.setTitle(title);
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
