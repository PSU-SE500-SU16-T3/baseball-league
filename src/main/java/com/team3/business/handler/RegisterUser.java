package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
import com.team3.business.models.TeamAssignment;


public interface RegisterUser {
	public Player processUser(Map<String,String> allRequestParams);
	public List<League> getLeague();
	public List<Season> getSeasons(Map<String, String> allRequestParams);
	public List<Division> getDivisions(Map<String, String> allRequestParams);
	public List<Player> getUnassignedPlayers();
	public List<Player> getAssignedPlayers(Map<String, String> allRequestParams);
	public boolean modifyPlayers(List<TeamAssignment> teamAssignments);
}
