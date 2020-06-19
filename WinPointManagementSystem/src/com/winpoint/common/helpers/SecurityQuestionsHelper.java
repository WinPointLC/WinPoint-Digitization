package com.winpoint.common.helpers;

import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.dao.RulesDao;
import com.winpoint.common.dao.SecurityQuestionsDao;
import com.winpoint.common.dao.StreamDao;

public class SecurityQuestionsHelper {
	public List<SecurityQuestions> getSecurityQuestionsList(){
		return new SecurityQuestionsDao().getSecurityQuestionsList();
	}
}
