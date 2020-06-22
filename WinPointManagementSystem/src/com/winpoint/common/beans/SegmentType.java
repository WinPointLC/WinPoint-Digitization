package com.winpoint.common.beans;

/**
 * @author shraddhaapadalkar
 *
 */
public class SegmentType {
		private Integer segmentTypeId;
		private String segmentTypeName;
		
		/**
		 * @param segmentTypeId;
		 * @param segmentTypeName; 
		 */
		public SegmentType(Integer segmentTypeId, String segmentTypeName) {
			super();
			this.segmentTypeId = segmentTypeId;
			this.segmentTypeName = segmentTypeName;
		}

		/**
		 * 
		 * @return segmentTypeId
		 */
		public Integer getSegmentTypeId() {
			return segmentTypeId;
		}

		/**
		 * 
		 * @param segmentTypeId
		 */
		public void setSegmentTypeId(Integer segmentTypeId) {
			this.segmentTypeId = segmentTypeId;
		}
        
		/**
		 * 
		 * @return segmentTypeName
		 */
		public String getSegmentTypeName() {
			return segmentTypeName;
		}

		
		/**
		 * 
		 * @param segmentTypeName
		 */
		public void setSegmentTypeName(String segmentTypeName) {
			this.segmentTypeName = segmentTypeName;
		}
		
		
		
		
}
