package com.winpoint.common.wrappers;

import java.util.Date;

public class EnquiryDetailsWrapper {
	
	private String fullName;
	private Boolean eligibility;
	private Integer coursesInterestedIn;
	private String suggestion;
	
	

	public EnquiryDetailsWrapper(String firstName, String lastName, int coursesInterestedIn,boolean eligibility, String suggestion) {
		
		this.fullName = firstName + " " + lastName;
		this.coursesInterestedIn = coursesInterestedIn;
		this.eligibility = eligibility;
		this.suggestion = suggestion;
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

	public Integer getCoursesInterestedIn() {
		return coursesInterestedIn;
	}

	public void setCoursesInterestedIn(Integer coursesInterestedIn) {
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
	
	
	
	
	
	
	
}
