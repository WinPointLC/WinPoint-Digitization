package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.dao.SecurityQuestionsDao;

public class SecurityQuestionsHelper {
	public List<SecurityQuestions> getSecurityQuestionsList(){
		return new SecurityQuestionsDao().getSecurityQuestionsList();
	}
	
	public void createSecurityQuestionsList(ArrayList<SecurityQuestions> newSecurityQuestionsArrayList) {
		 new SecurityQuestionsDao().createSecurityQuestionsList(newSecurityQuestionsArrayList);
	}
	
	public void deleteSecurityQuestionsList(ArrayList<Integer> deleteSecurityQuestionsArrayList) {
		 new SecurityQuestionsDao().deleteSecurityQuestionsList(deleteSecurityQuestionsArrayList);
	}

}
