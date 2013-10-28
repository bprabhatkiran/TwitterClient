package com.codepath.apps.restclienttemplate.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.TweetsAdapter;
import com.codepath.apps.restclienttemplate.helpers.EndlessScrollListener;

import eu.erikw.PullToRefreshListView;
import eu.erikw.PullToRefreshListView.OnRefreshListener;

public abstract class TweetsListFragment extends Fragment {
	
	TweetsAdapter tweetsAdapter;
	PullToRefreshListView lvTweets;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_tweets_list, container, false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		displayTweets();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		lvTweets = (PullToRefreshListView) getActivity().findViewById(R.id.lvTweets);
		lvTweets.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				displayTweets();
			}
		});

		lvTweets.setOnScrollListener(new EndlessScrollListener() {

			@Override
			public void onLoadMore(int page, int totalItemsCount) {
				if(tweetsAdapter == null) {
					displayTweets();
				} else {
					displayTweets(tweetsAdapter.getCount() + 10);
				}
			}
		});
	}
	
	public void displayTweets() {
		displayTweets(25);
	}
	
	public abstract void displayTweets(int count);
}
