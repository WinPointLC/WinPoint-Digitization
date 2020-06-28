package com.winpoint.common.wrappers;

import java.util.Date;

public class NumberOfStudentWrapper {
	private String fullName;
	private boolean enquired;
	private boolean registered;
	private Date startDate;
	private String preferredBatch;
	
	
	public NumberOfStudentWrapper(String firstName, String lastName, boolean enquired, boolean registered, Date startDate,
			String preferredBatch) {
		
		fullName = firstName + " " + lastName;
		this.enquired = enquired;
		this.registered = registered;
		this.startDate = startDate;
		this.preferredBatch = preferredBatch;
	}

	
	public String getName() {
		return fullName;
	}
	
	public void setName(String name) {
		this.fullName = name;
	}
	
	public boolean getEnquired() {
		return this.enquired;
	}
	
	public boolean getRegistered() {
		return this.registered;	
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public String getPreferredBatch() {
		return preferredBatch;
	}


	public void setPreferredBatch(String preferredBatch) {
		this.preferredBatch = preferredBatch;
	}
	
	
}
