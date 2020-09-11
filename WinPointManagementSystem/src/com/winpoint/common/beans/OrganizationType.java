package com.winpoint.common.beans;

/**
 * @author Abhishek Dixit
 *
 */
public class OrganizationType {
		private Integer organizationTypeId;
		private String organizationTypeName;
		
		/**
		 * @param segmentTypeId;
		 * @param segmentTypeName; 
		 */
		public OrganizationType(Integer organizationType, String organizationTypeName) {
			super();
			this.organizationTypeId = organizationType;
			this.organizationTypeName = organizationTypeName;
		}

		public OrganizationType(String organizationTypeName) {
			this.organizationTypeName = organizationTypeName;
		}

		public Integer getOrganizationTypeId() {
			return organizationTypeId;
		}

		public void setOrganizationTypeId(Integer organizationType) {
			this.organizationTypeId = organizationType;
		}

		public String getOrganizationTypeName() {
			return organizationTypeName;
		}

		public void setOrganizationTypeName(String organizationTypeName) {
			this.organizationTypeName = organizationTypeName;
		}
		
}
