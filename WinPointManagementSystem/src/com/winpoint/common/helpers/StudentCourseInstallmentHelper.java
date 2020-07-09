package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.dao.StudentCourseInstallmentDetailsDao;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

public class StudentCourseInstallmentHelper {
	public ArrayList<FeeRecordsScreenWrapper> getFeeRecordsScreenWrapperList(Integer batchId) {
		return new StudentCourseInstallmentDetailsDao().getFeeRecordsScreenWrapperList(batchId);
	}
}
