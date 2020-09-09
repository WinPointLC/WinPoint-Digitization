package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.TopicWisePerformance;
import com.winpoint.common.dao.AnalyticsDao;


public class AnalyticsHelper {
	public ArrayList<TopicWisePerformance > getStudentTestAnalysis(int userId, int courseId){
		return new AnalyticsDao().getStudentTestAnalysis(userId, courseId);
	}
}
