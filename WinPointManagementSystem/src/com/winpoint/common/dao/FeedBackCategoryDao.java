package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.FeedbackCategory;
import com.winpoint.common.util.sql.ConnectionManager;

public class FeedBackCategoryDao {

	public List<FeedbackCategory> getFeedBackCategoryList() {
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

}
