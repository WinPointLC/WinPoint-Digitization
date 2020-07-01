package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.dao.BatchDetailsDao;


public class BatchDetailsHelper {
		
	public List<BatchDetails> getBatchDetailsList() {
		return new BatchDetailsDao().getBatchDetailsList();
	}


	public ArrayList<BatchDetails> getBatchInstructorList() {
		return (ArrayList<BatchDetails>) new BatchDetailsDao().getBatchInstructorList();
		
	}
	
}


