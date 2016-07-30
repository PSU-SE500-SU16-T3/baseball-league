package com.team3.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.team3.business.handler.LeagueFactory;
import com.team3.business.models.League;


@Controller
public class CreateLeagueController {
	
	public void setLeagueFactory(LeagueFactory leagueFactory) {
	}
}
