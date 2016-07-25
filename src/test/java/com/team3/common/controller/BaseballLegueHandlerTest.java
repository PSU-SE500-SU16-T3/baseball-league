package com.team3.common.controller;

import com.team3.business.handler.BaseballLegueHandler;
import com.team3.business.handler.EmailHandler;
import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.League;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.User;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseballLegueHandlerTest {

	BaseballLegueHandler baseballLegueHandler;
	
	@Before  
    public void setUp() {  
		baseballLegueHandler = EasyMock.createMock(BaseballLegueHandler.class);
    }  
  
    @After  
    public void tearDown() {  
    	baseballLegueHandler = null; 
    }
    
    @Test
    public void testIsValidUser() { 
    	User mockUser = EasyMock.createMock(User.class);
    	
    	EasyMock.expect(mockUser).andReturn(new User()).anyTimes();  
        EasyMock.replay(mockUser);
      
        baseballLegueHandler.isValidUser(mockUser);
        
        EasyMock.verify(mockUser);
    }
    
    @Test
    public void testIsValidTeam() { 
    	Team mockTeam = EasyMock.createMock(Team.class);
    	
    	EasyMock.expect(mockTeam).andReturn(new Team()).anyTimes();  
        EasyMock.replay(mockTeam);
      
        baseballLegueHandler.isValidTeam(mockTeam);
        
        EasyMock.verify(mockTeam);
    }
    
    @Test
    public void testIsValidSeason() { 
    	Season mockSeason = EasyMock.createMock(Season.class);
    	
    	EasyMock.expect(mockSeason).andReturn(new Season()).anyTimes();  
        EasyMock.replay(mockSeason);
      
        baseballLegueHandler.isValidSeason(mockSeason);
        
        EasyMock.verify(mockSeason);
    }
    
    @Test
    public void testIsValidPlayer() { 
    	Player mockPlayer = EasyMock.createMock(Player.class);
    	
    	EasyMock.expect(mockPlayer).andReturn(new Player()).anyTimes();  
        EasyMock.replay(mockPlayer);
      
        baseballLegueHandler.isValidPlayer(mockPlayer);
        
        EasyMock.verify(mockPlayer);
    }
    
    @Test
    public void testIsValidPhone() { 
    	Phone mockPhone = EasyMock.createMock(Phone.class);
    	
    	EasyMock.expect(mockPhone).andReturn(new Phone()).anyTimes();  
        EasyMock.replay(mockPhone);
      
        baseballLegueHandler.isValidPhone(mockPhone);
        
        EasyMock.verify(mockPhone);
    }
    
    @Test
    public void testIsValidLegue() { 
    	League mockLeague = EasyMock.createMock(League.class);
    	
    	EasyMock.expect(mockLeague).andReturn(new League()).anyTimes();  
        EasyMock.replay(mockLeague);
      
        baseballLegueHandler.isValidLegue(mockLeague);
        
        EasyMock.verify(mockLeague);
    }
    
    @Test
    public void testIsValidField() { 
    	Field mockField = EasyMock.createMock(Field.class);
    	
    	EasyMock.expect(mockField).andReturn(new Field()).anyTimes();  
        EasyMock.replay(mockField);
      
        baseballLegueHandler.isValidField(mockField);
        
        EasyMock.verify(mockField);
    }
    
    @Test
    public void testIsValidDivision() { 
    	Division mockDivision = EasyMock.createMock(Division.class);
    	
    	EasyMock.expect(mockDivision).andReturn(new Division()).anyTimes();  
        EasyMock.replay(mockDivision);
      
        baseballLegueHandler.isValidDivision(mockDivision);
        
        EasyMock.verify(mockDivision);
    }
    
}
