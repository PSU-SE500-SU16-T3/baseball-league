package com.team3.business.models;

import java.util.Calendar;

public class Season {
	private int seasonID;
	private int leagueID;
	private String seasonName;
	private Calendar startDate;
	private Calendar endDate;
	private int numPlayer;
	
	public Season() {
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

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

}
