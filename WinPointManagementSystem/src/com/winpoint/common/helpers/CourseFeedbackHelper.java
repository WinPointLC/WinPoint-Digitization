package com.winpoint.common.helpers;


import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.dao.CourseFeedbackDao;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.wrappers.BatchFeedbackScreenWrapper;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;

public class CourseFeedbackHelper {
	
	public List<CourseFeedback> getResponses(Integer userId,Integer courseId){
		return new CourseFeedbackDao().getResponses(userId, courseId);
	}
		
	public ArrayList<Float> getAverageResponses(Integer courseId){
		return new CourseFeedbackDao().getAverageResponses(courseId);
	}
	
	public BatchFeedbackScreenWrapper getFeedbackCount(Integer courseId) {
		return new CourseFeedbackDao().getFeedbackCount(courseId);
	}
	
	public void createUserCourseFeedback(CourseFeedback userCourseFeedback) {
		new CourseFeedbackDao().createUserCourseFeedback(userCourseFeedback);
	}

}
