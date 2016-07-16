package com.team3.business.models;

import java.math.BigDecimal;

public class PlayerRole {
	
	private Player player;
	private String roleId;
	private BigDecimal leagueId;
	private String leagueName;
	
	public BigDecimal getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(BigDecimal leagueId) {
		this.leagueId = leagueId;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}	
}
