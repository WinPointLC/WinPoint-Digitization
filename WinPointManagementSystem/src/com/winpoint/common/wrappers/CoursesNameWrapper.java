package com.winpoint.common.wrappers;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class CoursesNameWrapper {

	private String fullName;
	private boolean enquired;
	private boolean registered;
	private Button addStudent;
	private CheckBox checkBox;
	
	public CoursesNameWrapper(String firstName, String lastName, boolean enquired, boolean registered, CheckBox checkBox, Button addStudent){
		
		fullName = firstName + " " + lastName;
		this.enquired = enquired;
		this.registered = registered;
		this.checkBox = checkBox;
		this.addStudent = addStudent;
		
	}
	
	public CheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public Button getAddStudent() {
		return addStudent;
	}

	public void setAddStudent(Button addStudent) {
		this.addStudent = addStudent;
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
