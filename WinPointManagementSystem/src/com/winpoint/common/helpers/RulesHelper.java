package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.Rules;
import com.winpoint.common.dao.RulesDao;

public class RulesHelper {
	public List<Rules> getRulesList(int testDetailId){
		return new RulesDao().getRulesList(testDetailId);
	}
}
