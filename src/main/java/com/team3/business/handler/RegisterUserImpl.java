package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
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

	public List<Player> getUnassignedPlayers() {
		List<Player> players = daoImpl.getUnassignedPlayers();
		return players;
	}

	public List<Player> getAssignedPlayers(Map<String, String> allRequestParams) {
		String teamId = allRequestParams.get("teamId");
		List<Player> players = daoImpl.getAssignedPlayers(teamId);
		return players;
	}

}
