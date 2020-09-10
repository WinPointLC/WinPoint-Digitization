package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.DifficultyLevel;
import com.winpoint.common.dao.DifficultyLevelDao;

public class DifficultyLevelHelper {
	
	
	public List<DifficultyLevel> getDifficultyLevelList() {
		return new DifficultyLevelDao().getDifficultyLevelList();
	}
	
	
	//===============================================================================================

	
	public void createDifficultyLevel(ArrayList<DifficultyLevel> newDifficultyLevelArrayList) {
		 new DifficultyLevelDao().createDifficultyLevelList(newDifficultyLevelArrayList);
	}
	
	public void deleteDifficultyLevel(ArrayList<Integer> deleteDifficultyLevelArrayList) {
		 new DifficultyLevelDao().deleteDifficultyLevelList(deleteDifficultyLevelArrayList);
	}

}
