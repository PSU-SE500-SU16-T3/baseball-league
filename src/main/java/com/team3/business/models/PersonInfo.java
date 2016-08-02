package com.team3.business.models;

import java.util.Calendar;
import java.util.Date;

public class PersonInfo {
	private String firstName;	
	private String lastName;
	private Date dateOfBirth;
	private String username;
	private String mobilephoneNum;
	private String homephoneNum;
	private String email;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilephoneNum() {
		return mobilephoneNum;
	}
	public void setMobilephoneNum(String mobilephoneNum) {
		this.mobilephoneNum = mobilephoneNum;
	}
	public String getHomephoneNum() {
		return homephoneNum;
	}
	public void setHomephoneNum(String homephoneNum) {
		this.homephoneNum = homephoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
