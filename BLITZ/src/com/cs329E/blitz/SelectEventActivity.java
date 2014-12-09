package com.cs329E.blitz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectEventActivity extends Activity {
	
	private static final String TAG = "Select Event Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_event);
		
		ImageView movieView = (ImageView) findViewById(R.id.option1_img);
		ImageView restaurantView = (ImageView) findViewById(R.id.option2_img);
		ImageView barView = (ImageView) findViewById(R.id.option3_img);
		ImageView otherView = (ImageView) findViewById(R.id.option4_img);
		
		restaurantView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the restaurant button");
				Intent restaurantIntent = new Intent(getBaseContext(), SelectContactActivity.class);
				restaurantIntent.putExtra("EXTRA_EVENT_NAME", "RESTAURANT");
				startActivity(restaurantIntent);
			}
		});
		
		movieView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the movie button");
				Intent movieIntent = new Intent(getBaseContext(), SelectContactActivity.class);
				movieIntent.putExtra("EXTRA_EVENT_NAME", "MOVIE");
				startActivity(movieIntent);
			}
		});
		
		barView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the bar button");
				Intent barIntent = new Intent(getBaseContext(), SelectContactActivity.class);
				barIntent.putExtra("EXTRA_EVENT_NAME", "BAR");
				startActivity(barIntent);
			}
		});
		
		otherView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the other button");
				Intent otherIntent = new Intent(getBaseContext(), SelectContactActivity.class);
				otherIntent.putExtra("EXTRA_EVENT_NAME", "OTHER");
				startActivity(otherIntent);
			}
		});
		
		Button invitationsButton = (Button) findViewById(R.id.invitationsButton);		
		invitationsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the invitations button");
				Intent invitationsIntent = new Intent(getBaseContext(), MyInvitationsActivity.class);
				startActivity(invitationsIntent);
			}
		});
			
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blitz_selection, menu);
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
