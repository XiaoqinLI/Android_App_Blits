package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contact>{
	public ContactAdapter(Context context, ArrayList<Contact> contacts){
		super (context, 0, contacts);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		Contact contact = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
		}
			
		TextView contactNameTV = (TextView) convertView.findViewById(R.id.contact_name);
		contactNameTV.setText(contact.getContactName());
		
		CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
		
		if (contact.isSelected())
		{
			checkbox.setChecked(true);
		}
		
		return convertView;
	}
	
	

}
