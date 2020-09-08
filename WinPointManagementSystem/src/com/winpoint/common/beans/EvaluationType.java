package com.winpoint.common.beans;

import java.util.Date;

/**
 * Stores the information of the evaluation type for a course.
 */
public class EvaluationType {
	private Integer evaluationTypeId;
	private String evaluationTypeName;
	private String offlineCheck;
	private Integer createdBy;
	private Date createdDate;
	
	/**
	 * @param evaluationTypeId
	 * @param evaluationTypeName
	 * @param createdBy
	 * @param createdDate
	 */
	public EvaluationType(Integer evaluationTypeId, String evaluationTypeName, Integer createdBy, Date createdDate) {
		super();
		this.evaluationTypeId = evaluationTypeId;
		this.evaluationTypeName = evaluationTypeName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	public String getOfflineCheck() {
		return offlineCheck;
	}

	public void setOfflineCheck(String offlineCheck) {
		this.offlineCheck = offlineCheck;
	}

	public EvaluationType(int evaluationTypeId, String evaluationTypeName, String offlineCheck) {
		// TODO Auto-generated constructor stub
		this.evaluationTypeId = evaluationTypeId;
		this.evaluationTypeName = evaluationTypeName;
		this.offlineCheck = offlineCheck;
	}

	/**
	 * @return the evaluationTypeId
	 */
	public Integer getEvaluationTypeId() {
		return evaluationTypeId;
	}
	
	/**
	 * @param evaluationTypeId the evaluationTypeId to set
	 */
	public void setEvaluationTypeId(Integer evaluationTypeId) {
		this.evaluationTypeId = evaluationTypeId;
	}
	
	/**
	 * @return the evaluationTypeName
	 */
	public String getEvaluationTypeName() {
		return evaluationTypeName;
	}
	
	/**
	 * @param evaluationTypeName the evaluationTypeName to set
	 */
	public void setEvaluationTypeName(String evaluationTypeName) {
		this.evaluationTypeName = evaluationTypeName;
	}
	
	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
