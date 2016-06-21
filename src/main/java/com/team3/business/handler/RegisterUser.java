package com.team3.business.handler;

import java.util.Map;

import com.team3.business.models.User;


public interface RegisterUser {
	public User processUser(Map<String,String> allRequestParams);
}
