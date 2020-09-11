package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.EvaluationType;
import com.winpoint.common.dao.EvaluationTypeDao;

public class EvaluationTypeHelper {

	public List<EvaluationType> getEvaluationTypeList() {
		return new EvaluationTypeDao().getEvaluationTypeList();
	}
	//===============================================================================================
	
	
	
	
	public void createEvaluationType(Object newEvaluationTypeList []) {
		ArrayList<EvaluationType>newEvaluationTypeArrayList =new ArrayList<>();	
		for(Object evaluationTypeObj : newEvaluationTypeList) {
			String string = evaluationTypeObj.toString();
			newEvaluationTypeArrayList.add(new EvaluationType(string.substring(1, string.length()-1)));
		}
		 new EvaluationTypeDao().createEvaluationTypeList(newEvaluationTypeArrayList);
	}
	
	public void deleteEvaluationType(Object deleteEvaluationTypeList []) {
		ArrayList<Integer> deleteEvaluationTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteEvaluationTypeList) {
			deleteEvaluationTypeArrayList.add(Integer.parseInt(id.toString()));
		}
		 new EvaluationTypeDao().deleteEvaluationTypeList(deleteEvaluationTypeArrayList);
	}

}
