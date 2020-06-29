package com.winpoint.common.wrappers;

public class AssignmentsScreenWrapper {
	private String fullName;
	private String feeStatus;
	private String coursewareIssued;
	private String assignmentsIssued;
	private String assignmentsSubmitted;
	
	public AssignmentsScreenWrapper(String firstName,String lastName,String feeStatus, String coursewareIssued, String assignmentsIssued,
			String assignmentsSubmitted) {
		// TODO Auto-generated constructor stub
		this.fullName=firstName + " " + lastName;
		this.feeStatus=feeStatus;
		this.coursewareIssued=coursewareIssued;
		this.assignmentsIssued=assignmentsIssued;
		this.assignmentsSubmitted=assignmentsSubmitted;
	}
	

	public String getName() {
		return fullName;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFeeStatus() {
		return this.feeStatus;	
	}
	
	public String getCoursewareIssued() {
		return this.coursewareIssued;	
	}
	public String getAssignmentsIssued() {
		return this.assignmentsIssued;	
	}
	public String getAssignmentsSubmitted() {
		return this.assignmentsSubmitted;	
	}
}
