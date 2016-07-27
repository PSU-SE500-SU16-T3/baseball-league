package com.team3.business.handler;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.team3.business.exception.BaseballLeagueException;
import com.team3.business.exception.ExceptionMessages;

public class EmailHandler implements ISocialMediaHandler   {

	//found the old email and password
	private String userName = "baseballeagie1234@gmail.com";////baseballlegue@gmail.com
	private String password = "hihihihihi"; ///somePass1
	private Email email = new SimpleEmail();
	
	private final String SUBJECT = "DO NOT REPLY: Baseball League Notification Mail.";
	
	
	

	public void writeEmail(String toLine, String subject, String message)throws BaseballLeagueException {
		try {
			//we need to ensure tha SSL Connect is set to true as well as Hot name and SMTP port, otherwose we will get an exception
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setSSLOnConnect(true);
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
	
	public void sendEmail(String toLine, String message) {
		try {
			this.userName = userName;
			this.password = password;
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setSSLOnConnect(true);
			this.writeEmail(toLine, this.SUBJECT, message);
		} catch (BaseballLeagueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PostStatus(String Post) {

		// method stub, cant post generic email
		
	}

	public void getStatuses(int NumberofPreviousStatuses) {
		// TODO Auto-generated method stub
		
	}

}
