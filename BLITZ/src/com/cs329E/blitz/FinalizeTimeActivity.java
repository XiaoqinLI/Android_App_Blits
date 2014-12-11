package com.cs329E.blitz;

import java.util.Calendar;

import com.cs329E.blitz.Fragments.MyInvitationsFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class FinalizeTimeActivity extends Activity {
	private static final String TAG = "Finalize Time Activity";
	private RelativeLayout layout;
	private String eventName;

	private TextView mTimeDisplayBetween;
	private TextView mTimeDisplayAnd;
	private int mHourBetween;
	private int mMinuteBetween;
	private String betweenAMPM = "AM";
	private int mHourAnd;
	private int mMinuteAnd;
	private String andAMPM = "AM";
	
	static final int TIME_DIALOG_BETWEEN_ID = 0;
	static final int TIME_DIALOG_AND_ID = 1;


	// The callback received when the user "sets" the time in the dialog
	private CustomTimePickerDialog.OnTimeSetListener mBetweenTimeSetListener = new CustomTimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDayBetween, int minuteBetween ) {
			mHourBetween = hourOfDayBetween;
			mMinuteBetween = minuteBetween;
			
			updateDisplayBetween(mHourBetween, mMinuteBetween);
		}
	};
	
	private CustomTimePickerDialog.OnTimeSetListener mAndTimeSetListener = new CustomTimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDayAnd, int minuteAnd ) {
			mHourAnd = hourOfDayAnd;
			mMinuteAnd = minuteAnd;
			
			updateDisplayAnd(mHourAnd, mMinuteAnd);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_finalize_time);
		layout = (RelativeLayout) findViewById(R.id.finalize_time_activity_bg);
		Intent intent = getIntent();
		eventName = intent.getStringExtra("EXTRA_EVENT_NAME");
		String locName = intent.getStringExtra("EXTRA_LOCATION_NAME");
		
		Typeface GillSansLight = Typeface.createFromAsset(getAssets(), "fonts/GillSans-Light.ttf");
		Typeface GillSans = Typeface.createFromAsset(getAssets(), "fonts/GillSans.ttf");
		Typeface GillSansBold = Typeface.createFromAsset(getAssets(), "fonts/GillSans-SemiBold.ttf");

		
		TextView whenTV = (TextView) findViewById(R.id.when_to_blitz);
		TextView whereTV = (TextView) findViewById(R.id.locName);
		
		whenTV.setTypeface(GillSans);
		whereTV.setTypeface(GillSansBold);

		
		if (eventName.equals("BAR")){
			layout.setBackgroundResource(R.drawable.blitzbg_bars);
			whenTV.setText("When do you want to go to");
			whereTV.setText(locName + "?");
		}
		else if (eventName.equals("RESTAURANT")){
			layout.setBackgroundResource(R.drawable.blitzbg_restaurants);
			whenTV.setText("When do you want to eat at");
			whereTV.setText(locName + "?");
		}
		else if (eventName.equals("MOVIE")){
			layout.setBackgroundResource(R.drawable.blitzbg_movies);
			whenTV.setText("When do you want to see");
			whereTV.setText(locName + "?");
		}
		else if (eventName.equals("OTHER")){
			layout.setBackgroundResource(R.drawable.blitzbg_events);
			whenTV.setText("When do you want to attend");
			whereTV.setText(locName + "?");
		}
			

		
		// Capture UI elements
		mTimeDisplayBetween = (TextView) findViewById(R.id.between_time_text);
		mTimeDisplayAnd = (TextView) findViewById(R.id.and_time_text);

		Button rightNowBtn = (Button) findViewById(R.id.rightNowButton);
		rightNowBtn.setTypeface(GillSansLight);

		rightNowBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Log.v(TAG, "User pressed the next button");
				Intent nextIntent = new Intent(FinalizeTimeActivity.this, MainScreenActivity.class);
				nextIntent.putExtra("EXTRA_PAGE_NAME", "invitations");
				startActivity(nextIntent);
			}
		});	
		
		Button setTimeBtn = (Button) findViewById(R.id.setTimeButton);
		setTimeBtn.setTypeface(GillSansLight);
		setTimeBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Log.v(TAG, "User pressed the next button");
				Intent nextIntent = new Intent(FinalizeTimeActivity.this, MainScreenActivity.class);
				nextIntent.putExtra("EXTRA_PAGE_NAME", "invitations");
				startActivity(nextIntent);
			}
		});	
		

		TextView mTextBetween = (TextView) findViewById(R.id.time_between);
		TextView mTextAnd = (TextView) findViewById(R.id.time_and);
		
		mTextBetween.setTypeface(GillSansLight);
		mTextAnd.setTypeface(GillSansLight);
		
		// Set an OnClickListener on the Change the Time Button
		// Get the current time
		final Calendar c = Calendar.getInstance();
		mHourBetween = c.get(Calendar.HOUR_OF_DAY);
		mMinuteBetween = c.get(Calendar.MINUTE);
		
		// Display the current date
		updateDisplayBetween(mHourBetween, mMinuteBetween);
	}
	
	@SuppressWarnings("deprecation")
    public void onClickA(View v) {
		showDialog(TIME_DIALOG_BETWEEN_ID);
      }  

	@SuppressWarnings("deprecation")
    public void onClickB(View v) {
		showDialog(TIME_DIALOG_AND_ID);
      }  
	
	// Update the time String in the TextView
	private void updateDisplayBetween(int hour, int min) {
		String amPM;
		String time;
		
		if (hour > 12)
		{
			hour -= 12;
			amPM = "PM";
		}
		else if (hour == 12)
		{
			amPM = "PM";
		}
		else if (hour == 0)
		{
			hour = 12;
			amPM = "AM";
		}
		else
		{
			amPM = "AM";
		}
		
		time = Integer.toString(hour) + ":" + pad(min) + " " + amPM;
		
		mTimeDisplayBetween.setText(time);
		
	}

	private void updateDisplayAnd(int hour, int min) {
		String amPM;
		String time;
		
		if (hour > 12)
		{
			hour -= 12;
			amPM = "PM";
		}
		else if (hour == 12)
		{
			amPM = "PM";
		}
		else if (hour == 0)
		{
			hour = 12;
			amPM = "AM";
		}
		else
		{
			amPM = "AM";
		}
		
		time = Integer.toString(hour) + ":" + pad(min) + " " + amPM;
		
		mTimeDisplayAnd.setText(time);
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
			return new CustomTimePickerDialog(this, mAndTimeSetListener, mHourAnd, mMinuteAnd,
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
