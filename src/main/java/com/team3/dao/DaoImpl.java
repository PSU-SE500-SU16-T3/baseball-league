package com.team3.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.team3.business.models.Address;
import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.Game;
import com.team3.business.models.League;
import com.team3.business.models.Payment;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.RefereePlayer;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignment;
import com.team3.business.models.TeamAssignments;
import com.team3.business.models.User;
import com.team3.dao.mapper.PlayerRoleMapper;

@Component("daoImpl")
public class DaoImpl extends JdbcDaoSupport implements Dao{

	public int insertUser(User user) {
		String sql = "INSERT INTO USERS (userName, passw, email, userRole, PersonID) VALUES (?, ?, ?, ?,?)";
					 
		getJdbcTemplate().update(sql, new Object[] { user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserRole(), user.getPersonID()});
		
		String UserIDsql = "Select UserID from USERS where userName=?";
		
		int UserID=(int)getJdbcTemplate().queryForObject(
				UserIDsql, new Object[] { user.getUserName() }, int.class);
		return UserID;		
		
	}

	public int insertPlayer(Player player) {
		String sql = "INSERT INTO PERSON (dob, firstname, lastname, middlename) VALUES (?, ?, ?, ?)";
		 
		 getJdbcTemplate().update(sql, new Object[] {player.getDateOfBirth(), player.getFirstName(), player.getLastName(), player.getMiddleName() });
		String PersonIDsql = "Select PersonID from Person where firstname=? and lastname=? and middlename=? and dob=?";
		
		int PersonID=(int)getJdbcTemplate().queryForObject(
				PersonIDsql, new Object[] { player.getFirstName(), player.getLastName(), player.getMiddleName(), player.getDateOfBirth() }, int.class);
		return PersonID;	
	}

	public void insertPhone(Phone phone) {
		String sql = "INSERT INTO PHONE (personID, phnetype,  phonenumber) VALUES (?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { phone.getPersonID(), phone.getPhoneType(), phone.getPhoneNum()});
	}

	public void insertPayment(Payment payment) {
		String sql = "INSERT INTO PAYMENT (personID, cardnumber, crvcode, expdate, nameoncard, paymenttype) VALUES (?, ?,?,?,?,?)";
		 
		getJdbcTemplate().update(sql, new Object[] {payment.getPersonID(), payment.getCardNumber(), payment.getCvvCode(), payment.getExpDate(), payment.getNameOnCard(), payment.getPaymentType()});
	}

	public void insertLeague(League league) {
		String sql = "INSERT INTO league( leaguelocation, leaguename) VALUES ( ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] {league.getLeagueLocation(), league.getLeagueName()});
	}

	public void insertSeason(Season season) {
		String sql = "INSERT INTO season(leagueid, seasonenddt, seasonid, seasonnumberofplayers, seasonstartdt, seasontitle) VALUES (?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { season.getLeagueID(), season.getEndDate(), season.getNumPlayer(), season.getStartDate(), season.getSeasonName()});
	}

	public void dropSeason(Season season) {
		String sql = "DELETE FROM season WHERE SEASONID= ? ";
		 
		getJdbcTemplate().update(sql, new Object[] { season.getSeasonID()});
	}

	public void insertDivision(Division division) {
		String sql = "INSERT INTO division( DIVISIONTITLE, DIVISIONMINAGE, DIVISIONMAXAGE, DIVISIONNUMBEROFPLAYER, SEASONID) VALUES (?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { division.getDivisionTitle(), division.getDivisionMinAge(), division.getDivisionMaxAge(), division.getDivisionNumPlayers(), division.getSeasonID()});
	}

	public void dropDivision(Division division) {
		String sql = "DELETE FROM division WHERE DIVISIONID= ? ";
		 
		getJdbcTemplate().update(sql, new Object[] { division.getDivisionID()});
	
		
	}
	
	public void insertGame(Game game) {
		String sql = "INSERT INTO game(Team1ID, Team2ID, gameScore, RefereeID, FieldID) VALUES ( ?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { game.getTeam1Id(), game.getTeam2Id(), game.getGameScore(), game.getRefereeId(), game.getFieldId()});
	}

