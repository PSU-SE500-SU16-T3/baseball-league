package com.team3.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

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
import com.team3.business.models.TeamAssignments;
import com.team3.business.models.User;

@Component("daoImpl")
public class DaoImpl extends JdbcDaoSupport implements Dao{

	public void insertUser(User user) {
		String sql = "INSERT INTO USERS (userName, passw, email, userRole) VALUES (?, ?, ?, ?)";
					 
		getJdbcTemplate().update(sql, new Object[] { user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserRole()});
		
	}

	public void insertPlayer(Player player) {
		String sql = "INSERT INTO PERSON (dob, firstname, lastname, middlename) VALUES (?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] {player.getDateOfBirth(), player.getFirstName(), player.getLastName(), player.getMiddleName() });
	}

	public void insertPhone(Phone phone) {
		String sql = "INSERT INTO PHONE (phnetype,  phonenumber) VALUES (?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { phone.getPhoneType(), phone.getPhoneNum()});
	}

	public void insertPayment(Payment payment) {
		String sql = "INSERT INTO PAYMENT (cardnumber, crvcode, expdate, nameoncard, paymenttype) VALUES (?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { payment.getCardNumber(), payment.getCvvCode(), payment.getExpDate(), payment.getNameOnCard(), payment.getPaymentType()});
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
		String sql = "INSERT INTO address(LINE1, LINE2, CITY, STATE, ZIP, ADDRESSTYPE) VALUES ( ?, ?, ?, ?, ?, ?)";
		 
		getJdbcTemplate().update(sql, new Object[] { address.getAddressLine1(), address.getAddressLine2(), address.getCity(), address.getState(), address.getZip(), address.getAddressType()});
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
		return false;
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

}
