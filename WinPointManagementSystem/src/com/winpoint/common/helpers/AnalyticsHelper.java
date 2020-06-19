package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Result;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.TestFeedback;
import com.winpoint.common.beans.TopicWisePerformance;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.dao.AnalyticsDao;
import com.winpoint.common.dao.ResultDao;
import com.winpoint.common.dao.StreamDao;
import com.winpoint.common.dao.TestFeedbackDao;
import com.winpoint.common.dao.UserProfileDao;

public class AnalyticsHelper {
	public ArrayList<TopicWisePerformance > getStudentTestAnalysis(int userId, int courseId){
		return new AnalyticsDao().getStudentTestAnalysis(userId, courseId);
	}
}
