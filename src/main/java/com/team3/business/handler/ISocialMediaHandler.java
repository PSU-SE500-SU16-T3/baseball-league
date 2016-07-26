package com.team3.business.handler;

public interface ISocialMediaHandler {
	void PostStatus(String Post);
	void getStatuses(int NumberofPreviousStatuses);
	void sendEmail(String string, String string2);
}
