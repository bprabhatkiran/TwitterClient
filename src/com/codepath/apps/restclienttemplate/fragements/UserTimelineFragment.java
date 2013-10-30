package com.codepath.apps.restclienttemplate.fragements;

import java.util.ArrayList;

import org.json.JSONArray;

import com.codepath.apps.restclienttemplate.RestClientApp;
import com.codepath.apps.restclienttemplate.TweetsAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

public class UserTimelineFragment extends TweetsListFragment {
	public User user;
	
	@Override
	public void displayTweets(int count) {
		if(user != null) {
			RestClientApp.getRestClient().getUserTimeline(user.getID(), count, new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONArray arg0) {
					parseTweets(arg0);
				}
			});
		} else {
			RestClientApp.getRestClient().getUserTimeline(count, new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONArray arg0) {
					parseTweets(arg0);
				}
			});
		}
	}
	
	public void parseTweets(JSONArray jsonTweets) {
		ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
		if(tweetsAdapter == null) {
			tweetsAdapter = new TweetsAdapter(getActivity(), tweets);
			lvTweets.setAdapter(tweetsAdapter);
		} else {
			tweetsAdapter.clear();
			tweetsAdapter.addAll(tweets);
		}
		lvTweets.onRefreshComplete();
	}
}
