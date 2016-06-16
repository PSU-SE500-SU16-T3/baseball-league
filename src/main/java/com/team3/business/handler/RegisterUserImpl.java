package com.team3.business.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.User;
import com.team3.dao.Dao;

@Service("registerUser")
public class RegisterUserImpl implements RegisterUser{
	
	@Autowired
	Dao daoImpl;

	public void processUser(Map<String, String> allRequestParams) {
		User user = new User();
		user.setUsername(allRequestParams.get("username"));
		user.setUserPassword(allRequestParams.get("password"));
		user.setUserEmail(allRequestParams.get("email"));
		daoImpl.insert(user);
	}

}
