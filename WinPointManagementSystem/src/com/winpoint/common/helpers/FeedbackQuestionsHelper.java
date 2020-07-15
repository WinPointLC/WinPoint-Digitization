package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.FeedbackQuestions;
import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.dao.FeedbackQuestionsDao;
import com.winpoint.common.dao.QuestionBankDao;
import com.winpoint.common.dao.StreamDao;

public class FeedbackQuestionsHelper {
	public ArrayList<FeedbackQuestions> getFeedbackQuestions(){
		return new FeedbackQuestionsDao().getFeedbackQuestions();
	}
	
	public ArrayList<FeedbackQuestions> getResponsesQuestion(Integer feedbackCategoryId){
		return new FeedbackQuestionsDao().getResponsesQuestion(feedbackCategoryId);
	}
}
