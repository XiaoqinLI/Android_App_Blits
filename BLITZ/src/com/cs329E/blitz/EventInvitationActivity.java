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
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class EventInvitationActivity extends ListActivity {
	private final String TAG = "Event Invitation Activity";
	
	TimeAdapter adapter;
	private static ArrayList<TimeOption> arrayOfTimes = new ArrayList<TimeOption>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_invitation);
		
		adapter = new TimeAdapter(this, arrayOfTimes);
		final ListView timeListView = getListView();
		timeListView.setAdapter(adapter);
		adapter.clear();
		
		adapter.add(new TimeOption(6, 0));
		adapter.add(new TimeOption(6, 30, "Alamo Drafthouse South Lamar"));
		adapter.add(new TimeOption(7, 0));
		adapter.add(new TimeOption(7, 30));
		adapter.add(new TimeOption(8, 0));
		adapter.add(new TimeOption(8, 30));
		
		timeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
			    checkbox.setChecked(!checkbox.isChecked());
				}
		});
		
		
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
