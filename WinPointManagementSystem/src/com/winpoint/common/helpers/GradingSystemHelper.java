package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.GradingSystem;
import com.winpoint.common.dao.GradingSystemDao;


public class GradingSystemHelper {	
	public List<GradingSystem> getGradingSystemList() {
		return new GradingSystemDao().getGradingSystemList();
	}
}
