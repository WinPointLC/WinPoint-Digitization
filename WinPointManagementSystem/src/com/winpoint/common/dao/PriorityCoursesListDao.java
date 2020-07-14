package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import com.winpoint.common.util.sql.ConnectionManager;

public class PriorityCoursesListDao {

	
	
	public HashMap< Integer, HashSet<String>> getCoursePreRequisites() {

			HashMap< Integer, HashSet<String>>coursesList= new HashMap<>();
			HashSet<String>coursesPre;

		ResultSet resultSet=null;

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "SELECT COURSE_ID, COURSE_NAME,FEES,PRE_REQUISITE FROM COURSES";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				coursesPre= new HashSet<>();
				for(String s:resultSet.getString("PRE_REQUISITE").split(",")) {
					coursesPre.add(s);
				}
				coursesPre.add(" ");
				coursesList.put(resultSet.getInt("COURSE_ID"), coursesPre);
			}
//			for(int i:coursesList.keySet()) {
//				System.out.println("Course ID: "+i);
//				for (String string : coursesList.get(i)) {
//					System.out.println(string);
//				}
//				System.out.println("\n\n");
//			}
			
		}
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return coursesList;
	}
	
	
	
	public HashMap< Integer, HashSet<String>> getActiveStudentsList() {

		HashMap< Integer, HashSet<String>>coursesDoneList= new HashMap<>();
		HashSet<String>coursesDone;
		int userID;

	ResultSet resultSet=null;

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "SELECT USER_ID,COURSE_ALREADY_DONE FROM USER_PROFILE\n" + 
				"WHERE ACTIVE_STATUS = 1\n" + 
				"AND USER_CATEGORY_ID=1";
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			coursesDone = new HashSet<>();
			String coursesAlreadyDone = resultSet.getString("COURSE_ALREADY_DONE");
		if(coursesAlreadyDone != null) {
			for(String s:coursesAlreadyDone.split(",")) {
				coursesDone.add(s);
			}
		}
			coursesDoneList.put(resultSet.getInt("USER_ID"), coursesDone);
		}
		
		 query = null;
		 resultSet = null;
		 
		 query = "SELECT A.USER_ID,B.COURSE_ID \n" + 
		 		"		 		FROM USER_PROFILE A\n" + 
		 		"		 		INNER JOIN STUDENT_COURSE_DETAILS B \n" + 
		 		"		 		ON A.USER_ID=B.USER_ID\n" + 
		 		"		 		WHERE A.ACTIVE_STATUS = 1\n" + 
		 		"		 		AND \n" + 
		 		"		 		A.USER_CATEGORY_ID=1";
		
		 resultSet = statement.executeQuery(query);
		 
		 while(resultSet.next()) {
			 userID = resultSet.getInt("USER_ID");
				 coursesDoneList.get(userID).add(Integer.toString(resultSet.getInt("COURSE_ID")));
				 
//				 System.out.println(resultSet.getString("FIRST_NAME")+" "+resultSet.getString("LAST_NAME")+" "+resultSet.getInt("USER_ID")+" "+Integer.toString(resultSet.getInt("COURSE_ID")));
		 }
		
		 
		 
