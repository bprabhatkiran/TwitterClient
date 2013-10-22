package com.codepath.apps.restclienttemplate.models;

import org.json.JSONObject;

public class User extends BaseModel {
	
	public String getName() {
		return getString("name");
	}
	
	public long getID() {
		return getLong("id");
	}
	
	public String getSreenName() {
		return getString("screen_name");
	}
	
	public String getProfileImageURL() {
		return getString("profile_image_url");
	}
	
	public String getProfileBackgroundImageURL() {
		return getString("profile_background_image_url");
	}
	
	public int getNumTweets() {
		return getInt("statuses_count");
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public static User fromJson(JSONObject jsonObject) {
		User newUser = new User();
		
		newUser.jsonObject = jsonObject;
		
		return newUser;
	}

}
