package com.team3.business.handler;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.team3.business.exception.BaseballLeagueException;
import com.team3.business.exception.ExceptionMessages;

public class EmailHandler {

	private String userName; //baseballeagie1234@gmail.com
	private String password; //hihihihihi
	private Email email = new SimpleEmail();
	
	private final String SUBJECT = "DO NOT REPLY: Baseball League Notification Mail.";
	
	public EmailHandler(String userName, String password) {
		this.userName = userName;
		this.password = password;
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
	}
	
	public void sendEmail(String toLine, String subject, String message)throws BaseballLeagueException {
		try {

			email.setAuthentication(userName, password);
			email.setFrom(userName);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(toLine);
			email.send();
		}
		catch (EmailException e) { 
			e.printStackTrace();
			throw new BaseballLeagueException(ExceptionMessages.EMAIL_EXCEPTION_MESSAGE, ExceptionMessages.EMAIL_EXCEPTION_TITLE);
		}
	}
	
	public void sendEmail(String toLine, String message) throws BaseballLeagueException {
		this.sendEmail(toLine, this.SUBJECT, message);
	}
}
