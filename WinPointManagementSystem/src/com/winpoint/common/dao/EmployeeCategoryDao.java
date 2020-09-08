package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.util.sql.ConnectionManager;

public class EmployeeCategoryDao {

	public List<EmployeeCategory> getEmployeeCategory(){
		
		List<EmployeeCategory> EmployeeCategoryList = new ArrayList<EmployeeCategory>();
	
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
		
			String query = "\n" + 
					"SELECT EMPLOYEE_CATEGORY_ID, EMPLOYEE_CATEGORY_NAME FROM EMPLOYEE_CATEGORY";
		
			ResultSet rs = statement.executeQuery(query);
		
			while(rs.next()) {
				EmployeeCategoryList.add(new EmployeeCategory(rs.getInt("EMPLOYEE_CATEGORY_ID"), rs.getString("EMPLOYEE_CATEGORY_NAME")));
			}
		
		}catch(SQLException e) {
			EmployeeCategoryList = null;
			e.printStackTrace();
		}
	
		return EmployeeCategoryList;
	
	}

	
}
