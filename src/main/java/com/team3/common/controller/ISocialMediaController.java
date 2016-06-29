package com.team3.common.controller;

public interface ISocialMediaController {
	void PostStatus(String Post);
	void getStatuses(int NumberofPreviousStatuses);
}
