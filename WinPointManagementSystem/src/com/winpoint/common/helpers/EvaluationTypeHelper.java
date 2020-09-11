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
			newEvaluationTypeArrayList.add(new EvaluationType(evaluationTypeObj.toString().substring(1, evaluationTypeObj.toString().length()-1)));
		}
		 new EvaluationTypeDao().createEvaluationTypeList(newEvaluationTypeArrayList);
	}
	
	public void deleteEvaluationType(ArrayList<Integer> deleteEvaluationTypeArrayList) {
		 new EvaluationTypeDao().deleteEvaluationTypeList(deleteEvaluationTypeArrayList);
	}

}
