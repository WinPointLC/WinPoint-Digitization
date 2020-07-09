package com.winpoint.common.wrappers;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EnquiryDetailsWrapper {
	
	private String fullName;
	private Boolean eligibility;
	private String coursesInterestedIn;
	private String suggestion;
	private Button update;
	
	

	public EnquiryDetailsWrapper(String firstName, String lastName, String courseInterestedIn,boolean eligibility, String suggestion, Button update) {
		
		this.fullName = firstName + " " + lastName;
		this.coursesInterestedIn = courseInterestedIn;
		this.eligibility = eligibility;
		this.suggestion = suggestion;
		this.update = update;
	}

	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Boolean getEligibility() {
		return eligibility;
	}

	public void setEligibility(Boolean eligibility) {
		this.eligibility = eligibility;
	}

	public String getCoursesInterestedIn() {
		return coursesInterestedIn;
	}

	public void setCoursesInterestedIn(String coursesInterestedIn) {
		this.coursesInterestedIn = coursesInterestedIn;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	} 
	
	// Function to data the data to database
	public void setDataToTable(String firstName, String lastName, String email, Date birthDate, String address, String gender, String mobileNumber, String college, String degree, String branch, Integer yearOfGraduation, Integer coursesInterestedIn, Integer courseAlreadyDone,  Integer timeSlotsId, String reference) {
		
	}



	public Button getUpdate() {
		System.out.println("Getter of the Update Button");
		return update;
	}



	public void setUpdate(Button update) {
		this.update = update;
	}
	
	
	
	
	
	
	
}