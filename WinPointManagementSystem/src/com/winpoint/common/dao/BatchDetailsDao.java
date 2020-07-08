package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.util.sql.ConnectionManager;

public class BatchDetailsDao {
	
	public List<BatchDetails> getBatchDetailsList() {
		
		List<BatchDetails> batchDetailsList = new ArrayList<BatchDetails>();
				
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "select BATCH_ID, COURSE_ID, FACULTY_USER_ID, BATCH_TIME, BEGIN_DATE, END_DATE, CREATED_BY, CREATED_DATE from BATCH_DETAILS\n" + 
					"";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				batchDetailsList.add(new BatchDetails(rs.getString("BATCH_ID"), rs.getInt("COURSE_ID"), rs.getInt("FACULTY_USER_ID"), rs.getInt("BATCH_TIME"), rs.getDate("BEGIN_DATE"), rs.getDate("END_DATE"), rs.getInt("CREATED_BY"), rs.getDate("CREATED_DATE")));
			}
			
		} 
		catch (SQLException e) {
			batchDetailsList = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<BatchDetails>) batchDetailsList;
		
	}
	
}
