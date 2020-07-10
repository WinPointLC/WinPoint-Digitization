
package com.winpoint.common.beans;

import java.util.Date;

public class UserTestDetails {
	private Integer userTestId;
	private Integer userId;
	private Integer testDetailsId;
	private Integer marksReceived;
	private String timeTaken;
	private Integer numberOfRegistration;
	private String feeStatus;
	private Integer createdBy;
	private Date createdDate;
	private Integer attempted;
	private String evaluationDone;
	public UserTestDetails(Integer userTestId, Integer userId, Integer testDetailsId, Integer marksReceived,
			String timeTaken, Integer numberOfRegistration, String feeStatus, Integer createdBy, Date createdDate,
			Integer attempted, String evaluationDone) {
		super();
		this.userTestId = userTestId;
		this.userId = userId;
		this.testDetailsId = testDetailsId;
		this.marksReceived = marksReceived;
		this.timeTaken = timeTaken;
		this.numberOfRegistration = numberOfRegistration;
		this.feeStatus = feeStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.attempted = attempted;
		this.evaluationDone = evaluationDone;
	}
	
	public UserTestDetails(String evaluationDone) {
		super();
		this.evaluationDone = evaluationDone;
	}

	public Integer getUserTestId() {
		return userTestId;
	}
	public void setUserTestId(Integer userTestId) {
		this.userTestId = userTestId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTestDetailsId() {
		return testDetailsId;
	}
	public void setTestDetailsId(Integer testDetailsId) {
		this.testDetailsId = testDetailsId;
	}
	public Integer getMarksReceived() {
		return marksReceived;
	}
	public void setMarksReceived(Integer marksReceived) {
		this.marksReceived = marksReceived;
	}
	public String getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}
	public Integer getNumberOfRegistration() {
		return numberOfRegistration;
	}
	public void setNumberOfRegistration(Integer numberOfRegistration) {
		this.numberOfRegistration = numberOfRegistration;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getAttempted() {
		return attempted;
	}
	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}
	public String getEvaluationDone() {
		return evaluationDone;
	}
	public void setEvaluationDone(String evaluationDone) {
		this.evaluationDone = evaluationDone;
	}
	
	
	
	
	
}