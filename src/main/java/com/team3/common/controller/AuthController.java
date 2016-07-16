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
import com.team3.business.models.Player;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.Response;

@Controller
public class AuthController {
	
	@Autowired
	private RegisterUser registerUser;	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response<PlayerRole> login(@RequestParam Map<String,String> allRequestParams) {
		PlayerRole playerRole = registerUser.getUserDetails(allRequestParams);
		Response<PlayerRole> response = new Response<PlayerRole>();
		if(playerRole.getRoleId().equals("10000")){
			response.setBody(playerRole);
			response.setRedirectTo("/admin/home");
			response.setStatus("success");
		}
		return response;
	}	
}
