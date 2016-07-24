package com.team3.common.controller;

import com.team3.business.authorization.AuthenticationException;
import com.team3.business.authorization.GaeAuthenticationFilter;
import com.team3.business.authorization.GoogleAccountsAuthenticationEntryPoint;
import com.team3.business.authorization.HttpServletRequest;
import com.team3.business.authorization.HttpServletResponse;

public class GoogleAccountsAuthenticationEntryPointTest {
	GoogleAccountsAuthenticationEntryPoint googleAccountsAthenticationEntryPoint;
	
	@Before  
    public void setUp() {  
		authorizationFilter = EasyMock.createMock(GaeAuthenticationFilter.class);
    }  
  
    @After  
    public void tearDown() {  
    	authorizationFilter = null;
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
