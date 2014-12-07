package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
		final Contact contact = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
		}
			

		TextView contactNameTV = (TextView) convertView.findViewById(R.id.contact_name);
		
		Typeface tf = Typeface.createFromAsset(convertView.getContext().getAssets(), "fonts/Tahoma.ttf");
		contactNameTV.setTypeface(tf);
		
		contactNameTV.setText(contact.getContactName());
		
		final CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
		
		if (contact.isSelected())
		{
			checkbox.setChecked(true);
		}
		
		checkbox.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View arg0) {
		        contact.setSelected(checkbox.isChecked());
		    }
		});
		

		return convertView;
	}
	
	

}
