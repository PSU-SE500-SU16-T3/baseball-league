package com.team3.common.controller;

import org.springframework.security.authentication.AuthenticationManager;
import com.team3.business.authorization.GaeAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAuthorizationFilterTest {
	GaeAuthenticationFilter authorizationFilter;
	AuthenticationDetailsSource ads;
	AuthenticationManager authenticationManager;
	AuthenticationFailureHandler failureHandler;
	
	@Before  
    public void setUp() {  
		authorizationFilter = EasyMock.createMock(GaeAuthenticationFilter.class);
		ads = EasyMock.createMock(AuthenticationDetailsSource.class);
		failureHandler = EasyMock.createMock(AuthenticationFailureHandler.class);
		authenticationManager = EasyMock.createMock(AuthenticationManager.class);
    }  
  
    @After  
    public void tearDown() {  
    	authorizationFilter = null;
    	ads = null;
		failureHandler = null;
		authenticationManager = null;
    }
    
    @Test
    public void testDoFilter() { 
    	ServletRequest requestMock = EasyMock.createMock(ServletRequest.class);
    	ServletResponse responseMock = EasyMock.createMock(ServletResponse.class);
    	FilterChain chainMock = EasyMock.createMock(FilterChain.class);
    	
    	EasyMock.expect(requestMock).andReturn(new ServletRequest()).anyTimes();  
        EasyMock.replay(requestMock);
        
        EasyMock.expect(responseMock).andReturn(new ServletResponse()).anyTimes();  
        EasyMock.replay(responseMock);
        
        EasyMock.expect(chainMock).andReturn(new FilterChain()).anyTimes();  
        EasyMock.replay(chainMock);
      
        authorizationFilter.doFilter(requestMock, responseMock, chainMock);
        
        EasyMock.verify(requestMock);
        EasyMock.verify(responseMock);
        EasyMock.verify(chainMock);
    }
}
