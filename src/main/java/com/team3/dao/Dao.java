package com.team3.dao;

import java.util.List;

import com.team3.business.models.Address;
import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.League;
import com.team3.business.models.Payment;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.RefereePlayer;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignment;
import com.team3.business.models.User;

public interface Dao {
	
	public void insertUser(User user);
	public void insertPlayer(Player player);
	public void insertPhone(Phone phone);
	public void insertPayment(Payment payment);
	public void insertLeague(League league);
	public void insertSeason(Season season);
	public void dropSeason(Season season);
	public void insertDivision(Division division);
	public void dropDivision(Division division);
	public void insertTeam(Team team);
	public void insertField(Field field);
	public void insertRefereePlayer(RefereePlayer refereePlayer);
	public void insertAddress(Address address);
	public List<League> getLeague();
	public List<Season> getSeasons(String leagueId);
	public List<Division> getDivisions(String seasonId);
	public List<Player> getUnassignedPlayers();
	public List<Player> getAssignedPlayers(String teamId);
	public boolean modifyPlayers(List<TeamAssignment> teamAssignments);
}
