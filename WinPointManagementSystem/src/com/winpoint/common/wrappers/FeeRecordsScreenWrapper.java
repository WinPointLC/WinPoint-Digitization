package com.winpoint.common.wrappers;

import java.sql.Date;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;

public class FeeRecordsScreenWrapper {
	private String paymentMode;
	private String name;
	
	StudentCourseInstallmentDetails studentCourseInstallmentDetailsObject;
	StudentCourseDetails studentCourseDetailsObject;
	
	public FeeRecordsScreenWrapper(Integer userId, Integer batchId, String feeStatus, String paymentMode,
			Integer plannedInstallment1, Date plannedInstallment1Date, Integer actualInstallment1, Date actualInstallment1Date,
			Integer plannedInstallment2, Date plannedInstallment2Date, Integer actualInstallment2, Date actualInstallment2Date,
			Integer plannedInstallment3, Date plannedInstallment3Date, Integer actualInstallment3, Date actualInstallment3Date,
			Integer dueAmount) {
		studentCourseDetailsObject = new StudentCourseDetails(userId, null, null, null, 
				null, null, batchId, null, null, null, null, 
				feeStatus, null, null, null, null, null, 
				null, null);
		
		studentCourseInstallmentDetailsObject = new StudentCourseInstallmentDetails(userId, null, 
				plannedInstallment1, plannedInstallment1Date, actualInstallment1, actualInstallment1Date, 
				plannedInstallment2, plannedInstallment2Date, actualInstallment2, actualInstallment2Date, 
				plannedInstallment3, plannedInstallment3Date, actualInstallment3, actualInstallment3Date, dueAmount);
		
		this.paymentMode = paymentMode;
		this.name = "User" + userId.toString(); //A dummy name(will be retrived from DB later)
	}
	//** This commented section is for test purpose only.
//	public Wrapper(StudentCourseDetails studentCourseDetails, StudentCourseInstallmentDetails studentCourseInstallmentDetails) {
//		this.studentCourseInstallmentDetailsObject = studentCourseInstallmentDetails;
//		this.studentCourseDetailsObject = studentCourseDetails;
//	}
//	
//	public StudentCourseDetails getStudentCourseDetailsObject() {
//		return studentCourseDetailsObject;
//	}

	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFeeStatus() {
		return studentCourseDetailsObject.getFeeStatus();
	}
	
	public Integer getUserId() {
		return studentCourseDetailsObject.getUserId();
	}
	
	public void setUserId(Integer userId) {
		studentCourseDetailsObject.setUserId(userId);
	}
	
	public Integer getPlannedInstallment1() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment1();
	}
	
	public void setPlannedInstallment1(Integer plannedInstallment1) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment1(plannedInstallment1);
	}
	
	public Date getPlannedInstallment1Date() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment1Date();
	}
	
	public void setPlannedInstallment1Date(Date plannedInstallment1Date) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment1Date(plannedInstallment1Date);
	}
	
	public Integer getActualInstallment1() {
		return studentCourseInstallmentDetailsObject.getActualInstallment1();
	}
	
	public void setActualInstallment1(Integer actualInstallment1) {
		studentCourseInstallmentDetailsObject.setActualInstallment1(actualInstallment1);
	}
	
	public Date getActualInstallment1Date() {
		return studentCourseInstallmentDetailsObject.getActualInstallment1Date();
	}
	
	public void setActualInstallment1Date(Date actualInstallment1Date) {
		studentCourseInstallmentDetailsObject.setActualInstallment1Date(actualInstallment1Date);
	}
	
	public Integer getPlannedInstallment2() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment2();
	}
	
	public void setPlannedInstallment2(Integer plannedInstallment2) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment2(plannedInstallment2);
	}
	
	public Date getPlannedInstallment2Date() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment2Date();
	}
	
	public void setPlannedInstallment2Date(Date plannedInstallment2Date) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment2Date(plannedInstallment2Date);
	}
	
	public Integer getActualInstallment2() {
		return studentCourseInstallmentDetailsObject.getActualInstallment2();
	}
	
	public void setActualInstallment2(Integer actualInstallment2) {
		studentCourseInstallmentDetailsObject.setActualInstallment2(actualInstallment2);
	}
	
	public Date getActualInstallment2Date() {
		return studentCourseInstallmentDetailsObject.getActualInstallment2Date();
	}
	
	public void setActualInstallment2Date(Date actualInstallment2Date) {
		studentCourseInstallmentDetailsObject.setActualInstallment2Date(actualInstallment2Date);
	}
	
	public Integer getPlannedInstallment3() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment3();
	}
	
	public void setPlannedInstallment3(Integer plannedInstallment3) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment3(plannedInstallment3);
	}
	
	public Date getPlannedInstallment3Date() {
		return studentCourseInstallmentDetailsObject.getPlannedInstallment3Date();
	}
	
	public void setPlannedInstallment3Date(Date plannedInstallment3Date) {
		studentCourseInstallmentDetailsObject.setPlannedInstallment3Date(plannedInstallment3Date);
	}
	
	Integer getActualInstallment3() {
		return studentCourseInstallmentDetailsObject.getActualInstallment3();
	}
	
	public void setActualInstallment3(Integer actualInstallment3) {
		studentCourseInstallmentDetailsObject.setActualInstallment3(actualInstallment3);
	}
	
	public Date getActualInstallment3Date() {
		return studentCourseInstallmentDetailsObject.getActualInstallment3Date();
	}
	
	public void setActualInstallment3Date(Date actualInstallment3Date) {
		studentCourseInstallmentDetailsObject.setActualInstallment3Date(actualInstallment3Date);
	}

	public Integer getDueAmount() {
		return studentCourseInstallmentDetailsObject.getDueAmount();
	}

	public void setDueAmount(Integer dueAmount) {
		studentCourseInstallmentDetailsObject.setDueAmount(dueAmount);
	}
}
