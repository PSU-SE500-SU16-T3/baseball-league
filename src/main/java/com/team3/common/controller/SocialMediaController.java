package com.team3.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.business.handler.ISocialMediaHandler;
import com.team3.business.handler.RegisterUser;
import com.team3.business.handler.SocialMediaFactory;
import com.team3.business.handler.SocialMediaTypes;

@Controller
public class SocialMediaController {
	@Autowired
	private SocialMediaFactory socialmediafactory;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/twitter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void PostTwitter(@RequestParam Map<String,String> allRequestParams) {
		System.out.println(allRequestParams);
		ISocialMediaHandler twitterhandler = socialmediafactory.getHandler(SocialMediaTypes.TwitterHandler);
		twitterhandler.PostStatus(allRequestParams.get("Message"));
	}
	@RequestMapping(value="/facebook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void PostFacebook(@RequestParam Map<String,String> allRequestParams) {
		System.out.println(allRequestParams);
		ISocialMediaHandler facebookhandler = socialmediafactory.getHandler(SocialMediaTypes.FacebookHandler);
		facebookhandler.PostStatus(allRequestParams.get("Message"));

	}
	@RequestMapping(value="/email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void PostEmail(@RequestParam Map<String,String> allRequestParams) {
		System.out.println(allRequestParams);
		ISocialMediaHandler emailhandler = socialmediafactory.getHandler(SocialMediaTypes.EmailHandler);
		emailhandler.PostStatus(allRequestParams.get("Message"));
	}
	
}
