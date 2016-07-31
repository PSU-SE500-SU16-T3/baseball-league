package com.team3.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.exception.BaseballLeagueException;
import com.team3.business.handler.EmailHandler;
import com.team3.business.handler.FacebookHandler;
import com.team3.business.handler.ISocialMediaHandler;
import com.team3.business.handler.SocialMediaFactory;
import com.team3.business.handler.SocialMediaTypes;
import com.team3.business.handler.TwitterHandler;

import facebook4j.FacebookException;
import twitter4j.TwitterException;

public class SocialMediaControllerTest {
	
	SocialMediaController socialMediaController;
	SocialMediaFactory mockSocialMediaFactory;
	
	@Before  
    public void setUp() {  
		mockSocialMediaFactory = EasyMock.createMock(SocialMediaFactory.class);
		socialMediaController = new SocialMediaController();
		socialMediaController.setSocialmediafactory(mockSocialMediaFactory);
    }  
  
    @After  
    public void tearDown() {  
    	mockSocialMediaFactory = null; 
    }
    
    @Test
    public void testPostmessageIfTwitter() throws BaseballLeagueException, TwitterException, FacebookException { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(TwitterHandler.class);
    	
    	EasyMock.expect(mockArguments.get("service")).andReturn("twitter").anyTimes();  
    	EasyMock.expect(mockArguments.get("message")).andReturn("xyz").anyTimes();  
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockSocialMediaFactory.getHandler(SocialMediaTypes.TwitterHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
    	EasyMock.replay(mockSocialMediaFactory);
    	
    	mockISocialMediaHandler.PostStatus(EasyMock.isA(String.class)); 
    	EasyMock.expectLastCall();
    	
    	EasyMock.replay(mockISocialMediaHandler);
    	
    	socialMediaController.Postmessage(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(mockSocialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
    
    @Test
    public void testPostmessageIfFacebook() throws BaseballLeagueException, TwitterException, FacebookException { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(FacebookHandler.class);
    	
    	EasyMock.expect(mockArguments.get("service")).andReturn("facebook").anyTimes();  
    	EasyMock.expect(mockArguments.get("message")).andReturn("xyz").anyTimes();  
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockSocialMediaFactory.getHandler(SocialMediaTypes.FacebookHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
    	EasyMock.replay(mockSocialMediaFactory);
    	
    	mockISocialMediaHandler.PostStatus(EasyMock.isA(String.class)); 
    	EasyMock.expectLastCall();
    	
    	EasyMock.replay(mockISocialMediaHandler);
    	
    	socialMediaController.Postmessage(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(mockSocialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
    
    @Test
    public void testPostmessageIfEmail() throws BaseballLeagueException, TwitterException, FacebookException { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(EmailHandler.class);
    	
    	EasyMock.expect(mockArguments.get("service")).andReturn("email").anyTimes();  
    	EasyMock.expect(mockArguments.get("message")).andReturn("xyz").anyTimes();  
    	EasyMock.expect(mockArguments.get("emails")).andReturn("xyz@gmail.com").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockSocialMediaFactory.getHandler(SocialMediaTypes.EmailHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
    	EasyMock.replay(mockSocialMediaFactory);
    	
    	mockISocialMediaHandler.sendEmail(EasyMock.isA(String.class),EasyMock.isA(String.class)); 
    	EasyMock.expectLastCall();
    	
    	EasyMock.replay(mockISocialMediaHandler);
    	
    	socialMediaController.Postmessage(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(mockSocialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
    
    @Test(expected=BaseballLeagueException.class)
    public void testPostmessageIfNoHandlerFound() throws BaseballLeagueException, TwitterException, FacebookException{ 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(mockArguments.get("service")).andReturn("xyz").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	socialMediaController.Postmessage(mockArguments);
        
        EasyMock.verify(mockArguments);
    }
}
