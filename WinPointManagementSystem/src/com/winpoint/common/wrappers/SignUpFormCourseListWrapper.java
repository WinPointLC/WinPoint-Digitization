package com.winpoint.common.wrappers;

public class SignUpFormCourseListWrapper {
	
	Integer courseId;
	String courseName;
	Integer courseTypeId;
	String courseTypeName;
	
	public SignUpFormCourseListWrapper(Integer courseId, String courseName, Integer courseTypeId,
			String courseTypeName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTypeId = courseTypeId;
		this.courseTypeName = courseTypeName;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(Integer courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}
	
}
