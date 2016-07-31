package com.team3.business.handler;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;

public class FacebookHandlerTest {

	FacebookHandler facebookHandler;
	
	@Before  
    public void setUp() {  
		facebookHandler = new FacebookHandler();
    }  
  
    @After  
    public void tearDown() {  
    	facebookHandler = null; 
    }
    
    @Test
    public void testPostStatus() throws Exception {
    	String mockPost = "xyz1";
    	Facebook mockFacebook = EasyMock.createMock(Facebook.class);
    	
    	FacebookHandler mockFacebookHandler = EasyMock.createMockBuilder(FacebookHandler.class)
    			.addMockedMethod("getfacebook")
    			.createMock();
        EasyMock.expect(mockFacebookHandler.getfacebook()).andReturn(mockFacebook).anyTimes();
        EasyMock.replay(mockFacebookHandler);
    	
    	EasyMock.expect(mockFacebook.postStatusMessage(EasyMock.isA(String.class))).andReturn("abc").anyTimes();    	
    	EasyMock.replay(mockFacebook);    	
      
    	mockFacebookHandler.PostStatus(mockPost);   
        
    	EasyMock.verify(mockFacebookHandler);
        EasyMock.verify(mockFacebook);
    }
    
    @Test
    public void testGetfacebook() throws Exception {
      
    	Facebook response = facebookHandler.getfacebook();
    	
    	assertEquals(new FacebookFactory().getInstance().getClass(), response.getClass());
    }
}
