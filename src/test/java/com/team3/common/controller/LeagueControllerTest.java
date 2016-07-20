package com.team3.common.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.business.handler.RegisterUser;
import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Season;

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
    
    @Test
    public void testGetSeasons() {    	
    	EasyMock.expect(registerUser.getSeasons(EasyMock.createMock(HashMap.class))).andReturn(new ArrayList<Season>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testGetDivisions() {    	
    	EasyMock.expect(registerUser.getDivisions(EasyMock.createMock(HashMap.class))).andReturn(new ArrayList<Division>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        EasyMock.verify(registerUser);
    }
}
