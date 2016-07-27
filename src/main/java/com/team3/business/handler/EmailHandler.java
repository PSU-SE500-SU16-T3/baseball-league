package com.team3.business.handler;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHandler implements ISocialMediaHandler   {

	
	private String userName = "baseballlegue@gmail.com";
	private String password = "somePass1"; 
	
	private final String SUBJECT = "DO NOT REPLY: Baseball League Notification Mail.";
	
	
	public void sendEmail(String toLine, String message) {


		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		  });

		try {

			Message messageObj = new MimeMessage(session);
			messageObj.setFrom(new InternetAddress(userName));
			messageObj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toLine));
			messageObj.setSubject(SUBJECT);
			messageObj.setText(message);

			Transport.send(messageObj);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void PostStatus(String Post) {

		// method stub, cant post generic email
		
	}

	public void getStatuses(int NumberofPreviousStatuses) {
		// TODO Auto-generated method stub
		
	}

}
