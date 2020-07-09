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
	 
	 
	 

}
	 
	 
	 

