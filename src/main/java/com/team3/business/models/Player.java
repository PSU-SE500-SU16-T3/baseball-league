package com.team3.business.models;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Player {
	private String firstName;
	private int personID;
	private String lastName;
	private String middleName;
	private SimpleDateFormat dateOfBirth;
	private int userID;
	private int addressID;
	private int phoneID;
	private int paymentID;
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
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
	public SimpleDateFormat getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public int getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(int phoneID) {
		this.phoneID = phoneID;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

}
