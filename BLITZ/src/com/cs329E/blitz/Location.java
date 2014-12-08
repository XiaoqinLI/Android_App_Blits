package com.cs329E.blitz;

import android.graphics.drawable.Drawable;

public class Location {
	private int locationId;
	private String locationName;
	private String picUrl;
	private Drawable pic;
	
	public Location(int locationId, String locationName){
		super();
		this.locationId = locationId;
		this.locationName = locationName;
	}

	public Location(int locationId, String locationName, String picUrl){
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.picUrl = picUrl;
	}
	
	public Location(int locationId, String locationName, Drawable pic){
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.pic = pic;
	}
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Drawable getPic() {
		return pic;
	}

	public void setPic(Drawable pic) {
		this.pic = pic;
	}
	
	// ***Must override string method for autocomplete listview
    @Override
    public String toString() {
        return locationName;
    }
	
	
	
}
