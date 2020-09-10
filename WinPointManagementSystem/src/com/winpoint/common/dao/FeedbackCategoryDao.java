package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.FeedbackCategory;
import com.winpoint.common.util.sql.ConnectionManager;

public class FeedbackCategoryDao {

	public List<FeedbackCategory> getFeedbackCategoryList() {
		// TODO Auto-generated method stub
		
		List<FeedbackCategory> feedbackCategoryList = new ArrayList<FeedbackCategory>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
		
			String query = "\n" + 
					"SELECT FEEDBACK_CATEGORY_ID, FEEDBACK_CATEGORY_DESCRIPTION FROM FEEDBACK_CATEGORY";
		
			ResultSet rs = statement.executeQuery(query);
		
			while(rs.next()) {
				feedbackCategoryList.add(new FeedbackCategory(rs.getInt("FEEDBACK_CATEGORY_ID"), rs.getString("FEEDBACK_CATEGORY_DESCRIPTION")));
			}
		
		}catch(SQLException e) {
			feedbackCategoryList = null;
			e.printStackTrace();
		}
	
		return feedbackCategoryList;
		
	}
	
	//===============================================================================================
	

	public void createFeedbackCategoryList(ArrayList<FeedbackCategory> newFeedbackCategoryArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(FeedbackCategory FeedbackCategoryList: newFeedbackCategoryArrayList) {
			String query = "INSERT INTO FEEDBACK_CATEGORY VALUES ("+FeedbackCategoryList.getFeedbackCategoryDescription()+")";
			statement.executeQuery(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void deleteFeedbackCategoryList(ArrayList<Integer> deleteFeedbackCategoryArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteFeedbackCategoryString = new StringBuilder();
			for(int FeedbackCategoryId: deleteFeedbackCategoryArrayList) {
				deleteFeedbackCategoryString.append(FeedbackCategoryId);
				deleteFeedbackCategoryString.append(',');
			}
			deleteFeedbackCategoryString.deleteCharAt(deleteFeedbackCategoryString.length()-1);
			String query ="DELETE FROM FEEDBACK_CATEGORY \n" + 
					"WHERE FEEDBACK_CATEGORY_ID IN  ("+ deleteFeedbackCategoryString.toString() +")";
			statement.executeQuery(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}

}
