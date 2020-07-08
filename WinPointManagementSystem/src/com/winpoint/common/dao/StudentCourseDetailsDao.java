package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import com.microsoft.sqlserver.jdbc.SQLServerException;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;

public class StudentCourseDetailsDao {

	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(int userId) {
		ArrayList<StudentCourseDetails> studentCourseDetailsList = new ArrayList<>();		
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT STREAMS.STREAM_NAME, \r\n" + 
					"		COURSE_TYPE.COURSE_TYPE_NAME, \r\n" + 
					"		COURSES.COURSE_ID, COURSES.COURSE_NAME, COURSES.LOGO_LOCATION, \r\n" + 
					"		STUDENT_COURSE_DETAILS.COURSE_AGGR\r\n" + 
					"FROM STREAMS JOIN COURSES \r\n" + 
					"	ON STREAMS.STREAM_ID =  COURSES.STREAM_ID\r\n" + 
					"		LEFT OUTER JOIN COURSE_TYPE \r\n" + 
					"		ON COURSE_TYPE.COURSE_TYPE_ID = COURSES.COURSE_TYPE_ID\r\n" + 
					"		LEFT OUTER JOIN STUDENT_COURSE_DETAILS \r\n" + 
					"		ON COURSES.COURSE_ID = STUDENT_COURSE_DETAILS.COURSE_ID\r\n" + 
					"WHERE COURSES.COURSE_ID IN \r\n" + 
					"	(SELECT STUDENT_COURSE_DETAILS.COURSE_ID FROM STUDENT_COURSE_DETAILS where STUDENT_COURSE_DETAILS.USER_ID=" + userId + "and courses.stream_Id = 1) and STUDENT_COURSE_DETAILS.USER_ID=" + userId;
			resultSet = statement.executeQuery(query);
			int i = 1;
			while(resultSet.next()) {
				int courseId = resultSet.getInt("COURSE_ID");
				String courseName = resultSet.getString("COURSE_NAME");
				String logoLocation = resultSet.getString("LOGO_LOCATION"); 
				String courseTypeName = resultSet.getString("COURSE_TYPE_NAME");
				String streamName = resultSet.getString("STREAM_NAME");
				int courseAggr = resultSet.getInt("COURSE_AGGR");
				StudentCourseDetails secQuest = new StudentCourseDetails(userId, courseId, courseName, logoLocation, courseTypeName, streamName, courseAggr);
				System.out.println(i + ". " +courseName);
				i++;
				studentCourseDetailsList.add(secQuest);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
		
		return studentCourseDetailsList;
		
		
	}
	
	public ArrayList<StudentCourseDetails> getStudentGACourseDetailsList(int userId) {
		
		ArrayList<StudentCourseDetails> studentGACourseDetailsList = new ArrayList<>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT STREAMS.STREAM_NAME, \r\n" + 
					"		COURSE_TYPE.COURSE_TYPE_NAME, \r\n" + 
					"		COURSES.COURSE_ID, COURSES.COURSE_NAME, COURSES.LOGO_LOCATION, \r\n" + 
					"		STUDENT_COURSE_DETAILS.COURSE_AGGR\r\n" + 
					"FROM STREAMS JOIN COURSES \r\n" + 
					"	ON STREAMS.STREAM_ID =  COURSES.STREAM_ID\r\n" + 
					"		LEFT OUTER JOIN COURSE_TYPE \r\n" + 
					"		ON COURSE_TYPE.COURSE_TYPE_ID = COURSES.COURSE_TYPE_ID\r\n" + 
					"		LEFT OUTER JOIN STUDENT_COURSE_DETAILS \r\n" + 
					"		ON COURSES.COURSE_ID = STUDENT_COURSE_DETAILS.COURSE_ID\r\n" + 
					"WHERE COURSES.COURSE_ID IN \r\n" + 
					"	(SELECT STUDENT_COURSE_DETAILS.COURSE_ID FROM STUDENT_COURSE_DETAILS where STUDENT_COURSE_DETAILS.USER_ID=" + userId + "and courses.stream_Id = 3 ) and STUDENT_COURSE_DETAILS.USER_ID=" + userId;
			resultSet = statement.executeQuery(query);
			int i = 1;
			while(resultSet.next()) {
				int courseId = resultSet.getInt("COURSE_ID");
				String courseName = resultSet.getString("COURSE_NAME");
				String logoLocation = resultSet.getString("LOGO_LOCATION"); 
				String courseTypeName = resultSet.getString("COURSE_TYPE_NAME");
				String streamName = resultSet.getString("STREAM_NAME");
				int courseAggr = resultSet.getInt("COURSE_AGGR");
				StudentCourseDetails secQuest = new StudentCourseDetails(userId, courseId, courseName, logoLocation, courseTypeName, streamName, courseAggr);
				i++;
				studentGACourseDetailsList.add(secQuest);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return studentGACourseDetailsList;
		
	}

	public void createStudentCourseDetails(int userId, int courseId, String courseName, int streamId, String feeStatus) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();			
			String query = "INSERT INTO STUDENT_COURSE_DETAILS (USER_ID, COURSE_ID, FEE_STATUS) VALUES (" + userId + ","+ courseId + ",'" + feeStatus + "')" ;
			System.out.println(query);
			statement.executeUpdate(query);
			
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}
	
	public void updateStudentCourseDetails(int userId, int courseId) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();			
			String query = "UPDATE STUDENT_COURSE_DETAILS SET FEE_STATUS = 'PAID' WHERE USER_ID = " + userId + " AND COURSE_ID = " + courseId;
			System.out.println(query);
			statement.executeUpdate(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	public ArrayList<StudentCourseDetails> getStudentCourseDetails() {		
		ArrayList<StudentCourseDetails> studentCourseDetails = new ArrayList<StudentCourseDetails>();
		StudentCourseDetails studentCourseDetails1,studentCourseDetails2,studentCourseDetails3;
		
		studentCourseDetails1 = new StudentCourseDetails(10, null, null, null, null, null, 10, null, null, null, null, 
				"partially paid", null, null, "Yes", "Yes","Yes", null, null);
		studentCourseDetails2 = new StudentCourseDetails(11, null, null, null, null, null, 20, null, null, null, null, 
				"paid", null, null,"Yes", "Yes","Yes", null, null);
		studentCourseDetails3 = new StudentCourseDetails(12, null, null, null, null, null, 50, null, null, null, null, 
				"not paid", null, null,"Yes", "Yes","Yes", null, null);
		
		studentCourseDetails.add(studentCourseDetails1);
		studentCourseDetails.add(studentCourseDetails2);
		studentCourseDetails.add(studentCourseDetails3);
		
		return studentCourseDetails;
	}
	
public ArrayList<StudentCourseDetails> getBatchFeedback() {
		
		ArrayList<StudentCourseDetails> getBatchFeedback = new ArrayList<StudentCourseDetails>();
		
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "select FEEDBACK_GIVEN from STUDENT_COURSE_DETAILS";
			
			
			resultSet  = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				getBatchFeedback.add(new StudentCourseDetails(resultSet.getString("FEEDBACK_GIVEN")));
				
			}

		} 
		catch (SQLException e) {
			getBatchFeedback = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<StudentCourseDetails>) getBatchFeedback;
		
				
		/*getBatchFeedback.add(new StudentCourseDetails("yes"));
		getBatchFeedback.add(new StudentCourseDetails("yes"));
		getBatchFeedback.add(new StudentCourseDetails("yes"));
		
		return  getBatchFeedback;*/
		

	}

		
}
