package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class TimeLineActivity extends FragmentActivity {
	TweetsAdapter tweetsAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_line);
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
	
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (requestCode == 0) {
//			// Kind of a hack, as I am not checking the result code
//			displayTweets();
//		}
//	}
}
