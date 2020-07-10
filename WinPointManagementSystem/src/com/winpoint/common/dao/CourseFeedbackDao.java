package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.CourseFeedback;

import com.winpoint.common.util.sql.ConnectionManager;


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
		
		Float sum=0.0f;
		Integer i= 0;
		Float average=0.0f;
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			for(int j=1;j<=14;j++) {
				
				if(j == 11 || j == 12) {
					continue;
				}
			
					String query1 = "SELECT user_id, RESPONSE from COURSE_FEEDBACK where COURSE_ID=" + courseId + "and FEEDBACK_QUESTION_ID ="+ j;
			
			
					resultSet  = statement.executeQuery(query1);
					sum=0.0f;
					average = 0.0f;
					i=0;
					while(resultSet.next()) {
						sum += Float.parseFloat(resultSet.getString("RESPONSE"));

						i++;
				
					}
					average = (float) (sum/i);
			
					averageResponseList.add(average);
				
			}
			averageResponseList.add(new Float(i));
		} 
		catch (SQLException e) {
			averageResponseList = null;
			e.printStackTrace();
		}
		
		return  averageResponseList;
	}
}

	 
	 
	 
	 

