package com.team3.business.models;

public class Phone {
	private int phoneID;
	private int phoneType;
	private String phoneNum;
	private int personID;
	
	public int getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(int phoneID) {
		this.phoneID = phoneID;
	}
	public int getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
}
