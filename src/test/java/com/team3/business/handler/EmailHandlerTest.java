package com.team3.business.handler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.exception.BaseballLeagueException;

public class EmailHandlerTest {

	EmailHandler emailHandler;
	
	@Before  
    public void setUp() {  
		emailHandler = new EmailHandler();
    }  
  
    @After  
    public void tearDown() {  
    	emailHandler = null; 
    }
    
    @Test
    public void testSendEmail() throws BaseballLeagueException { 
    	emailHandler.sendEmail("baseballlegue@gmail.com", "message from EmailHandlerTest");;
    }
}
