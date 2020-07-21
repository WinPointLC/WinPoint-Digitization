package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.BatchFeedbackScreenWrapper;


public class CourseFeedbackDao {
	
	public List<CourseFeedback> getResponses(Integer userId, Integer courseId){ 
		ArrayList<CourseFeedback> feedBackResponses =  new ArrayList<>();
		
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT * FROM COURSE_FEEDBACK\r\n" + 
					"WHERE USER_ID =" + userId  + "AND COURSE_ID =" + courseId;
			
			
			resultSet  = statement.executeQuery(query1);
			
			
			while(resultSet.next()) {
				feedBackResponses.add(new CourseFeedback(resultSet.getInt("USER_ID"), resultSet.getInt("COURSE_ID"), resultSet.getInt("FEEDBACK_QUESTION_ID"), 
						resultSet.getString("RESPONSE"), null, null,null));
			}

		} 
		catch (SQLException e) {
			feedBackResponses = null;
			e.printStackTrace();
		}
		
		return  feedBackResponses;
	}	
	
	
	
	 
	public ArrayList<Float> getAverageResponses(Integer courseId){
		
		ArrayList<Float> averageResponseList =  new ArrayList<>();
		
		
		Integer i= 0;
		
		ResultSet resultSet1 = null, resultSet2 = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			
					String query1 = "SELECT COUNT (DISTINCT USER_ID) AS FEEDBACK_COUNT FROM COURSE_FEEDBACK "
							+ "WHERE COURSE_ID = "+ courseId;
			
					resultSet1  = statement.executeQuery(query1);
					Integer feedbackCount = null;
					while(resultSet1.next()) {
						feedbackCount = resultSet1.getInt("FEEDBACK_COUNT");
						}
					
					String query2 = "SELECT  RESPONSE FROM COURSE_FEEDBACK \r\n" + 
							"WHERE COURSE_ID="+courseId+" AND FEEDBACK_QUESTION_ID IN (\r\n" + 
							"SELECT FEEDBACK_QUESTION_ID FROM FEEDBACK_QUESTIONS\r\n" + 
							"WHERE FEEDBACK_QUESTION_TYPE_ID = 1 AND FEEDBACK_CATEGORY_ID=1)";
			
				
					resultSet2  = statement.executeQuery(query2);
					
					resultSet2.last();
					Integer questionCount=resultSet2.getRow()/feedbackCount;
					Integer[] sum = new Integer[questionCount];
					
					for(i=0;i<questionCount;i++) {
						sum[i]=0;
					}
					resultSet2.first();
					
					i=0;
					while(resultSet2.next()) {
						if(i>=questionCount) {
							i=0;
						}
						sum[i]+= Integer.parseInt(resultSet2.getString("RESPONSE"));
						
						i++;
					}
					
					for(i=0;i<questionCount; i++) {
						averageResponseList.add(new Float(((sum[i]*1.0f)/(feedbackCount*1.0f))));
						
						
					} 
		} 
		catch (SQLException e) {
			averageResponseList = null;
			e.printStackTrace();
		}
		
		
		return  averageResponseList;
	}
	
	
	
	
	public  BatchFeedbackScreenWrapper getFeedbackCount(Integer courseId){
		
		BatchFeedbackScreenWrapper studentFeedbackCount =  null;
		
		
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			
					String query = "SELECT COUNT (DISTINCT USER_ID) AS FEEDBACK_COUNT FROM COURSE_FEEDBACK "
							+ "WHERE COURSE_ID = "+ courseId;
			
					resultSet  = statement.executeQuery(query);
					Integer feedbackCount = null;
					while(resultSet.next()) {
						feedbackCount = resultSet.getInt("FEEDBACK_COUNT");
						}
					
					studentFeedbackCount = new BatchFeedbackScreenWrapper(feedbackCount);
					

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return  studentFeedbackCount;
	}
	
	
	

	

	public void createUserCourseFeedback(CourseFeedback userCourseFeedback) {
		try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();			
		String query = "INSERT INTO STUDENT_COURSE_DETAILS (USER_ID, COURSE_ID, FEEDBACK_QUESTION_ID, RESPONSE) "
				+ "VALUES (" + userCourseFeedback.getUserId() + ","+ userCourseFeedback.getCourseId() + "," + userCourseFeedback.getFeedbackId() + "," + userCourseFeedback.getStudentResponse() +")" ;
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

	 
}	 
	 
	 

