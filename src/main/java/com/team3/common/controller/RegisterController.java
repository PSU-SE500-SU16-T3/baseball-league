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
	import com.team3.business.models.TeamAssignments;

	@Controller
	public class RegisterController { 
		
		@Autowired
		private RegisterUser registerUser;
		
		ObjectMapper mapper = new ObjectMapper();
		
		@RequestMapping(value="/register", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Player getShopInJSON(@RequestParam Map<String,String> allRequestParams) {
			System.out.println(allRequestParams);
			Player player = registerUser.processUser(allRequestParams);
			return player;

		}
	}


