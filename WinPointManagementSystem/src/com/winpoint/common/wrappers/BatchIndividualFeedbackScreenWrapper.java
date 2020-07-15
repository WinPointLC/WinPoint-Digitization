package com.winpoint.common.wrappers;

import javafx.scene.control.Hyperlink;

public class BatchIndividualFeedbackScreenWrapper {
	
	private int userId;
	private String fullName;
	private String instructorName;
	private Integer duration;
	private String email ;
	private String mobile;
	private String status;
	private Hyperlink hpl;
	
	
	
	
	public BatchIndividualFeedbackScreenWrapper(int userId, String firstName, String lastName, String instructorName, Integer duration, String email,
			String mobile, String status) {
		//super();
		this.userId = userId;
		this.fullName = firstName + " " + lastName;
		this.instructorName = instructorName;
		this.duration = duration;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}



	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public Hyperlink getHpl() {
		return hpl;
	}



	public void setHpl(Hyperlink hpl) {
		this.hpl = hpl;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}
	
		

}
