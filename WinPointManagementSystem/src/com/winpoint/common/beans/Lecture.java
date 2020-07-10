package com.winpoint.common.beans;

import java.sql.Date;

public class Lecture {
	private Integer lectureId;
	private Integer batchId;
	private Integer lectureNumber;
	private Integer lectureDuration;
	private Integer startTime;
	private String lectureCoverage;
	private Date lectureDate;
	private String comments;
	
	public Lecture(Integer lectureId, Integer batchId, Integer lectureNumber, Integer lectureDuration, Integer startTime,
			String lectureCoverage, Date lectureDate, String comments) {
		super();
		this.lectureId = lectureId;
		this.batchId = batchId;
		this.lectureNumber = lectureNumber;
		this.lectureDuration = lectureDuration;
		this.startTime = startTime;
		this.lectureCoverage = lectureCoverage;
		this.lectureDate = lectureDate;
		this.comments = comments;
	}
	public Integer getLectureId() {
		return lectureId;
	}
	public void setLectureId(Integer lectureId) {
		this.lectureId = lectureId;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public Integer getLectureNumber() {
		return lectureNumber;
	}
	public void setLectureNumber(Integer lectureNumber) {
		this.lectureNumber = lectureNumber;
	}
	public Integer getLectureDuration() {
		return lectureDuration;
	}
	public void setLectureDuration(Integer lectureDuration) {
		this.lectureDuration = lectureDuration;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public String getLectureCoverage() {
		return lectureCoverage;
	}
	public void setLectureCoverage(String lectureCoverage) {
		this.lectureCoverage = lectureCoverage;
	}
	public Date getLectureDate() {
		return lectureDate;
	}
	public void setLectureDate(Date lectureDate) {
		this.lectureDate = lectureDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
