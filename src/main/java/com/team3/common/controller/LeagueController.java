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
import com.team3.business.models.Game;
import com.team3.business.models.League;
import com.team3.business.models.Player;
import com.team3.business.models.Response;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.TeamAssignment;
import com.team3.business.models.TeamAssignments;

@Controller
public class LeagueController {
	
	@Autowired
	private RegisterUser registerUser;
	
	public void setRegisterUser(RegisterUser registerUser) {
		this.registerUser = registerUser;
	}
	
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/getJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Player getShopInJSON(@RequestParam Map<String,String> allRequestParams) {
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
	
	@RequestMapping(value="/getTeams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Team> getTeams(@RequestParam Map<String,String> allRequestParams) {
		List<Team> teams = registerUser.getTeams(allRequestParams);
		return teams;

	}
	
	@RequestMapping(value="/getUnassignedPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getUnassignedPlayers(@RequestParam Map<String,String> allRequestParams) {
		List<Player> players = registerUser.getUnassignedPlayers(allRequestParams);
		return players;

	}
	
	@RequestMapping(value="/getAssignedPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getAssignedPlayers(@RequestParam Map<String,String> allRequestParams) {
		List<Player> players = registerUser.getAssignedPlayers(allRequestParams);
		return players;

	}
	
	@RequestMapping(value="/modifyPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean modifyPlayers(@RequestParam Map<String,String> allRequestParams) throws JsonParseException, JsonMappingException, IOException {
		List<TeamAssignment> teamAssignmentList = Arrays.asList(mapper.readValue(allRequestParams.get("assignedPlayers").toString(),TeamAssignment[].class));
		TeamAssignments teamAssignment = new TeamAssignments();
		teamAssignment.setTeamAssignments(teamAssignmentList);
		teamAssignment.setTeamId(allRequestParams.get("teamId"));
		boolean status = registerUser.modifyPlayers(teamAssignment);
		return status;

	}
	
	@RequestMapping(value="/registerSeason", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> registerSeason(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.registerSeason(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Season created successfully.");
		}
		return response;

	}
	
	@RequestMapping(value="/registerDivision", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> registerDivision(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.registerDivision(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Division created successfully.");
		}
		return response;

	}
	
	@RequestMapping(value="/registerTeam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> registerTeam(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.registerTeam(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Team created successfully.");
		}
		return response;

	}
	
	@RequestMapping(value="/getSeasonDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Season getSeasonDetail(@RequestParam Map<String,String> allRequestParams) {
		Season season = registerUser.getSeasonDetail(allRequestParams);
		return season;

	}
	
	@RequestMapping(value="/updateSeason", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> updateSeason(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.updateSeason(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Season information updated successfully.");
		}
		return response;
	}
	
	@RequestMapping(value="/getDivisionDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Division getDivisionDetail(@RequestParam Map<String,String> allRequestParams) {
		Division division = registerUser.getDivisionDetail(allRequestParams);
		return division;

	}
	
	@RequestMapping(value="/updateDivision", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> updateDivision(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.updateDivision(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Division information updated successfully.");
		}
		return response;
	}
	
	@RequestMapping(value="/updateTeam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<String> updateTeam(@RequestParam Map<String,String> allRequestParams) {
		boolean status = registerUser.updateTeam(allRequestParams);
		Response<String> response = new Response<String>();
		if(status){
			response.setStatus("success");
			response.setBody("Team information updated successfully.");
		}
		return response;
	}
	
	@RequestMapping(value="/getGames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Game> getGames(@RequestParam Map<String,String> allRequestParams) {
		List<Game> Games = registerUser.getGames(allRequestParams);
		return Games;
	}
}
