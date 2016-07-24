package com.team3.common.controller;

import java.io.Console;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.business.handler.ISocialMediaHandler;
import com.team3.business.handler.SocialMediaFactory;
import com.team3.business.handler.SocialMediaTypes;
import com.team3.business.models.Response;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SocialMediaController {
	@Autowired
	private SocialMediaFactory socialmediafactory;	
	
	public void setSocialmediafactory(SocialMediaFactory socialmediafactory) {
		this.socialmediafactory = socialmediafactory;
	}
	
	@RequestMapping(value="/postmessage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void Postmessage(@RequestParam Map<String,String> allRequestParams) {
		if (allRequestParams.get("service").equals("twitter")){
			ISocialMediaHandler twitterhandler = socialmediafactory.getHandler(SocialMediaTypes.TwitterHandler);
			twitterhandler.PostStatus(allRequestParams.get("message"));
		} else if (allRequestParams.get("service").equals("facebook")){
			ISocialMediaHandler facebookhandler = socialmediafactory.getHandler(SocialMediaTypes.FacebookHandler);
			facebookhandler.PostStatus(allRequestParams.get("message"));
		}
		else if (allRequestParams.get("service").equals("email")){
			ISocialMediaHandler emailhandler = socialmediafactory.getHandler(SocialMediaTypes.EmailHandler);
			emailhandler.PostStatus(allRequestParams.get("message"));
		} else
		{
			System.out.println(allRequestParams.get("service"));
		}
		
	}
	
	
}
