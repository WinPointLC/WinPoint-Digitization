package com.winpoint.common.wrappers;

import java.util.ArrayList;
import java.util.Date;

public class NumberOfStudentWrapper {
	private String fullName;
	private boolean enquired;
	private boolean registered;
	private Date startDate;
	private String preferredBatch;
	private ArrayList<UserCoursesDoneWrapper> arrayList;
		
	public NumberOfStudentWrapper(String firstName, String lastName, String preferredBatch, boolean enquired, boolean registered) {
		
		this.fullName = firstName + " " + lastName;
		this.enquired = enquired;
		this.registered = registered;
//		this.startDate = startDate;
		this.preferredBatch = preferredBatch;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEnquired(boolean enquired) {
		this.enquired = enquired;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
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
