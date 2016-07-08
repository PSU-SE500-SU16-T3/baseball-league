package com.team3.business.models;

import java.math.BigDecimal;

public class League {
	private BigDecimal leagueID;
	private String leagueName;
	private String leagueLocation;
	private int userID;
	
	public League() {
	}

	public BigDecimal getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(BigDecimal leagueID) {
		this.leagueID = leagueID;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueLocation() {
		return leagueLocation;
	}

	public void setLeagueLocation(String leagueLocation) {
		this.leagueLocation = leagueLocation;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
