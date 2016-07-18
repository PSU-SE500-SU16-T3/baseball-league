package com.team3.business.models;

import java.math.BigDecimal;
<<<<<<< HEAD
import java.util.Calendar;
=======
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> branch 'master' of https://github.com/PSU-SE500-SU16-T3/baseball-league.git

public class Player {
	private BigDecimal personID;
	private String firstName;	
	private String lastName;
	private String middleName;
<<<<<<< HEAD
	private Calendar dateOfBirth;
=======
	private Date dateOfBirth;
>>>>>>> branch 'master' of https://github.com/PSU-SE500-SU16-T3/baseball-league.git
	
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
<<<<<<< HEAD
	public Calendar getDateOfBirth() {
=======
	public Date getDateOfBirth() {
>>>>>>> branch 'master' of https://github.com/PSU-SE500-SU16-T3/baseball-league.git
		return dateOfBirth;
	}
<<<<<<< HEAD
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
=======
	public void setDateOfBirth(Date dob) {
		this.dateOfBirth = dob;
>>>>>>> branch 'master' of https://github.com/PSU-SE500-SU16-T3/baseball-league.git
	}
}
