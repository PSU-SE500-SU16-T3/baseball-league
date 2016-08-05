package com.team3.business.models;

import java.math.BigDecimal;

public class RefereePlayer extends Player {

	private BigDecimal refereePlayerID;
	private int LeagueID;
	private String fullname;
	public BigDecimal getRefereePlayerID() {
		return refereePlayerID;
	}
	public void setRefereePlayerID(BigDecimal bigDecimal) {
		this.refereePlayerID = bigDecimal;
	}
	public int getLeagueID() {
		return LeagueID;
	}
	public void setLeagueID(int leagueID) {
		LeagueID = leagueID;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