	public void insertTeam(Team team) {
		String sql = "INSERT INTO team(TEAMID, TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID, SEASONID, LEAGUEID, FIELDID, REFEREEID, PERSONID) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { team.getTeamTitle(), team.getTeamNumPlayers(), team.getDivisionID(), team.getSeasonID(), team.getLeagueID(), team.getFieldID(), team.getRefereeID(), team.getPersonID()});
	}

	public void insertField(Field field) {
		String sql = "INSERT INTO field(FIELDID, FIELDNAME, FIELDLOCATION) VALUES ( ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { field.getFieldName(), field.getFieldLocation()});
	}

	public void insertRefereePlayer(RefereePlayer refereePlayer) {
		String sql = "INSERT INTO REFEREEPLAYER(PERSONID) VALUES (?)";
		 
		getJdbcTemplate().update(sql, new Object[] { refereePlayer.getRefereePlayerID()});
	}

	public void insertAddress(Address address) {
		String sql = "INSERT INTO address(personID, address, city, state, zip) VALUES ( ?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { address.getPersonID(), address.getAddress(), address.getCity(), address.getState(), address.getZip()});
	}

	public List<League> getLeague() {
		String sql = "SELECT LEAGUEID, LEAGUENAME, LEAGUELOCATION FROM LEAGUE";
		List<League> leagues = new ArrayList<League>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			League league = new League();
			league.setLeagueID((BigDecimal)(row.get("LEAGUEID")));
			league.setLeagueName((String)(row.get("LEAGUENAME")));
			league.setLeagueLocation((String)(row.get("LEAGUELOCATION")));
			leagues.add(league);
		}		
		return leagues;
	}
	
	public List<com.team3.business.models.Game> getGame() {
		String sql = "SELECT GameID, Team1ID, Team2ID, gameScore, RefereeID, FieldID FROM GAME";
		List<Game> games = new ArrayList<Game>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			Game game = new Game();
			game.setGameId((BigDecimal)row.get("GameID"));
			game.setTeam1Id((BigDecimal)row.get("Team1ID"));
			game.setTeam2Id((BigDecimal) row.get("Team2ID"));
			game.setGameScore((String) row.get("gameScore"));
			game.setRefereeId((BigDecimal) row.get("RefereeID"));
			game.setFieldId((BigDecimal) row.get("FieldID"));
			games.add(game);
		}		
		return games;
	}
	
	public List<Season> getSeasons(String leagueId) {
		String sql = "SELECT SEASONID, SEASONTITLE FROM SEASON WHERE LEAGUEID = ?";
		List<Season> seasons = new ArrayList<Season>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { leagueId });
		for (Map<String, Object> row : rows) {
			Season season = new Season();
			season.setSeasonID((BigDecimal)(row.get("SEASONID")));
			season.setSeasonName((String)(row.get("SEASONTITLE")));
			seasons.add(season);
		}		
		return seasons;
	}

	public List<Division> getDivisions(String seasonId) {
		String sql = "SELECT DIVISIONID, DIVISIONTITLE, DIVISIONMINAGE, DIVISIONMAXAGE, DIVISIONNUMBEROFPLAYER FROM DIVISION WHERE SEASONID = ?";
		List<Division> divisions = new ArrayList<Division>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { seasonId });
		for (Map<String, Object> row : rows) {
			Division division = new Division();
			division.setDivisionID((BigDecimal)(row.get("DIVISIONID")));
			division.setDivisionTitle((String)(row.get("DIVISIONTITLE")));
			division.setDivisionMinAge((BigDecimal)(row.get("DIVISIONMINAGE")));
			division.setDivisionMaxAge((BigDecimal)(row.get("DIVISIONMAXAGE")));
			division.setDivisionNumPlayers((BigDecimal)(row.get("DIVISIONNUMBEROFPLAYER")));
			divisions.add(division);
		}		
		return divisions;
	}	
	
	public List<Team> getTeams(String divisionId) {
		String sql = "SELECT TEAMID, TEAMTITLE, TEAMNUMBEROFPLAYERS, FIELDID FROM TEAM WHERE DIVISIONID = ?";
		List<Team> teams = new ArrayList<Team>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { divisionId });
		for (Map<String, Object> row : rows) {
			Team team = new Team();
			team.setTeamID((BigDecimal)(row.get("TEAMID")));
			team.setTeamTitle((String)(row.get("TEAMTITLE")));
			team.setTeamNumPlayers((BigDecimal)(row.get("TEAMNUMBEROFPLAYERS")));
			team.setFieldID((BigDecimal)(row.get("FIELDID")));
			teams.add(team);
		}		
		return teams;
	}
	
	public List<Player> getAssignedPlayers(String teamId) {
		String sql = "SELECT PERSONID, FIRSTNAME, LASTNAME FROM PERSON WHERE PERSONID IN "
				+ "(SELECT TA.PERSONID from TEAMASSIGNMENT TA, PERSONROLEASSIGNMENT PRA WHERE PRA.ROLEID=10001 AND TA.PERSONID=PRA.PERSONID AND TA.TEAMID = ?) ORDER BY FIRSTNAME ASC";
		List<Player> players = new ArrayList<Player>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { teamId });
		for (Map<String, Object> row : rows) {
			Player player = new Player();
			player.setPersonID((BigDecimal)(row.get("PERSONID")));
			player.setFirstName((String)(row.get("FIRSTNAME")));
			player.setLastName((String)(row.get("LASTNAME")));
			players.add(player);
		}		
		return players;
	}
	
	public List<Player> getUnassignedPlayers() {
		String sql = "SELECT P.PERSONID, P.FIRSTNAME, P.LASTNAME FROM PERSON P, PERSONROLEASSIGNMENT PRA WHERE P.PERSONID NOT IN "
				+ "(SELECT PERSONID FROM TEAMASSIGNMENT) AND P.PERSONID=PRA.PERSONID AND PRA.ROLEID = 10001 ORDER BY P.FIRSTNAME ASC";
		List<Player> players = new ArrayList<Player>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map<String, Object> row : rows) {
			Player player = new Player();
			player.setPersonID((BigDecimal)(row.get("PERSONID")));
			player.setFirstName((String)(row.get("FIRSTNAME")));
			player.setLastName((String)(row.get("LASTNAME")));
			players.add(player);
		}		
		return players;
	}

	public boolean modifyPlayers(TeamAssignments teamAssignments) {
		deletePlayersFromTeam(teamAssignments.getTeamId());
		insertBatchTeamAssignment(teamAssignments.getTeamAssignments(), teamAssignments.getTeamId());
		return true;
	}
	
	private void deletePlayersFromTeam(String teamId) {
		String sql = "DELETE FROM TEAMASSIGNMENT WHERE TEAMID = ?";
		getJdbcTemplate().update(sql, new Object[] { teamId });
	}

	//insert batch example
	private void insertBatchTeamAssignment(final List<TeamAssignment> teamAssignments, final String teamId){
			
	  String sql = "INSERT INTO TEAMASSIGNMENT " +
		"(TEAMID, PERSONID) VALUES (?,?)";
				
	  getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
				
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			TeamAssignment teamAssignment = teamAssignments.get(i);
			ps.setLong(1, new Long(teamId));
			ps.setLong(2, new Long(teamAssignment.getId()));			
		}
				
		public int getBatchSize() {
			return teamAssignments.size();
		}
	  });
	}

	public PlayerRole getUserDetails(String username) {
		String sql = "SELECT U.PERSONID, P.FIRSTNAME, P.LASTNAME, PRA.ROLEID FROM USERS U, PERSON P, PERSONROLEASSIGNMENT PRA WHERE U.USERNAME = ? AND U.PERSONID = P.PERSONID AND U.PERSONID=PRA.PERSONID";
		PlayerRole playerRole = (PlayerRole)getJdbcTemplate().queryForObject(sql, new Object[] { username }, new PlayerRoleMapper());
		if(playerRole.getRoleId().equals("10000")){
			String getLeagueSql = "SELECT LEAGUEID, LEAGUENAME FROM LEAGUE WHERE PERSONID = "+playerRole.getPlayer().getPersonID();
			SqlRowSet rs = (SqlRowSet)getJdbcTemplate().queryForRowSet(getLeagueSql);
			try {
				while(rs.next()){
					playerRole.setLeagueId(rs.getBigDecimal("LEAGUEID"));
					playerRole.setLeagueName(rs.getString("LEAGUENAME"));
				}				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return playerRole;
	}

	public boolean registerSeason(Season season) {
		String sql = "INSERT INTO SEASON  (SEASONTITLE,SEASONSTARTDT,SEASONENDDT,SEASONNUMBEROFPLAYERS,LEAGUEID  ) VALUES (?, ?, ?,20, ?)";
		int count = getJdbcTemplate().update(sql, new Object[] {season.getSeasonName(), season.getStartDate(), season.getEndDate(), season.getLeagueID()});
		if(count > 0)
			return true;
		else
			return false;
	}

	public boolean registerDivision(Division division) {
		String sql = "INSERT INTO DIVISION(DIVISIONTITLE,DIVISIONMINAGE,DIVISIONMAXAGE,DIVISIONNUMBEROFPLAYER,SEASONID) VALUES (?, ?, ?, ?, ?)";
		int count = getJdbcTemplate().update(sql, new Object[] {division.getDivisionTitle(), division.getDivisionMinAge(), division.getDivisionMaxAge(), division.getDivisionNumPlayers(), division.getSeasonID()});
		if(count > 0)
			return true;
		else
			return false;
	}
	
	public boolean registerTeam(Team team) {
		String sql = "INSERT INTO TEAM(TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID) VALUES (?, ?, ?)";
		int count = getJdbcTemplate().update(sql, new Object[] {team.getTeamTitle(), team.getTeamNumPlayers(), team.getDivisionID()});
		if(count > 0)
			return true;
		else
			return false;
	}
	
	public Season getSeasonDetail(String seasonId) {
  		String sql = "SELECT SEASONID, SEASONTITLE, SEASONSTARTDT, SEASONENDDT, SEASONNUMBEROFPLAYERS, LEAGUEID FROM SEASON WHERE SEASONID = "+seasonId;
		Season season = new Season();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SqlRowSet rs = (SqlRowSet)getJdbcTemplate().queryForRowSet(sql);
		try {
			while(rs.next()){
				
				season.setSeasonID(rs.getBigDecimal("SEASONID"));
				season.setSeasonName(rs.getString("SEASONTITLE"));
				season.setStartDate(new Timestamp(rs.getDate("SEASONSTARTDT").getTime()));
				season.setEndDate(new Timestamp(rs.getDate("SEASONENDDT").getTime()));
				season.setNumPlayer(rs.getInt("SEASONID"));
				season.setLeagueID(rs.getBigDecimal("SEASONID"));
			}				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return season;
	}

	

	public boolean updateSeason(Season season) {
		String sql = "UPDATE SEASON SET SEASONTITLE = ?, SEASONSTARTDT = ?, SEASONENDDT = ? WHERE SEASONID = ?";
		int count = getJdbcTemplate().update(sql, new Object[] {season.getSeasonName(), season.getStartDate(), season.getEndDate(), season.getSeasonID()});
		if(count > 0)
			return true;
		else
			return false;
	}

	public int getRoleID(String role) {
		String RoleIDsql = "Select RoleID from UserRole where UserRole =?";
		
		int RoleID=(int)getJdbcTemplate().queryForObject(
				RoleIDsql, new Object[] { role }, int.class);
		return RoleID;	
	}

	public int getPhoneTypeID(String PhoneType) {
		String PhoneIDsql = "Select PhoneTypeID from PhoneType where PhoneType =?";
		
		int PhoneTypeID=(int)getJdbcTemplate().queryForObject(
				PhoneIDsql, new Object[] { PhoneType }, int.class);
		return PhoneTypeID;	
	}

	public int getPaymentTypeID(String PaymentType) {
		String PaymentIDsql = "Select PaymentTypeID from PaymentType where PaymentType =?";
		
		int PaymentTypeID=(int)getJdbcTemplate().queryForObject(
				PaymentIDsql, new Object[] { PaymentType }, int.class);
		return PaymentTypeID;	
	}

	public String getfullname(int PersonID) {
		String FullnameSql = "Select FirstName || ' '|| LastName from Person where PersonID =?";
		
		String Fullname=(String)getJdbcTemplate().queryForObject(
				FullnameSql, new Object[] { PersonID }, String.class);
		return Fullname;	
	}
	
	

}
