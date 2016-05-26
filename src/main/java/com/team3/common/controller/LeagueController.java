package com.team3.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.business.models.Team;

@Controller
public class LeagueController {
	
	@RequestMapping(value="/getJson", method = RequestMethod.GET)
	public @ResponseBody Team getShopInJSON() {

		Team team = new Team();
		team.setFirstName("Abhijit");
		team.setLastName("Sonis");
		team.setAge(35);
		return team;

	}
}
