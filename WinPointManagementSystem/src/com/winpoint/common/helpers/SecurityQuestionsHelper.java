package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.dao.SecurityQuestionsDao;

public class SecurityQuestionsHelper {
	public List<SecurityQuestions> getSecurityQuestionsList(){
		return new SecurityQuestionsDao().getSecurityQuestionsList();
	}
}
