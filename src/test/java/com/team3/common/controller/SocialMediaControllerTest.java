package com.team3.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.handler.EmailHandler;
import com.team3.business.handler.FacebookHandler;
import com.team3.business.handler.ISocialMediaHandler;
import com.team3.business.handler.SocialMediaFactory;
import com.team3.business.handler.SocialMediaTypes;
import com.team3.business.handler.TwitterHandler;

public class SocialMediaControllerTest {
	SocialMediaController socialMediaController;
	SocialMediaFactory socialMediaFactory;
	
	@Before  
    public void setUp() {  
		socialMediaFactory = EasyMock.createMock(SocialMediaFactory.class);
		socialMediaController = new SocialMediaController();
		socialMediaController.setSocialmediafactory(socialMediaFactory);
    }  
  
    @After  
    public void tearDown() {  
    	socialMediaFactory = null; 
    }
    
    @Test
    public void testPostTwitter() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(TwitterHandler.class);
    	
    	EasyMock.expect(mockArguments.get("Message")).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(socialMediaFactory.getHandler(SocialMediaTypes.TwitterHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
        EasyMock.replay(socialMediaFactory);
        
        mockISocialMediaHandler.PostStatus(mockArguments.get("Message"));
        EasyMock.expectLastCall().anyTimes();
        
        EasyMock.replay(mockISocialMediaHandler);
        
        socialMediaController.PostTwitter(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(socialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
    
    @Test
    public void testPostFacebook() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(FacebookHandler.class);
    	
    	EasyMock.expect(mockArguments.get("Message")).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(socialMediaFactory.getHandler(SocialMediaTypes.FacebookHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
        EasyMock.replay(socialMediaFactory);
        
        mockISocialMediaHandler.PostStatus(mockArguments.get("Message"));
        EasyMock.expectLastCall().anyTimes();
        
        EasyMock.replay(mockISocialMediaHandler);
        
        socialMediaController.PostFacebook(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(socialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
    
    @Test
    public void testPostEmail() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	ISocialMediaHandler mockISocialMediaHandler = EasyMock.createMock(EmailHandler.class);
    	
    	EasyMock.expect(mockArguments.get("Message")).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(socialMediaFactory.getHandler(SocialMediaTypes.EmailHandler)).andReturn(mockISocialMediaHandler).anyTimes();  
        EasyMock.replay(socialMediaFactory);
        
        mockISocialMediaHandler.PostStatus(mockArguments.get("Message"));
        EasyMock.expectLastCall().anyTimes();
        
        EasyMock.replay(mockISocialMediaHandler);
        
        socialMediaController.PostEmail(mockArguments);
        
        EasyMock.verify(mockArguments);
        EasyMock.verify(socialMediaFactory);
        EasyMock.verify(mockISocialMediaHandler);
    }
}
