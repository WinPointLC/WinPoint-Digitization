package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.EnquiryDetails;
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
	
	//GroupB
public List<BatchDetails> getBatchDetailsList1() {
		
		List<BatchDetails> batchDetailsList1 = new ArrayList<BatchDetails>();
				
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "select bd.BATCH_ID, bd.COURSE_ID,bd.FACULTY_USER_ID,(up.FIRST_NAME+' '+up.LAST_NAME) AS FACULTY_NAME, \r\n" + 
					"bd.BATCH_TIME, bd.BEGIN_DATE, bd.END_DATE, bd.CREATED_BY, bd.CREATED_DATE \r\n" + 
					"FROM BATCH_DETAILS bd, USER_PROFILE up\r\n" + 
					"WHERE bd.FACULTY_USER_ID=up.USER_ID ";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				batchDetailsList1.add(new BatchDetails(rs.getString("BATCH_ID"), rs.getInt("COURSE_ID"), rs.getInt("FACULTY_USER_ID"), rs.getInt("BATCH_TIME"), rs.getDate("BEGIN_DATE"), rs.getDate("END_DATE"), rs.getInt("CREATED_BY"), rs.getDate("CREATED_DATE"),rs.getNString("FACULTY_NAME")));
			}
			
		} 
		catch (SQLException e) {
			batchDetailsList1 = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<BatchDetails>) batchDetailsList1;
		
	}

	
//group A - for inserting the values in the table. ~ Shraddha
public void create(BatchDetails batchDetails) throws SQLException {
	java.sql.Date sqlBeginDate = new java.sql.Date( batchDetails.getStartDate().getTime());
	java.sql.Date sqlEndDate = new java.sql.Date( batchDetails.getEndDate().getTime());
	

	try(Connection connection = ConnectionManager.getConnection()){
		Statement statement = connection.createStatement();
		String query = "\n" +
				"INSERT INTO BATCH_DETAILS \n" +
				"(BATCH_NAME, \n" +
				"LECTURE_DURATION, \n" +
				"TOTAL_NUMBER_OF_LECTURES, \n" +
				"FACULTY_USER_ID, \n" +
				"BATCH_TIME, \n" +
				"BEGIN_DATE, \n" +
				"END_DATE)\n" +
				"VALUES("+
				batchDetails.getBatchName()+"','"+
				batchDetails.getLectureDuration()+"','"+
				batchDetails.getTotalNumberOfLectures()+"','"+
				batchDetails.getFacultyId()+"','"+
				batchDetails.getBatchTime()+"','"+
				sqlBeginDate+"','"+
				sqlEndDate+"')";
		
		System.out.println(query);
		statement.executeUpdate(query);
	}
}

	
}
