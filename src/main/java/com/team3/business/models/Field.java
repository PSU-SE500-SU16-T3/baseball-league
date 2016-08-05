package com.team3.business.models;

import java.math.BigDecimal;

public class Field {
	private String fieldName;
	private String fieldLocation;
	private BigDecimal fieldID;
	private int LeagueID;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldLocation() {
		return fieldLocation;
	}
	public void setFieldLocation(String fieldLocation) {
		this.fieldLocation = fieldLocation;
	}
	public BigDecimal getFieldID() {
		return fieldID;
	}
	public void setFieldID(BigDecimal bigDecimal) {
		this.fieldID = bigDecimal;
	}
	public int getLeagueID() {
		return LeagueID;
	}
	public void setLeagueID(int leagueID) {
		LeagueID = leagueID;
	}
}
