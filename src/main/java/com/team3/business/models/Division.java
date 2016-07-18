package com.team3.business.models;

import java.math.BigDecimal;

public class Division {
	private BigDecimal divisionID;
	private BigDecimal seasonID;
	private int leagueID;
	private String divisionTitle;
	private BigDecimal divisionMinAge;
	private BigDecimal divisionMaxAge;
	private BigDecimal divisionNumPlayers;
	
	
	public BigDecimal getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(BigDecimal divisionID) {
		this.divisionID = divisionID;
	}
	public BigDecimal getSeasonID() {
		return seasonID;
	}
	public void setSeasonID(BigDecimal seasonID) {
		this.seasonID = seasonID;
	}
	public int getLeagueID() {
		return leagueID;
	}
	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}
	public String getDivisionTitle() {
		return divisionTitle;
	}
	public void setDivisionTitle(String divisionTitle) {
		this.divisionTitle = divisionTitle;
	}
	public BigDecimal getDivisionMinAge() {
		return divisionMinAge;
	}
	public void setDivisionMinAge(BigDecimal divisionMinAge) {
		this.divisionMinAge = divisionMinAge;
	}
	public BigDecimal getDivisionMaxAge() {
		return divisionMaxAge;
	}
	public void setDivisionMaxAge(BigDecimal divisionMaxAge) {
		this.divisionMaxAge = divisionMaxAge;
	}
	public BigDecimal getDivisionNumPlayers() {
		return divisionNumPlayers;
	}
	public void setDivisionNumPlayers(BigDecimal divisionNumPlayers) {
		this.divisionNumPlayers = divisionNumPlayers;
	}
}
