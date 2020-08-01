package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.BatchDetailsDao;
import com.winpoint.common.dao.EnquiryDetailsDao;
import com.winpoint.common.wrappers.BatchDetailsWrapper;



public class BatchDetailsHelper {
		
	public List<BatchDetailsWrapper> getBatchDetailsList() {
		return new BatchDetailsDao().getBatchDetailsList();
	}
	public List<BatchDetails> getBatchDetailsList1() {
		return new BatchDetailsDao().getBatchDetailsList1();
	}
	
	public ArrayList<BatchDetailsWrapper> getWrapperListOfBatches(Integer courseId){
		return new BatchDetailsDao().getWrapperListOfBatches(courseId);
	}

	public BatchDetails getBatchDetails(Integer batchId) {
		return new BatchDetailsDao().getBatchDetails(batchId);
	}
	
	public BatchDetailsWrapper countNumberOfBatches(Integer courseId) {
		return new BatchDetailsDao().getcountNumberOfBatches(courseId);
	} 
	
	public void create(EnquiryDetails enquiryDetailsObject) throws SQLException {
		new EnquiryDetailsDao().create(enquiryDetailsObject);
	}
	
	public void create(BatchDetails batchDetails) throws SQLException {
		new BatchDetailsDao().create(batchDetails);
	}
	public boolean doBatchExist(Integer courseId, Integer timeSlotsId, Integer facultyUserId, Integer segmentTypeId) {
		return new BatchDetailsDao().doBatchExist(courseId,timeSlotsId,facultyUserId,segmentTypeId);
	}
	

}


