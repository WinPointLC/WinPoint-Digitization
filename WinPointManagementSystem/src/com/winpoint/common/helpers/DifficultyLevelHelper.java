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

	
	public void createDifficultyLevelList(Object newDifficultyLevelList []) {
		ArrayList<DifficultyLevel>newDifficultyLevelArrayList =new ArrayList<>();	
		for(Object difficultyLevelObj : newDifficultyLevelList) {
			String string = difficultyLevelObj.toString();
			newDifficultyLevelArrayList.add(new DifficultyLevel(string.substring(1, string.length()-1)));
		}
		 new DifficultyLevelDao().createDifficultyLevelList(newDifficultyLevelArrayList);
	}
	
	public void deleteDifficultyLevelList(Object deleteDifficultyLevelList []) {
			ArrayList<Integer> deleteDifficultyLevelArrayList = new ArrayList<Integer>();
			for(Object id: deleteDifficultyLevelList) {
				deleteDifficultyLevelArrayList.add(Integer.parseInt(id.toString()));
				if(deleteDifficultyLevelList.length!=0) {
				 new DifficultyLevelDao().deleteDifficultyLevelList(deleteDifficultyLevelArrayList);
				}
			}
		}
}
