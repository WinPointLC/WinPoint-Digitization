package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.dao.SecurityQuestionsDao;

public class SecurityQuestionsHelper {
	public List<SecurityQuestions> getSecurityQuestionsList(){
		return new SecurityQuestionsDao().getSecurityQuestionsList();
	}
	
	public void createSecurityQuestionsList(Object[] newSecurityQuestionsList) {
		ArrayList<SecurityQuestions> newSecurityQuestionsArrayList =new ArrayList<>();
		for(Object object : newSecurityQuestionsList) {
			String string = object.toString();
			newSecurityQuestionsArrayList.add(new SecurityQuestions(string.substring(1, string.length()-1)));
		}
		 new SecurityQuestionsDao().createSecurityQuestionsList(newSecurityQuestionsArrayList);
	}
	
	public void deleteSecurityQuestionsList(Object[] deleteSecurityQuestionsList) {
		ArrayList<Integer> deleteSecurityQuestionsArrayList = new ArrayList<Integer>();
		for(Object id: deleteSecurityQuestionsList) {
			deleteSecurityQuestionsArrayList.add(Integer.parseInt(id.toString()));
		}

		 new SecurityQuestionsDao().deleteSecurityQuestionsList(deleteSecurityQuestionsArrayList);
	}

}
