package com.team3.business.models;
// comment
public class Address {
	//test2
	private int addressID;
	private int personID;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPersonID() {
		return this.personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
