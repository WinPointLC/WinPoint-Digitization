package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.dao.EmployeeCategoryDao;

public class EmployeeCategoryHelper {

	public List<EmployeeCategory> getEmployeeCategoryList(){
		return new EmployeeCategoryDao().getEmployeeCategoryList();
		
	}
	
}
