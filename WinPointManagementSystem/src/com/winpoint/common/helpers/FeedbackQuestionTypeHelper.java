package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.FeedbackQuestionType;
import com.winpoint.common.dao.FeedbackQuestionTypeDao;

public class FeedbackQuestionTypeHelper {

	public List<FeedbackQuestionType> getFeedbackQuestionTypeList() {
		return new FeedbackQuestionTypeDao().getFeedbackQuestionTypeList();
	}

	


	
	public void createFeedbackQuestionType(Object newFeedbackQuestionTypeList []) {
		ArrayList<FeedbackQuestionType>newFeedbackQuestionTypeArrayList =new ArrayList<>();	
		for(Object feedbackQuestionTypeObj : newFeedbackQuestionTypeList) {
			newFeedbackQuestionTypeArrayList.add(new FeedbackQuestionType(feedbackQuestionTypeObj.toString().substring(1, feedbackQuestionTypeObj.toString().length()-1)));
		}
		 new FeedbackQuestionTypeDao().createFeedbackQuestionTypeList(newFeedbackQuestionTypeArrayList);
	}
	
	public void deleteFeedbackQuestionType(ArrayList<Integer> deleteFeedbackQuestionTypeArrayList) {
		 new FeedbackQuestionTypeDao().deleteFeedbackQuestionTypeList(deleteFeedbackQuestionTypeArrayList);
	}

	
}
