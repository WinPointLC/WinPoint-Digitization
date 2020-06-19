package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.TestFeedback;
import com.winpoint.common.dao.StreamDao;
import com.winpoint.common.dao.TestFeedbackDao;

public class TestFeedbackHelper {
	public boolean insertTestFeedback(int userId, int courseId, List<TestFeedback> testFeedbackList){
		return new TestFeedbackDao().insertTestFeedback(userId, courseId, testFeedbackList);
	}
}
