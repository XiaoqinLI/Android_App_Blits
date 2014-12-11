package com.cs329E.blitz;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devsmart.android.ui.HorizontalListView;

public class SelectLocationActivity extends Activity {
	private static final String TAG = "Select Location Activity";
	private RelativeLayout layout;
	private String eventName;
//	private int[] ids = {R.id.favourite1, R.id.favourite2, R.id.favourite3, R.id.favourite4, R.id.favourite5};
	private TextView eventLabel, locationLabel;
	private AutoCompleteTextView autoCompletetextView;
	
	String locationName;

	private static final String[] RESTAURANT = new String[] { "Mellow Mushroom", "Madam Mam's", 
		"Qdoba Mexican Grill", "Noodles & Company", "Quizno's"};
	private static final String[] MOVIE = new String[] { "Forrest Gump", "The Princess Bride",
		"Harry Potter", "The Hitchhiker's Guide to the Galaxy", "Frozen"};
	private static final String[] BAR = new String[] { "Crown & Anchor Pub", "Posse East", 
		"Cain & Abel's", "Spider House Cafe", "The Hole in the Wall"};

	//	private static ArrayList<FriendFavourites> arrayOfPlayers = new ArrayList<FriendFavourites>();
	//	private ArrayList<Bitmap> items = new ArrayList<Bitmap>();
	private ArrayList<Drawable> items = new ArrayList<Drawable>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		Intent intent = getIntent();
		eventName = intent.getStringExtra("EXTRA_EVENT_NAME");

		if (eventName.equals("RESTAURANT")){
			setContentView(R.layout.activity_select_location_restaurant);			
		}
		else if (eventName.equals("OTHER")){
			setContentView(R.layout.activity_select_location_other);			

		}
		else{
			setContentView(R.layout.activity_select_location_movie_bar);
		}

