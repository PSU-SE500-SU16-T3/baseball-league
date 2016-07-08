package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Season;
import com.team3.business.models.User;
import com.team3.dao.Dao;

@Service("registerUser")
public class RegisterUserImpl implements RegisterUser{
	
	@Autowired
	Dao daoImpl;

	public User processUser(Map<String, String> allRequestParams) {
		User user = new User();
		user.setUsername(allRequestParams.get("username"));
		user.setUserPassword(allRequestParams.get("password"));
		user.setUserEmail(allRequestParams.get("email"));
		daoImpl.insertUser(user);
		return user;
	}
	
	public List<League> getLeague() {
		List<League> leagues = daoImpl.getLeague();
		return leagues;
	}
	
	public List<Season> getSeasons(Map<String, String> allRequestParams) {
		String leagueId = allRequestParams.get("leagueId");
		List<Season> seasons = daoImpl.getSeasons(leagueId);
		return seasons;
	}

	public List<Division> getDivisions(Map<String, String> allRequestParams) {
		String seasonId = allRequestParams.get("seasonId");
		List<Division> divisions = daoImpl.getDivisions(seasonId);
		return divisions;
	}

}
