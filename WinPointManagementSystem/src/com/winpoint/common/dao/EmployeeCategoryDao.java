package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.EmployeeCategory;
import com.winpoint.common.util.sql.ConnectionManager;

public class EmployeeCategoryDao {

	public List<EmployeeCategory> getEmployeeCategoryList(){
		
		List<EmployeeCategory> employeeCategoryList = new ArrayList<EmployeeCategory>();
	
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
		
			String query = "\n" + 
					"SELECT EMPLOYEE_CATEGORY_ID, EMPLOYEE_CATEGORY_NAME FROM EMPLOYEE_CATEGORY";
		
			ResultSet rs = statement.executeQuery(query);
		
			while(rs.next()) {
				employeeCategoryList.add(new EmployeeCategory(rs.getInt("EMPLOYEE_CATEGORY_ID"), rs.getString("EMPLOYEE_CATEGORY_NAME")));
			}
		
		}catch(SQLException e) {
			employeeCategoryList = null;
			e.printStackTrace();
		}
	
		return employeeCategoryList;
	
	}
	
	//===============================================================================================

	public void createEmployeeCategoryList(ArrayList<EmployeeCategory> newEmployeeCategoryList) {
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
		
			for(EmployeeCategory EmployeeCategoryList: newEmployeeCategoryList) {
			String query = "INSERT INTO EMPLOYEE_CATEGORY VALUES ('"+EmployeeCategoryList.getEmployeeCategoryName()+"',NULL,NULL)";
			statement.executeUpdate(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void deleteEmployeeCategoryList(ArrayList<Integer> deleteEmployeeCategoryArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteEmployeeCategoryString = new StringBuilder();
			for(int EmployeeCategoryId: deleteEmployeeCategoryArrayList) {
				deleteEmployeeCategoryString.append(EmployeeCategoryId);
				deleteEmployeeCategoryString.append(',');
			}
			deleteEmployeeCategoryString.deleteCharAt(deleteEmployeeCategoryString.length()-1);
			String query ="DELETE FROM EMPLOYEE_CATEGORY \n" +  
					"WHERE EMPLOYEE_CATEGORY_ID IN ("+ deleteEmployeeCategoryString.toString() +")";
			statement.executeUpdate(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	
	
	
	

	
}
