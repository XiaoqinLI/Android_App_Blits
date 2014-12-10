package com.cs329E.blitz;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SelectContactActivity extends ListActivity {
	
	private static final String TAG = "Select Contact Activity";	
	private static final int PICK_CONTACT = 2;
	private RelativeLayout layout;
	private String eventName;
	
	ContactAdapter adapter;
	private static ArrayList<Contact> arrayOfContacts = new ArrayList<Contact>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_contact);
		
		layout =(RelativeLayout)findViewById(R.id.select_contact_activity_bg);
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
		
		Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
		Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
		
		TextView tv = (TextView) findViewById(R.id.who_to_blitz);
		tv.setTypeface(GillSans);
		
		adapter = new ContactAdapter(this, arrayOfContacts);
		final ListView contactListView = getListView();
		contactListView.setAdapter(adapter);
		
		adapter.clear();
		adapter.add(new Contact(1, "Michael Scott"));
		adapter.add(new Contact(1, "Dwight Schrute"));
		adapter.add(new Contact(1, "Jim Halpert"));
		
		
		
		final Button addFromContactButton = (Button) findViewById(R.id.contactbutton);		
		addFromContactButton.setTypeface(GillSansLight);

		addFromContactButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Log.v(TAG, "User pressed the add from contact button");
				Intent addFromContactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(addFromContactIntent, PICK_CONTACT);			
			}
		});	

		final Button nextButton = (Button) findViewById(R.id.next);
		nextButton.setTypeface(GillSansLight);

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the next button");
				Intent nextIntent = new Intent(getBaseContext(), SelectLocationActivity.class);
				nextIntent.putExtra("EXTRA_EVENT_NAME", eventName);
				startActivity(nextIntent);
			}
		});
		
	}
	
	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent data) {
	  super.onActivityResult(reqCode, resultCode, data);
	  switch (reqCode) {
	    case (PICK_CONTACT) :
	      if (resultCode == Activity.RESULT_OK) {
	        Uri contactData = data.getData();
	        Cursor c =  getContentResolver().query(contactData, null, null, null, null);
	        if (c.moveToFirst()) {
	          String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
	          // TODO Whatever you want to do with the selected contact name.	          
	          adapter.add(new Contact(1, name, true));
	        }
	      }
	      break;
	  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_contact, menu);
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
