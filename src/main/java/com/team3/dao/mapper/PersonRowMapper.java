package com.team3.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.jdbc.core.RowMapper;

import com.team3.business.models.PersonInfo;
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;

public class PersonRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonInfo Person = new PersonInfo();
		Person.setFirstName((String)(rs.getString("FIRSTNAME")));
		Person.setLastName((String)(rs.getString("LASTNAME")));
		Person.setDateOfBirth(rs.getDate("DOB"));
		Person.setHomephoneNum(rs.getString("Home"));
		Person.setUsername(rs.getString("USERNAME"));
		Person.setMobilephoneNum(rs.getString("Mobile"));
		Person.setEmail(rs.getString("email"));
		return Person;
	}
	
}