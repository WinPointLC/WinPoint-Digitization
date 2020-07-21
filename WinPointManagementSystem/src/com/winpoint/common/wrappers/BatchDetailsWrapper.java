package com.winpoint.common.wrappers;

import java.util.Date;

import javafx.scene.control.Button;

public class BatchDetailsWrapper {
	private String batchIds;
	private Integer batchId;
	private String batchName;
	private Integer courseId;
	private Integer facultyId;
	private Integer batchTime;
	private Date startDate;
	private Date endDate;
	private Integer createdBy;
	private Date createdDate;
	private Button add;
	private String facultyName;
	private String facultyImageLocation;

	public BatchDetailsWrapper(Integer batchId, Integer courseId, Integer facultyId, Integer batchTime, Date startDate,
			Date endDate, Integer createdBy, Date createdDate, Button add) {
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.batchTime = batchTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.add=add;
	}
	
	public BatchDetailsWrapper(Integer batchId, String batchName, String facultyName,
			String facultyImageLocation) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.facultyName = facultyName;
		this.facultyImageLocation = facultyImageLocation;
	}

	
	

	public String getBatchIds() {
		return batchIds;
	}

	public void setBatchIds(String batchIds) {
		this.batchIds = batchIds;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyImageLocation() {
		return facultyImageLocation;
	}

	public void setFacultyImageLocation(String facultyImageLocation) {
		this.facultyImageLocation = facultyImageLocation;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
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
