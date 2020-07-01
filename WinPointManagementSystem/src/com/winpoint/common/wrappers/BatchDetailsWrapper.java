package com.winpoint.common.wrappers;

import java.util.Date;

public class BatchDetailsWrapper {
	private String batchId;
	private Integer courseId;
	private Integer facultyId;
	private Integer batchTime;
	private Date startDate;
	private Date endDate;
	private Integer createdBy;
	private Date createdDate;

	public BatchDetailsWrapper(String batchId, Integer courseId, Integer facultyId, Integer batchTime, Date startDate,
			Date endDate, Integer createdBy, Date createdDate) {
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.batchTime = batchTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public Integer getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(Integer batchTime) {
		this.batchTime = batchTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
	
	
}
