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

	
	public void createDifficultyLevel(Object newDifficultyLevelList []) {
		ArrayList<DifficultyLevel>newDifficultyLevelArrayList =new ArrayList<>();	
		for(Object difficultyLevelObj : newDifficultyLevelList) {
			newDifficultyLevelArrayList.add(new DifficultyLevel(difficultyLevelObj.toString().substring(1, difficultyLevelObj.toString().length()-1)));
		}
		 new DifficultyLevelDao().createDifficultyLevelList(newDifficultyLevelArrayList);
	}
	
	public void deleteDifficultyLevel(ArrayList<Integer> deleteDifficultyLevelArrayList) {
		 new DifficultyLevelDao().deleteDifficultyLevelList(deleteDifficultyLevelArrayList);
	}

}
