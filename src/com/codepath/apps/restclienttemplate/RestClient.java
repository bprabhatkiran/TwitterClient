package com.codepath.apps.restclienttemplate;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class RestClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
    public static final String REST_URL = "https://api.twitter.com/1.1";
    public static final String REST_CONSUMER_KEY = "kMqSQFHOaLRO1TOwARUkg";
    public static final String REST_CONSUMER_SECRET = "lhotp7RGm8xOhVxwqJGSEmBMpfRTmPtQRn0TMmzk";
    public static final String REST_CALLBACK_URL = "oauth://demotwitterapp"; // Change this (here and in manifest)
    
    public RestClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }
    
    // Wrapper around statuses endpoint
    public void getStatuses(int count, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/home_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", Integer.toString(count));
        client.get(apiUrl, params, handler);
    }
    
    public void getMentions(int count, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/mentions_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", Integer.toString(count));
        client.get(apiUrl, params, handler);
    }
    
    public void getAccountCredentials(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("account/verify_credentials.json");
        client.get(apiUrl, null, handler);
    }
    
    public void getUserTimeline(int count, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/user_timeline.json");
        RequestParams params = new RequestParams();
        params.put("count", Integer.toString(count));
        client.get(apiUrl, params, handler);
    }
    
    public void postTweet(String statusUpdate, AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("statuses/update.json");
        RequestParams params = new RequestParams();
        params.put("status", statusUpdate);
        client.post(apiUrl, params, handler);
    }
}