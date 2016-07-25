package com.team3.common.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.business.handler.RegisterUser;
import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Response;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignment;
import com.team3.business.models.TeamAssignments;


public class LeagueControllerTest {
	LeagueController leagueController;
	RegisterUser registerUser;	
	ObjectMapper mapper;
	private IMocksControl controller;

	
	@Before  
    public void setUp() {  
		registerUser = EasyMock.createMock(RegisterUser.class);  
		mapper = EasyMock.createMock(ObjectMapper.class);
		leagueController = new LeagueController();
		leagueController.setRegisterUser(registerUser);
		controller = EasyMock.createStrictControl();

    }  
  
    @After  
    public void tearDown() {  
    	registerUser = null;  
    	mapper = null;      
    }
    
    @Test
    public void testGetLeague() {
    	List<League> leagues = new ArrayList<League>();
    	League league = new League();
    	league.setLeagueID(new BigDecimal("10000"));
    	league.setLeagueName("XYZ");
    	leagues.add(league);
    	
    	EasyMock.expect(registerUser.getLeague()).andReturn(leagues).anyTimes();  
        EasyMock.replay(registerUser);
        
        EasyMock.verify(registerUser);
        
        assertEquals(leagueController.getLeague().size(), leagues.size());
        
       
    }
    
    @Test
    public void testGetSeasons() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	EasyMock.expect(registerUser.getSeasons(mockArguments)).andReturn(new ArrayList<Season>()).anyTimes();  
        EasyMock.replay(registerUser); 
        assertEquals(leagueController.getSeasons(mockArguments).getClass(), ArrayList.class);
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testGetDivisions() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.getDivisions(mockArguments)).andReturn(new ArrayList<Division>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        assertEquals(leagueController.getDivisions(mockArguments).getClass(), ArrayList.class);
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testGetTeams() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.getTeams(mockArguments)).andReturn(new ArrayList<Team>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        assertEquals(leagueController.getTeams(mockArguments).getClass(), ArrayList.class);
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testGetUnassignedPlayers() {
    	List<Player> players = new ArrayList<Player>();
    	Player player = new Player();
    	player.setFirstName("Tim");
    	player.setLastName("Rogers");
    	player.setPersonID(new BigDecimal("10000"));
    	players.add(player);
    	
    	EasyMock.expect(registerUser.getUnassignedPlayers()).andReturn(players).anyTimes();  
        EasyMock.replay(registerUser);
        
        EasyMock.verify(registerUser);
        
        assertEquals(leagueController.getUnassignedPlayers().size(), players.size());      
       
    }
    
    @Test
    public void testGetAssignedPlayers() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.getAssignedPlayers(mockArguments)).andReturn(new ArrayList<Player>()).anyTimes();  
        EasyMock.replay(registerUser); 
        
        assertEquals(leagueController.getAssignedPlayers(mockArguments).getClass(), ArrayList.class);
        EasyMock.verify(registerUser);
    }
    
    
    @Test
    public void testModifyPlayers() throws JsonParseException, JsonMappingException, IOException { 
    	
    	Map<String,String> mockArguments = new HashMap<String, String>();
    	mockArguments.put("assignedPlayers", "[{\"id\":10006,\"name\":\"Abhijit Griffin\"},{\"id\":10005,\"name\":\"Artem Simpson\"}]");
    	mockArguments.put("teamId","10001");
    	
    	List<TeamAssignment> mockTeamAssignmentList = new ArrayList<TeamAssignment>();
    	TeamAssignments mockTeamAssignment = new TeamAssignments();
    	
    	ObjectMapper oMapper = new ObjectMapper();
    	
    	TeamAssignment[] teamAssignmentArr = oMapper.readValue(mockArguments.get("assignedPlayers").toString(), TeamAssignment[].class);
    	mockTeamAssignmentList = Arrays.asList(teamAssignmentArr);
        
        EasyMock.expect(mapper.readValue(mockArguments.get("assignedPlayers").toString(), TeamAssignment[].class)).andReturn(teamAssignmentArr).anyTimes();  
        EasyMock.replay(mapper);

        mockTeamAssignment.setTeamAssignments(mockTeamAssignmentList);
        mockTeamAssignment.setTeamId(mockArguments.get("teamId"));
    	
    	EasyMock.expect(registerUser.modifyPlayers(EasyMock.isA(TeamAssignments.class))).andReturn(new Boolean(true)).anyTimes();  
        EasyMock.replay(registerUser);
        
        boolean status = leagueController.modifyPlayers(mockArguments);
        assertEquals(status, true);
        
        EasyMock.verify(mapper);
        EasyMock.verify(registerUser);
        
    }
    
    @Test
    public void testRegisterSeason() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.registerSeason(mockArguments)).andReturn(true).anyTimes();  
        EasyMock.replay(registerUser);
        
        Response<String> response = leagueController.registerSeason(mockArguments);
        
        assertEquals(response.getStatus(), "success");
        assertEquals(response.getBody(), "Season created successfully.");
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testRegisterDivision() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.registerDivision(mockArguments)).andReturn(true).anyTimes();  
        EasyMock.replay(registerUser);
        
        Response<String> response = leagueController.registerDivision(mockArguments);
        
        assertEquals(response.getStatus(), "success");
        assertEquals(response.getBody(), "Division created successfully.");
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testRegisterTeam() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.registerTeam(mockArguments)).andReturn(true).anyTimes();  
        EasyMock.replay(registerUser);
        
        Response<String> response = leagueController.registerTeam(mockArguments);
        
        assertEquals(response.getStatus(), "success");
        assertEquals(response.getBody(), "Team created successfully.");
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testGetSeasonDetail() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	EasyMock.expect(registerUser.getSeasonDetail(mockArguments)).andReturn(new Season()).anyTimes();  
        EasyMock.replay(registerUser); 
        assertEquals(leagueController.getSeasonDetail(mockArguments).getClass(), Season.class);
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testUpdateSeason() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	
    	EasyMock.expect(registerUser.updateSeason(mockArguments)).andReturn(true).anyTimes();  
        EasyMock.replay(registerUser);
        
        Response<String> response = leagueController.updateSeason(mockArguments);
        
        assertEquals(response.getStatus(), "success");
        assertEquals(response.getBody(), "Season created successfully.");
        
        EasyMock.verify(registerUser);
    }
}
