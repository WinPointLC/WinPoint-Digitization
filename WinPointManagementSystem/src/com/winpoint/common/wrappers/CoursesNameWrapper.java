package com.winpoint.common.wrappers;

public class CoursesNameWrapper {

	private String fullName;
	private boolean enquired;
	private boolean registered;
	
	public CoursesNameWrapper(String firstName, String lastName, boolean enquired, boolean registered) {
		
		fullName = firstName + " " + lastName;
		this.enquired = enquired;
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
	
}
