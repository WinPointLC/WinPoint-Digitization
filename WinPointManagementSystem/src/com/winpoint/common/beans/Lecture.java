package com.winpoint.common.beans;

import java.util.Date;

public class Lecture {
	private Integer lectureId;
	private Integer batchId;
	private Integer lectureNumber;
	private Integer lectureDuration;
	private Date startTime;
	private String[] lectureCoverage;
	private Date lectureDate;
	private String comments;
	private String absentee;
	
	public Lecture(Integer lectureId, Integer batchId, Integer lectureNumber, Integer lectureDuration, Date startTime,
			String[] lectureCoverage, Date lectureDate, String comments) {
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
	
	
	public Lecture(Integer batchId, Integer lectureNumber, Integer lectureDuration, Date startTime,
			String[] lectureCoverage, Date lectureDate) {
		super();
		this.batchId = batchId;
		this.lectureNumber = lectureNumber;
		this.lectureDuration = lectureDuration;
		this.startTime = startTime;
		this.lectureCoverage = lectureCoverage;
		this.lectureDate = lectureDate;
	}


	public Lecture(Integer lectureNumber, String absentee) {
		super();
		this.lectureNumber = lectureNumber;
		this.absentee = absentee;
	}

	public String getAbsentee() {
		return absentee;
	}
	public void setAbsentee(String absentee) {
		this.absentee = absentee;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String[] getLectureCoverage() {
		return lectureCoverage;
	}
	public void setLectureCoverage(String[] lectureCoverage) {
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
