package com.winpoint.common.helpers;

import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.dao.QuestionBankDao;

public class AddQuestionHelper {

	public void createQuestion(QuestionBank questionObj) {
		new QuestionBankDao().createQuestion(questionObj);
	}
}
