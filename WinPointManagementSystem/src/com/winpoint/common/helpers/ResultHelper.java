package com.winpoint.common.helpers;


import java.util.List;

import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Result;

import com.winpoint.common.dao.ResultDao;
import com.winpoint.common.dao.UserTestDetailsDao;

public class ResultHelper {
	public boolean updateStudentTestResponses(int userId, List<QuestionBank> questionsList, Integer[] answersList, Integer[] isCorrectList, Result result){
		return new ResultDao().updateStudentTestResponses(userId, questionsList, answersList, isCorrectList, result);
		
	}
	
	public boolean updateUserTestDetails(int userId, List<QuestionBank> questionsList, Result result) {
		return new UserTestDetailsDao().updateUserTestDetails(userId, questionsList, result);
	}
}
