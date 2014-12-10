package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AvatarAdapter extends ArrayAdapter<Contact>{
	public AvatarAdapter(Context context, ArrayList<Contact> contacts){
		super (context, 0, contacts);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		final Contact contact = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_avatar, parent, false);
		}
		
		ImageView contactImg = (ImageView) convertView.findViewById(R.id.avatar2);
		contactImg.setImageDrawable(contact.getAvatar());

		TextView contactName = (TextView) convertView.findViewById(R.id.contact_name2);
		contactName.setText(contact.getContactName());
		
		return convertView;
	}
}
