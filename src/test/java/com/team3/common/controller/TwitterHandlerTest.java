package com.team3.common.controller;

import com.team3.business.handler.EmailHandler;
import com.team3.business.handler.TwitterHandler;

public class TwitterHandlerTest {

	TwitterHandler twitterHandler;
	
	@Before  
    public void setUp() {  
		twitterHandler = EasyMock.createMock(TwitterHandler.class);
    }  
  
    @After  
    public void tearDown() {  
    	twitterHandler = null; 
    }
    
    @Test
    public void testPostStatus() { 
    	String mockPost = EasyMock.createMock(String.class);
    	
    	EasyMock.expect(mockPost).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockPost);
      
        twitterHandler.PostStatus(mockPost);
        
        EasyMock.verify(mockPost);
    }
    
    @Test
    public void testGetStatuses() { 
    	int mockNumberofPreviousStatuses = EasyMock.createMock(int.class);
    	
    	EasyMock.expect(mockNumberofPreviousStatuses).andReturn(1).anyTimes();  
        EasyMock.replay(mockNumberofPreviousStatuses);
      
        twitterHandler.getStatuses(mockNumberofPreviousStatuses);
        
        EasyMock.verify(mockNumberofPreviousStatuses);
    }
    
    
}
