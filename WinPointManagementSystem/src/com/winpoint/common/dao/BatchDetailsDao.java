package com.winpoint.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;

public class BatchDetailsDao {
	
	public List<BatchDetails> getBatchDetailsList() {
		
		List<BatchDetails> batchDetailsList = new ArrayList<BatchDetails>();
				
		batchDetailsList.add(new BatchDetails(" 1 ",2));
		batchDetailsList.add(new BatchDetails(" 2 ",3));
		batchDetailsList.add(new BatchDetails(" 3 ",4));
		
		return batchDetailsList;

	}
}
