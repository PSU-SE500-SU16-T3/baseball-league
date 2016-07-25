package com.team3.common.controller;

import com.team3.business.authorization.AuthenticationDetailsSource;
import com.team3.business.authorization.AuthenticationFailureHandler;
import com.team3.business.authorization.AuthenticationManager;
import com.team3.business.authorization.GaeAuthenticationFilter;
import com.team3.business.authorization.ServletRequest;
import com.team3.business.authorization.SimpleUrlAuthenticationFailureHandler;
import com.team3.business.authorization.WebAuthenticationDetailsSource;
import com.team3.business.handler.EmailHandler;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
