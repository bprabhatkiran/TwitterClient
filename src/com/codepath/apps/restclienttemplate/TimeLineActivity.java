package com.codepath.apps.restclienttemplate;

import com.codepath.apps.restclienttemplate.fragements.HomeTimelineFragment;
import com.codepath.apps.restclienttemplate.fragements.MentionsFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class TimeLineActivity extends FragmentActivity implements TabListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_line);
		setupNavigationBars();
	}

	private void setupNavigationBars() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		
		Tab homeTab = actionBar.newTab().setTag("HomeTimelineFragment").setText("Home").setIcon(R.drawable.ic_home).setTabListener(this);
		Tab mentionsTab = actionBar.newTab().setTag("MentionsFragment").setText("Mentions").setIcon(R.drawable.ic_mentions).setTabListener(this);
		
		actionBar.addTab(homeTab);
		actionBar.addTab(mentionsTab);
		actionBar.selectTab(homeTab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time_line, menu);
		return true;
	}

	public boolean composeMessage(MenuItem item) {
		Intent i = new Intent(getApplicationContext(), ComposeActivity.class);
		startActivityForResult(i, 0);
		return true;
	}
	
	public void openProfile(MenuItem item) {
		Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
		startActivity(i);
	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
		if(tab.getTag() == "HomeTimelineFragment") {
			fts.add(R.id.frameContainer, new HomeTimelineFragment());
		} else {
			fts.add(R.id.frameContainer, new MentionsFragment());
		}
		fts.commit();
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (requestCode == 0) {
//			// Kind of a hack, as I am not checking the result code
//			displayTweets();
//		}
//	}
}
