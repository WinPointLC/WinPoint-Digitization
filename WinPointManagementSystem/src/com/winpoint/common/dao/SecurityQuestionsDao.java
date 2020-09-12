package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.util.sql.ConnectionManager;

public class SecurityQuestionsDao {

	public List<SecurityQuestions> getSecurityQuestionsList() {
		
		List<SecurityQuestions> securityQuestionsList = new ArrayList<SecurityQuestions>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT  * from SECURITY_QUESTIONS";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int securityQuestionId = resultSet.getInt("SECURITY_QUESTION_ID");
				String securityQuestion = resultSet.getString("SECURITY_QUESTION");
				SecurityQuestions secQuest = new SecurityQuestions(securityQuestionId, securityQuestion);
				securityQuestionsList.add(secQuest);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return securityQuestionsList;
		
	}

	public void createSecurityQuestionsList(ArrayList<SecurityQuestions> newSecurityQuestionsArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(SecurityQuestions securityQuestions: newSecurityQuestionsArrayList) {
			String query = "INSERT INTO SECURITY_QUESTIONS\n" + 
					"(SECURITY_QUESTION) VALUES\n" + 
					"('"+ securityQuestions.getSecurityQuestion() +"')";
			statement.executeUpdate(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void deleteSecurityQuestionsList(ArrayList<Integer> deleteSecurityQuestionsArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteSecurityQuestionsString = new StringBuilder();
			for(int securityQuestionsId: deleteSecurityQuestionsArrayList) {
				deleteSecurityQuestionsString.append(securityQuestionsId);
				deleteSecurityQuestionsString.append(',');
			}
			deleteSecurityQuestionsString.deleteCharAt(deleteSecurityQuestionsString.length()-1);
			String query ="DELETE FROM SECURITY_QUESTIONS\n" + 
					"WHERE SECURITY_QUESTION_ID IN ("+ deleteSecurityQuestionsString.toString() +")";
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
