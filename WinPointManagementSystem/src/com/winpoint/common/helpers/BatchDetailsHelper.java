package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.dao.BatchDetailsDao;
import com.winpoint.common.wrappers.BatchDetailsWrapper;
import com.winpoint.common.wrappers.LectureWrapper;



public class BatchDetailsHelper {
		
	public List<BatchDetails> getBatchDetailsList() {
		return new BatchDetailsDao().getBatchDetailsList();
	}
	public List<BatchDetails> getBatchDetailsList1() {
		return new BatchDetailsDao().getBatchDetailsList1();
	}
	
	public ArrayList<BatchDetailsWrapper> getWrapperListOfBatches(Integer courseId){
		return new BatchDetailsDao().getWrapperListOfBatches(courseId);
	}
	
	public void create(BatchDetails batchDetailsObject) throws SQLException {
		// TODO Auto-generated method stub
		new BatchDetailsDao().create(batchDetailsObject);
	}
	
	public LectureWrapper getBatchDetails(Integer batchId) {
		return new BatchDetailsDao().getBatchDetails(batchId);
	}
}


