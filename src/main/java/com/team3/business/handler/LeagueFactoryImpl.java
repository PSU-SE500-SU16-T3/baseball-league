package com.team3.business.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.dao.Dao;

@Service("leagueFactory")
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

	// use case 1
	public League SetLeagueParams(Map<String, String> allRequestParams) {
		League league = new League();
		league.setLeagueName(allRequestParams.get("leagueName"));
		league.setLeagueLocation(allRequestParams.get("leagueLocation"));
		league.setLeagueID(null); //todo
		
		daoImpl.insertLeague(league);
		
		return league;
	}
}
