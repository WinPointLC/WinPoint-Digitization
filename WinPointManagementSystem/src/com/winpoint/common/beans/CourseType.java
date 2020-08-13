package com.winpoint.common.beans;

import java.util.Date;

public class CourseType {
	private Integer courseTypeId;
	private String courseTypeName;
	private Integer createdBy;
	private Date createddDate;
	
	/**
	 * @param courseTypeId
	 * @param courseTypeName
	 * @param createdBy
	 * @param createdDate
	 */
	public CourseType(Integer courseTypeId, String courseTypeName, Integer createdBy, Date createdDate) {
		super();
		this.courseTypeId = courseTypeId;
		this.courseTypeName = courseTypeName;
		this.createdBy = createdBy;
		this.createddDate = createdDate;
	}
	
	public CourseType(int courseTypeId, String courseTypeName) {
		this.courseTypeId = courseTypeId;
		this.courseTypeName = courseTypeName;
	}

	public CourseType(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	/**
	 * @return the courseTypeId
	 */
	public Integer getCourseTypeId() {
		return courseTypeId;
	}
	
	/**
	 * @return the courseTypeName
	 */
	public String getCourseTypeName() {
		return courseTypeName;
	}
	
	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createddDate;
	}
	
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		createddDate = createdDate;
	}
}
