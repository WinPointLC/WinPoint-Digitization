package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.StudentCategory;
import com.winpoint.common.util.sql.ConnectionManager;

public class StudentCategoryDao {

public List<StudentCategory> getStudentCategoryList(){
		
		List<StudentCategory> studentCategoryList = new ArrayList<>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
//				studentCategoryList.add();
			}
			
		}catch(SQLException e) {
			studentCategoryList = null;
			e.printStackTrace();
		}
	    
		return studentCategoryList;		
	}

	public void createStudentCategoryList(ArrayList<StudentCategory> newStudentCategoryArrayList) {
	
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(StudentCategory studentCategoryList: newStudentCategoryArrayList) {
			String query = "";
			statement.executeQuery(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	
	public void deleteStudentCategoryList(ArrayList<Integer> deleteStudentCategoryArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteStudentCategoryString = new StringBuilder();
			for(int courseId: deleteStudentCategoryArrayList) {
				deleteStudentCategoryString.append(courseId);
				deleteStudentCategoryString.append(',');
			}
			deleteStudentCategoryString.deleteCharAt(deleteStudentCategoryString.length()-1);
			String query ="";
			statement.executeQuery(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	
	}

}
