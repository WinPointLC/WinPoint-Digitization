package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.DifficultyLevel;
import com.winpoint.common.dao.DifficultyLevelDao;

public class DifficultyLevelHelper {

	public List<DifficultyLevel> getDifficultyLevelList() {
		return new DifficultyLevelDao().getDifficultyLevelList();
	}

}
