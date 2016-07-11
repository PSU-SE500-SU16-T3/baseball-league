package com.team3.business.handler;
import java.util.Map;

import com.team3.business.models.League;

public interface LeagueFactory {
	public League GetLeague(Map<String,String> allRequestParams);
	public League SetLeagueParams(Map<String,String> allRequestParams);
	public League processUser(Map<String,String> allRequestParams);
}
