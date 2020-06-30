package com.winpoint.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;

public class BatchDetailsDao {
	
	public List<BatchDetails> getBatchDetailsList() {
		
		List<BatchDetails> batchDetailsList = new ArrayList<BatchDetails>();
						
		return batchDetailsList;

	}
	
public ArrayList<BatchDetails> getBatchInstructorList() {
		
		ArrayList<BatchDetails> getBatchInstructorList = new ArrayList<BatchDetails>();
				
		getBatchInstructorList.add(new BatchDetails(2));
		getBatchInstructorList.add(new BatchDetails(3));
		getBatchInstructorList.add(new BatchDetails(4));
		
		return  getBatchInstructorList;
		

	}
	
	
}
