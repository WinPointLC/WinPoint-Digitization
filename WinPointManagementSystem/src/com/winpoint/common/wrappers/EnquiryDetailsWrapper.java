package com.winpoint.common.wrappers;
public class EnquiryDetailsWrapper {
	
	private String fullName;
	private Boolean eligibility;
	private Integer coursesInterestedIn;
	private String suggestion;
	
	

	public EnquiryDetailsWrapper(String firstName, String lastName, int coursesInterestedIn,boolean eligibility, String suggestion) {
		// TODO Auto-generated constructor stub
		
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
	
	
	
}
