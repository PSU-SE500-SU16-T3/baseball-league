package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignments;


public interface RegisterUser {
	public Player processUser(Map<String,String> allRequestParams);
	public void addperson(Map<String,String> allRequestParams);
	public List<League> getLeague();
	public List<Season> getSeasons(Map<String, String> allRequestParams);
	public List<Division> getDivisions(Map<String, String> allRequestParams);
	public List<Player> getUnassignedPlayers();
	public List<Player> getAssignedPlayers(Map<String, String> allRequestParams);
	public boolean modifyPlayers(TeamAssignments teamAssignment);
	public PlayerRole getUserDetails(Map<String, String> allRequestParams);
	public List<Team> getTeams(Map<String, String> allRequestParams);
	public boolean registerSeason(Map<String, String> allRequestParams);
	public boolean registerDivision(Map<String, String> allRequestParams);
}
