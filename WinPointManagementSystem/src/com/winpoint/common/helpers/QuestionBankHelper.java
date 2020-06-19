package com.winpoint.common.helpers;

import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.dao.QuestionBankDao;
import com.winpoint.common.dao.StreamDao;

public class QuestionBankHelper {
	public List<QuestionBank> getQuestionsList(int testDetailId){
		return new QuestionBankDao().getQuestionsList(testDetailId);
	}
}
