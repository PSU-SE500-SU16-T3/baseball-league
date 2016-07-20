package com.team3.business.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Season {
	private BigDecimal seasonID;
	private BigDecimal leagueID;
	private String seasonName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
	private Timestamp startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
	private Timestamp endDate;
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

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

}
