package com.team3.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.business.handler.RegisterUser;
import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
import com.team3.business.models.User;

@Controller
public class LeagueController {
	
	@Autowired
	private RegisterUser registerUser;
	
	@RequestMapping(value="/getJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Player getShopInJSON(@RequestParam Map<String,String> allRequestParams) {
		System.out.println(allRequestParams);
		Player player = registerUser.processUser(allRequestParams);
		return player;

	}
	
	@RequestMapping(value="/getLeague", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<League> getLeague() {
		List<League> leagues = registerUser.getLeague();
		return leagues;

	}
	
	@RequestMapping(value="/getSeasons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Season> getSeasons(@RequestParam Map<String,String> allRequestParams) {
		List<Season> seasons = registerUser.getSeasons(allRequestParams);
		return seasons;

	}
	
	@RequestMapping(value="/getDivisions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Division> getDivisions(@RequestParam Map<String,String> allRequestParams) {
		List<Division> divisions = registerUser.getDivisions(allRequestParams);
		return divisions;

	}
}
