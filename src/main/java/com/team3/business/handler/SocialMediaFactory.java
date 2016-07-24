package com.team3.business.handler;

import org.springframework.stereotype.Service;

@Service("SocialMediaFactory")
public class SocialMediaFactory {

	 public ISocialMediaHandler getHandler(SocialMediaTypes HandlerType){
		 
		 switch(HandlerType){
		 case EmailHandler:
			 return new EmailHandler();
		 case FacebookHandler:
			 return new FacebookHandler();	 
		 case TwitterHandler:
			 return new TwitterHandler();
		 default:
			 return new TwitterHandler();
		 }	      
	   }
	
	}