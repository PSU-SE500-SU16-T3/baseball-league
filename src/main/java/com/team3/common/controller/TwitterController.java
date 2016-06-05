package com.team3.common.controller;



import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterController {

	public static void main(String[] args){
		twitter4j.Twitter twit = getTwitter();
		ResponseList<Status> statuses;
		try {
			statuses = twit.getHomeTimeline();

		for(Status st : statuses){
			Post();
			System.out.println("-----"+st.getUser().getName()+"-----"+st.getText());
		}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static twitter4j.Twitter getTwitter(){
		//Setup with App info from twitter
		ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("GSJj2oH3aVrlpygN5ezRyxhKY")
			.setOAuthConsumerSecret("AVFfzl2zkgTBo2G1uHHnxtRAOYv4Ecoo56P6VB79h186YomHwU")
			.setOAuthAccessToken("739570400657428480-kvnoG4MGhthKpYo3Q4MmFqWG9Zy8Ikr")
			.setOAuthAccessTokenSecret("mJ6VliReWNfnSbyXgXoxOreeQ2FqDVRq9qlUKwimdMOkV");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twit = tf.getInstance();
		return twit;
	}
	
	public static void Post(){
		twitter4j.Twitter twit = getTwitter();
		try {
			Status Stat = twit.updateStatus("I'm Tweeting from Java!");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
