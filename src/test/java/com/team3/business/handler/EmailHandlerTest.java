package com.team3.business.handler;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.exception.BaseballLeagueException;
import com.team3.business.handler.EmailHandler;

public class EmailHandlerTest {

	EmailHandler emailHandler;
	
	@Before  
    public void setUp() {  
		emailHandler = EasyMock.createMock(EmailHandler.class);
    }  
  
    @After  
    public void tearDown() {  
    	emailHandler = null; 
    }
    
    //@Test
    public void testSendEmail() throws BaseballLeagueException { 
    	String mockToLine = EasyMock.createMock(String.class);
    	String mockSubject = EasyMock.createMock(String.class);
    	String mockMessage = EasyMock.createMock(String.class);
    	
    	EasyMock.expect(mockToLine).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockToLine);
        
        EasyMock.expect(mockSubject).andReturn("ZZZ").anyTimes();  
        EasyMock.replay(mockSubject);
        
        EasyMock.expect(mockSubject).andReturn("XXX").anyTimes();  
        EasyMock.replay(mockSubject);
      
        //emailHandler.writeEmail(mockToLine, mockSubject, mockMessage);
        
        EasyMock.verify(mockToLine);
        EasyMock.verify(mockSubject);
        EasyMock.verify(mockMessage);
    }
    
    //@Test
    public void testSendEmail2() throws BaseballLeagueException { 
    	String mockToLine = EasyMock.createMock(String.class);
    	String mockMessage = EasyMock.createMock(String.class);
    	
    	EasyMock.expect(mockToLine).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockToLine);
        
        EasyMock.expect(mockMessage).andReturn("XXX").anyTimes();  
        EasyMock.replay(mockMessage);
      
        emailHandler.sendEmail(mockToLine, mockMessage);
        
        EasyMock.verify(mockToLine);
        EasyMock.verify(mockMessage);
    }
    
    //@Test
    public void testPostStatus() { 
    	String mockPost = EasyMock.createMock(String.class);
    	
    	EasyMock.expect(mockPost).andReturn("XYZ").anyTimes();  
        EasyMock.replay(mockPost);
      
        emailHandler.PostStatus(mockPost);
        
        EasyMock.verify(mockPost);
    }
}
