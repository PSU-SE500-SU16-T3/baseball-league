package com.team3.common.controller;

import com.team3.business.authorization.GoogleAccountsAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoogleAccountsAuthenticationEntryPointTest {
	GoogleAccountsAuthenticationEntryPoint googleAccountsAthenticationEntryPoint;
	
	@Before  
    public void setUp() {  
		googleAccountsAthenticationEntryPoint = EasyMock.createMock(GoogleAccountsAuthenticationEntryPoint.class);
    }  
  
    @After  
    public void tearDown() {  
    	googleAccountsAthenticationEntryPoint = null;
    }
    
    @Test
    public void testCommence() { 
    	HttpServletRequest requestMock = EasyMock.createMock(HttpServletRequest.class);
    	HttpServletResponse responseMock = EasyMock.createMock(HttpServletResponse.class);
    	AuthenticationException authExceptionMock = EasyMock.createMock(AuthenticationException.class);
    	
    	EasyMock.expect(requestMock).andReturn(new HttpServletRequest()).anyTimes();  
        EasyMock.replay(requestMock);
        
        EasyMock.expect(responseMock).andReturn(new HttpServletResponse()).anyTimes();  
        EasyMock.replay(responseMock);
        
        EasyMock.expect(authExceptionMock).andReturn(new AuthenticationException()).anyTimes();  
        EasyMock.replay(authExceptionMock);
      
        googleAccountsAthenticationEntryPoint.commence(requestMock, responseMock, authExceptionMock);
        
        EasyMock.verify(requestMock);
        EasyMock.verify(responseMock);
        EasyMock.verify(authExceptionMock);
    }
}
