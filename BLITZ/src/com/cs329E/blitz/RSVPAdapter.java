package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RSVPAdapter extends ArrayAdapter<Contact>{
	public RSVPAdapter(Context context, ArrayList<Contact> contacts){
		super (context, 0, contacts);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		final Contact contact = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_rsvp, parent, false);
		}
		
		ImageView contactImg = (ImageView) convertView.findViewById(R.id.avatar);
		contactImg.setImageDrawable(contact.getAvatar());

		TextView contactName = (TextView) convertView.findViewById(R.id.contact_name);
		contactName.setText(contact.getContactName());
		
		return convertView;
	}
}
