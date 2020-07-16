package com.winpoint.common.beans;

import java.util.Date;

public class ManageRevenue {
		
		Integer revenueDetailId;
		Integer revenueTypeId;
		String recieptNumber;
		String payerDescription;
		Integer courseId;
		Integer batchId;
		Float revenueAmount;
		Integer paymentModeId;
		String chequeNumber;
		Integer segmentTypeId;
		Integer organizationId;
		Integer userId;
		Date recieveDate;
		
		

		public ManageRevenue(Integer revenueDetailId, Integer revenueTypeId, String recieptNumber,
				String payerDescription, Integer courseId, Integer batchId, float revenueAmount, Integer paymentModeId,
				String chequeNumber, Integer segmentTypeId, Integer organizationId, Integer userId,
				Date recieveDate) {
			super();
			this.revenueDetailId = revenueDetailId;
			this.revenueTypeId = revenueTypeId;
			this.recieptNumber = recieptNumber;
			this.payerDescription = payerDescription;
			this.courseId = courseId;
			this.batchId = batchId;
			this.revenueAmount = revenueAmount;
			this.paymentModeId = paymentModeId;
			this.chequeNumber = chequeNumber;
			this.segmentTypeId = segmentTypeId;
			this.organizationId = organizationId;
			this.userId = userId;
			this.recieveDate = recieveDate;
		}


		


		public ManageRevenue(int int1, int int2, String string, String string2, int int3, int int4, float float1,
				int int5, String string3, int int6, int int7, int int8, java.sql.Date date) {
			// TODO Auto-generated constructor stub
		}





		public Integer getRevenueDetailId() {
			return revenueDetailId;
		}

		public void setRevenueDetailId(Integer revenueDetailId) {
			this.revenueDetailId = revenueDetailId;
		}

		public Integer getRevenueTypeId() {
			return revenueTypeId;
		}

		public void setRevenueTypeId(Integer revenueTypeId) {
			this.revenueTypeId = revenueTypeId;
		}

		

		public String getRecieptNumber() {
			return recieptNumber;
		}
		
		public void setRecieptNumber(String recieptNumber) {
			this.recieptNumber = recieptNumber;
		}

		public String getPayerDescription() {
			return payerDescription;
		}

		public void setPayerDescription(String payerDescription) {
			this.payerDescription = payerDescription;
		}

		public Integer getCourseId() {
			return courseId;
		}

		public void setCourseId(Integer courseId) {
			this.courseId = courseId;
		}

		public Integer getBatchId() {
			return batchId;
		}


		public void setBatchId(Integer batchId) {
			this.batchId = batchId;
		}

		public Float getRevenueAmount() {
			return revenueAmount;
		}

		public void setRevenueAmount(Float revenueAmount) {
			this.revenueAmount = revenueAmount;
		}


		public Integer getPaymentModeId() {
			return paymentModeId;
		}


		public void setPaymentModeId(Integer paymentModeId) {
			this.paymentModeId = paymentModeId;
		}


		public String getChequeNumber() {
			return chequeNumber;
		}


		public void setChequeNumber(String chequeNumber) {
			this.chequeNumber = chequeNumber;
		}


		public Integer getSegmentTypeId() {
			return segmentTypeId;
		}
		
		public void setSegmentTypeId(Integer segmentTypeId) {
			this.segmentTypeId = segmentTypeId;
		}


		public Integer getOrganizationId() {
			return organizationId;
		}

		public void setOrganizationId(Integer organizationId) {
			this.organizationId = organizationId;
		}

		
		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Date getRecieveDate() {
			return recieveDate;
		}

		public void setRecieveDate(Date recieveDate) {
			this.recieveDate = recieveDate;
		}
	
}
