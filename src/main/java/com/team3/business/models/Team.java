package com.team3.business.models;

public class Team {
	private int teamID;
	private String teamTitle;
	private int teamNumPlayers;
	private int divisionID;
	private int seasonID;
	private int fieldID;
	private int leagueID;
	private int refereeID;
	private int personID;
	
	public int getTeamID() {
		return this.teamID;
	}
	
	public String getTeamTitle() {
		return this.teamTitle;
	}
	
	public int getTeamNumPlayers(){
		return this.teamNumPlayers;
	}
	
	public int getDivisionID(){
		return this.divisionID;
	}
	
	public int getSeasonID(){
		return this.seasonID;
	}
	
	public int getFieldID() {
		return this.fieldID;
	}
	
	public int getLeagueID() {
		return this.leagueID;
	}
	
	public int getRefereeID() {
		return this.refereeID;
	}
	
	public int getPersonID() {
		return this.personID;
	}
	
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}
	
	public void setTeamNumPlayers(int teamNumPlayers) {
		this.teamNumPlayers = teamNumPlayers;
	}
	
	public void setDivisionID(int divisonID) {
		this.divisionID = divisonID;
	}
	
	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}
	
	public void setLeagueID(int leagueID) {
		this.leagueID = leagueID;
	}
	
	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}
	
	public void setRefereeID(int refereeID) {
		this.refereeID = refereeID;
	}
	
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
}
