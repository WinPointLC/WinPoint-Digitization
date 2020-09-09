package com.winpoint.common.helpers;


import java.util.List;

import com.winpoint.common.beans.TestFeedback;
import com.winpoint.common.dao.TestFeedbackDao;

public class TestFeedbackHelper {
	public boolean insertTestFeedback(int userId, int courseId, List<TestFeedback> testFeedbackList){
		return new TestFeedbackDao().insertTestFeedback(userId, courseId, testFeedbackList);
	}
}
