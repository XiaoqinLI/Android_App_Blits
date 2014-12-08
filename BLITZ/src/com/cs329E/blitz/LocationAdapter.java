package com.cs329E.blitz;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class LocationAdapter extends BaseAdapter implements Filterable{
	
	Context _context;
	ArrayList<Location> locations;
	
	public LocationAdapter(Context context, ArrayList<Location> _locations) {
		_context = context;
		locations = _locations;
		orig = locations;
		filter = new LocationFilter();
	}
	
	@Override
	public int getCount(){
		if (locations != null)
			return locations.size();
		else
			return 0;
	}
	
	@Override
	public Location getItem(int arg0){
		return locations.get(arg0);
	}
	
	@Override
	public long getItemId(int arg0){
		return locations.get(arg0).getLocationId();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		Location location = getItem(position);
		
		if (convertView == null) {
			convertView = LayoutInflater.from(_context).inflate(R.layout.item_location, parent ,false);
		}
		
		TextView locationNameTV = (TextView) convertView.findViewById(R.id.location_name);
		locationNameTV.setText(location.getLocationName());
		
		return convertView;
	}
	
	@Override
	public Filter getFilter(){
		return filter;
	}
	
	private LocationFilter filter;
	ArrayList<Location> orig;
	
	
	// **** Filter **** //
	private class LocationFilter extends Filter{
		
		public LocationFilter(){
			
		}
		
		@Override
		protected FilterResults performFiltering(CharSequence constraint){
			
			// case insensitive searching
			String s_constraint = constraint.toString();
			s_constraint = s_constraint.toLowerCase(Locale.getDefault());
			constraint = s_constraint;
			
			FilterResults oReturn = new FilterResults();
			ArrayList<Location> results = new ArrayList<Location>();
			if (orig == null)
				orig = locations;
			
			if (constraint != null)
			{
				if (orig != null && orig.size() > 0){
					for (Location l : orig) {
						if (l.getLocationName().toLowerCase(Locale.getDefault()).contains(constraint))
							results.add(l);
					}
				}
				oReturn.values = results;
			}
			
			return oReturn;
		}
		
	    @SuppressWarnings("unchecked")
	    	@Override
	    	protected void publishResults(CharSequence constraint, FilterResults results) {
	    	locations = (ArrayList<Location>)results.values;
	    	notifyDataSetChanged();
	    }

	}

	
	
}
