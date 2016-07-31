package com.team3.business.handler;



import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

//import org.apache.geronimo.mail.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
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
	
	public void setDaoImpl(Dao daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	private static int _personID;	
	
	public static void set_personID(int _personID) {
		RegisterUserImpl._personID = _personID;
	}

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
		String retrieveBy = allRequestParams.get("retrieveBy");
		String retrieveId = allRequestParams.get("retrieveId");
		List<Team> teams = daoImpl.getTeams(retrieveBy, retrieveId);
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
		byte[] decoded = Base64.decode(allRequestParams.get("authdata").getBytes());
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
		Season season = createSeasonObj(allRequestParams);
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
	
	public boolean registerTeam(Map<String, String> allRequestParams) {
		Team team = new Team();
		team.setTeamTitle(allRequestParams.get("teamName"));
		team.setTeamNumPlayers(new BigDecimal(allRequestParams.get("noOfPlayers")));
		team.setDivisionID(new BigDecimal(allRequestParams.get("divisionId")));
		boolean status = daoImpl.registerTeam(team);
		return status;
	}
	
	public Season getSeasonDetail(Map<String, String> allRequestParams) {
		String seasonId = allRequestParams.get("seasonId");
		Season season = daoImpl.getSeasonDetail(seasonId);
		return season;
	}
	
	public boolean updateSeason(Map<String, String> allRequestParams) {
		Season season = createSeasonObj(allRequestParams);
		boolean status = daoImpl.updateSeason(season);
		return status;
	}
	
	public  Season createSeasonObj(Map<String, String> allRequestParams) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Season season = new Season();
		season.setSeasonName(allRequestParams.get("seasonName"));
		try {
			season.setStartDate(new Timestamp(sdf.parse(allRequestParams.get("seasonStartDate")).getTime()));
			season.setEndDate(new Timestamp(sdf.parse(allRequestParams.get("seasonEndDate")).getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(allRequestParams.get("leagueId")!=null){
			season.setLeagueID(new BigDecimal(allRequestParams.get("leagueId")));
		}else if(allRequestParams.get("seasonId")!=null){
			season.setSeasonID(new BigDecimal(allRequestParams.get("seasonId")));
		}
			
		return season;
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

	public void addaddress(Map<String, String> allRequestParams) {
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

	public void addpayment(Map<String, String> allRequestParams) {
		Payment payment = new Payment();
		payment.setNameOnCard(daoImpl.getfullname(_personID));
		payment.setCardNumber(allRequestParams.get("cardnumber"));
		payment.setCvvCode(allRequestParams.get("cvc"));
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, Integer.parseInt(allRequestParams.get("experation").substring(0,2)));
		calendar.set(Calendar.YEAR, Integer.parseInt(allRequestParams.get("experation").substring(3,5)));
		payment.setExpDate(calendar);
		payment.setPersonID(_personID);
		payment.setPaymentType(daoImpl.getPaymentTypeID(allRequestParams.get("paymenttype")));
		daoImpl.insertPayment(payment);
	}
	
	public League setLeague(Map<String, String> allRequestParams) {
		League league = new League();
		league.setLeagueName(allRequestParams.get("leagueName"));
		league.setLeagueLocation(allRequestParams.get("leagueLocation"));
		league.setUserID(_personID);
		
		daoImpl.insertLeague(league);
		
		return league;
	}
	
	public League submitLeague(Map<String, String> allRequestParams) {
		League league = new League();
//		league.setLeagueName(allRequestParams.get("leagueName"));
//		league.setLeagueLocation(allRequestParams.get("leagueLocation"));
//		league.setUserID(_personID);
		
		int leagueID = daoImpl.getLeagueID(allRequestParams.get("leagueLocation"));
		
		//System.out.println("INside submitLeague and the league location is:"+allRequestParams.get("leagueLocation"));
		//System.out.println("The LeagueID is:"+leagueID);
		
		// todo:  use real personID when the findleague page is connected to registration
		//daoImpl.insertPersonLeague(leagueID, _personID);
		daoImpl.insertPersonLeague(leagueID, 10008);
		
		String leagueName = daoImpl.getLeagueName(leagueID);
		
		league.setLeagueName(leagueName);
		
		return league;
	}

	

}
