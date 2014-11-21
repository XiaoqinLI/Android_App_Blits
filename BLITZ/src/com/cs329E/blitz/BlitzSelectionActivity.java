package com.cs329E.blitz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class BlitzSelectionActivity extends Activity {
	
	private static final String TAG = "Select Event Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blitz_selection);
		
		ImageView movieView = (ImageView) findViewById(R.id.option1_img);
		ImageView restaurantView = (ImageView) findViewById(R.id.option2_img);
		ImageView beerView = (ImageView) findViewById(R.id.option3_img);
		ImageView otherView = (ImageView) findViewById(R.id.option4_img);
		
		movieView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the movie button");
//				Intent restaurantIntent = new Intent(BlitzSelectionActivity.this, RegisterActivity.class);
//				startActivity(restaurantIntent);
			}
		});
		
		restaurantView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the restaurant button");
//				Intent restaurantIntent = new Intent(BlitzSelectionActivity.this, RegisterActivity.class);
//				startActivity(restaurantIntent);
			}
		});
		
		beerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the drink button");
//				Intent restaurantIntent = new Intent(BlitzSelectionActivity.this, RegisterActivity.class);
//				startActivity(restaurantIntent);
			}
		});
		
		otherView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the other button");
//				Intent restaurantIntent = new Intent(BlitzSelectionActivity.this, RegisterActivity.class);
//				startActivity(restaurantIntent);
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
