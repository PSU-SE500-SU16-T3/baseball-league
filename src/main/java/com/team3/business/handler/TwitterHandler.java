package com.team3.business.handler;



import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterHandler implements ISocialMediaHandler  {
	 private static twitter4j.Twitter getTwitter(){

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
	public void PostStatus(String Post){
		twitter4j.Twitter twit = getTwitter();
		try {
			twit.updateStatus(Post);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getStatuses(int NumberofPreviousStatuses) {
		twitter4j.Twitter twit = getTwitter();
		ResponseList<Status> statuses;
		try {
			statuses = twit.getHomeTimeline();

		for(Status st : statuses){
			System.out.println("-----"+st.getUser().getName()+"-----"+st.getText());
		}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
