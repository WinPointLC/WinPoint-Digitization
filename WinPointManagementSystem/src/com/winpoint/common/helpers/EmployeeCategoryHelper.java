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
			String string = employeeCategoryObj.toString();
			newEmployeeCategoryArrayList.add(new EmployeeCategory(string.substring(1, string.length()-1)));
		}
		new EmployeeCategoryDao().createEmployeeCategoryList(newEmployeeCategoryArrayList);
	}
		
	public void deleteEmployeeCategory(Object deleteEmployeeCategoryList []) {
		ArrayList<Integer> deleteEmployeeCategoryArrayList = new ArrayList<Integer>();
		for(Object id: deleteEmployeeCategoryList) {
			deleteEmployeeCategoryArrayList.add(Integer.parseInt(id.toString()));
		}
		new EmployeeCategoryDao().deleteEmployeeCategoryList(deleteEmployeeCategoryArrayList);
	}
}
