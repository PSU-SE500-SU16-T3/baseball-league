package com.team3.business.models;

import java.math.BigDecimal;
import java.util.Date;

public class Game {
	private BigDecimal gameId;	
	private BigDecimal team1Id;
	private BigDecimal team2Id;
	private String gameScore;
	private BigDecimal refereeId;
	private BigDecimal fieldId;
	private Date gameTime;
	private String FieldName;
	public BigDecimal getGameId() {
		return gameId;
	}
	public void setGameId(BigDecimal gameId) {
		this.gameId = gameId;
	}
	public BigDecimal getTeam1Id() {
		return team1Id;
	}
	public void setTeam1Id(BigDecimal team1Id) {
		this.team1Id = team1Id;
	}
	public BigDecimal getTeam2Id() {
		return team2Id;
	}
	public void setTeam2Id(BigDecimal team2Id) {
		this.team2Id = team2Id;
	}
	public String getGameScore() {
		return gameScore;
	}
	public void setGameScore(String gameScore) {
		this.gameScore = gameScore;
	}
	public BigDecimal getRefereeId() {
		return refereeId;
	}
	public void setRefereeId(BigDecimal refereeId) {
		this.refereeId = refereeId;
	}
	public BigDecimal getFieldId() {
		return fieldId;
	}
	public void setFieldId(BigDecimal fieldId) {
		this.fieldId = fieldId;
	}
	public Date getGameTime() {
		return gameTime;
	}
	public void setGameTime(Date gameTime) {
		this.gameTime = gameTime;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
}
