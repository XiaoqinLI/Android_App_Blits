package com.cs329E.blitz;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class FriendFavouritesAdapter extends ArrayAdapter<FriendFavourites>{
	public FriendFavouritesAdapter(Context context, ArrayList<FriendFavourites> friendFavourites) {
        super(context, 0, friendFavourites);
     }
 
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	    // Get the data item for this position
		 FriendFavourites friendFavourites = getItem(position);    
	    // Check if an existing view is being reused, otherwise inflate the view
	    if (convertView == null) {
	       convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_friendfavourite, parent, false);
	    }
	    // Lookup view for data population
	    ImageView profileImg = (ImageView) convertView.findViewById(R.id.friendfavourite_img);
	   
	    // Populate the data into the template view using the data object
	    
	    profileImg.setImageDrawable(friendFavourites.getProfPic());
//	    profileImg.setImageResource(friendFavourites.getProfPic());
        
	   
	    return convertView;
	}
}
