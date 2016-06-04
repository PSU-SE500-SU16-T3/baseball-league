package com.team3.business.models;

public class Division {
	private int divisionID;
	private int seasonID;
	private int leagueID;
	private String divisionTitle;
	private int divisionMinAge;
	private int divisionMaxAge;
	private int divisionNumPlayers;
	
	public int getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}
	public int getSeasonID() {
		return seasonID;
	}
	public void setSeasonID(int seasonID) {
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
	public int getDivisionMinAge() {
		return divisionMinAge;
	}
	public void setDivisionMinAge(int divisionMinAge) {
		this.divisionMinAge = divisionMinAge;
	}
	public int getDivisionMaxAge() {
		return divisionMaxAge;
	}
	public void setDivisionMaxAge(int divisionMaxAge) {
		this.divisionMaxAge = divisionMaxAge;
	}
	public int getDivisionNumPlayers() {
		return divisionNumPlayers;
	}
	public void setDivisionNumPlayers(int divisionNumPlayers) {
		this.divisionNumPlayers = divisionNumPlayers;
	}
}
