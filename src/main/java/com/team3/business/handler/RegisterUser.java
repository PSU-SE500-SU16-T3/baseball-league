package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.Game;
import com.team3.business.models.League;
import com.team3.business.models.PersonInfo;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.RefereePlayer;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignments;


public interface RegisterUser {
	public Player processUser(Map<String,String> allRequestParams);
	public void addperson(Map<String,String> allRequestParams);
	public void addpayment(Map<String,String> allRequestParams);
	public League setLeague(Map<String,String> allRequestParams);
	public List<League> getLeague();
	public List<Season> getSeasons(Map<String, String> allRequestParams);
	public List<Division> getDivisions(Map<String, String> allRequestParams);
	public List<Player> getUnassignedPlayers(Map<String, String> allRequestParams);
	public List<Player> getAssignedPlayers(Map<String, String> allRequestParams);
	public boolean modifyPlayers(TeamAssignments teamAssignment);
	public PlayerRole getUserDetails(Map<String, String> allRequestParams);
	public List<Team> getTeams(Map<String, String> allRequestParams);
	public boolean registerSeason(Map<String, String> allRequestParams);
	public boolean registerDivision(Map<String, String> allRequestParams);
	public Season getSeasonDetail(Map<String, String> allRequestParams);
	public boolean updateSeason(Map<String, String> allRequestParams);
	public boolean registerTeam(Map<String, String> allRequestParams);
	public void addaddress(Map<String,String> allRequestParams);
	public List<Game> getGames(Map<String, String> allRequestParams);
	public League submitLeague(Map<String, String> allRequestParams);
	public League submitleagueByName(Map<String, String> allRequestParams);
	public Division getDivisionDetail(Map<String, String> allRequestParams);
	public boolean updateDivision(Map<String, String> allRequestParams);
	public boolean updateTeam(Map<String, String> allRequestParams);
	public PersonInfo getPersonInfo(Map<String, String> allRequestParams);
	public List<Field> getFields(Map<String, String> allRequestParams);
	public List<RefereePlayer> getRefs(Map<String, String> allRequestParams);
	public boolean postGame(Map<String, String> allRequestParams);
}
