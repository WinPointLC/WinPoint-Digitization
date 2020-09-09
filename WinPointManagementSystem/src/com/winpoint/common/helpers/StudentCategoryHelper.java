package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.StudentCategory;
import com.winpoint.common.dao.StudentCategoryDao;

public class StudentCategoryHelper {
	public List<StudentCategory> getResponses(){
		return new StudentCategoryDao().getStudentCategoryList();
	}
}
