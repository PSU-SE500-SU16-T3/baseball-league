package com.team3.common.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.business.handler.RegisterUser;
import com.team3.business.models.Division;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
import com.team3.business.models.TeamAssignment;

@Controller
public class LeagueController {
	
	@Autowired
	private RegisterUser registerUser;
	
	ObjectMapper mapper = new ObjectMapper();
	
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
	
	@RequestMapping(value="/getUnassignedPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getUnassignedPlayers() {
		List<Player> players = registerUser.getUnassignedPlayers();
		return players;

	}
	
	@RequestMapping(value="/getAssignedPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getAssignedPlayers(@RequestParam Map<String,String> allRequestParams) {
		List<Player> players = registerUser.getAssignedPlayers(allRequestParams);
		return players;

	}
	
	@RequestMapping(value="/modifyPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean modifyPlayers(@RequestParam Map<String,String> allRequestParams) throws JsonParseException, JsonMappingException, IOException {
		List<TeamAssignment> teamAssignments = Arrays.asList(mapper.readValue(allRequestParams.get("assignedPlayers").toString(),TeamAssignment[].class));
		boolean status = registerUser.modifyPlayers(teamAssignments);
		return status;

	}
}
