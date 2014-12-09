package com.cs329E.blitz;

public class TimeOption {
	private int hour;
	private int minute;
	private String location;
	
	public TimeOption(int hour, int minute, String location){
		super();
		this.hour = hour;
		this.minute = minute;
		this.location = location;
	}
	
	public TimeOption(int hour, int minute){
		super();
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
