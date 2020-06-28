package com.winpoint.common.wrappers;

import java.sql.Date;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;

public class FeeRecordsScreenWrapper {
	private String paymentMode;
	private String name;
	
	StudentCourseInstallmentDetails studentCourseInstallmentDetails;
	StudentCourseDetails studentCourseDetails;
	
	//** This commented section is for test purpose only.
	/*
	public FeeRecordsScreenWrapper(Integer userId, Integer batchId, String feeStatus, String paymentMode,
			Integer plannedInstallment1, Date plannedInstallment1Date, Integer actualInstallment1, Date actualInstallment1Date,
			Integer plannedInstallment2, Date plannedInstallment2Date, Integer actualInstallment2, Date actualInstallment2Date,
			Integer plannedInstallment3, Date plannedInstallment3Date, Integer actualInstallment3, Date actualInstallment3Date,
			Integer dueAmount) {
		studentCourseDetails = new StudentCourseDetails(userId, null, null, null, 
				null, null, batchId, null, null, null, null, 
				feeStatus, null, null, null, null, null, 
				null, null);
		
		studentCourseInstallmentDetails = new StudentCourseInstallmentDetails(userId, null, 
				plannedInstallment1, plannedInstallment1Date, actualInstallment1, actualInstallment1Date, 
				plannedInstallment2, plannedInstallment2Date, actualInstallment2, actualInstallment2Date, 
				plannedInstallment3, plannedInstallment3Date, actualInstallment3, actualInstallment3Date, dueAmount);
		
		this.paymentMode = paymentMode;
		this.name = "User" + userId.toString(); //A dummy name(will be retrived from DB later)
	}
	*/
	
	public FeeRecordsScreenWrapper(StudentCourseDetails studentCourseDetails, StudentCourseInstallmentDetails studentCourseInstallmentDetails) {
		this.studentCourseInstallmentDetails = studentCourseInstallmentDetails;
		this.studentCourseDetails= studentCourseDetails;
		
		this.paymentMode = "Cash";
		this.name = "User" + studentCourseDetails.getUserId().toString();
	}
	
	public StudentCourseDetails getStudentCourseDetails() {
		return studentCourseDetails;
	}

	public void setStudentCourseDetails(StudentCourseDetails studentCourseDetails) {
		this.studentCourseDetails = studentCourseDetails;
	}
	
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
		return studentCourseDetails.getFeeStatus();
	}
	
	public Integer getUserId() {
		return studentCourseDetails.getUserId();
	}
	
	public void setUserId(Integer userId) {
		studentCourseDetails.setUserId(userId);
	}
	
	public Integer getPlannedInstallment1() {
		return studentCourseInstallmentDetails.getPlannedInstallment1();
	}
	
	public void setPlannedInstallment1(Integer plannedInstallment1) {
		studentCourseInstallmentDetails.setPlannedInstallment1(plannedInstallment1);
	}
	
	public Date getPlannedInstallment1Date() {
		return studentCourseInstallmentDetails.getPlannedInstallment1Date();
	}
	
	public void setPlannedInstallment1Date(Date plannedInstallment1Date) {
		studentCourseInstallmentDetails.setPlannedInstallment1Date(plannedInstallment1Date);
	}
	
	public Integer getActualInstallment1() {
		return studentCourseInstallmentDetails.getActualInstallment1();
	}
	
	public void setActualInstallment1(Integer actualInstallment1) {
		studentCourseInstallmentDetails.setActualInstallment1(actualInstallment1);
	}
	
	public Date getActualInstallment1Date() {
		return studentCourseInstallmentDetails.getActualInstallment1Date();
	}
	
	public void setActualInstallment1Date(Date actualInstallment1Date) {
		studentCourseInstallmentDetails.setActualInstallment1Date(actualInstallment1Date);
	}
	
	public Integer getPlannedInstallment2() {
		return studentCourseInstallmentDetails.getPlannedInstallment2();
	}
	
	public void setPlannedInstallment2(Integer plannedInstallment2) {
		studentCourseInstallmentDetails.setPlannedInstallment2(plannedInstallment2);
	}
	
	public Date getPlannedInstallment2Date() {
		return studentCourseInstallmentDetails.getPlannedInstallment2Date();
	}
	
	public void setPlannedInstallment2Date(Date plannedInstallment2Date) {
		studentCourseInstallmentDetails.setPlannedInstallment2Date(plannedInstallment2Date);
	}
	
	public Integer getActualInstallment2() {
		return studentCourseInstallmentDetails.getActualInstallment2();
	}
	
	public void setActualInstallment2(Integer actualInstallment2) {
		studentCourseInstallmentDetails.setActualInstallment2(actualInstallment2);
	}
	
	public Date getActualInstallment2Date() {
		return studentCourseInstallmentDetails.getActualInstallment2Date();
	}
	
	public void setActualInstallment2Date(Date actualInstallment2Date) {
		studentCourseInstallmentDetails.setActualInstallment2Date(actualInstallment2Date);
	}
	
	public Integer getPlannedInstallment3() {
		return studentCourseInstallmentDetails.getPlannedInstallment3();
	}
	
	public void setPlannedInstallment3(Integer plannedInstallment3) {
		studentCourseInstallmentDetails.setPlannedInstallment3(plannedInstallment3);
	}
	
	public Date getPlannedInstallment3Date() {
		return studentCourseInstallmentDetails.getPlannedInstallment3Date();
	}
	
	public void setPlannedInstallment3Date(Date plannedInstallment3Date) {
		studentCourseInstallmentDetails.setPlannedInstallment3Date(plannedInstallment3Date);
	}
	
	public Integer getActualInstallment3() {
		return studentCourseInstallmentDetails.getActualInstallment3();
	}
	
	public void setActualInstallment3(Integer actualInstallment3) {
		studentCourseInstallmentDetails.setActualInstallment3(actualInstallment3);
	}
	
	public Date getActualInstallment3Date() {
		return studentCourseInstallmentDetails.getActualInstallment3Date();
	}
	
	public void setActualInstallment3Date(Date actualInstallment3Date) {
		studentCourseInstallmentDetails.setActualInstallment3Date(actualInstallment3Date);
	}

	public Integer getDueAmount() {
		return studentCourseInstallmentDetails.getDueAmount();
	}

	public void setDueAmount(Integer dueAmount) {
		studentCourseInstallmentDetails.setDueAmount(dueAmount);
	}
}
