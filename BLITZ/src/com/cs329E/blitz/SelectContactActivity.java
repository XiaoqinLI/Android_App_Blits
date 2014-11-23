package com.cs329E.blitz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class SelectContactActivity extends Activity {
	
	private static final String TAG = "Select Contact Activity";	
	private static final int PICK_CONTACT = 2;
	private LinearLayout layout;
	private LinearLayout contactlayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_contact);
		
		layout =(LinearLayout)findViewById(R.id.select_contact_activity_bg);
		Intent intent = getIntent();
		String eventName = intent.getStringExtra("EXTRA_EVENT_NAME");
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
		
		contactlayout =(LinearLayout)findViewById(R.id.select_contact_checkboxes);
		
		
		final Button addFromContactButton = (Button) findViewById(R.id.contactbutton);		
		addFromContactButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Log.v(TAG, "User pressed the add from contact button");
				Intent addFromContactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(addFromContactIntent, PICK_CONTACT);			
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
	          CheckBox checkbox = new CheckBox(getBaseContext());
	          checkbox = (CheckBox)((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.right_check_box,null);
	          checkbox.setText(name);
	          checkbox.setTextColor(Color.BLACK);
	          
	          LinearLayout.LayoutParams checkbox_relativeParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	          contactlayout.addView(checkbox, checkbox_relativeParams);
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
