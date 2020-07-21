package com.winpoint.common.beans;

public class CoursePlans {
	private Integer courseId;
	private Integer lectureNumber;
	private String lecturePlan;
	private String[] topicNames;
	public CoursePlans(Integer courseId, Integer lectureNumber, String lecturePlan, String[] topicNames) {
		super();
		this.courseId = courseId;
		this.lectureNumber = lectureNumber;
		this.lecturePlan = lecturePlan;
		this.topicNames = topicNames;
	}
	public CoursePlans(Integer courseId, Integer lectureNumber, String[] topicNames) {
		super();
		this.courseId = courseId;
		this.lectureNumber = lectureNumber;
		this.topicNames = topicNames;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getLectureNumber() {
		return lectureNumber;
	}
	public void setLectureNumber(Integer lectureNumber) {
		this.lectureNumber = lectureNumber;
	}
	public String getLecturePlan() {
		return lecturePlan;
	}
	public void setLecturePlan(String lecturePlan) {
		this.lecturePlan = lecturePlan;
	}
	public String[] getTopicNames() {
		return topicNames;
	}
	public void setTopicNames(String[] topicNames) {
		this.topicNames = topicNames;
	}
	
	
}
