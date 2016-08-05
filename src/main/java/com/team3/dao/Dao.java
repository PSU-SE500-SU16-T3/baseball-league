package com.team3.dao;

import java.util.List;

import com.team3.business.models.Address;
import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.Game;
import com.team3.business.models.League;
import com.team3.business.models.Payment;
import com.team3.business.models.PersonInfo;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.RefereePlayer;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignments;
import com.team3.business.models.User;

public interface Dao {
	
	public int insertUser(User user);
	public int insertPlayer(Player player);
	public int getRoleID(String role);
	public int getPhoneTypeID(String PhoneType);
	public int getPaymentTypeID(String PaymentType);
	public String getfullname(int PersonID);
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
	public List<Game> getGame();
	public List<Season> getSeasons(String leagueId);
	public List<Division> getDivisions(String seasonId);
	public List<Player> getUnassignedPlayers(String leagueId);
	public List<Player> getAssignedPlayers(String teamId);
	public boolean modifyPlayers(TeamAssignments teamAssignments);
	public PlayerRole getUserDetails(String username);
	public List<Team> getTeams(String divisionId, String retrieveId);
	public boolean registerSeason(Season season);
	public boolean registerDivision(Division division);
	public Season getSeasonDetail(String seasonId);
	public boolean updateSeason(Season season);
	public boolean registerTeam(Team team);
	public int getLeagueID(String LeagueLoc);
	public void insertPersonLeague(int LeagueID, int UserID);
	public String getLeagueName(int LeagueID);
	public List<Game> getGames(String retrieveId);
	public int getLeagueIDbyName(String LeagueName);
	public Division getDivisionDetail(String divisionId);
	public boolean updateDivision(Division division);
	public boolean updateTeam(Team team);
	public PersonInfo getPersonInfo(String string);
	public List<Field> getFields(String retrieveId);
	public List<RefereePlayer> getRefs(String retrieveId);
	public boolean registerGame(Game game);
}
