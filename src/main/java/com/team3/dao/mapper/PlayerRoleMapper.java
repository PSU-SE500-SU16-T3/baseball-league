package com.team3.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;

public class PlayerRoleMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlayerRole playerRole = new PlayerRole();
		Player player = new Player();
		player.setPersonID((rs.getBigDecimal("PERSONID")));
		player.setFirstName((String)(rs.getString("FIRSTNAME")));
		player.setLastName((String)(rs.getString("LASTNAME")));
		playerRole.setPlayer(player);
		playerRole.setRoleId((String)(rs.getString("ROLEID")));
		return playerRole;
	}
	
}