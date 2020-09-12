package com.winpoint.common.beans;

/**
 * @author Abhishek Dixit
 *
 */
public class RevenueType {
		private Integer revenueTypeId;
		private String revenueTypeName;
		
		/**
		 * @param segmentTypeId;
		 * @param segmentTypeName; 
		 */
		public RevenueType(Integer revenueType, String revenueTypeName) {
			super();
			this.revenueTypeId = revenueType;
			this.revenueTypeName = revenueTypeName;
		}

		public RevenueType(String revenueTypeName) {
			// TODO Auto-generated constructor stu
			this.revenueTypeName = revenueTypeName;
			
		}

		public Integer getRevenueTypeId() {
			return revenueTypeId;
		}

		public void setRevenueTypeId(Integer revenueType) {
			this.revenueTypeId = revenueType;
		}

		public String getRevenueTypeName() {
			return revenueTypeName;
		}

		public void setRevenueTypeName(String revenueTypeName) {
			this.revenueTypeName = revenueTypeName;
		}

				
		
		
}
