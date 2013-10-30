package com.codepath.apps.restclienttemplate.models;

import java.io.Serializable;

import org.json.JSONObject;

@SuppressWarnings("serial")
public class User implements Serializable {
    private String name;
    private long userId;
    private String screenName;
    private String profileImageUrl;
    private String profileBackgroundImageUrl;
    private int numTweets;
    private int followersCount;
    private int friendsCount;
    private String description;
    
	public String getName() {
		return name;
	}
	
	public long getID() {
		return userId;
	}
	
	public String getSreenName() {
		return screenName;
	}
	
	public String getProfileImageURL() {
		return profileImageUrl;
	}
	
	public String getProfileBackgroundImageURL() {
		return profileBackgroundImageUrl;
	}
	
	public int getNumTweets() {
		return numTweets;
	}
	
	public int getFollowersCount() {
		return followersCount;
	}
	
	public int getFriendsCount() {
		return friendsCount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static User fromJson(JSONObject json) {
        User u = new User();
        try {
                u.userId = json.getLong("id");
                u.name = json.getString("name");
                u.screenName = json.getString("screen_name");
                u.profileImageUrl = json.getString("profile_image_url");
                u.profileBackgroundImageUrl = json.getString("profile_background_image_url");
                u.numTweets = json.getInt("statuses_count");
                u.followersCount = json.getInt("followers_count");
                u.friendsCount = json.getInt("friends_count");
                u.description = json.getString("description");
        } catch (Exception e) {
                e.printStackTrace();
                return null;
        }
        return u;
	}
}
