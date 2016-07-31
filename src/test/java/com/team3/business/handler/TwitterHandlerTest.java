package com.team3.business.handler;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterHandlerTest {

	TwitterHandler twitterHandler;
	
	@Before  
    public void setUp() {  
		twitterHandler = new TwitterHandler();
    }  
  
    @After  
    public void tearDown() {  
    	//twitterHandler = null; 
    }
    
    @Test
    public void testPostStatus() throws Exception {
    	String mockPost = "xyz";
    	Twitter mockTwitter = EasyMock.createMock(Twitter.class);
    	Status mockStatus = EasyMock.createMock(Status.class);
    	
    	TwitterHandler mockTwitterHandler = EasyMock.createMockBuilder(TwitterHandler.class)
    			.addMockedMethod("getTwitter")
    			.createMock();
        EasyMock.expect(mockTwitterHandler.getTwitter()).andReturn(mockTwitter).anyTimes();
        EasyMock.replay(mockTwitterHandler);
    	
    	EasyMock.expect(mockTwitter.updateStatus(mockPost)).andReturn(mockStatus).anyTimes();    	
    	EasyMock.replay(mockTwitter);    	
      
    	mockTwitterHandler.PostStatus(mockPost);   
        
        EasyMock.verify(mockTwitterHandler);
        EasyMock.verify(mockTwitter);
    }
    
    @Test
    public void testGetTwitter() throws Exception {
      
        Twitter response = twitterHandler.getTwitter();
        
        assertEquals((new TwitterFactory((new ConfigurationBuilder()).build()).getInstance().getClass()), response.getClass());
    }
}
