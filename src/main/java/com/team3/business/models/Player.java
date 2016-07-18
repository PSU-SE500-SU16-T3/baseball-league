package com.team3.business.models;


import java.math.BigDecimal;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.math.BigDecimal;
import java.util.Calendar;


public class Player {
	private BigDecimal personID;
	private String firstName;	
	private String lastName;

	private String middleName;

	private Calendar dateOfBirth;


	public BigDecimal getPersonID() {
		return personID;
	}
	public void setPersonID(BigDecimal personID) {
		this.personID = personID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;

	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
