package com.team3.business.handler;

import facebook4j.FacebookException;
import twitter4j.TwitterException;

public interface ISocialMediaHandler {
	void PostStatus(String Post) throws TwitterException, FacebookException;
	void getStatuses(int NumberofPreviousStatuses);
	void sendEmail(String string, String string2);
}
