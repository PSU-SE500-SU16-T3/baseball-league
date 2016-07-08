package com.team3.business.handler;

import java.util.List;
import java.util.Map;

import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Season;
import com.team3.business.models.User;


public interface RegisterUser {
	public User processUser(Map<String,String> allRequestParams);
	public List<League> getLeague();
	public List<Season> getSeasons(Map<String, String> allRequestParams);
	public List<Division> getDivisions(Map<String, String> allRequestParams);
}
