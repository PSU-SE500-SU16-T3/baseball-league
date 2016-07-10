package com.team3.business.authorization;

public interface UserRegistry {
	  GaeUser findUser(String userId);
	  void registerUser(GaeUser newUser);
	  void removeUser(String userId);
}
