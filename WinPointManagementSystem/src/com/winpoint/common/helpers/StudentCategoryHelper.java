package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.StudentCategory;
import com.winpoint.common.dao.StudentCategoryDao;

public class StudentCategoryHelper {
	public List<StudentCategory> getResponses(){
		return new StudentCategoryDao().getStudentCategoryList();
	}
	
	public void createStudentCategoryList(Object[] newStudentCategoryList) {
		ArrayList<StudentCategory> newStudentCategoryArrayList = new ArrayList<StudentCategory>();
		for(Object object: newStudentCategoryList) {
			String string = object.toString();
			newStudentCategoryArrayList.add(new StudentCategory(string.substring(1, string.length()-1)));
		}
		 new StudentCategoryDao().createStudentCategoryList(newStudentCategoryArrayList);
	}
	
	public void deleteStudentCategoryList(Object[] deleteStudentCategoryList) {
		ArrayList<Integer> deleteStudentCategoryArrayList = new ArrayList<Integer>();
		for(Object id: deleteStudentCategoryList) {
			deleteStudentCategoryArrayList.add(Integer.parseInt(id.toString()));
		}
		if(deleteStudentCategoryArrayList.size()!=0) {
		 new StudentCategoryDao().deleteStudentCategoryList(deleteStudentCategoryArrayList);
		}
	}

}
