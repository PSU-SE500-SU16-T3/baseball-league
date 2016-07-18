package com.team3.business.models;

import java.math.BigDecimal;
import java.util.Calendar;

public class Season {
	private BigDecimal seasonID;
	private BigDecimal leagueID;
	private String seasonName;
	private Calendar startDate;
	private Calendar endDate;
	private int numPlayer;
	
	
	public Season() {
	}

	public BigDecimal getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(BigDecimal seasonID) {
		this.seasonID = seasonID;
	}

	public BigDecimal getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(BigDecimal leagueID) {
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
