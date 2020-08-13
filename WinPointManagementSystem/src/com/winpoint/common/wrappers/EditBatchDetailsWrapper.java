package com.winpoint.common.wrappers;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import com.winpoint.common.beans.Topic;


public class EditBatchDetailsWrapper {
	private Integer lectureNumber;
	private Date lectureDate;
	private String startTime;
	private String lectureDuration;
	private String comments;
	ArrayList<Integer> topicsList;
	private String lecCoverage;
	public EditBatchDetailsWrapper(Integer lectureNumber, Date lectureDate, String startTime, String lectureDuration,
			String comments,ArrayList<Integer> topicsList) {
		super();
		this.lectureNumber = lectureNumber;
		this.lectureDate = lectureDate;
		this.startTime = startTime;
		this.lectureDuration = lectureDuration;
		this.comments = comments;
		this.topicsList=topicsList;
	}
	
	
	public String getLecCoverage() {
		return lecCoverage;
	}


	public void setLecCoverage(String lecCoverage) {
		this.lecCoverage = lecCoverage;
	}


	


	public EditBatchDetailsWrapper( Date lectureDate, String startTime, String lectureDuration,
			String comments, String lecCoverage) {
		super();
		this.lectureDate = lectureDate;
		this.startTime = startTime;
		this.lectureDuration = lectureDuration;
		this.comments = comments;
		this.lecCoverage = lecCoverage;
	}


	public Integer getLectureNumber() {
		return lectureNumber;
	}
	public void setLectureNumber(Integer lectureNumber) {
		this.lectureNumber = lectureNumber;
	}
	public Date getLectureDate() {
		return lectureDate;
	}
	public void setLectureDate(Date lectureDate) {
		this.lectureDate = lectureDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getLectureDuration() {
		return lectureDuration;
	}
	public void setLectureDuration(String lectureDuration) {
		this.lectureDuration = lectureDuration;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ArrayList<Integer> getTopicsList() {
		return topicsList;
	}
	public void setTopicsList(ArrayList<Integer> topicsList) {
		this.topicsList = topicsList;
	}
	
	
	
}