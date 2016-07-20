package com.team3.business.handler;
enum HandlerType {TwitterHandler, FacebookHandler, EmailHandler}
public class SocialMediaFactory {
	 public ISocialMediaHandler getHandler(HandlerType HandlerType){
		 
		 switch(HandlerType){
		 case EmailHandler:
			 return new EmailHandler();
		 case FacebookHandler:
			 return new FacebookHandler();	 
		 case TwitterHandler:
			 return new TwitterHandler();
		 default:
			 return null;
		 }	      
	   }
	
	}