package com.cs329E.blitz;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.devsmart.android.ui.HorizontalListView;

public class EventInvitationActivity extends ListActivity {
	private final String TAG = "Event Invitation Activity";
	private static final int GET_TEXT_REQUEST_CODE = 1;
	private GestureDetector mGestureDetector;

	TimeAdapter adapter;
	private static ArrayList<TimeOption> arrayOfTimes = new ArrayList<TimeOption>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_invitation);
		
		mGestureDetector = new GestureDetector(this,
				new GestureDetector.SimpleOnGestureListener() {
					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						if (velocityX < -10.0f) {
							Log.v(TAG, "User swiped right");
							EventInvitationActivity.this.finish();
						}
						return true;
					}
				});
		
		
		adapter = new TimeAdapter(this, arrayOfTimes);
		final ListView timeListView = getListView();
		timeListView.setAdapter(adapter);
		adapter.clear();
		
		adapter.add(new TimeOption(18, 0));
		adapter.add(new TimeOption(18, 30, "Alamo Drafthouse South Lamar"));
		adapter.add(new TimeOption(19, 0));
		adapter.add(new TimeOption(19, 30));
		adapter.add(new TimeOption(20, 0));
		adapter.add(new TimeOption(20, 30));
		
		timeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
			    checkbox.setChecked(!checkbox.isChecked());
				}
		});
		
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
		RSVPAdapter hlvAdapter;
		
		contacts.add(new Contact(1, "Jim", getResources().getDrawable(R.drawable.avatar_jim)));
		contacts.add(new Contact(2, "Dwight", getResources().getDrawable(R.drawable.avatar_dwight)));
		contacts.add(new Contact(3, "Ryan", getResources().getDrawable(R.drawable.avatar_ryan)));
		contacts.add(new Contact(4, "Angela", getResources().getDrawable(R.drawable.avatar_angela)));
		contacts.add(new Contact(5, "Michael", getResources().getDrawable(R.drawable.avatar_michael)));
		
		hlvAdapter = new RSVPAdapter(this, contacts);
		hListView.setAdapter(hlvAdapter);
		
		Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
		Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
		Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
		
		TextView tv1 = (TextView) findViewById(R.id.invitationfrom);
		TextView tv2 = (TextView) findViewById(R.id.when);
		TextView tv3 = (TextView) findViewById(R.id.locationname);
		
		tv1.setTypeface(GillSans);
		tv2.setTypeface(GillSans);
		tv3.setTypeface(GillSansSemiBold);
		
		Button declineBtn = (Button) findViewById(R.id.decline);
		declineBtn.setTypeface(GillSansLight);
		
		Button acceptBtn = (Button) findViewById(R.id.accept);
		acceptBtn.setTypeface(GillSansLight);
		
		acceptBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EventInvitationActivity.this.finish();
			}
		});

		declineBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				EventInvitationActivity.this.finish();
			}
		});
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_invitation, menu);
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
	
	@Override
	public void onBackPressed() {
	  super.onBackPressed();
	  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}
