package com.team3.business.handler;



import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.geronimo.mail.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignments;
import com.team3.dao.Dao;

@Service("registerUser")
public class RegisterUserImpl implements RegisterUser{
	
	@Autowired
	Dao daoImpl;

	public Player processUser(Map<String, String> allRequestParams) {
		//User user = new User();
		Player player = new Player();
		//user.setUsername(allRequestParams.get("username"));
		//user.setUserPassword(allRequestParams.get("password"));
		//user.setUserEmail(allRequestParams.get("email"));
		player.setFirstName(allRequestParams.get("username"));
		player.setMiddleName(allRequestParams.get("password"));
		player.setLastName(allRequestParams.get("email"));
		daoImpl.insertPlayer(player);
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
			/*season.setStartDate(new Date(sdf1.parse(allRequestParams.get("seasonStartDate")).getTime()));
			season.setEndDate(new Date(sdf1.parse(allRequestParams.get("seasonEndDate")).getTime()));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		season.setLeagueID(new BigDecimal(allRequestParams.get("leagueId")));
		boolean status = daoImpl.registerSeason(season);
		return status;
	}

}
