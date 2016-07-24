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
	
@Controller
public class RegisterController { 
	
	@Autowired
	private RegisterUser registerUser;
	
	public void setRegisterUser(RegisterUser registerUser) {
		this.registerUser = registerUser;
	}
	@RequestMapping(value="/addperson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addperson(@RequestParam Map<String,String> allRequestParams) {
		registerUser.addperson(allRequestParams);

	}
	@RequestMapping(value="/addaddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addaddress(@RequestParam Map<String,String> allRequestParams) {
		registerUser.addaddress(allRequestParams);
		

	}
	@RequestMapping(value="/addpayment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addpayment(@RequestParam Map<String,String> allRequestParams) {
		registerUser.addpayment(allRequestParams);
	}
}


