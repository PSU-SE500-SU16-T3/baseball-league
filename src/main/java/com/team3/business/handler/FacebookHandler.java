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
		String accessTokenString = "EAAD2W3NJEF4BAKAkkQ7NiuTZAqnNwzzWVLEu1Id348ZB0MOkmIzTQi98mKFJNv9AdA2nNGXHkPfhnmX7PHavgjScLVVa0DBtTn4dFWTxtiJfglCyI4lRLFTS05ql1xIZB7Qm81OuPXkqeDM8ki8fsVZCV9IKISYZD";
		AccessToken at = new AccessToken(accessTokenString);
		facebook.setOAuthAccessToken(at);
		facebook.setOAuthPermissions("manage_pages, publish_pages");
		
		return facebook;
	}

}
