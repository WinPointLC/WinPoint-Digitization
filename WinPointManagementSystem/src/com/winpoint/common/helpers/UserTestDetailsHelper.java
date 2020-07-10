package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.dao.UserTestDetailsDao;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;


public class UserTestDetailsHelper {
	public static List<EvaluationScreenWrapper> getEvaluationScreenWrapperDetails(Integer batchId) {
	return new UserTestDetailsDao().getEvaluationScreenWrapperDetails(batchId);
	}
}
