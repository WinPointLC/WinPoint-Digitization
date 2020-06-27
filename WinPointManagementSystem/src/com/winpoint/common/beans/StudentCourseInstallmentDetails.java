package com.winpoint.common.beans;

import java.sql.Date;

public class StudentCourseInstallmentDetails {
	private Integer userId;
	private Integer courseId;
	private Integer plannedInstallment1;
	private Date plannedInstallment1Date;
	private Integer actualInstallment1;
	private Date actualInstallment1Date;
	private Integer plannedInstallment2;
	private Date plannedInstallment2Date;
	private Integer actualInstallment2;
	private Date actualInstallment2Date;
	private Integer plannedInstallment3;
	private Date plannedInstallment3Date;
	private Integer actualInstallment3;
	private Date actualInstallment3Date;
	private Integer dueAmount;
	
	
	public StudentCourseInstallmentDetails(Integer actualInstallment1, Date actualInstallment1Date, 
			Integer actualInstallment2, Date actualInstallment2Date,Integer actualInstallment3, Date actualInstallment3Date, Integer dueAmount) {
		
		super();
		this.actualInstallment1 = actualInstallment1;
		this.actualInstallment1Date = actualInstallment1Date;
		this.actualInstallment2 = actualInstallment2;
		this.actualInstallment2Date = actualInstallment2Date;
		this.actualInstallment3 = actualInstallment3;
		this.actualInstallment3Date = actualInstallment3Date;
		this.dueAmount = dueAmount;
		
	}
	
	public StudentCourseInstallmentDetails(Integer userId, Integer courseId, Integer plannedInstallment1,
			Date plannedInstallment1Date, Integer actualInstallment1, Date actualInstallment1Date,
			Integer plannedInstallment2, Date plannedInstallment2Date, Integer actualInstallment2,
			Date actualInstallment2Date, Integer plannedInstallment3, Date plannedInstallment3Date,
			Integer actualInstallment3, Date actualInstallment3Date, Integer dueAmount) {
		super();
		this.userId = userId;
		this.courseId = courseId;
		this.plannedInstallment1 = plannedInstallment1;
		this.plannedInstallment1Date = plannedInstallment1Date;
		this.actualInstallment1 = actualInstallment1;
		this.actualInstallment1Date = actualInstallment1Date;
		this.plannedInstallment2 = plannedInstallment2;
		this.plannedInstallment2Date = plannedInstallment2Date;
		this.actualInstallment2 = actualInstallment2;
		this.actualInstallment2Date = actualInstallment2Date;
		this.plannedInstallment3 = plannedInstallment3;
		this.plannedInstallment3Date = plannedInstallment3Date;
		this.actualInstallment3 = actualInstallment3;
		this.actualInstallment3Date = actualInstallment3Date;
		this.setDueAmount(dueAmount);
	}



	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public Integer getPlannedInstallment1() {
		return plannedInstallment1;
	}
	
	public void setPlannedInstallment1(Integer plannedInstallment1) {
		this.plannedInstallment1 = plannedInstallment1;
	}
	
	public Date getPlannedInstallment1Date() {
		return plannedInstallment1Date;
	}
	
	public void setPlannedInstallment1Date(Date plannedInstallment1Date) {
		this.plannedInstallment1Date = plannedInstallment1Date;
	}
	
	public Integer getActualInstallment1() {
		return actualInstallment1;
	}
	
	public void setActualInstallment1(Integer actualInstallment1) {
		this.actualInstallment1 = actualInstallment1;
	}
	
	public Date getActualInstallment1Date() {
		return actualInstallment1Date;
	}
	
	public void setActualInstallment1Date(Date actualInstallment1Date) {
		this.actualInstallment1Date = actualInstallment1Date;
	}
	
	public Integer getPlannedInstallment2() {
		return plannedInstallment2;
	}
	
	public void setPlannedInstallment2(Integer plannedInstallment2) {
		this.plannedInstallment2 = plannedInstallment2;
	}
	
	public Date getPlannedInstallment2Date() {
		return plannedInstallment2Date;
	}
	
	public void setPlannedInstallment2Date(Date plannedInstallment2Date) {
		this.plannedInstallment2Date = plannedInstallment2Date;
	}
	
	public Integer getActualInstallment2() {
		return actualInstallment2;
	}
	
	public void setActualInstallment2(Integer actualInstallment2) {
		this.actualInstallment2 = actualInstallment2;
	}
	
	public Date getActualInstallment2Date() {
		return actualInstallment2Date;
	}
	
	public void setActualInstallment2Date(Date actualInstallment2Date) {
		this.actualInstallment2Date = actualInstallment2Date;
	}
	
	public Integer getPlannedInstallment3() {
		return plannedInstallment3;
	}
	
	public void setPlannedInstallment3(Integer plannedInstallment3) {
		this.plannedInstallment3 = plannedInstallment3;
	}
	
	public Date getPlannedInstallment3Date() {
		return plannedInstallment3Date;
	}
	
	public void setPlannedInstallment3Date(Date plannedInstallment3Date) {
		this.plannedInstallment3Date = plannedInstallment3Date;
	}
	
	public Integer getActualInstallment3() {
		return actualInstallment3;
	}
	
	public void setActualInstallment3(Integer actualInstallment3) {
		this.actualInstallment3 = actualInstallment3;
	}
	
	public Date getActualInstallment3Date() {
		return actualInstallment3Date;
	}
	
	public void setActualInstallment3Date(Date actualInstallment3Date) {
		this.actualInstallment3Date = actualInstallment3Date;
	}

	public Integer getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Integer dueAmount) {
		this.dueAmount = dueAmount;
	}

	
}
