package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.dao.EmployeeCategoryDao;

public class EmployeeCategoryHelper {

	public List<EmployeeCategory> getEmployeeCategoryList(){
		return new EmployeeCategoryDao().getEmployeeCategoryList();
		
	}	
		
	public void createEmployeeCategory(Object newEmployeeCategoryList []) {
		ArrayList<EmployeeCategory>newEmployeeCategoryArrayList =new ArrayList<>();	
		for(Object employeeCategoryObj : newEmployeeCategoryList) {
			newEmployeeCategoryArrayList.add(new EmployeeCategory(employeeCategoryObj.toString().substring(1, employeeCategoryObj.toString().length()-1)));
		}
		new EmployeeCategoryDao().createEmployeeCategoryList(newEmployeeCategoryArrayList);
	}
		
	public void deleteEmployeeCategory(ArrayList<Integer> deleteEmployeeCategoryArrayList) {
		new EmployeeCategoryDao().deleteEmployeeCategoryList(deleteEmployeeCategoryArrayList);
	}
}
