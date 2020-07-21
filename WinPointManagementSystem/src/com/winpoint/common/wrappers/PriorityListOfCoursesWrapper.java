package com.winpoint.common.wrappers;

import java.util.Date;

import javafx.scene.control.Button;

public class PriorityListOfCoursesWrapper {
	private int courseId;
	private String course;
	private int segmentType;
	private int availableTime;
	private int noOfStudents;
	private Date beginDate;
	private String faucultyName;
	private int totalRevenue;
	private Button launch;
	
	
//this is commented for tp	
//	public PriorityListOfCoursesWrapper(String course, String segmentType, String availableTime, String noOfStudents,
//			Date beginDate, String faucultyName, int totalRevenue, Button launch) {
//		super();
//		this.course = course;
//		this.segmentType = segmentType;
//		this.availableTime = availableTime;
//		this.noOfStudents = noOfStudents;
//		this.beginDate = beginDate;
//		this.faucultyName = faucultyName;
//		this.totalRevenue = totalRevenue;
//		this.launch = launch;
//	}



	public PriorityListOfCoursesWrapper(int courseId,String courseName, int segmentType, int availableTime, int noOfStudents, Date beginDate, int totalRevenue, Button launchButton) {

		this.courseId = courseId;
		this.course = courseName;
		this.segmentType = segmentType;
		this.availableTime = availableTime;
		this.noOfStudents = noOfStudents;
		this.beginDate = beginDate;
		this.totalRevenue = totalRevenue;
		
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public int getSegmentType() {
		return segmentType;
	}



	public void setSegmentType(int segmentType) {
		this.segmentType = segmentType;
	}



	public int getAvailableTime() {
		return availableTime;
	}



	public void setAvailableTime(int availableTime) {
		this.availableTime = availableTime;
	}



	public int getNoOfStudents() {
		return noOfStudents;
	}



	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}



	public Date getBeginDate() {
		return beginDate;
	}



	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}



	public String getFaucultyName() {
		return faucultyName;
	}



	public void setFaucultyName(String faucultyName) {
		this.faucultyName = faucultyName;
	}



	public int getTotalRevenue() {
		return totalRevenue;
	}



	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}



	public Button getLaunch() {
		return launch;
	}



	public void setLaunch(Button launch) {
		this.launch = launch;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
