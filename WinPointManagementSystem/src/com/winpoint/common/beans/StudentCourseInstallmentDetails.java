package com.winpoint.common.beans;

import java.sql.Date;

public class StudentCourseInstallmentDetails {
private Integer UserId;
private Integer CourseId;
private Integer PlannedInstallment1;
private Date PlannedInstallment1Date;
private Integer ActualInstallment1;
private Date ActualInstallment1Date;
private Integer PlannedInstallment2;
private Date PlannedInstallment2Date;
private Integer ActualInstallment2;
private Date ActualInstallment2Date;
private Integer PlannedInstallment3;
private Date PlannedInstallment3Date;
private Integer ActualInstallment3;
private Date ActualInstallment3Date;
public StudentCourseInstallmentDetails(Integer userId, Integer courseId, Integer plannedInstallment1,
		Date plannedInstallment1Date, Integer actualInstallment1, Date actualInstallment1Date,
		Integer plannedInstallment2, Date plannedInstallment2Date, Integer actualInstallment2,
		Date actualInstallment2Date, Integer plannedInstallment3, Date plannedInstallment3Date,
		Integer actualInstallment3, Date actualInstallment3Date) {
	super();
	UserId = userId;
	CourseId = courseId;
	PlannedInstallment1 = plannedInstallment1;
	PlannedInstallment1Date = plannedInstallment1Date;
	ActualInstallment1 = actualInstallment1;
	ActualInstallment1Date = actualInstallment1Date;
	PlannedInstallment2 = plannedInstallment2;
	PlannedInstallment2Date = plannedInstallment2Date;
	ActualInstallment2 = actualInstallment2;
	ActualInstallment2Date = actualInstallment2Date;
	PlannedInstallment3 = plannedInstallment3;
	PlannedInstallment3Date = plannedInstallment3Date;
	ActualInstallment3 = actualInstallment3;
	ActualInstallment3Date = actualInstallment3Date;
}
public Integer getUserId() {
	return UserId;
}
public void setUserId(Integer userId) {
	UserId = userId;
}
public Integer getCourseId() {
	return CourseId;
}
public void setCourseId(Integer courseId) {
	CourseId = courseId;
}
public Integer getPlannedInstallment1() {
	return PlannedInstallment1;
}
public void setPlannedInstallment1(Integer plannedInstallment1) {
	PlannedInstallment1 = plannedInstallment1;
}
public Date getPlannedInstallment1Date() {
	return PlannedInstallment1Date;
}
public void setPlannedInstallment1Date(Date plannedInstallment1Date) {
	PlannedInstallment1Date = plannedInstallment1Date;
}
public Integer getActualInstallment1() {
	return ActualInstallment1;
}
public void setActualInstallment1(Integer actualInstallment1) {
	ActualInstallment1 = actualInstallment1;
}
public Date getActualInstallment1Date() {
	return ActualInstallment1Date;
}
public void setActualInstallment1Date(Date actualInstallment1Date) {
	ActualInstallment1Date = actualInstallment1Date;
}
public Integer getPlannedInstallment2() {
	return PlannedInstallment2;
}
public void setPlannedInstallment2(Integer plannedInstallment2) {
	PlannedInstallment2 = plannedInstallment2;
}
public Date getPlannedInstallment2Date() {
	return PlannedInstallment2Date;
}
public void setPlannedInstallment2Date(Date plannedInstallment2Date) {
	PlannedInstallment2Date = plannedInstallment2Date;
}
public Integer getActualInstallment2() {
	return ActualInstallment2;
}
public void setActualInstallment2(Integer actualInstallment2) {
	ActualInstallment2 = actualInstallment2;
}
public Date getActualInstallment2Date() {
	return ActualInstallment2Date;
}
public void setActualInstallment2Date(Date actualInstallment2Date) {
	ActualInstallment2Date = actualInstallment2Date;
}
public Integer getPlannedInstallment3() {
	return PlannedInstallment3;
}
public void setPlannedInstallment3(Integer plannedInstallment3) {
	PlannedInstallment3 = plannedInstallment3;
}
public Date getPlannedInstallment3Date() {
	return PlannedInstallment3Date;
}
public void setPlannedInstallment3Date(Date plannedInstallment3Date) {
	PlannedInstallment3Date = plannedInstallment3Date;
}
public Integer getActualInstallment3() {
	return ActualInstallment3;
}
public void setActualInstallment3(Integer actualInstallment3) {
	ActualInstallment3 = actualInstallment3;
}
public Date getActualInstallment3Date() {
	return ActualInstallment3Date;
}
public void setActualInstallment3Date(Date actualInstallment3Date) {
	ActualInstallment3Date = actualInstallment3Date;
}


}
