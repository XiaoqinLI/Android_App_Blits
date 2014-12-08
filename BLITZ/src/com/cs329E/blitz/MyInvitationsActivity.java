package com.cs329E.blitz;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
