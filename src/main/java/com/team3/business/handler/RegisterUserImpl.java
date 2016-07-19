package com.team3.business.handler;



import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.geronimo.mail.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

@Service("registerUser")
public class RegisterUserImpl implements RegisterUser{
	
	@Autowired
	Dao daoImpl;
	private int _personID;
	public Player processUser(Map<String, String> allRequestParams) {
		//User user = new User();
		Player player = new Player();
		User user= new User();
		Address address= new Address();
		Phone mobilephone =new Phone();
		Phone homephone =new Phone();
		Payment payment = new Payment();
		player.setFirstName(allRequestParams.get("firstname"));
		player.setMiddleName(allRequestParams.get("middlename"));
		player.setLastName(allRequestParams.get("lastname"));
		player.setDateOfBirth(javax.xml.bind.DatatypeConverter.parseDateTime(allRequestParams.get("dob")));
		user.setUsername(allRequestParams.get("username"));
		user.setUserPassword(allRequestParams.get("password"));
		String role = allRequestParams.get("role");
		
		daoImpl.insertPhone(mobilephone);
		daoImpl.insertPhone(homephone);
		daoImpl.insertPlayer(player);
		daoImpl.insertAddress(address);
		daoImpl.insertPayment(payment);
		return player;
	}
	
	public List<League> getLeague() {
		List<League> leagues = daoImpl.getLeague();
		return leagues;
	}
	
	public List<Season> getSeasons(Map<String, String> allRequestParams) {
		String leagueId = allRequestParams.get("leagueId");
		List<Season> seasons = daoImpl.getSeasons(leagueId);
		return seasons;
	}

	public List<Division> getDivisions(Map<String, String> allRequestParams) {
		String seasonId = allRequestParams.get("seasonId");
		List<Division> divisions = daoImpl.getDivisions(seasonId);
		return divisions;
	}
	
	public List<Team> getTeams(Map<String, String> allRequestParams) {
		String divisionId = allRequestParams.get("divisionId");
		List<Team> teams = daoImpl.getTeams(divisionId);
		return teams;
	}

	public List<Player> getUnassignedPlayers() {
		List<Player> players = daoImpl.getUnassignedPlayers();
		return players;
	}

	public List<Player> getAssignedPlayers(Map<String, String> allRequestParams) {
		String teamId = allRequestParams.get("teamId");
		List<Player> players = daoImpl.getAssignedPlayers(teamId);
		return players;
	}

	public boolean modifyPlayers(TeamAssignments teamAssignments) {
		boolean status = daoImpl.modifyPlayers(teamAssignments);
		return status;
	}

	public PlayerRole getUserDetails(Map<String, String> allRequestParams) {	
		byte[] decoded = Base64.decode(allRequestParams.get("authdata"));
		String authParams = "";
		try {
			authParams = new String(decoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] userDetails = authParams.split(":"); 
		PlayerRole playerRole = daoImpl.getUserDetails(userDetails[0]);
		return playerRole;
	}

	public boolean registerSeason(Map<String, String> allRequestParams) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		Season season = new Season();
		season.setSeasonName(allRequestParams.get("seasonName"));
		try {
			season.setStartDate(javax.xml.bind.DatatypeConverter.parseDateTime(allRequestParams.get("seasonStartDate")));
			season.setEndDate(javax.xml.bind.DatatypeConverter.parseDateTime(allRequestParams.get("seasonEndDate")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		season.setLeagueID(new BigDecimal(allRequestParams.get("leagueId")));
		boolean status = daoImpl.registerSeason(season);
		return status;
	}

	public boolean registerDivision(Map<String, String> allRequestParams) {
		Division division = new Division();
		division.setDivisionTitle(allRequestParams.get("divisionName"));
		division.setDivisionMinAge(new BigDecimal(allRequestParams.get("minAge")));
		division.setDivisionMaxAge(new BigDecimal(allRequestParams.get("maxAge")));
		division.setDivisionNumPlayers(new BigDecimal(allRequestParams.get("maxNoOfPlayers")));
		division.setSeasonID(new BigDecimal(allRequestParams.get("seasonId")));
		boolean status = daoImpl.registerDivision(division);
		return status;
	}

	public void addperson(Map<String, String> allRequestParams) {
		Player player = new Player();
		User user= new User();
		player.setFirstName(allRequestParams.get("firstname"));
		player.setMiddleName(allRequestParams.get("middlename"));
		player.setLastName(allRequestParams.get("lastname"));
		player.setDateOfBirth(javax.xml.bind.DatatypeConverter.parseDateTime(allRequestParams.get("dob")));
		user.setUsername(allRequestParams.get("username"));
		user.setUserPassword(allRequestParams.get("password"));
		user.setUserEmail(allRequestParams.get("email"));
		user.setUserRole(daoImpl.getRoleID(allRequestParams.get("role")));
		_personID  = daoImpl.insertPlayer(player);
		user.setPersonID(_personID);
		daoImpl.insertUser(user);
		
	}

	public void addpayment(Map<String, String> allRequestParams) {
		Address address= new Address();
		Phone mobilephone =new Phone();
		Phone homephone =new Phone();
		address.setAddress(allRequestParams.get("address"));
		address.setCity(allRequestParams.get("city"));
		address.setState(allRequestParams.get("state"));
		address.setZip(allRequestParams.get("zip"));
		address.setPersonID((_personID));
		mobilephone.setPhoneNum(allRequestParams.get("mobilephone"));
		mobilephone.setPersonID(_personID);
		mobilephone.setPhoneType(daoImpl.getPhoneTypeID("Mobile"));
		homephone.setPhoneNum(allRequestParams.get("homephone"));
		homephone.setPersonID(_personID);
		homephone.setPhoneType(daoImpl.getPhoneTypeID("Home"));
		daoImpl.insertPhone(mobilephone);
		daoImpl.insertPhone(homephone);
		daoImpl.insertAddress(address);
	}

	public void addaddress(Map<String, String> allRequestParams) {
		Payment payment = new Payment();
		
	}

}
