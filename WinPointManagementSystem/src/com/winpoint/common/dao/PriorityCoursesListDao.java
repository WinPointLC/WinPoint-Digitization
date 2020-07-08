package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.PriorityListOfCoursesWrapper;

public class PriorityCoursesListDao {

	public List<PriorityListOfCoursesWrapper> getPriorityCoursesList() {
		
		List<PriorityListOfCoursesWrapper>priorityCoursesList= new ArrayList<>();
		ResultSet resultSet=null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = " SELECT * FORM COURSES";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
			}
		}
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
		return priorityCoursesList;
		
	}
	
	
	public void preRequisite() {

			HashMap< Integer, ArrayList<String>>eligibilityList= new HashMap<>();
			ArrayList<String>eligibility;

		ResultSet resultSet=null;

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM COURSES";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				eligibility= new ArrayList<>();
				for(String s:resultSet.getString("PRE_REQUISITE").split(",")) {
					eligibility.add(s);
				}
				eligibilityList.put(resultSet.getInt("COURSE_ID"), eligibility);
			}
			for(int i:eligibilityList.keySet()) {
				System.out.println("---------------"+i+"------------------");
				for (String string : eligibilityList.get(i)) {
					System.out.println(string);
				}
			}
		
			
		}
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	
	public void registered() {
		ResultSet resultSet=null;
		
		HashMap<Integer, ArrayList<Integer>>studentCourses= new HashMap<>();
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM STUDENT_COURSE_DETAILS\n" + 
					"ORDER BY USER_ID,COURSE_ID";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				if(studentCourses.containsKey(resultSet.getInt("USER_ID"))==false){
					ArrayList<Integer>coursesDone=new ArrayList<>();
							coursesDone.add(resultSet.getInt("COURSE_ID"));
					studentCourses.put(resultSet.getInt("USER_ID"),coursesDone );
				}
				else {
					studentCourses.get(resultSet.getInt("USER_ID")).add(resultSet.getInt("COURSE_ID"));
				}
			}
			
			for (int i  : studentCourses.keySet()) {
				System.out.println("Student "+i);
				for(int k: studentCourses.get(i)) {
					System.out.println(k);
				}
				System.out.println("\n");
			}
		}
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}
}

