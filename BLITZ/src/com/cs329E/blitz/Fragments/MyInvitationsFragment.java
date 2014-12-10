package com.cs329E.blitz.Fragments;

import java.util.ArrayList;

import com.cs329E.blitz.Blitz;
import com.cs329E.blitz.Contact;
import com.cs329E.blitz.EventInvitationActivity;
import com.cs329E.blitz.InvitationAdapter;
import com.cs329E.blitz.R;
import com.cs329E.blitz.MainScreenActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MyInvitationsFragment extends ListFragment{
    // Store instance variables
    private String title;
    private int page;
	InvitationAdapter adapter;
	private static ArrayList<Blitz> arrayOfInvitations = new ArrayList<Blitz>();
	
	String TAG = "MyInvitations Fragment";
	

    // newInstance constructor for creating fragment with arguments
    public static MyInvitationsFragment newInstance(int page, String title) {
    	MyInvitationsFragment myInvitationsFragment = new MyInvitationsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        myInvitationsFragment.setArguments(args);
        return myInvitationsFragment;
    }
    
    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_invitations, container, false);
        
		ListView invitationListView = (ListView) view.findViewById(android.R.id.list);
	    adapter = new InvitationAdapter(getActivity(), arrayOfInvitations);
	    adapter.clear();
		
		ArrayList<Contact> contacts1 = new ArrayList<Contact>();
		contacts1.add(new Contact(1, "Jim"));
		contacts1.add(new Contact(2, "Dwight"));
		contacts1.add(new Contact(3, "Ryan"));
		contacts1.add(new Contact(4, "Angela"));
		contacts1.add(new Contact(5, "Michael"));
		adapter.add(new Blitz(1, "Pam Beesly", "restaurant", contacts1));
		
		ArrayList<Contact> contacts2 = new ArrayList<Contact>();
		contacts2.add(new Contact(1, "Pam"));
		contacts2.add(new Contact(2, "Angela"));
		adapter.add(new Blitz(1, "Jim Halpert", "movie", contacts2));
		
		ArrayList<Contact> contacts3 = new ArrayList<Contact>();
		contacts3.add(new Contact(1, "Jim"));
		contacts3.add(new Contact(2, "Dwight"));
		adapter.add(new Blitz(1, "Michael Scott", "other", contacts3));
		
		ArrayList<Contact> contacts4 = new ArrayList<Contact>();
		contacts4.add(new Contact(1, "Kevin"));
		contacts4.add(new Contact(2, "Jim"));
		contacts4.add(new Contact(2, "Toby"));
		adapter.add(new Blitz(1, "Dwight Schrute", "bar", contacts4));    
		
		invitationListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
    		
		// **** Development only: long-pressing will bring up creator time finalize activity
		invitationListView.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int idx, long id) {
				
				Intent intent = new Intent(getActivity(), EventInvitationActivity.class);
				intent.putExtra("EXTRA_INVITATION_ID", Integer.toString(idx + 10));
				getActivity().startActivity(intent);	
				
				return true;
			}

		});
		
		Typeface GillSansLight = Typeface.createFromAsset(getActivity().getAssets(), "fonts/GillSans-Light.ttf");
		
        return view;
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
		Log.v(TAG, "Selected Blitz for RSVP");
		
		Intent intent = new Intent(getActivity(), EventInvitationActivity.class);
		intent.putExtra("EXTRA_INVITATION_ID", Integer.toString(position));
		getActivity().startActivity(intent);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
        }
        super.onActivityCreated(savedInstanceState);
    }
    

}
