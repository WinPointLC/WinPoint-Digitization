package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.EnquiredStudetnsCourseWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class PriorityCoursesListDao {
	
	
	
	private HashMap< Course, HashSet<String>> getCoursePreRequisites() {

	HashMap< Course, HashSet<String>>coursesList= new HashMap<>();
	HashSet<String>coursesPre;

	ResultSet resultSet=null;
	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "\n" + 
				"SELECT COURSE_ID,COURSE_NAME,FEES,PRE_REQUISITE,STREAM_ID,COURSE_TYPE_ID,DURATION FROM COURSES"; //to add faculty id
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			coursesPre= new HashSet<>();
			for(String s:resultSet.getString("PRE_REQUISITE").split(",")) {
				coursesPre.add(s);
			}
			coursesList.put(new Course(resultSet.getInt("COURSE_ID"), resultSet.getString("COURSE_NAME"),
					resultSet.getInt("FEES"), resultSet.getInt("STREAM_ID"), resultSet.getInt("COURSE_TYPE_ID"),
					resultSet.getInt("DURATION")), coursesPre);
		}		
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
		String query = "SELECT USER_ID,FIRST_NAME,LAST_NAME,COURSE_ALREADY_DONE,USER_ID,MOBILE_NUMBER,TIME_SLOTS_IDS,\n" + 
				"				EMAIL_ID,USER_CATEGORY_ID, SEGMENT_TYPE_ID FROM USER_PROFILE\n" + 
				"				WHERE ACTIVE_STATUS = 1\n" + 
				"				AND USER_CATEGORY_ID=1\n" + 
				"				";
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
					resultSet.getString("EMAIL_ID"), resultSet.getString("MOBILE_NUMBER"), resultSet.getInt("USER_CATEGORY_ID"),
					resultSet.getString("TIME_SLOTS_IDS"),resultSet.getInt("SEGMENT_TYPE_ID"));
			
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
			 String courseId = Integer.toString(resultSet.getInt("COURSE_ID"));
			 (coursesDoneMap.get(userID).getCoursesDoneSet()).add(courseId);
			 }	
	}
	
	catch (SQLServerException e) {
		e.printStackTrace();
	} 
	catch (SQLException e1) {
		e1.printStackTrace();
	} 
	
	return coursesDoneMap;
}
	
	
	public HashMap<EnquiryDetails, EnquiredStudetnsCourseWrapper> getEligibleEnquiryDetails() {
		HashMap<EnquiryDetails, EnquiredStudetnsCourseWrapper>EnquiredStudentsCoursesMap = new HashMap<>();
		
		ResultSet resultSet=null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "SELECT ENQUIRY_ID,FIRST_NAME,LAST_NAME,EMAIL_ID,MOBILE_NO,\n" + 
					"ELIGIBILITY,COURSE_INTERESTED_IN,TIME_SLOTS_ID,COURSE_ALREADY_DONE,\n" + 
					" SEGMENT_TYPE_ID FROM ENQUIRY_DETAILS\n" + 
					"WHERE ACTIVE_STATUS = 1";
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			boolean eligibility=resultSet.getInt("ELIGIBILITY")==0?true:false;
				
				
			EnquiryDetails en = new EnquiryDetails(resultSet.getInt("ENQUIRY_ID"),resultSet.getString("FIRST_NAME"),
					resultSet.getString("LAST_NAME"),resultSet.getString("EMAIL_ID"),resultSet.getString("MOBILE_NO"),
					eligibility,resultSet.getString("COURSE_INTERESTED_IN"),resultSet.getString("TIME_SLOTS_ID"),
					resultSet.getString("COURSE_ALREADY_DONE"),resultSet.getInt("SEGMENT_TYPE_ID"));
				HashSet<String>coursesDone = new HashSet<>();
				HashSet<String>coursesInterestedIn = new HashSet<>();
				for(String course: resultSet.getString("COURSE_ALREADY_DONE").split(",")) {
					coursesDone.add(course);
				}
				for(String course: resultSet.getString("COURSE_INTERESTED_IN").split(",")) {
					coursesInterestedIn.add(course);
				}
			
				EnquiredStudetnsCourseWrapper enquiredStudetnsCourseWrapper = new EnquiredStudetnsCourseWrapper(coursesInterestedIn, coursesDone);
				EnquiredStudentsCoursesMap.put(en, enquiredStudetnsCourseWrapper);
				
			}
		}
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return EnquiredStudentsCoursesMap;
	}
		

	public HashMap<Course, ArrayList<UserCoursesDoneWrapper>> coursesStudentsEligibleMap() {
		HashMap< Course, HashSet<String>>courseList = getCoursePreRequisites();
		HashMap<Integer, UserCoursesDoneWrapper> studentsList = getActiveStudentsList();
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>>coursesStudentsEligibleMap = new HashMap<>();
		
		for(Course course : courseList.keySet()) {
			ArrayList<UserCoursesDoneWrapper>user= new ArrayList<>();//coursesStudentsEligibleMap.get(course);
			//coursesStudentsEligibleMap.put(course,new ArrayList<>());
			for(int userId : studentsList.keySet()) {
				if((!(studentsList.get(userId).getCoursesDoneSet().contains(Integer.toString(course.getCourseId())))
						&& studentsList.get(userId).getCoursesDoneSet().containsAll(courseList.get(course))) || (courseList.get(course).contains("0") 
								&& !studentsList.get(userId).getCoursesDoneSet().contains(Integer.toString(course.getCourseId())))){					
					user.add(studentsList.get(userId));	
					//System.out.println("Course : "+course.getCourseName()+" Name :  "+userId);
				}
			}
			//System.out.println("Course : "+course.getCourseName()+" Size :  "+user.size());
			coursesStudentsEligibleMap.put(course,user);
		}
		return coursesStudentsEligibleMap;
	}
	
	
	public HashMap<Course, ArrayList<UserCoursesDoneWrapper>> coursesEligibleEnquiredStudentsMaps() {
		HashMap< Course, HashSet<String>>courseList = getCoursePreRequisites();
		HashMap<EnquiryDetails, EnquiredStudetnsCourseWrapper>EnquiredStudentsCoursesMap = getEligibleEnquiryDetails();
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>> coursesEnquiredStudetnsMap = new HashMap<>();
				
		for(Course course : courseList.keySet()) {
			ArrayList<UserCoursesDoneWrapper> enquiryList = new ArrayList<>();

			//coursesEnquiredStudetnsMap.put(course, new ArrayList<>());
			for(EnquiryDetails enquiry : EnquiredStudentsCoursesMap.keySet()) {
				if( (!EnquiredStudentsCoursesMap.get(enquiry).getCoursesAlreadyDoneSet().contains(Integer.toString(course.getCourseId())))  &&
						((courseList.get(course).contains("0"))||EnquiredStudentsCoursesMap.get(enquiry).getCoursesAlreadyDoneSet().containsAll(courseList.get(course)))    
						&&  (EnquiredStudentsCoursesMap.get(enquiry).getCoursesInterestedInSet().contains(Integer.toString(course.getCourseId())))) {
					
					enquiryList.add(new UserCoursesDoneWrapper(enquiry, EnquiredStudentsCoursesMap.get(enquiry).getCoursesAlreadyDoneSet()));
					//System.out.println("Course : "+course.getCourseName()+" Name :  "+enquiry.getFirstName());
				}
				
			}
			//System.out.println("Course : "+course.getCourseName()+" Size :  "+enquiryList.size());
			coursesEnquiredStudetnsMap.put(course, enquiryList);

		}
		
		return coursesEnquiredStudetnsMap;
	}
		
}

//!EnquiredStudentsCoursesMap.get(enquiry).getCoursesAlreadyDoneSet().contains(Integer.toString(course.getCourseId()))

//EnquiredStudentsCoursesMap.get(enquiry).getCoursesInterestedInSet().contains(Integer.toString(course.getCourseId()))

//EnquiredStudentsCoursesMap.get(enquiry).getCoursesAlreadyDoneSet().containsAll(courseList.get(course))

//(courseList.get(course).contains("0"))





	