package com.codepath.apps.restclienttemplate.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tweet extends BaseModel {
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public String getBody() {
		return getString("text");
	}
	
	public Long getId() {
		return getLong("id");
	}
	
	public static Tweet fromJson(JSONObject jsonObject) {
		Tweet newTweet = new Tweet();
		newTweet.jsonObject = jsonObject;
		try {
			newTweet.user = User.fromJson(jsonObject.getJSONObject("user"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newTweet;
	}
	
	public static ArrayList<Tweet> fromJson(JSONArray jsonArray) {
		ArrayList<Tweet> result = new ArrayList<Tweet>();
		
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = null;
			try {
				jsonObject = jsonArray.getJSONObject(i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tweet newTweet = Tweet.fromJson(jsonObject);
			if(newTweet != null) {
				result.add(newTweet);
			}
		}
		return result;
	}
}
