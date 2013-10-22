package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseModel {
	protected JSONObject jsonObject;
	public BaseModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getJSONString() {
		return jsonObject.toString();
	}
	
	public String getString(String name) {
		try {
			return jsonObject.getString(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public long getLong(String name) {
		try {
			return jsonObject.getLong(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getInt(String name) {
		try {
			return jsonObject.getInt(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public double getDouble(String name) {
		try {
			return jsonObject.getDouble(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

}
