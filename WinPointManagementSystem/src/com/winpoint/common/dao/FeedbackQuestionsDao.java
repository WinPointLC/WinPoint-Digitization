package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.FeedbackQuestions;

import com.winpoint.common.util.sql.ConnectionManager;

public class FeedbackQuestionsDao {

	public ArrayList<FeedbackQuestions> getFeedbackQuestions(int feedbackQuestionCategoryId) {
		
		ArrayList<FeedbackQuestions> feedbackQuestionsList = new ArrayList<FeedbackQuestions>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "select FEEDBACK_QUESTION_ID, FEEDBACK_QUESTION, FEEDBACK_QUESTION_TYPE_ID from FEEDBACK_QUESTIONS WHERE FEEDBACK_CATEGORY_ID =" + feedbackQuestionCategoryId;
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int feedbackQuestionId = resultSet.getInt("FEEDBACK_QUESTION_ID");
				String feedbackQuestion = resultSet.getString("FEEDBACK_QUESTION");
				Integer feedbackQuestionTypeId = resultSet.getInt("FEEDBACK_QUESTION_TYPE_ID");
				FeedbackQuestions feedbackQuestions = new FeedbackQuestions(feedbackQuestionId, feedbackQuestion, feedbackQuestionTypeId);
				/*feedbackQuestions.setFeedbackQuestionId(feedbackQuestionId);
				feedbackQuestions.setFeedbackQuestion(feedbackQuestion);
				feedbackQuestions.setFeedbackQuestionTypeId(feedbackQuestionTypeId);*/
				feedbackQuestionsList.add(feedbackQuestions);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return feedbackQuestionsList;
		
	}
	
	public ArrayList<FeedbackQuestions> getResponsesQuestion(Integer feedbackCategoryId){ 
		ArrayList<FeedbackQuestions> responsesQuestionList =  new ArrayList<>();
		
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT FEEDBACK_QUESTION_ID, FEEDBACK_QUESTION, FEEDBACK_QUESTION_TYPE_ID FROM FEEDBACK_QUESTIONS\r\n" + 
					"WHERE FEEDBACK_CATEGORY_ID = " + feedbackCategoryId;
				
			
			resultSet  = statement.executeQuery(query1);
			
			
			while(resultSet.next()) {
				responsesQuestionList.add(new FeedbackQuestions(resultSet.getInt("FEEDBACK_QUESTION_ID"),
						null,resultSet.getString("FEEDBACK_QUESTION"), resultSet.getInt("FEEDBACK_QUESTION_TYPE_ID"),null,null));
			}

		} 
		catch (SQLException e) {
			responsesQuestionList = null;
			e.printStackTrace();
		}
		
		return  responsesQuestionList;
	}
	 

}
