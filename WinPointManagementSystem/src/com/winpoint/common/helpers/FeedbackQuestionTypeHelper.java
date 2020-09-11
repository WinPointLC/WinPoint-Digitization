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
			String string = feedbackQuestionTypeObj.toString();
			newFeedbackQuestionTypeArrayList.add(new FeedbackQuestionType(string.substring(1, string.length()-1)));
		}
		 new FeedbackQuestionTypeDao().createFeedbackQuestionTypeList(newFeedbackQuestionTypeArrayList);
	}
	
	public void deleteFeedbackQuestionType(ArrayList<Integer> deleteFeedbackQuestionTypeList) {
		ArrayList<Integer> deleteFeedbackQuestionTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteFeedbackQuestionTypeList) {
			deleteFeedbackQuestionTypeArrayList.add(Integer.parseInt(id.toString()));
		}	
		 new FeedbackQuestionTypeDao().deleteFeedbackQuestionTypeList(deleteFeedbackQuestionTypeArrayList);
	}

	
}
