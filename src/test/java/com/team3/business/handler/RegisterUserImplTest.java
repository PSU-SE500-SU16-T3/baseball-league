package com.team3.business.handler;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.models.Address;
import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Payment;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignments;
import com.team3.business.models.User;
import com.team3.dao.Dao;
import com.team3.dao.DaoImpl;

public class RegisterUserImplTest {
	
	RegisterUserImpl registerUserImpl;
	Dao mockDaoImpl;
	int mockPersonId;
	Map<String,String> mockArguments;
	
	@Before  
    public void setUp() {  
		mockDaoImpl = EasyMock.createMock(DaoImpl.class);
		registerUserImpl = new RegisterUserImpl();
		registerUserImpl.setDaoImpl(mockDaoImpl);
		registerUserImpl.set_personID(10001);
		mockArguments = EasyMock.createMock(HashMap.class);
    }  
  
    @After  
    public void tearDown() {  
    	mockDaoImpl = null; 
    	mockArguments = null;
    }
    
    @Test
    public void testProcessUser() throws Exception {
    	
    	Player mockPlayer = EasyMock.createMock(Player.class);
    	
    	EasyMock.expect(mockArguments.get("firstname")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("middlename")).andReturn("d").anyTimes();
    	EasyMock.expect(mockArguments.get("lastname")).andReturn("abc").anyTimes();
    	EasyMock.expect(mockArguments.get("dob")).andReturn("2000-07-05T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("username")).andReturn("tom").anyTimes();
    	EasyMock.expect(mockArguments.get("password")).andReturn("Password").anyTimes();
    	EasyMock.expect(mockArguments.get("role")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	    	
    	
    	mockDaoImpl.insertPhone(EasyMock.isA(Phone.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	EasyMock.expect(mockDaoImpl.insertPlayer(EasyMock.isA(Player.class))).andReturn(10001).anyTimes();
    	
    	mockDaoImpl.insertAddress(EasyMock.isA(Address.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	mockDaoImpl.insertPayment(EasyMock.isA(Payment.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	EasyMock.replay(mockDaoImpl);
    	
    	Player response = registerUserImpl.processUser(mockArguments);
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);
    }
    
    @Test
    public void testGetLeague() {
    	List<League> mockLeagues = EasyMock.createMock(ArrayList.class);
        
    	EasyMock.expect(mockDaoImpl.getLeague()).andReturn(mockLeagues).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<League> response = registerUserImpl.getLeague();
    	
    	assertEquals(response, mockLeagues);
    	
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetSeasons() {
    	List<Season> mockSeasons = EasyMock.createMock(ArrayList.class);
    	
    	EasyMock.expect(mockArguments.get("leagueId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getSeasons(EasyMock.isA(String.class))).andReturn(mockSeasons).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<Season> response = registerUserImpl.getSeasons(mockArguments);
    	
    	assertEquals(response, mockSeasons);
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetDivisions() {
    	List<Division> mockDivisions = EasyMock.createMock(ArrayList.class);
    	
    	EasyMock.expect(mockArguments.get("seasonId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getDivisions(EasyMock.isA(String.class))).andReturn(mockDivisions).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<Division> response = registerUserImpl.getDivisions(mockArguments);
    	
    	assertEquals(response, mockDivisions);
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetTeams() {
    	List<Team> mockTeams = EasyMock.createMock(ArrayList.class);
    	
    	EasyMock.expect(mockArguments.get("retrieveBy")).andReturn("abc").anyTimes();
    	EasyMock.expect(mockArguments.get("retrieveId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getTeams(EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(mockTeams).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<Team> response = registerUserImpl.getTeams(mockArguments);
    	
    	assertEquals(response, mockTeams);
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetUnassignedPlayers() {
    	List<Player> mockPlayers = EasyMock.createMock(ArrayList.class);
        
    	EasyMock.expect(mockDaoImpl.getUnassignedPlayers()).andReturn(mockPlayers).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<Player> response = registerUserImpl.getUnassignedPlayers();
    	
    	assertEquals(response, mockPlayers);
    	
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetAssignedPlayers() {
    	List<Player> mockPlayers = EasyMock.createMock(ArrayList.class);
    	
    	EasyMock.expect(mockArguments.get("teamId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getAssignedPlayers(EasyMock.isA(String.class))).andReturn(mockPlayers).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	List<Player> response = registerUserImpl.getAssignedPlayers(mockArguments);
    	
    	assertEquals(response, mockPlayers);
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testModifyPlayers() {
    	TeamAssignments mockTeamAssignments = EasyMock.createMock(TeamAssignments.class);
        
    	EasyMock.expect(mockDaoImpl.modifyPlayers(EasyMock.isA(TeamAssignments.class))).andReturn(true).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	boolean response = registerUserImpl.modifyPlayers(mockTeamAssignments);
    	
    	assertEquals(response, true);
    	
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testGetUserDetails() {
    	PlayerRole mockPlayerRole = EasyMock.createMock(PlayerRole.class);
    	
    	EasyMock.expect(mockArguments.get("authdata")).andReturn("QmlsbDpQYXNzd29yZA==").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getUserDetails(EasyMock.isA(String.class))).andReturn(mockPlayerRole).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	PlayerRole response = registerUserImpl.getUserDetails(mockArguments);
    	
    	assertEquals(mockPlayerRole.getClass(), response.getClass());
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);       
    }
    
    @Test
    public void testRegisterSeason() throws Exception {
    	Season mockSeason = EasyMock.createMock(Season.class);
    	
    	EasyMock.expect(mockArguments.get("seasonName")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonStartDate")).andReturn("2016-07-05T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonEndDate")).andReturn("2016-07-21T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("leagueId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	RegisterUserImpl mockRegisterUserImpl = EasyMock.createMockBuilder(RegisterUserImpl.class)
    			.addMockedMethod("createSeasonObj")
    			.createMock();
        EasyMock.expect(mockRegisterUserImpl.createSeasonObj(mockArguments)).andReturn(mockSeason).anyTimes();
        EasyMock.replay(mockRegisterUserImpl);
    	
    	EasyMock.expect(mockDaoImpl.registerSeason(EasyMock.isA(Season.class))).andReturn(true).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	boolean response = registerUserImpl.registerSeason(mockArguments);
    	
    	assertEquals(true, response);
    	
    	EasyMock.verify(mockRegisterUserImpl);
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);    	
    }
    
    @Test
    public void testRegisterDivision() throws Exception {
    	EasyMock.expect(mockArguments.get("divisionName")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("minAge")).andReturn("12").anyTimes();
    	EasyMock.expect(mockArguments.get("maxAge")).andReturn("15").anyTimes();
    	EasyMock.expect(mockArguments.get("maxNoOfPlayers")).andReturn("40").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.registerDivision(EasyMock.isA(Division.class))).andReturn(true).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	boolean response = registerUserImpl.registerDivision(mockArguments);
    	
    	assertEquals(true, response);

    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl); 
    }
    
    @Test
    public void testRegisterTeam() throws Exception {
    	EasyMock.expect(mockArguments.get("teamName")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("noOfPlayers")).andReturn("10").anyTimes();    	
    	EasyMock.expect(mockArguments.get("divisionId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.registerTeam(EasyMock.isA(Team.class))).andReturn(true).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	boolean response = registerUserImpl.registerTeam(mockArguments);
    	
    	assertEquals(true, response);

    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl); 
    }
    
    @Test
    public void testGetSeasonDetail() throws Exception {
        
    	Season mockSeason = EasyMock.createMock(Season.class);
    	
    	EasyMock.expect(mockArguments.get("seasonId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getSeasonDetail(EasyMock.isA(String.class))).andReturn(mockSeason).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	Season response = registerUserImpl.getSeasonDetail(mockArguments);
    	
    	assertEquals(mockSeason.getClass(), response.getClass());

    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl); 
    }
    
    @Test
    public void testUpdateSeason() throws Exception {
    	
    	Season mockSeason = EasyMock.createMock(Season.class);
    	
    	EasyMock.expect(mockArguments.get("seasonName")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonStartDate")).andReturn("2016-07-05T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonEndDate")).andReturn("2016-07-21T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("leagueId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	RegisterUserImpl mockRegisterUserImpl = EasyMock.createMockBuilder(RegisterUserImpl.class)
    			.addMockedMethod("createSeasonObj")
    			.createMock();
        EasyMock.expect(mockRegisterUserImpl.createSeasonObj(mockArguments)).andReturn(mockSeason).anyTimes();
        EasyMock.replay(mockRegisterUserImpl);
    	
    	EasyMock.expect(mockDaoImpl.updateSeason(EasyMock.isA(Season.class))).andReturn(true).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	boolean response = registerUserImpl.updateSeason(mockArguments);
    	
    	assertEquals(true, response);
    	
    	EasyMock.verify(mockRegisterUserImpl);
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);    	
    }
    
    @Test
    public void testCreateSeasonObj() throws Exception {
    	
    	EasyMock.expect(mockArguments.get("seasonName")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonStartDate")).andReturn("2016-07-05T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("seasonEndDate")).andReturn("2016-07-21T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("leagueId")).andReturn(null).anyTimes();
    	EasyMock.expect(mockArguments.get("seasonId")).andReturn("10001").anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	registerUserImpl.createSeasonObj(mockArguments);
    	
    	EasyMock.verify(mockArguments);
    }
    
    @Test
    public void testAddperson() throws Exception {
    	
    	String roleId = "10001";
    	
    	EasyMock.expect(mockArguments.get("firstname")).andReturn("xyz").anyTimes();
    	EasyMock.expect(mockArguments.get("middlename")).andReturn("d").anyTimes();
    	EasyMock.expect(mockArguments.get("lastname")).andReturn("abc").anyTimes();
    	EasyMock.expect(mockArguments.get("dob")).andReturn("2000-07-05T04:00:00.000Z").anyTimes();
    	EasyMock.expect(mockArguments.get("username")).andReturn("tom").anyTimes();
    	EasyMock.expect(mockArguments.get("password")).andReturn("Password").anyTimes();
    	EasyMock.expect(mockArguments.get("email")).andReturn("xyz@gmail.com").anyTimes();
    	EasyMock.expect(mockArguments.get("role")).andReturn(roleId).anyTimes();
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getRoleID(EasyMock.isA(String.class))).andReturn(10001).anyTimes();
    	EasyMock.expect(mockDaoImpl.insertPlayer(EasyMock.isA(Player.class))).andReturn(10002).anyTimes();
    	EasyMock.expect(mockDaoImpl.insertUser(EasyMock.isA(User.class))).andReturn(10003).anyTimes();
    	EasyMock.replay(mockDaoImpl);
    	
    	registerUserImpl.addperson(mockArguments);    	
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);
    }
    
    @Test
    public void testAddaddress() throws Exception {
    	
    	EasyMock.expect(mockArguments.get("address")).andReturn("xyz rd").anyTimes();
    	EasyMock.expect(mockArguments.get("city")).andReturn("boston").anyTimes();
    	EasyMock.expect(mockArguments.get("state")).andReturn("ma").anyTimes();
    	EasyMock.expect(mockArguments.get("zip")).andReturn("02166").anyTimes();
    	EasyMock.expect(mockArguments.get("mobilephone")).andReturn("1234567890").anyTimes();
    	EasyMock.expect(mockArguments.get("homephone")).andReturn("1234567890").anyTimes();    	
    	EasyMock.replay(mockArguments);
    	
    	EasyMock.expect(mockDaoImpl.getPhoneTypeID(EasyMock.isA(String.class))).andReturn(20001).anyTimes();    	
    	
    	mockDaoImpl.insertPhone(EasyMock.isA(Phone.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	mockDaoImpl.insertAddress(EasyMock.isA(Address.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	EasyMock.replay(mockDaoImpl);
    	
    	registerUserImpl.addaddress(mockArguments);    	
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);
    }
    
    @Test
    public void testAddpayment() throws Exception {
    	
    	
    	EasyMock.expect(mockArguments.get("cardnumber")).andReturn("1234567891234567").anyTimes();
    	EasyMock.expect(mockArguments.get("cvc")).andReturn("123").anyTimes();
    	EasyMock.expect(mockArguments.get("experation")).andReturn("123456789").anyTimes();
    	EasyMock.expect(mockArguments.get("paymenttype")).andReturn("02166").anyTimes();
    	    	
    	EasyMock.replay(mockArguments);
    	

    	EasyMock.expect(mockDaoImpl.getfullname(10001)).andReturn("xyz d abc").anyTimes();
    	EasyMock.expect(mockDaoImpl.getPaymentTypeID(EasyMock.isA(String.class))).andReturn(10001).anyTimes();    	
    	
    	mockDaoImpl.insertPayment(EasyMock.isA(Payment.class));
    	EasyMock.expectLastCall().anyTimes();
    	
    	EasyMock.replay(mockDaoImpl);
    	
    	registerUserImpl.addpayment(mockArguments);    	
    	
    	EasyMock.verify(mockArguments);
    	EasyMock.verify(mockDaoImpl);
    }
}
