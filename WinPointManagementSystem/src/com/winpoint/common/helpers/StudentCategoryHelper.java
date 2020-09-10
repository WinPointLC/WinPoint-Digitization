package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.StudentCategory;
import com.winpoint.common.dao.StudentCategoryDao;

public class StudentCategoryHelper {
	public List<StudentCategory> getResponses(){
		return new StudentCategoryDao().getStudentCategoryList();
	}
	
	public void createStudentCategoryList(ArrayList<StudentCategory> newStudentCategoryArrayList) {
		 new StudentCategoryDao().createStudentCategoryList(newStudentCategoryArrayList);
	}
	
	public void deleteStudentCategoryList(ArrayList<Integer> deleteStudentCategoryArrayList) {
		 new StudentCategoryDao().deleteStudentCategoryList(deleteStudentCategoryArrayList);
	}

}
