package com.team3.business.handler;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class FacebookHandler implements ISocialMediaHandler {

	public void PostStatus(String Post) {
		Facebook facebook = getfacebook();
		try {
			facebook.postStatusMessage(Post);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void getStatuses(int NumberofPreviousStatuses) {
		// TODO Auto-generated method stub
		
	}
	
	private Facebook getfacebook(){
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("270872636624990", "405765261426f0d5f39ec51dd3ed4953");
		String accessTokenString = "EAACEdEose0cBAH92UzpMXvODUhMoHmyYHmFyCVTT88oRVZAfT3gxZCc7A3CQBLCEQTYN3rfZC1AAV9G5gUmpTMJe8E0HUhdNAvyOscGZAIx3aksFIZC7nZAcGG9XBv3UqK4MXEASIsUZBlhYWe15fCMZCElSxo8kiOFCyUxbzIIWnAZDZD";
		AccessToken at = new AccessToken(accessTokenString);
		facebook.setOAuthAccessToken(at);
		return facebook;
	}

}
