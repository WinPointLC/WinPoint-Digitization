package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.dao.CourseFeedbackDao;



public class CourseFeedbackHelper {
	
	public List<CourseFeedback> getResponses(){
		return new CourseFeedbackDao().getResponses();
	}
	

}
