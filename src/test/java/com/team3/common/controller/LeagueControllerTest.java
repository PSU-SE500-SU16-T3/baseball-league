package com.team3.common.controller;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.business.handler.RegisterUser;
import com.team3.business.models.League;

public class LeagueControllerTest {
	
	RegisterUser registerUser;	
	ObjectMapper mapper;
	
	
	@Before  
    public void setUp() {  
		registerUser = EasyMock.createMock(RegisterUser.class);  
		mapper = EasyMock.createMock(ObjectMapper.class);
    }  
  
    @After  
    public void tearDown() {  
    	registerUser = null;  
    	mapper = null;      
    }
    
    @Test
    public void testGetLeague() {    	
    	EasyMock.expect(registerUser.getLeague()).andReturn(new ArrayList<League>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        EasyMock.verify(registerUser);
    }
}
