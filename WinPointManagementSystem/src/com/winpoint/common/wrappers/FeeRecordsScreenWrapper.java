package com.winpoint.common.wrappers;

import java.sql.Date;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;

public class FeeRecordsScreenWrapper {
	private String paymentMode;
	private String name;
	private String feeStatus;
	private Integer userId;
	private String mobile;
	private String emailId;
	
	private StudentCourseInstallmentDetails studentCourseInstallmentDetails;
	
	public FeeRecordsScreenWrapper(Integer userId, String name, String feeStatus, String paymentMode, 
			String emailId, String mobile, StudentCourseInstallmentDetails studentCourseInstallmentDetails) {
		this.studentCourseInstallmentDetails = studentCourseInstallmentDetails;
		this.feeStatus = feeStatus;
		this.paymentMode = paymentMode;
		this.name = name;
		this.userId = userId;
		this.mobile = mobile;
		this.emailId = emailId;
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
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getFeeStatus() {
		return feeStatus;
	}
	
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public StudentCourseInstallmentDetails getStudentCourseInstallmentDetails() {
		return studentCourseInstallmentDetails;
	}
	
	public void setStudentCourseInstallmentDetails(StudentCourseInstallmentDetails studentCourseInstallmentDetails) {
		this.studentCourseInstallmentDetails = studentCourseInstallmentDetails;
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
