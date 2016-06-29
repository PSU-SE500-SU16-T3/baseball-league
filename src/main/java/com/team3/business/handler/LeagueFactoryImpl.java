package com.team3.business.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.League;
import com.team3.dao.Dao;

public class LeagueFactoryImpl implements LeagueFactory {
	@Autowired
	Dao daoImpl;
	
	public League processUser(Map<String, String> allRequestParams) {
		
		return null;
	}

	public League GetLeague(Map<String, String> allRequestParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public void SetLeagueParams(Map<String, String> allRequestParams) {
		// TODO Auto-generated method stub
		
	}

}
