package com.cs329E.blitz;


import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SelectLocationActivity extends ListActivity {
	private LinearLayout layout;
	private String eventName;
	private LinearLayout myGallery;
	private static ArrayList<FriendFavourites> arrayOfPlayers = new ArrayList<FriendFavourites>();

	
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

		FriendFavouritesListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.v("TAG", "Hit on a figure, doing nothing");
				Toast.makeText(SelectLocationActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});


		/*
		Gallery g = (Gallery) findViewById(R.id.gallery);

		// Create a new ImageAdapter and set in as the Adapter for the Gallery
		g.setAdapter(new ImageAdapter(this));

		// Set an setOnItemClickListener on the Gallery
		g.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Display a Toast message indicate the selected item
				Toast.makeText(SelectLocationActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
		*/
			
	}
	
	

	
	// The Adapter class used with the Gallery
		public class ImageAdapter extends BaseAdapter {

			private static final int IMAGE_DIM = 800;

			private int mGalleryItemBackground;
			private Context mContext;

			// List of IDs corresponding to the images
			private Integer[] mImageIds = { R.drawable.sample_1,
					R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
					R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7 };

			public ImageAdapter(Context c) {
				mContext = c;
				TypedArray a = obtainStyledAttributes(R.styleable.SelectLocationActivity);
				mGalleryItemBackground = a.getResourceId(
						R.styleable.SelectLocationActivity_android_galleryItemBackground,
						0);
				a.recycle();
			}

			public int getCount() {
				return mImageIds.length;
			}

			public Object getItem(int position) {
				return mImageIds[position];
			}

			public long getItemId(int position) {
				return position;
			}

			public View getView(int position, View convertView, ViewGroup parent) {

				ImageView imageView = (ImageView) convertView;

				// If convertView is not recycled set it up now
				if (null == imageView) {
					imageView = new ImageView(mContext);

					imageView.setLayoutParams(new Gallery.LayoutParams(IMAGE_DIM,
							IMAGE_DIM));
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);
					imageView.setBackgroundResource(mGalleryItemBackground);

				}

				// Set the image for the imageView
				imageView.setImageResource(mImageIds[position]);

				return imageView;
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
