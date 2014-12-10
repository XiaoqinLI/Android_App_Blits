package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InvitationAdapter extends ArrayAdapter<Blitz>{
	String TAG = "Invitation Adapter";
	
	public InvitationAdapter(Context context, ArrayList<Blitz> invitations){
		super (context, 0, invitations);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		final Blitz blitz = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_invitation, parent, false);
		}
			
		Typeface GillSans = Typeface.createFromAsset(convertView.getContext().getAssets(), "fonts/GillSans.ttf");
		
		TextView adminNameTV = (TextView) convertView.findViewById(R.id.admin_name);
		adminNameTV.setText(blitz.getAdminName());
		adminNameTV.setTypeface(GillSans);
		
		ImageView event_pic = (ImageView) convertView.findViewById(R.id.event_pic);
		if (blitz.getEventType() == "restaurant")
			event_pic.setImageResource(R.drawable.restaurant_icon);
		else if (blitz.getEventType() == "movie")
			event_pic.setImageResource(R.drawable.movie_icon);
		else if (blitz.getEventType() == "bar")
			event_pic.setImageResource(R.drawable.bar_icon);
		else
			event_pic.setImageResource(R.drawable.other_icon);
		
		TextView attendees = (TextView) convertView.findViewById(R.id.attendees);
		attendees.setTypeface(GillSans);
		
		String s = "with ";
		
		ArrayList<Contact> attendeesList = blitz.getAttendees();
		int len = attendeesList.size();
		int count = 0;
		
		if (len == 0)
			s = "";
		
		for (Contact c : attendeesList)
		{
			if (count == len-1 && len > 1)
				s += "and " + c.getContactName();
			else
			{
				if (len == 2)
					s += c.getContactName() + " ";
				else
					s += c.getContactName() + ", ";
			}
			
			count++;
		}
		
		attendees.setText(s);
		

		return convertView;
	}
	
	

}
