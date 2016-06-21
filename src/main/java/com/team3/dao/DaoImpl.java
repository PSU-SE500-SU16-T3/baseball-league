package com.team3.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.team3.business.models.User;

@Component("daoImpl")
public class DaoImpl extends JdbcDaoSupport implements Dao{

	public void insert(User user) {
		String sql = "INSERT INTO USERS " +
				"(userName, passw, email, userID, userRole) VALUES (?, ?, ?, userID_SEQ.NEXTVAL, ?)";
					 
		getJdbcTemplate().update(sql, new Object[] { user.getUsername(),
				user.getUserPassword(), user.getUserEmail(), 345});
		
	}

}
