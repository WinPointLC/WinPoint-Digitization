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
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;

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
	
	public ArrayList<AssignmentsScreenWrapper> getAssignmentScreenWrapperList(Integer batchId) {		
		ArrayList<AssignmentsScreenWrapper> assignmentsScreenWrapperList = new ArrayList<AssignmentsScreenWrapper>();
			ResultSet resultSet1 = null;
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
				
				String query1="SELECT FIRST_NAME,LAST_NAME,FEE_STATUS,COURSEWARE_ISSUED,ASSIGNMENTS_ISSUED,ASSIGNMENTS_SUBMITTED\r\n" + 
						"FROM USER_PROFILE u,STUDENT_COURSE_DETAILS s,BATCH_DETAILS b\r\n" + 
						"WHERE u.USER_ID=s.USER_ID AND b.BATCH_ID="+batchId+" AND b.COURSE_ID=s.COURSE_ID";
				resultSet1=statement.executeQuery(query1);
				while(resultSet1.next()) {
					String coursewareIssued=(resultSet1.getBoolean("COURSEWARE_ISSUED"))? "YES" : "NO";
					String assignmentsIssued=(resultSet1.getBoolean("ASSIGNMENTS_ISSUED"))? "YES" : "NO";
					String assignmentsSubmitted=(resultSet1.getBoolean("ASSIGNMENTS_SUBMITTED"))? "YES" : "NO";;
					assignmentsScreenWrapperList.add(new AssignmentsScreenWrapper(resultSet1.getString("FIRST_NAME"),
							resultSet1.getString("LAST_NAME"),
							resultSet1.getString("FEE_STATUS"),
							coursewareIssued,assignmentsIssued,assignmentsSubmitted));
					
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return  assignmentsScreenWrapperList;
	}
	public ArrayList<EvaluationScreenWrapper> getStudentEvaluationDetails(Integer batchId) {		
		ArrayList<EvaluationScreenWrapper> evaluationScreenWrapperList = new ArrayList<EvaluationScreenWrapper>();
			ResultSet resultSet = null;
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
				
				String query1="SELECT FIRST_NAME,LAST_NAME,scd.USER_ID,COURSE_AGGR,GRADE_ID,CERTIFICATE_GIVEN FROM USER_PROFILE up, STUDENT_COURSE_DETAILS scd\r\n" + 
						"WHERE up.USER_ID=scd.USER_ID AND scd.BATCH_ID="+batchId;
				resultSet=statement.executeQuery(query1);
				while(resultSet.next()) {
					
					String gradeId=(resultSet.getString("GRADE_ID"));
					String certificateGiven=(resultSet.getString("CERTIFICATE_GIVEN"));
					evaluationScreenWrapperList.add(new EvaluationScreenWrapper(resultSet.getString("FIRST_NAME"),
							resultSet.getString("LAST_NAME"),resultSet.getInt("USER_ID"),null,
							resultSet.getInt("COURSE_AGGR"),gradeId,certificateGiven));
					
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return evaluationScreenWrapperList;
	}
	public ArrayList<StudentCourseDetails> getStudentCountInCourse(Integer courseId){ 
		ArrayList<StudentCourseDetails> batchCount =  new ArrayList<>();
		
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT COUNT(USER_ID) AS STUDENT_COUNT_PER_BATCH, BATCH_ID FROM STUDENT_COURSE_DETAILS WHERE COURSE_ID ="+ courseId + "GROUP BY BATCH_ID";
			
			
			resultSet  = statement.executeQuery(query1);
			
			
			while(resultSet.next()) {
				batchCount.add(new StudentCourseDetails(resultSet.getInt("STUDENT_COUNT_PER_BATCH"),resultSet.getInt("BATCH_ID")));
			}

		} 
		catch (SQLException e) {
			batchCount = null;
			e.printStackTrace();
		}
		
		return  batchCount;
	}
}