		if (eventName.equals("BAR") || eventName.equals("RESTAURANT") || eventName.equals("MOVIE")) {
			Button searchButton = (Button) findViewById(R.id.searchingButton);
			searchButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {				
					Log.v(TAG, "User pressed the next button");
					AutoCompleteTextView search = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
					locationName = search.getText().toString();
					Intent nextIntent = new Intent(SelectLocationActivity.this, FinalizeTimeActivity.class);
					nextIntent.putExtra("EXTRA_EVENT_NAME", eventName);
					nextIntent.putExtra("EXTRA_LOCATION_NAME", locationName);
					startActivity(nextIntent);
				}
			});	
			
		}
		
		Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
		Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");

		layout =(RelativeLayout)findViewById(R.id.select_location_activity_bg);	
		locationLabel = (TextView)findViewById(R.id.where_to_blitz);
		locationLabel.setTypeface(GillSans);
		
		
		Button nextButton = (Button) findViewById(R.id.next2);
		nextButton.setTypeface(GillSansLight);
		nextButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Log.v(TAG, "User pressed the next button");
				AutoCompleteTextView search = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
				
				if (eventName.equals("BAR") || eventName.equals("RESTAURANT") || eventName.equals("MOVIE"))
					locationName = search.getText().toString();
				else {
					TextView eventName = (TextView) findViewById(R.id.eventName);
					locationName = eventName.getText().toString();
				}
				
				Intent nextIntent = new Intent(SelectLocationActivity.this, FinalizeTimeActivity.class);
				nextIntent.putExtra("EXTRA_EVENT_NAME", eventName);
				nextIntent.putExtra("EXTRA_LOCATION_NAME", locationName);
				startActivity(nextIntent);
			}
		});	
		
		
		
		if (eventName.equals("BAR")){
			layout.setBackgroundResource(R.drawable.blitzbg_bars);
			locationLabel.setText("Where do you want to go?");
			
			ArrayList<Location> locations = new ArrayList<Location>();
			AutoCompleteTextView txtLocations;
			LocationAdapter adapter;
			
			txtLocations = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			locations.add(new Location(1, "Crown & Anchor Pub"));
			locations.add(new Location(2, "Posse East"));
			locations.add(new Location(3, "Cain & Abel's"));
			locations.add(new Location(4, "Spider House Cafe"));
			locations.add(new Location(5, "The Hole in the Wall"));
			
			adapter = new LocationAdapter(this, locations);
			txtLocations.setThreshold(1);
			txtLocations.setAdapter(adapter);
								
			
		}
		else if (eventName.equals("RESTAURANT")){
			layout.setBackgroundResource(R.drawable.blitzbg_restaurants);
			locationLabel.setText("Where do you want to go?");
			
			ArrayList<Location> locations = new ArrayList<Location>();
			AutoCompleteTextView txtLocations;
			LocationAdapter adapter;
			
			txtLocations = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			locations.add(new Location(1, "Mellow Mushroom"));
			locations.add(new Location(2, "Madam Mam's"));
			locations.add(new Location(3, "Noodles & Company"));
			locations.add(new Location(4, "Qdoba Mexican Grill"));
			locations.add(new Location(5, "Quizno's"));
			locations.add(new Location(6, "Raising Cane's"));
			locations.add(new Location(7, "Torchy's Tacos"));
			locations.add(new Location(8, "Whataburger"));
			
			adapter = new LocationAdapter(this, locations);
			txtLocations.setThreshold(2);
			txtLocations.setAdapter(adapter);
		

			TextView yourFriendsTV = (TextView)findViewById(R.id.your_friend_like_text);
			yourFriendsTV.setTypeface(GillSans);
			
			
			ArrayList<Location> favorites = new ArrayList<Location>();
			final HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			FavoritesAdapter hlvAdapter;
			
			favorites.add(new Location(1, "Kerbey Lane Cafe", getResources().getDrawable(R.drawable.kerbey)));
			favorites.add(new Location(1, "Mellow Mushroom", getResources().getDrawable(R.drawable.mellowmushroom)));
			favorites.add(new Location(1, "Torchy's Tacos", getResources().getDrawable(R.drawable.canes)));
			favorites.add(new Location(1, "Whataburger", getResources().getDrawable(R.drawable.whataburger)));
			favorites.add(new Location(1, "Raising Cane's", getResources().getDrawable(R.drawable.torchys)));
			
			hlvAdapter = new FavoritesAdapter(this, favorites);
			hListView.setAdapter(hlvAdapter);
			
			hListView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					Location selectedLocation = (Location) hListView.getItemAtPosition(arg2);
					locationName = selectedLocation.getLocationName();
					
					Intent nextIntent = new Intent(SelectLocationActivity.this, FinalizeTimeActivity.class);
					nextIntent.putExtra("EXTRA_EVENT_NAME", eventName);
					nextIntent.putExtra("EXTRA_LOCATION_NAME", locationName);
					startActivity(nextIntent);
				}
			});
			
		
			
			
		}
		else if (eventName.equals("MOVIE")){

			layout.setBackgroundResource(R.drawable.blitzbg_movies);
			locationLabel.setText("What do you want to see?");
			
			ArrayList<Location> locations = new ArrayList<Location>();
			AutoCompleteTextView txtLocations;
			LocationAdapter adapter;
			
			txtLocations = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			locations.add(new Location(1, "Forrest Gump"));
			locations.add(new Location(2, "The Princess Bride"));
			locations.add(new Location(3, "Harry Potter and the Deathly Hallows Part 1"));
			locations.add(new Location(4, "The Hitchhiker's Guide to the Galaxy"));
			locations.add(new Location(5, "Frozen"));
			
			adapter = new LocationAdapter(this, locations);
			txtLocations.setThreshold(1);
			txtLocations.setAdapter(adapter);
						
		}
		
		else {
			layout.setBackgroundResource(R.drawable.blitzbg_events);
			locationLabel.setText("What do you want to do?");
			
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
