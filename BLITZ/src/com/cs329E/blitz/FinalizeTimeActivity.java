package com.cs329E.blitz;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class FinalizeTimeActivity extends Activity {
	private static final String TAG = "Finalize Time Activity";
	private LinearLayout layout;
	private String eventName;

	private TextView mTimeDisplayBetween;
	private TextView mTimeDisplayAnd;
	private Button mPickTimeBetween;
	private Button mPickTimeAnd;
	private int mHourBetween;
	private int mMinuteBetween;
	private int mHourAnd;
	private int mMinuteAnd;
	
	static final int TIME_DIALOG_BETWEEN_ID = 0;
	static final int TIME_DIALOG_AND_ID = 1;


	// The callback received when the user "sets" the time in the dialog
	private CustomTimePickerDialog.OnTimeSetListener mBetweenTimeSetListener = new CustomTimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDayBetween, int minuteBetween ) {
			mHourBetween = hourOfDayBetween;
			mMinuteBetween = minuteBetween;
			updateDisplayBetween();
		}
	};
	
	private CustomTimePickerDialog.OnTimeSetListener mAndTimeSetListener = new CustomTimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute ) {
			mHourAnd = hourOfDay;
			mMinuteAnd = minute;
			updateDisplayAnd();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finalize_time);
		layout =(LinearLayout)findViewById(R.id.finalize_time_activity_bg);
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
				
		// Capture UI elements
		mTimeDisplayBetween = (TextView) findViewById(R.id.between_time_text);
		mPickTimeBetween = (Button) findViewById(R.id.time_between_button);
		mTimeDisplayAnd = (TextView) findViewById(R.id.and_time_text);
		mPickTimeAnd = (Button) findViewById(R.id.time_and_button);

		// Set an OnClickListener on the Change the Time Button
		mPickTimeBetween.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			public void onClick(View v) {
				showDialog(TIME_DIALOG_BETWEEN_ID);
			}
		});
		
		mPickTimeAnd.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			public void onClick(View v) {
				showDialog(TIME_DIALOG_AND_ID);
			}
		});

		// Get the current time
		final Calendar c = Calendar.getInstance();
		mHourBetween = c.get(Calendar.HOUR_OF_DAY);
		mMinuteBetween = c.get(Calendar.MINUTE);

		// Display the current date
		updateDisplayBetween();
	}

	// Update the time String in the TextView
	private void updateDisplayBetween() {
		mTimeDisplayBetween.setText(new StringBuilder().append(pad(mHourBetween)).append(":")
				.append(pad(mMinuteBetween)));
	}

	private void updateDisplayAnd() {
		mTimeDisplayAnd.setText(new StringBuilder().append(pad(mHourAnd)).append(":")
				.append(pad(mHourAnd)));
	}
	
	// Prepends a "0" to 1-digit minutes 
	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_BETWEEN_ID:
			return new CustomTimePickerDialog(this, mBetweenTimeSetListener, mHourBetween, mMinuteBetween,
					false);
		case TIME_DIALOG_AND_ID:
			return new CustomTimePickerDialog(this, mAndTimeSetListener, mHourAnd, mHourAnd,
					false);
		}
		return null;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finalize_time, menu);
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
