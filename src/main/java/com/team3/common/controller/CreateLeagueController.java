package com.team3.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.business.handler.RegisterUser;
import com.team3.business.models.Team;
import com.team3.business.models.User;

@Controller
public class CreateLeagueController {
	
	// todo:  this will process the leagueName and leagueLocation.  
	//  Is LeagueFactoryImpl.SetLeagueParams() intended for this or should I create other class
}
