package com.team3.business.models;

public class User {
	private int userID;
	private String username;
	private String userPassword;
	private String userEmail;
	private String userRole;
	
	public User() {
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userRole=" + userRole + "]";
	}
}
