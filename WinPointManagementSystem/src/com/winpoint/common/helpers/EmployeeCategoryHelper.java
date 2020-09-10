package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.dao.EmployeeCategoryDao;

public class EmployeeCategoryHelper {

	public List<EmployeeCategory> getEmployeeCategoryList(){
		return new EmployeeCategoryDao().getEmployeeCategoryList();
		
	}	
		
	public void createEmployeeCategory(ArrayList<EmployeeCategory> newEmployeeCategoryList) {
		new EmployeeCategoryDao().createEmployeeCategoryList(newEmployeeCategoryList);
	}
		
	public void deleteEmployeeCategory(ArrayList<Integer> deleteEmployeeCategoryArrayList) {
		new EmployeeCategoryDao().deleteEmployeeCategoryList(deleteEmployeeCategoryArrayList);
	}
}
