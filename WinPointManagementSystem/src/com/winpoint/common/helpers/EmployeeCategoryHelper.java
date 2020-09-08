package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.dao.EmployeeCategoryDao;

public class EmployeeCategoryHelper {

	public List<EmployeeCategory> getEmployeeCategory(){
		return new EmployeeCategoryDao().getEmployeeCategory();
		
	}
	
}
