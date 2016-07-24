package com.team3.common.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.handler.LeagueFactory;
import com.team3.business.handler.LeagueFactoryImpl;
import com.team3.business.models.League;

import static org.junit.Assert.assertEquals;

public class CreateLeagueControllerTest {
	CreateLeagueController createLeagueController;
	LeagueFactory leagueFactory;
	
	@Before  
    public void setUp() {  
		leagueFactory = EasyMock.createMock(LeagueFactoryImpl.class);
		createLeagueController = new CreateLeagueController();
		createLeagueController.setLeagueFactory(leagueFactory);
    }  
  
    @After  
    public void tearDown() {  
    	leagueFactory = null; 
    }
    
    @Test
    public void testSetLeague() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	League mockLeague = new League();
    	mockLeague.setLeagueID(new BigDecimal("10001"));
    	mockLeague.setLeagueName("XYZ");

    	EasyMock.expect(leagueFactory.SetLeagueParams(mockArguments)).andReturn(mockLeague).anyTimes();  
        EasyMock.replay(leagueFactory);
        
        League response = createLeagueController.setLeague(mockArguments);
        
        assertEquals("XYZ", response.getLeagueName());
        
        EasyMock.verify(leagueFactory);
    }
}
