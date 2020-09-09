package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.dao.QuestionBankDao;

public class QuestionBankHelper {
	public List<QuestionBank> getQuestionsList(int testDetailId){
		return new QuestionBankDao().getQuestionsList(testDetailId);
	}
}
