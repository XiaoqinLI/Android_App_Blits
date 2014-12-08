package com.cs329E.blitz;

import java.util.ArrayList;

public class Blitz {
	private int blitzId;
	private String adminName;
	private String eventType;
	private double time;
	private String location;
	private ArrayList<Contact> attendees = new ArrayList<Contact>();
	
	public Blitz(int blitzId, String adminName, String eventType, double time, String location){
		super();
		this.blitzId = blitzId;
		this.adminName = adminName;
		this.eventType = eventType;
		this.time = time;
		this.location = location;
	}
	
	public Blitz (int blitzId, String adminName, String eventType, ArrayList<Contact> attendees){
		super();
		this.blitzId = blitzId;
		this.adminName = adminName;
		this.eventType = eventType;
		this.attendees = attendees;
	}

	public int getBlitzId() {
		return blitzId;
	}

	public void setBlitzId(int blitzId) {
		this.blitzId = blitzId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Contact> getAttendees() {
		return attendees;
	}

	public void setAttendees(ArrayList<Contact> attendees) {
		this.attendees = attendees;
	}
	
	
	
}
