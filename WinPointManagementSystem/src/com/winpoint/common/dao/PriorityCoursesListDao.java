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
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class PriorityCoursesListDao {

	
	
	private HashMap< Course, HashSet<String>> getCoursePreRequisites() {

		HashMap< Course, HashSet<String>>coursesList= new HashMap<>();
		HashSet<String>coursesPre;

	ResultSet resultSet=null;

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "SELECT COURSE_ID,COURSE_NAME,FEES,PRE_REQUISITE,STREAM_ID,COURSE_TYPE_ID FROM COURSES";
		resultSet = statement.executeQuery(query);
//		LIST
		while(resultSet.next()) {
			coursesPre= new HashSet<>();
			for(String s:resultSet.getString("PRE_REQUISITE").split(",")) {
				coursesPre.add(s);
			}
			coursesList.put(new Course(resultSet.getInt("COURSE_ID"), resultSet.getString("COURSE_NAME"), resultSet.getInt("FEES"), resultSet.getInt("STREAM_ID"), resultSet.getInt("COURSE_TYPE_ID")), coursesPre);
		}
//		for(int i:coursesList.keySet()) {
//			System.out.println("Course ID: "+i);
//			for (String string : coursesList.get(i)) {
//				System.out.println(string);
//			}
//			System.out.println("\n\n");
//		}
		
	}
	
	catch (SQLServerException e) {
		e.printStackTrace();
	} 
	catch (SQLException e1) {
		e1.printStackTrace();
	} 
	return coursesList;
	}
	
	
	
	private HashMap<Integer, UserCoursesDoneWrapper> getActiveStudentsList() {

		HashMap< Integer, UserCoursesDoneWrapper>coursesDoneMap= new HashMap<>();
		HashSet<String>coursesDone;
		int userID;

	ResultSet resultSet=null;

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "SELECT USER_ID,FIRST_NAME,LAST_NAME,COURSE_ALREADY_DONE,USER_ID,MOBILE_NUMBER,TIME_SLOTS_IDS,\n"+
				"EMAIL_ID,USER_CATEGORY_ID FROM USER_PROFILE\n" +
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
		
			UserProfile userProfile=new UserProfile(resultSet.getInt("USER_ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), 
					resultSet.getString("EMAIL_ID"), resultSet.getString("MOBILE_NUMBER"), resultSet.getInt("USER_CATEGORY_ID"), resultSet.getInt("TIME_SLOTS_IDS"));
			coursesDoneMap.put(resultSet.getInt("USER_ID"),new UserCoursesDoneWrapper(userProfile, coursesDone));
			
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
			 
//			 
			 
				 coursesDoneMap.get(userID).getCoursesDoneSet().add(Integer.toString(resultSet.getInt("COURSE_ID")));
				 
		 }
		
		 
		 
//		for(int i:coursesDoneMap.keySet()) {
//			System.out.println("Student ID: "+i+"\nCourses Already Done:");
//			for (String string : coursesDoneMap.get(i).getCoursesDoneSet()) {
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
	
	return coursesDoneMap;
}

	
	private HashMap< Integer,UserCoursesDoneWrapper> getTimeSlotDepependentStudentList(int timeSlotId) {

		HashMap< Integer, UserCoursesDoneWrapper>coursesDoneList= new HashMap<>();
		HashSet<String>coursesDone;
		int userID;

	ResultSet resultSet=null;

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "SELECT USER_ID,FIRST_NAME,LAST_NAME,COURSE_ALREADY_DONE,USER_ID,MOBILE_NUMBER,TIME_SLOTS_IDS,\n"+
				"EMAIL_ID,USER_CATEGORY_ID FROM USER_PROFILE\n" + 
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
				coursesDoneList.put(resultSet.getInt("USER_ID"),new UserCoursesDoneWrapper(new UserProfile(resultSet.getInt("USER_ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), 
						resultSet.getString("EMAIL_ID"), resultSet.getString("MOBILE_NUMBER"), resultSet.getInt("USER_CATEGORY_ID"), resultSet.getInt("TIME_SLOTS_IDS")), coursesDone));
			}
		
			for(Integer string : coursesDoneList.keySet()) {
				System.out.println(coursesDoneList.get(string).getUserProfile().getFirstName());
			}
		 	query = null;
		 	resultSet = null;
		 
		 	query = "SELECT A.USER_ID,B.COURSE_ID \n" + 
		 			"		 		FROM USER_PROFILE A\n" + 
		 			"		 		INNER JOIN STUDENT_COURSE_DETAILS B \n" + 
		 			"		 		ON A.USER_ID=B.USER_ID\n" + 
		 			"		 		WHERE A.ACTIVE_STATUS = 1\n" + 
		 			"		 		AND A.TIME_SLOTS_IDS="+timeSlotId +" AND\n"+ 
		 			"		 		A.USER_CATEGORY_ID=1 ORDER BY A.USER_ID,B.COURSE_ID";
		 
		
		 	resultSet = statement.executeQuery(query);
		 
		 	while(resultSet.next()) {
			 	userID = resultSet.getInt("USER_ID");
				 	coursesDoneList.get(userID).getCoursesDoneSet().add(Integer.toString(resultSet.getInt("COURSE_ID")));
				
		 	}	
		
//		 	for (Integer string : coursesDoneList.keySet()) {
//					System.out.println(coursesDoneList.get(string).getUserProfile().getFirstName());
//				}
//		 
//			for(int i:coursesDoneList.keySet()) {
//				System.out.println("Student ID: "+i+"\nCourses PRE REQ:");
//				for (String string : coursesDoneList.get(i).getCoursesDoneSet()) {
//					System.out.println(string);
//				}
//				System.out.println("\n");
//			}	
		}
	
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	
		return coursesDoneList;
	}
	
	
	public HashMap<Course, ArrayList<UserCoursesDoneWrapper>> coursesStudent() {
		HashMap< Course, HashSet<String>>courseList=new PriorityCoursesListDao().getCoursePreRequisites();
		HashMap<Integer, UserCoursesDoneWrapper> studentsList = new PriorityCoursesListDao().getActiveStudentsList();
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>>coursesStudentsEligibleMap = new HashMap<>();
		
		for(Course i:courseList.keySet()) {
			coursesStudentsEligibleMap.put(i,new ArrayList<>());
			for(int j:studentsList.keySet()) {
				if((!(studentsList.get(j).getCoursesDoneSet().contains(Integer.toString(i.getCourseId()))) && 
						studentsList.get(j).getCoursesDoneSet().containsAll(courseList.get(i))) || 
						(courseList.get(i).contains("0") && !studentsList.get(j).getCoursesDoneSet().contains(Integer.toString(i.getCourseId())))){
					
					ArrayList<UserCoursesDoneWrapper>user=coursesStudentsEligibleMap.get(i);
					user.add(studentsList.get(j));
					coursesStudentsEligibleMap.put(i,user);
				}
			}
		}
		return coursesStudentsEligibleMap;
	}
}


//for(Course k:count.keySet()) {
//	System.out.println(k.getCourseName()+"\n");
//	for (UserCoursesDoneWrapper string : count.get(k)) {
//		System.out.println(string.getUserProfile().getFirstName());
//	}
//	System.out.println("\n\n\n");
//}
	