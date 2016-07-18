package com.team3.business.models;

import java.math.BigDecimal;

public class Team {
	private BigDecimal teamID;
	private String teamTitle;
	private BigDecimal teamNumPlayers;
	private BigDecimal divisionID;
	private BigDecimal seasonID;
	private BigDecimal fieldID;
	private BigDecimal leagueID;
	private BigDecimal refereeID;
	private BigDecimal personID;
	
	public BigDecimal getTeamID() {
		return this.teamID;
	}
	
	public String getTeamTitle() {
		return this.teamTitle;
	}
	
	public BigDecimal getTeamNumPlayers(){
		return this.teamNumPlayers;
	}
	
	public BigDecimal getDivisionID(){
		return this.divisionID;
	}
	
	public BigDecimal getSeasonID(){
		return this.seasonID;
	}
	
	public BigDecimal getFieldID() {
		return this.fieldID;
	}
	
	public BigDecimal getLeagueID() {
		return this.leagueID;
	}
	
	public BigDecimal getRefereeID() {
		return this.refereeID;
	}
	
	public BigDecimal getPersonID() {
		return this.personID;
	}
	
	public void setTeamID(BigDecimal teamID) {
		this.teamID = teamID;
	}
	
	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}
	
	public void setTeamNumPlayers(BigDecimal teamNumPlayers) {
		this.teamNumPlayers = teamNumPlayers;
	}
	
	public void setDivisionID(BigDecimal divisonID) {
		this.divisionID = divisonID;
	}
	
	public void setSeasonID(BigDecimal seasonID) {
		this.seasonID = seasonID;
	}
	
	public void setLeagueID(BigDecimal leagueID) {
		this.leagueID = leagueID;
	}
	
	public void setFieldID(BigDecimal fieldID) {
		this.fieldID = fieldID;
	}
	
	public void setRefereeID(BigDecimal refereeID) {
		this.refereeID = refereeID;
	}
	
	public void setPersonID(BigDecimal personID) {
		this.personID = personID;
	}
		
}
