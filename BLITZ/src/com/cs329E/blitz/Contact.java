package com.cs329E.blitz;

public class Contact {
	private int contactId;
	private String contactName;
	private boolean isSelected = false;

	public Contact(int contactId, String contactName) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
	}

	public Contact(int contactId, String contactName, boolean isSelected) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.isSelected = isSelected;
	}
	
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
}
