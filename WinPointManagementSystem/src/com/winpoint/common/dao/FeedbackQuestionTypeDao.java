package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.FeedbackQuestionType;
import com.winpoint.common.util.sql.ConnectionManager;

public class FeedbackQuestionTypeDao {

	public List<FeedbackQuestionType> getFeedbackQuestionTypeList() {
		// TODO Auto-generated method stub
		List<FeedbackQuestionType> feedbackQuestionTypeList = new ArrayList<FeedbackQuestionType>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
		
			String query = "\n" + 
					"SELECT FEEDBACK_QUESTION_TYPE_ID, FEEDBACK_QUESTION_TYPE_DESCRIPTION FROM FEEDBACK_QUESTION_TYPE";
		
			ResultSet rs = statement.executeQuery(query);
		
			while(rs.next()) {
				feedbackQuestionTypeList.add(new FeedbackQuestionType(rs.getInt("FEEDBACK_QUESTION_TYPE_ID"), rs.getString("FEEDBACK_QUESTION_TYPE_DESCRIPTION")));
			}
		
		}catch(SQLException e) {
			feedbackQuestionTypeList = null;
			e.printStackTrace();
		}
	
		return feedbackQuestionTypeList;
		
	}

	
	
}
