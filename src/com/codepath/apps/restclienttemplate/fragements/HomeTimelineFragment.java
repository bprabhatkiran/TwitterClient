package com.codepath.apps.restclienttemplate.fragements;

import java.util.ArrayList;

import org.json.JSONArray;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.restclienttemplate.RestClientApp;
import com.codepath.apps.restclienttemplate.TweetsAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class HomeTimelineFragment extends TweetsListFragment {
	@Override
	public void displayTweets(int count) {
		RestClientApp.getRestClient().getStatuses(count, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONArray jsonTweets) {
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
			public void onFailure(Throwable e) {
				Log.d("DEBUG", "Fetch timeline error: " + e.toString());
			}
		});
	}

}
