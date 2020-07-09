package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.dao.BatchDetailsDao;


public class BatchDetailsHelper {
		
	public List<BatchDetails> getBatchDetailsList() {
		return new BatchDetailsDao().getBatchDetailsList();
	}
	public List<BatchDetails> getBatchDetailsList1() {
		return new BatchDetailsDao().getBatchDetailsList1();
	}
}


