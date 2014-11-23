package com.cs329E.blitz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class SelectLocationActivity extends Activity {
	private LinearLayout layout;
	private String eventName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_location);
		
		layout =(LinearLayout)findViewById(R.id.select_location_activity_bg);
		Intent intent = getIntent();
		eventName = intent.getStringExtra("EXTRA_EVENT_NAME");
		if (eventName.equals("BAR")){
			layout.setBackgroundResource(R.drawable.blitzbg_bars);
		}
		else if (eventName.equals("RESTAURANT")){
			layout.setBackgroundResource(R.drawable.blitzbg_restaurants);
		}
		else if (eventName.equals("MOVIE")){
			layout.setBackgroundResource(R.drawable.blitzbg_movies);
		}
		else if (eventName.equals("OTHER")){
			layout.setBackgroundResource(R.drawable.blitzbg_events);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_location, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
