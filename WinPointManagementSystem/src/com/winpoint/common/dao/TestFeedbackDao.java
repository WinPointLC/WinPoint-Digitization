package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.TestFeedback;
import com.winpoint.common.util.sql.ConnectionManager;

public class TestFeedbackDao {

	public boolean insertTestFeedback(int userId, int courseId, List<TestFeedback> testFeedbackList) {
		
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			int testDetailId = 0;
			int userTestId = 0;
			String query = "SELECT TEST_DETAIL_ID FROM TEST_DETAILS WHERE TEST_NUMBER =1 AND COURSE_ID = " + courseId;
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			   testDetailId = resultSet.getInt("TEST_DETAIL_ID");
			}
			query = "SELECT USER_TEST_ID FROM USER_TEST_DETAILS WHERE USER_ID = " + userId + "AND TEST_DETAIL_ID = " + testDetailId;
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			   
			   userTestId = resultSet.getInt("USER_TEST_ID");
			}
			
			for(TestFeedback testFeedback : testFeedbackList){
				query = "INSERT INTO [dbo].[TEST_FEEDBACK]\r\n" + 
						"           ([USER_TEST_ID]\r\n" + 
						"           ,[FEEDBACK_QUESTION_ID]\r\n" + 
						"           ,[RESPONSE]\r\n" +  ")" +
						"     VALUES\r\n" + 
						"           (" + userTestId + "\r\n" + 
						"           ," + testFeedback.getFeedbackQuestionId() + "\r\n" + 
						"           ," + testFeedback.getResponse() + ")";
				statement.executeUpdate(query);
			}
			
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return true;
		
	}
}
