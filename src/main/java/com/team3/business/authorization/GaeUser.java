package com.team3.business.authorization;

import java.io.Serializable;
import java.util.Set;

public class GaeUser implements Serializable{
	 private  String userId;
	  private  String email;
	  private  String nickname;
	  private  String forename;
	  private  String surname;
	  private  Set<AppRole> authorities;
	  private  boolean enabled;
	  
	public String getUserId() {
		return userId;
	}
	public String getEmail() {
		return email;
	}
	public String getNickname() {
		return nickname;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public Set<AppRole> getAuthorities() {
		return authorities;
	}
	public boolean isEnabled() {
		return enabled;
	}
	  
	  
}