//		for(int i:coursesDoneList.keySet()) {
//			System.out.println("Student ID: "+i+"\nCourses PRE REQ:");
//			for (String string : coursesDoneList.get(i)) {
//				System.out.println(string);
//			}
//			System.out.println("\n");
//		}	
	}
	
	catch (SQLServerException e) {
		e.printStackTrace();
	} 
	catch (SQLException e1) {
		e1.printStackTrace();
	} 
	
	return coursesDoneList;
}

	
	public HashMap< Integer, HashSet<String>> getTimeSlotDepependentStudentList(int timeSlotId) {

		HashMap< Integer, HashSet<String>>coursesDoneList= new HashMap<>();
		HashSet<String>coursesDone;
		int userID;

	ResultSet resultSet=null;

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "SELECT USER_ID,COURSE_ALREADY_DONE FROM USER_PROFILE\n" + 
				"WHERE ACTIVE_STATUS = 1\n" + 
				"AND USER_CATEGORY_ID=1\n"
				+ "AND TIME_SLOTS_IDS="+timeSlotId;
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			coursesDone = new HashSet<>();
			String coursesAlreadyDone = resultSet.getString("COURSE_ALREADY_DONE");
		if(coursesAlreadyDone != null) {
			for(String s:coursesAlreadyDone.split(",")) {
				coursesDone.add(s);
			}
		}
			coursesDoneList.put(resultSet.getInt("USER_ID"), coursesDone);
		}
		
		 query = null;
		 resultSet = null;
		 
		 query = "SELECT A.USER_ID,B.COURSE_ID \n" + 
		 		"		 		FROM USER_PROFILE A\n" + 
		 		"		 		INNER JOIN STUDENT_COURSE_DETAILS B \n" + 
		 		"		 		ON A.USER_ID=B.USER_ID\n" + 
		 		"		 		WHERE A.ACTIVE_STATUS = 1\n" + 
		 		"		 		AND \n" + 
		 		"		 		A.USER_CATEGORY_ID=1 ORDER BY A.USER_ID,B.COURSE_ID";
		
		 resultSet = statement.executeQuery(query);
		 
		 while(resultSet.next()) {
			 userID = resultSet.getInt("USER_ID");
				 coursesDoneList.get(userID).add(Integer.toString(resultSet.getInt("COURSE_ID")));
				 
//				 System.out.println(resultSet.getString("FIRST_NAME")+" "+resultSet.getString("LAST_NAME")+" "+resultSet.getInt("USER_ID")+" "+Integer.toString(resultSet.getInt("COURSE_ID")));
		 }
		
		 
		 
//		for(int i:coursesDoneList.keySet()) {
//			System.out.println("Student ID: "+i+"\nCourses PRE REQ:");
//			for (String string : coursesDoneList.get(i)) {
//				System.out.println(string);
//			}
//			System.out.println("\n");
//		}	
	}
	
	catch (SQLServerException e) {
		e.printStackTrace();
	} 
	catch (SQLException e1) {
		e1.printStackTrace();
	} 
	
	return coursesDoneList;
}
	
	
	
	
//	public HashMap<Integer, HashSet<Integer>> registered() {
//	ResultSet resultSet=null;
//	
//	HashMap<Integer, HashSet<Integer>>studentCourses= new HashMap<>();
//	try(Connection connection = ConnectionManager.getConnection()){
//		
//		Statement statement = connection.createStatement();
//		
//		String query = "SELECT * FROM STUDENT_COURSE_DETAILS\n" + 
//				"ORDER BY USER_ID,COURSE_ID";
//		
//		resultSet = statement.executeQuery(query);
//		
//		while(resultSet.next()) {
//			if(!studentCourses.containsKey(resultSet.getInt("USER_ID"))){
//				HashSet<Integer>coursesDone=new HashSet<>();
//				coursesDone.add(resultSet.getInt("COURSE_ID"));
//				studentCourses.put(resultSet.getInt("USER_ID"),coursesDone );
//			}	
//			else {
//				studentCourses.get(resultSet.getInt("USER_ID")).add(resultSet.getInt("COURSE_ID"));
//			}
//		}	
//		for (int i  : studentCourses.keySet()) {
//			System.out.println("Student "+i);
//			for(int k: studentCourses.get(i)) {
//				System.out.println(k);
//			}
//			System.out.println("\n");
//		}
//	}
//	
//	catch (SQLServerException e) {
//		e.printStackTrace();
//	} 
//	catch (SQLException e1) {
//		e1.printStackTrace();
//	}
//	return studentCourses;
//}
	
	
	
	
	
//	public List<PriorityListOfCoursesWrapper> getPriorityCoursesList() {
//	
//	List<PriorityListOfCoursesWrapper>priorityCoursesList= new ArrayList<>();
//	ResultSet resultSet=null;
//	
//	try(Connection connection = ConnectionManager.getConnection()){
//		Statement statement = connection.createStatement();
//		String query = " SELECT * FORM COURSES";
//		resultSet = statement.executeQuery(query);
//		
//		while(resultSet.next()) {
//			
//		}
//	}
//	
//	catch (SQLServerException e) {
//		e.printStackTrace();
//	} 
//	catch (SQLException e1) {
//		e1.printStackTrace();
//	} 
//	
//	return priorityCoursesList;
//	
//}

	
}

