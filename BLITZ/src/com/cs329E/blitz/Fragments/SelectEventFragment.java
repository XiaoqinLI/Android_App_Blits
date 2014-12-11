package com.cs329E.blitz.Fragments;

import com.cs329E.blitz.R;
import com.cs329E.blitz.SelectContactActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectEventFragment extends Fragment{
    // Store instance variables
    private String title;
    private int page;
    
    String TAG = "SelectEvent Fragment";

    // newInstance constructor for creating fragment with arguments
    public static SelectEventFragment newInstance(int page, String title) {
    	SelectEventFragment selectEventFragment = new SelectEventFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        selectEventFragment.setArguments(args);
        return selectEventFragment;
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
        View view = inflater.inflate(R.layout.activity_select_event, container, false);

		TextView send = (TextView) view.findViewById(R.id.textView1);
        Typeface Gotham = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Gotham-Medium.otf");
		send.setTypeface(Gotham);
        
		ImageView movieView = (ImageView) view.findViewById(R.id.option1_img);
		ImageView restaurantView = (ImageView) view.findViewById(R.id.option2_img);
		ImageView barView = (ImageView) view.findViewById(R.id.option3_img);
		ImageView otherView = (ImageView) view.findViewById(R.id.option4_img);
		
		restaurantView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the restaurant button");
				Intent restaurantIntent = new Intent(getActivity(), SelectContactActivity.class);
				restaurantIntent.putExtra("EXTRA_EVENT_NAME", "RESTAURANT");
				startActivity(restaurantIntent);
			}
		});
		
		movieView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the movie button");
				Intent movieIntent = new Intent(getActivity(), SelectContactActivity.class);
				movieIntent.putExtra("EXTRA_EVENT_NAME", "MOVIE");
				startActivity(movieIntent);
			}
		});
		
		barView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the bar button");
				Intent barIntent = new Intent(getActivity(), SelectContactActivity.class);
				barIntent.putExtra("EXTRA_EVENT_NAME", "BAR");
				startActivity(barIntent);
			}
		});
		
		otherView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG, "User pressed the other button");
				Intent otherIntent = new Intent(getActivity(), SelectContactActivity.class);
				otherIntent.putExtra("EXTRA_EVENT_NAME", "OTHER");
				startActivity(otherIntent);
			}
		});        
        
        return view;
    }
    

}
