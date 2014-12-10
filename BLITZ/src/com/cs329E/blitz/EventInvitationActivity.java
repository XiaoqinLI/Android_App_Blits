package com.cs329E.blitz;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devsmart.android.ui.HorizontalListView;

public class EventInvitationActivity extends ListActivity {
	private final String TAG = "Event Invitation Activity";
	private static final int GET_TEXT_REQUEST_CODE = 1;
	private int eventId;
	
	TimeAdapter adapter;
	private static ArrayList<TimeOption> arrayOfTimes = new ArrayList<TimeOption>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		
		Intent intent = getIntent();
		eventId = Integer.parseInt(intent.getStringExtra("EXTRA_INVITATION_ID"));
		
		// ****FOR DEMO PURPOSES, ARTIFICIALLY CREATE DIFFERENT VIEWS FOR EACH EVENT IN LIST
		
		// Time voting: Events (0-9)
		
		// FIRST EVENT:RESTAURANT INVITATION (PAM) 
		if (eventId == 0)
		{
			setContentView(R.layout.activity_event_restaurant);
			

			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(18, 00));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 00));
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(20, 00));
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
			
			tv1.setText("Invitation from Pam Beesly");
			tv2.setText("When do you want to go to");
			tv3.setText("Mellow Mushroom?");
			
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

		// SECOND EVENT: MOVIE INVITATION (JIM) 
		else if (eventId == 1)
		{
			setContentView(R.layout.activity_event_movie);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(18, 00, "AMC Barton Creek Square 14"));
			adapter.add(new TimeOption(18, 15, "Alamo Drafthouse South Lamar"));
			adapter.add(new TimeOption(18, 40, "Alamo Drafthouse Village"));
			adapter.add(new TimeOption(18, 45, "AMC Barton Creek Square 14"));
			adapter.add(new TimeOption(19, 00, "Alamo Drafthouse South Lamar"));
			adapter.add(new TimeOption(19, 30, "AMC Barton Creek Square 14"));
			
			timeListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
				    checkbox.setChecked(!checkbox.isChecked());
					}
			});
			
			
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			RSVPAdapter hlvAdapter;
			
			contacts.add(new Contact(1, "Angela", getResources().getDrawable(R.drawable.avatar_angela)));
			contacts.add(new Contact(2, "Pam", getResources().getDrawable(R.drawable.avatar_pam)));
			
			hlvAdapter = new RSVPAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.invitationfrom);
			TextView tv2 = (TextView) findViewById(R.id.when);
			TextView tv3 = (TextView) findViewById(R.id.locationname);
			
			tv1.setText("Invitation from Jim Halpert");
			tv2.setText("When do you want to go see");
			tv3.setText("Frozen?");
			
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
		
		
		// THIRD EVENT: "OTHER" INVITATION (MICHAEL) 
		else if (eventId == 2)
		{
			setContentView(R.layout.activity_event_invitation);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(18, 00));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 00));
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(20, 00));
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
			
			hlvAdapter = new RSVPAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.invitationfrom);
			TextView tv2 = (TextView) findViewById(R.id.when);
			TextView tv3 = (TextView) findViewById(R.id.locationname);
			
			tv1.setText("Invitation from Michael Scott");
			tv2.setText("When do you want to attend");
			tv3.setText("Study Group?");
			
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
		
		
		
		// FIRST EVENT: BAR INVITATION (DWIGHT) 
		else if (eventId == 3)
		{
			setContentView(R.layout.activity_event_invitation);
			

			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(18, 00));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 00));
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(20, 00));
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
			
			contacts.add(new Contact(1, "Kevin", getResources().getDrawable(R.drawable.avatar_kevin)));
			contacts.add(new Contact(2, "Jim", getResources().getDrawable(R.drawable.avatar_jim)));
			contacts.add(new Contact(3, "Toby", getResources().getDrawable(R.drawable.avatar_toby)));
			
			hlvAdapter = new RSVPAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.invitationfrom);
			TextView tv2 = (TextView) findViewById(R.id.when);
			TextView tv3 = (TextView) findViewById(R.id.locationname);
			
			tv1.setText("Invitation from Dwight Schrute");
			tv2.setText("When do you want to go to");
			tv3.setText("Crown & Anchor Pub?");
			
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
		
		
		/////////////////////////////////////////////////////////////
		/// Admin/Creator – Finalize Times: (Long Press) Events (10-19) 
		
		// FIRST: FINALIZE TIME RESTAURANT
		else if (eventId == 10)
		{
			setContentView(R.layout.activity_event_restaurant_finalize);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 15));
			
			timeListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
				    checkbox.setChecked(!checkbox.isChecked());
					}
			});
			
			
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			AvatarAdapter hlvAdapter;
			
			contacts.add(new Contact(1, "Jim", getResources().getDrawable(R.drawable.avatar_jim)));
			contacts.add(new Contact(2, "Ryan", getResources().getDrawable(R.drawable.avatar_ryan)));
			contacts.add(new Contact(3, "Michael", getResources().getDrawable(R.drawable.avatar_michael)));
			
			// programatically set width
			int numContacts = contacts.size();
		    DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
		    int px = Math.round(numContacts * 65 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
			hListView.getLayoutParams().width = px;			

			hlvAdapter = new AvatarAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.locationname);
					
			tv1.setTypeface(GillSansSemiBold);
			
			Button finalizeBtn = (Button) findViewById(R.id.finalize);
			finalizeBtn.setTypeface(GillSansLight);
			
			finalizeBtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EventInvitationActivity.this.finish();
				}
			});

		}
		
		
		
		// SECOND: FINALIZE TIME MOVIE
		else if (eventId == 11)
		{
			setContentView(R.layout.activity_event_restaurant_finalize);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 15));
			
			timeListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
				    checkbox.setChecked(!checkbox.isChecked());
					}
			});
			
			
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			AvatarAdapter hlvAdapter;
			
			contacts.add(new Contact(1, "Pam", getResources().getDrawable(R.drawable.avatar_pam)));

			// programatically set width
			int numContacts = contacts.size();
		    DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
		    int px = Math.round(numContacts * 65 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
			hListView.getLayoutParams().width = px;			

			hlvAdapter = new AvatarAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.locationname);
					
			tv1.setText("Frozen");
			tv1.setTypeface(GillSansSemiBold);
			
			Button finalizeBtn = (Button) findViewById(R.id.finalize);
			finalizeBtn.setTypeface(GillSansLight);
			
			finalizeBtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EventInvitationActivity.this.finish();
				}
			});

		}
		
		
		// THIRD: FINALIZE TIME OTHER
		else if (eventId == 12)
		{
			setContentView(R.layout.activity_event_restaurant_finalize);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 15));
			
			timeListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
				    checkbox.setChecked(!checkbox.isChecked());
					}
			});
			
			
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			AvatarAdapter hlvAdapter;
			
			contacts.add(new Contact(1, "Jim", getResources().getDrawable(R.drawable.avatar_jim)));
			contacts.add(new Contact(1, "Dwight", getResources().getDrawable(R.drawable.avatar_dwight)));

			// programatically set width
			int numContacts = contacts.size();
		    DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
		    int px = Math.round(numContacts * 65 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
			hListView.getLayoutParams().width = px;			

			hlvAdapter = new AvatarAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.locationname);
					
			tv1.setText("Study Group");
			tv1.setTypeface(GillSansSemiBold);
			
			Button finalizeBtn = (Button) findViewById(R.id.finalize);
			finalizeBtn.setTypeface(GillSansLight);
			
			finalizeBtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EventInvitationActivity.this.finish();
				}
			});

		}
		
		
		// FOURTH: FINALIZE TIME MOVIE
		else if (eventId == 13)
		{
			setContentView(R.layout.activity_event_restaurant_finalize);
			
			
			adapter = new TimeAdapter(this, arrayOfTimes);
			final ListView timeListView = getListView();
			timeListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			timeListView.setAdapter(adapter);
			adapter.clear();
			
			adapter.add(new TimeOption(19, 30));
			adapter.add(new TimeOption(18, 30));
			adapter.add(new TimeOption(19, 15));
			
			timeListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
				    checkbox.setChecked(!checkbox.isChecked());
					}
			});
			
			
			ArrayList<Contact> contacts = new ArrayList<Contact>();
			HorizontalListView hListView = (HorizontalListView) findViewById(R.id.hlistview);
			AvatarAdapter hlvAdapter;
			
			contacts.add(new Contact(1, "Kevin", getResources().getDrawable(R.drawable.avatar_kevin)));
			contacts.add(new Contact(2, "Jim", getResources().getDrawable(R.drawable.avatar_jim)));
			contacts.add(new Contact(3, "Toby", getResources().getDrawable(R.drawable.avatar_toby)));

			// programatically set width
			int numContacts = contacts.size();
		    DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
		    int px = Math.round(numContacts * 65 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
			hListView.getLayoutParams().width = px;			

			hlvAdapter = new AvatarAdapter(this, contacts);
			hListView.setAdapter(hlvAdapter);
			
			
			
			Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
			Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
			Typeface GillSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");
			
			TextView tv1 = (TextView) findViewById(R.id.locationname);
					
			tv1.setText("Crown & Anchor Pub");
			tv1.setTypeface(GillSansSemiBold);
			
			Button finalizeBtn = (Button) findViewById(R.id.finalize);
			finalizeBtn.setTypeface(GillSansLight);
			
			finalizeBtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					EventInvitationActivity.this.finish();
				}
			});

		}
		

		
		
		
		/////////////////////////////////////////////////////////////
		// DEFAULT TO RESTAURANT
		else
		{
			setContentView(R.layout.activity_event_invitation);
			
			
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
	

}
