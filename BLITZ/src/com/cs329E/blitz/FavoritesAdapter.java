package com.cs329E.blitz;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class FavoritesAdapter extends ArrayAdapter<Location>{
	public FavoritesAdapter(Context context, ArrayList<Location> locations){
		super (context, 0, locations);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		final Location location = getItem(position);
		
		if (convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_favorite, parent, false);
		}
		
		ImageView locImg = (ImageView) convertView.findViewById(R.id.favorite_pic);
		locImg.setImageDrawable(location.getPic());

		return convertView;
	}
}
