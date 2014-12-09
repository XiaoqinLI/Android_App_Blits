package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeAdapter extends ArrayAdapter<TimeOption>{
	public TimeAdapter(Context context, ArrayList<TimeOption> times){
		super (context, 0, times);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		final TimeOption time = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_time, parent, false);
		}
		
		TextView timeRow = (TextView) convertView.findViewById(R.id.time_option);
		
		String t;
		String amPM;
		String h;
		String m;
		
		if (time.getHour() >= 12)
		{	
			h = Integer.toString(time.getHour() - 12);
			amPM = "PM";
		}
		else
		{	
			h = Integer.toString(time.getHour());
			amPM = "AM";
		}
		if (time.getMinute() < 10)
			m = "0" + Integer.toString(time.getMinute());
		else
			m = Integer.toString(time.getMinute());
		
		t = h + ":" + m + "" + amPM;
		
		timeRow.setText(t);
		
		
		
		if (time.getLocation() != null)
		{
			TextView location = (TextView) convertView.findViewById(R.id.location);
			location.setText(time.getLocation());
		}
		
		return convertView;
	}
}
