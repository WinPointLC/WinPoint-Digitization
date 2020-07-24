package com.winpoint.common.wrappers;

import java.util.Date;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class PriorityListOfCoursesWrapper {
	
	private int courseId;
	private String course;
	private int segmentType;
	private int availableTime;
	private int noOfStudents;
	private Date beginDate;
	private String facultyName;
	private int totalRevenue;
	private Button launch;
	
	private ChoiceBox<String> availableChoiceBox;// = new ChoiceBox<String>();
	
	private ChoiceBox<String> facultyNameList;// = new ChoiceBox<String>();

	//private ChoiceBox available;
	private int courseTypeId;
	private String courseTypeName;
	

	public PriorityListOfCoursesWrapper(int courseId,String courseName,int courseTypeId, int segmentType, ChoiceBox<String> availableChoiceBox, int noOfStudents, Date beginDate, ChoiceBox<String> facultyNameList, int totalRevenue, Button launch) {

		this.courseId = courseId;
		this.course = courseName;
		this.courseTypeId = courseTypeId;
		this.segmentType = segmentType;
		this.availableChoiceBox = availableChoiceBox;
		this.noOfStudents = noOfStudents;
		this.beginDate = beginDate;
		this.totalRevenue = totalRevenue;
		this.launch = launch;
		this.facultyNameList = facultyNameList;
		
	}
	
	public ChoiceBox<String> getAvailableTime() {
		return availableChoiceBox;
	}

	public void setAvailableTime(ChoiceBox<String> availableChoiceBox) {
		this.availableChoiceBox = availableChoiceBox;
	}

	public int getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public PriorityListOfCoursesWrapper(int courseId,String courseName, int segmentType, ChoiceBox<String> availableChoiceBox, int noOfStudents, Date beginDate, int totalRevenue, Button launch) {

		this.courseId = courseId;
		this.course = courseName;
		this.segmentType = segmentType;
		this.availableChoiceBox = availableChoiceBox;
		this.noOfStudents = noOfStudents;
		this.beginDate = beginDate;
		this.totalRevenue = totalRevenue;
		this.launch = launch;
	}

	public ChoiceBox<String> getAvailbleTime() {
		return availableChoiceBox;
	}

	public void getAvailbleTime(ChoiceBox<String> availableChoiceBox) {
		this.availableChoiceBox = availableChoiceBox;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Button getLaunchButton() {
		return launch;
	}

	public void setLaunchButton(Button launch) {
		this.launch = launch;
	}

	public int getSegmentType() {
		return segmentType;
	}

	public void setSegmentType(int segmentType) {
		this.segmentType = segmentType;
	}
//
//	public int getAvailableTime() {
//		return availableTime;
//	}
//
//
//
//	public void setAvailableTime(int availableTime) {
//		this.availableTime = availableTime;
//	}



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
		return facultyName;
	}



	public void setFaucultyName(String facultyName) {
		this.facultyName = facultyName;
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

	public ChoiceBox<String> getFacultyName() {
		return facultyNameList;
	}

	public void setFacultyName(ChoiceBox<String> facultyNameList) {
		this.facultyNameList = facultyNameList;
	}

}
