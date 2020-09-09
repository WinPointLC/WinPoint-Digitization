package com.winpoint.common.helpers;

import java.util.ArrayList;


import com.winpoint.common.beans.FeedbackQuestions;

import com.winpoint.common.dao.FeedbackQuestionsDao;


public class FeedbackQuestionsHelper {
	public ArrayList<FeedbackQuestions> getFeedbackQuestionsList(int feedbackQuestionCategoryId){
		return new FeedbackQuestionsDao().getFeedbackQuestions(feedbackQuestionCategoryId);
	}
	
	public ArrayList<FeedbackQuestions> getResponsesQuestion(Integer feedbackCategoryId){
		return new FeedbackQuestionsDao().getResponsesQuestion(feedbackCategoryId);
	}
}
