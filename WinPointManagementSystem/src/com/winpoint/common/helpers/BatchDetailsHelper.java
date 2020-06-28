package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.dao.BatchDetailsDao;


public class BatchDetailsHelper {
		
	public List<BatchDetails> getBatchDetailsList() {
		return new BatchDetailsDao().getBatchDetailsList();
	}
	
}
