package com.team3.dao;

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
import com.team3.business.models.User;

@Component("daoImpl")
public class DaoImpl extends JdbcDaoSupport implements Dao{

	public void insertUser(User user) {
		String sql = "INSERT INTO USERS (userName, passw, email, userID, userRole) VALUES (?, ?, ?, userID_SEQ.NEXTVAL, ?);";
					 
		getJdbcTemplate().update(sql, new Object[] { user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserRole()});
		
	}

	public void insertPlayer(Player player) {
		String sql = "INSERT INTO PERSON (addressid, dob, firstname, lastname, middlename, paymentid, phoneid, userid, personid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, personid_SEQ.NEXTVAL);";
		 
		getJdbcTemplate().update(sql, new Object[] { player.getAddressID(), player.getDateOfBirth(), player.getFirstName(), player.getLastName(), player.getMiddleName(), player.getPaymentID(), player.getPhoneID(), player.getUserID()});
	}

	public void insertPhone(Phone phone) {
		String sql = "INSERT INTO PHONE (phnetype, phoneid, phonenumber) VALUES (?, phoneid_SEQ.NEXTVAL, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { phone.getPhoneType(), phone.getPhoneNum()});
	}

	public void insertPayment(Payment payment) {
		String sql = "INSERT INTO PAYMENT (cardnumber, crvcode, expdate, nameoncard, paymentid, paymenttype) VALUES (?, ?, ?, ?, paymentid_SEQ.NEXTVAL, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { payment.getCardNumber(), payment.getCvvCode(), payment.getExpDate(), payment.getNameOnCard(), payment.getPaymentType()});
	}

	public void insertLeague(League league) {
		String sql = "INSERT INTO league( leagueid, leaguelocation, leaguename, userid) VALUES (leagueid_SEQ.NEXTVAL, ?, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] {league.getLeagueLocation(), league.getLeagueName(), league.getUserID()});
	}

	public void insertSeason(Season season) {
		String sql = "INSERT INTO season(leagueid, seasonenddt, seasonid, seasonnumberofplayers, seasonstartdt, seasontitle) VALUES (?, ?, seasonid_SEQ.NEXTVAL, ?, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { season.getLeagueID(), season.getEndDate(), season.getNumPlayer(), season.getStartDate(), season.getSeasonName()});
	}

	public void dropSeason(Season season) {
		String sql = "DELETE FROM season WHERE SEASONID= ? ;";
		 
		getJdbcTemplate().update(sql, new Object[] { season.getSeasonID()});
	}

	public void insertDivision(Division division) {
		String sql = "INSERT INTO division(DIVISIONID, DIVISIONTITLE, DIVISIONMINAGE, DIVISIONMAXAGE, DIVISIONNUMBEROFPLAYER, SEASONID, LEAGUEID) VALUES (DIVISIONID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { division.getDivisionTitle(), division.getDivisionMinAge(), division.getDivisionMaxAge(), division.getDivisionNumPlayers(), division.getSeasonID(), division.getLeagueID()});
	}

	public void dropDivision(Division division) {
		String sql = "DELETE FROM division WHERE DIVISIONID= ? ;";
		 
		getJdbcTemplate().update(sql, new Object[] { division.getDivisionID()});
	
		
	}

	public void insertTeam(Team team) {
		String sql = "INSERT INTO team(TEAMID, TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID, SEASONID, LEAGUEID, FIELDID, REFEREEID, PERSONID) VALUES (TEAMID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { team.getTeamTitle(), team.getTeamNumPlayers(), team.getDivisionID(), team.getSeasonID(), team.getLeagueID(), team.getFieldID(), team.getRefereeID(), team.getPersonID()});
	}

	public void insertField(Field field) {
		String sql = "INSERT INTO field(FIELDID, FIELDNAME, FIELDLOCATION) VALUES (FIELDID_SEQ.NEXTVAL, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { field.getFieldName(), field.getFieldLocation()});
	}

	public void insertRefereePlayer(RefereePlayer refereePlayer) {
		String sql = "INSERT INTO REFEREEPLAYER(REFEREEID, PERSONID) VALUES (REFEREEID_SEQ.NEXTVAL, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { refereePlayer.getRefereePlayerID()});
	}

	public void insertAddress(Address address) {
		String sql = "INSERT INTO address(ADDRESSID, LINE1, LINE2, CITY, STATE, ZIP, ADDRESSTYPE) VALUES (ADDRESSID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?);";
		 
		getJdbcTemplate().update(sql, new Object[] { address.getAddressLine1(), address.getAddressLine2(), address.getCity(), address.getState(), address.getZip(), address.getAddressType()});
	}

}
