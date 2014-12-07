package com.cs329E.blitz;


import java.util.ArrayList;

import org.lucasr.twowayview.TwoWayView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SelectLocationActivity extends Activity {
	private static final String TAG = "Select Location Activity";
	private LinearLayout layout;
	private String eventName;
	private LinearLayout myGallery;
	private int[] ids = {R.id.favourite1, R.id.favourite2, R.id.favourite3, R.id.favourite4, R.id.favourite5};
	private TextView eventLabel, restaurantLabel;
	private AutoCompleteTextView autoCompletetextView;

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

		layout =(LinearLayout)findViewById(R.id.select_location_activity_bg);	
		eventLabel = (TextView)findViewById(R.id.where_to_blitz);
		restaurantLabel = (TextView)findViewById(R.id.where_to_blitz_rest);

		if (eventName.equals("BAR")){
			layout.setBackgroundResource(R.drawable.blitzbg_bars);
			eventLabel.setText("where do you want to go?");
			autoCompletetextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					R.layout.list_item, BAR);
			autoCompletetextView.setAdapter(adapter);
			autoCompletetextView.setOnItemClickListener(new OnItemClickListener() {
				// Display a Toast Message when the user clicks on an item in the AutoCompleteTextView
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Toast.makeText(getApplicationContext(), "The winner is:" + arg0.getAdapter().getItem(arg2), Toast.LENGTH_SHORT).show();

				}
			});
		}
		else if (eventName.equals("RESTAURANT")){
			layout.setBackgroundResource(R.drawable.blitzbg_restaurants);
			restaurantLabel.setText("where do you want to go?");

			ArrayList<Location> locations = new ArrayList<Location>();
			AutoCompleteTextView txtLocations;
			LocationAdapter adapter;
			
			txtLocations = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			locations.add(new Location(1, "Mellow Mushroom"));
			locations.add(new Location(2, "Madam Mam's"));
			locations.add(new Location(3, "Noodles & Company"));
			locations.add(new Location(4, "Qdoba Mexican Grill"));
			locations.add(new Location(5, "Quizno's"));
			
			adapter = new LocationAdapter(this, locations);
			txtLocations.setAdapter(adapter);
			txtLocations.setThreshold(0);
			

			txtLocations.setOnItemClickListener(new OnItemClickListener() {
				// Display a Toast Message when the user clicks on an item in the AutoCompleteTextView
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Toast.makeText(getApplicationContext(), "The winner is:" + arg0.getAdapter().getItem(arg2), Toast.LENGTH_SHORT).show();

				}
			});

			// HorizontalScrollView: dumb method
			ImageView image1 = (ImageView) findViewById(R.id.favourite1);
			ImageView image2 = (ImageView) findViewById(R.id.favourite2);
			ImageView image3 = (ImageView) findViewById(R.id.favourite3);
			ImageView image4 = (ImageView) findViewById(R.id.favourite4);
			ImageView image5 = (ImageView) findViewById(R.id.favourite5);

			image1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					for(int i=0; i<ids.length; i++) {
						if(v.getId() == ids[i]) {
							Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
							selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
							startActivity(selectLocationIntent);				        }
					}
				}
			});

			image2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					for(int i=0; i<ids.length; i++) {
						if(v.getId() == ids[i]) {
							Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
							selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
							startActivity(selectLocationIntent);				        }
					}
				}
			});

			image3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					for(int i=0; i<ids.length; i++) {
						if(v.getId() == ids[i]) {
							Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
							selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
							startActivity(selectLocationIntent);				        }
					}
				}
			});

			image4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					for(int i=0; i<ids.length; i++) {
						if(v.getId() == ids[i]) {
							Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
							selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
							startActivity(selectLocationIntent);				        }
					}
				}
			});

			image5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					for(int i=0; i<ids.length; i++) {
						if(v.getId() == ids[i]) {
							Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
							selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
							startActivity(selectLocationIntent);				        }
					}
				}
			});
		}
		else if (eventName.equals("MOVIE")){
			layout.setBackgroundResource(R.drawable.blitzbg_movies);
			eventLabel.setText("what do you want to see?");
			autoCompletetextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_items);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					R.layout.list_item, MOVIE);
			autoCompletetextView.setAdapter(adapter);
			autoCompletetextView.setOnItemClickListener(new OnItemClickListener() {
				// Display a Toast Message when the user clicks on an item in the AutoCompleteTextView
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Toast.makeText(getApplicationContext(), "The winner is:" + arg0.getAdapter().getItem(arg2), Toast.LENGTH_SHORT).show();

				}
			});
		}
		else if (eventName.equals("OTHER")){
			layout.setBackgroundResource(R.drawable.blitzbg_events);
			eventLabel.setText("what do you want to do?");
		}

		//		if (eventName.equals("RESTAURANT")){

		/*
			// ListView method: vertical layout only
			// Create the adapter to convert the array to views
			FriendFavouritesAdapter adapter = new FriendFavouritesAdapter(this, arrayOfPlayers);
			// Attach the adapter to a ListView
			ListView FriendFavouritesListView = getListView();
			FriendFavouritesListView.setAdapter(adapter);
			adapter.clear();
			adapter.add(new FriendFavourites(getResources().getDrawable(R.drawable.sample_1)));
			adapter.add(new FriendFavourites(getResources().getDrawable(R.drawable.sample_2)));
			adapter.add(new FriendFavourites(getResources().getDrawable(R.drawable.sample_3)));
			adapter.add(new FriendFavourites(getResources().getDrawable(R.drawable.sample_4)));
			adapter.add(new FriendFavourites(getResources().getDrawable(R.drawable.sample_6)));

			FriendFavouritesListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Log.v(TAG, "Hit on a favourite place, go to set time");
					Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
					selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
					startActivity(selectLocationIntent);					
				}
			});
			;

		 */
		// advanced method, using twowayview package but
		// not working for images, need a customized adapter maybe
		//		items.add(getResources().getDrawable(R.drawable.sample_1));
		//		items.add(getResources().getDrawable(R.drawable.sample_2));
		//		items.add(getResources().getDrawable(R.drawable.sample_3));
		//		items.add(getResources().getDrawable(R.drawable.sample_4));
		//		items.add(getResources().getDrawable(R.drawable.sample_5));
		//		items.add(getResources().getDrawable(R.drawable.sample_6));
		//		items.add(getResources().getDrawable(R.drawable.sample_7));
		//		ArrayAdapter<Drawable> aItems = new ArrayAdapter<Drawable>(this, R.layout.simple_list_item_1, items);

		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_1));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_2));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_3));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_4));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_5));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_6));
		//		items.add(BitmapFactory.decodeResource(getResources(), R.drawable.sample_7));
		//		ArrayAdapter<Bitmap> aItems = new ArrayAdapter<Bitmap>(this, R.layout.simple_list_item_1, items);

		//		TwoWayView lvTest = (TwoWayView) findViewById(R.id.lvItems);
		//		lvTest.setAdapter(aItems);
		//				
		//		lvTest.setOnItemClickListener(new OnItemClickListener() {
		//			public void onItemClick(AdapterView<?> parent, View view,
		//					int position, long id) {
		//				Log.v(TAG, "Hit on a favourite place, go to set time");
		//				Intent selectLocationIntent = new Intent(getBaseContext(), FinalizeTimeActivity.class);
		//				selectLocationIntent.putExtra("EXTRA_EVENT_NAME", eventName);
		//				startActivity(selectLocationIntent);					
		//			}
		//		});
		//		}			
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
