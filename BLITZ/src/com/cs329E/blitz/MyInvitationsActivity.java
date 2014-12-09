package com.cs329E.blitz;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MyInvitationsActivity extends ListActivity {
	
	private final String TAG = "My Invitations Activity";
	
	InvitationAdapter adapter;
	private static ArrayList<Blitz> arrayOfInvitations = new ArrayList<Blitz>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_invitations);
		
		adapter = new InvitationAdapter(this, arrayOfInvitations);
		final ListView invitationListView = getListView();
		invitationListView.setAdapter(adapter);
		adapter.clear();

		ArrayList<Contact> contacts1 = new ArrayList<Contact>();
		contacts1.add(new Contact(1, "Jim"));
		contacts1.add(new Contact(2, "Dwight"));
		contacts1.add(new Contact(3, "Ryan"));
		contacts1.add(new Contact(4, "Angela"));
		contacts1.add(new Contact(5, "Michael"));
		adapter.add(new Blitz(1, "Pam Beesly", "restaurant", contacts1));
		
		ArrayList<Contact> contacts2 = new ArrayList<Contact>();
		contacts2.add(new Contact(1, "Pam"));
		contacts2.add(new Contact(2, "Angela"));
		adapter.add(new Blitz(1, "Jim Halpert", "movie", contacts2));

		ArrayList<Contact> contacts3 = new ArrayList<Contact>();
		adapter.add(new Blitz(1, "Michael Scott", "other", contacts3));
		
		ArrayList<Contact> contacts4 = new ArrayList<Contact>();
		contacts4.add(new Contact(1, "Kevin"));
		contacts4.add(new Contact(2, "Jim"));
		contacts4.add(new Contact(2, "Toby"));
		adapter.add(new Blitz(1, "Dwight Schrute", "bar", contacts4));

		
		invitationListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.v(TAG, "Selected Blitz for RSVP");
				
				Intent intent = new Intent(getBaseContext(), EventInvitationActivity.class);
				startActivity(intent);				
			
				}
		});
		
		Button backButton = (Button) findViewById(R.id.backbutton);		
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the other button");
				Intent intent = new Intent(getBaseContext(), SelectEventActivity.class);
				startActivity(intent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_invitations, menu);
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
