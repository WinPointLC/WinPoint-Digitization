package com.winpoint.common.wrappers;

import javafx.scene.control.Button;

public class CoursesNameWrapper {

	private String fullName;
	private boolean enquired;
	private boolean registered;
	private Button add;
	
	public CoursesNameWrapper(String firstName, String lastName, boolean enquired, boolean registered,Button add){
		
		fullName = firstName + " " + lastName;
		this.enquired = enquired;
		this.registered = registered;
		this.setAdd(new Button("Add"));
		
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

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}
	
}
