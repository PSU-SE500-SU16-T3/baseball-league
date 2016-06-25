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
		String sql = "INSERT INTO USERS " +
				"(userName, passw, email, userID, userRole) VALUES (?, ?, ?, userID_SEQ.NEXTVAL, ?)";
					 
		getJdbcTemplate().update(sql, new Object[] { user.getUsername(),
				user.getUserPassword(), user.getUserEmail(), 345});
		
	}

	public void insertPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	public void insertPhone(Phone phone) {
		// TODO Auto-generated method stub
		
	}

	public void insertPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	public void insertLeague(League league) {
		// TODO Auto-generated method stub
		
	}

	public void insertSeason(Season season) {
		// TODO Auto-generated method stub
		
	}

	public void dropSeason(Season season) {
		// TODO Auto-generated method stub
		
	}

	public void insertDivision(Division division) {
		// TODO Auto-generated method stub
		
	}

	public void dropDivision(Division division) {
		// TODO Auto-generated method stub
		
	}

	public void insertTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	public void insertField(Field field) {
		// TODO Auto-generated method stub
		
	}

	public void insertRefereePlayer(RefereePlayer refereePlayer) {
		// TODO Auto-generated method stub
		
	}

	public void insertAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

}
