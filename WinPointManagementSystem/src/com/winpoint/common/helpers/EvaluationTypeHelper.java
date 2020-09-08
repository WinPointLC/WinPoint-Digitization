package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.EvaluationType;
import com.winpoint.common.dao.EvaluationTypeDao;

public class EvaluationTypeHelper {

	public List<EvaluationType> getEvaluationTypeList() {
		return new EvaluationTypeDao().getEvaluationTypeList();
	}

	
}
