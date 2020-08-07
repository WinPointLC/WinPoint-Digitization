package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.BatchDetailsWrapper;

public class BatchDetailsDao {
	
	//Group A - to Display Data in the BatchDetails table - Abhishek
	public List<BatchDetailsWrapper> getBatchDetailsList() {
		
		List<BatchDetailsWrapper> batchDetailsWrapperList = new ArrayList<BatchDetailsWrapper>();
				
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT BATCH.BATCH_ID, BATCH.BATCH_NAME, COURSE.COURSE_NAME, U.FIRST_NAME+' '+U.LAST_NAME AS FACULTY , T.TIME_SLOTS_DESCRIPTION, BATCH.BEGIN_DATE, BATCH.END_DATE, BATCH.CREATED_BY, BATCH.CREATED_DATE\n" + 
					"FROM BATCH_DETAILS BATCH\n" + 
					"INNER JOIN COURSES COURSE\n" + 
					"ON  BATCH.COURSE_ID = COURSE.COURSE_ID\n" + 
					"INNER JOIN TIME_SLOTS T\n" + 
					"ON BATCH.BATCH_TIME = T.TIME_SLOTS_ID\n" + 
					"INNER JOIN FACULTY_SKILLS FACULTY\n" + 
					"ON BATCH.FACULTY_USER_ID = FACULTY.FACULTY_USER_ID\n" + 
					"INNER JOIN USER_PROFILE U\n" + 
					"ON FACULTY.FACULTY_USER_ID = U.USER_ID";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				batchDetailsWrapperList.add(new BatchDetailsWrapper(
						rs.getInt("BATCH_ID"),
						rs.getString("BATCH_NAME"),
						rs.getString("COURSE_NAME"),
						rs.getString("FACULTY"),
						rs.getString("TIME_SLOTS_DESCRIPTION"),
						rs.getDate("BEGIN_DATE"),
						rs.getDate("END_DATE"),
						rs.getInt("CREATED_BY"),
						rs.getDate("CREATED_DATE"),
						null
						));
			}
			
		} 
		catch (SQLException e) {
			batchDetailsWrapperList = null;
			e.printStackTrace();
		}
		
		return  (List<BatchDetailsWrapper>) batchDetailsWrapperList;
		
	}
	
	
	
	//GROUP A - For Inserting the Data in BatchDetails - Abhishek
	public void create(BatchDetails batchDetails) throws SQLException {
		java.sql.Date sqlCreatedDate = new java.sql.Date(batchDetails.getCreatedDate().getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(batchDetails.getEndDate().getTime());
		java.sql.Date sqlStartDate = new java.sql.Date(batchDetails.getStartDate().getTime());
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "\n" + 
					"INSERT INTO BATCH_DETAILS (\n" + 
					"BATCH_NAME,\n" + 
					"BATCH_TIME,\n" + 
					"COURSE_ID,\n" + 
					"FACULTY_USER_ID,\n" + 
					"BEGIN_DATE,\n" + 
					"CURRENT_LECTURE_NUMBER,\n" + 
					"LECTURE_DURATION,\n" + 
					"TOTAL_NUMBER_OF_LECTURES,\n" + 
					"SEGMENT_TYPE_ID,\n" + 
					"END_DATE,\n" + 
					"CREATED_BY,\n" + 
					"CREATED_DATE)\n" + 
					"\n" + 
					"VALUES (\n" + 
					"'"+ batchDetails.getBatchName() +"',\n" + 
					""+ batchDetails.getBatchTime() +",\n" + 
					""+ batchDetails.getCourseId() +",\n" + 
					""+ batchDetails.getFacultyId() +",\n" + 
					"'"+ sqlStartDate +"',\n" + 
					""+ batchDetails.getCurrentLectureNumber() +",\n" + 
					"'"+ batchDetails.getLectureDuration() +"',\n" + 
					""+ batchDetails.getTotalNumberOfLectures() +",\n" + 
					""+ batchDetails.getSegmentTypeId() +",\n" + 
					"'"+ sqlEndDate +"',\n" + 
					""+ batchDetails.getCreatedBy() +",\n" + 
					"'"+ sqlCreatedDate +"')\n" + 
					"";
//			System.out.println(query);
			statement.executeUpdate(query);
			
		}

		
	}
	
	
	//Group A - for counting the NO. of batches - Abhishek
	public BatchDetailsWrapper getcountNumberOfBatches(Integer courseId) {
		BatchDetailsWrapper count = null;
		
		ResultSet resultSet = null;

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();

			String query = "\n" + 
					"SELECT COUNT(COURSE_ID) as COUNT_BATCH FROM BATCH_DETAILS\n" + 
					"					WHERE COURSE_ID =  "+courseId;
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				count = new BatchDetailsWrapper(resultSet.getInt("COUNT_BATCH"));
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return count ;
		
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
				batchDetailsList1.add(new BatchDetails(rs.getInt("BATCH_ID"), rs.getInt("COURSE_ID"), rs.getInt("FACULTY_USER_ID"), rs.getInt("BATCH_TIME"), rs.getDate("BEGIN_DATE"), rs.getDate("END_DATE"), rs.getInt("CREATED_BY"), rs.getDate("CREATED_DATE"),rs.getNString("FACULTY_NAME")));
			}
			
		} 
		catch (SQLException e) {
			batchDetailsList1 = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<BatchDetails>) batchDetailsList1;
		
	}

	
	//group A - for inserting the values in the table. ~ Shraddha
//	public void create(BatchDetails batchDetails) throws SQLException {
//		java.sql.Date sqlBeginDate = new java.sql.Date( batchDetails.getStartDate().getTime());
//		java.sql.Date sqlEndDate = new java.sql.Date( batchDetails.getEndDate().getTime());
//		
//	
//		try(Connection connection = ConnectionManager.getConnection()){
//			Statement statement = connection.createStatement();
//			String query = "\n" +
//					"INSERT INTO BATCH_DETAILS \n" +
//					"(BATCH_NAME, \n" +
//					"LECTURE_DURATION, \n" +
//					"TOTAL_NUMBER_OF_LECTURES, \n" +
//					"FACULTY_USER_ID, \n" +
//					"BATCH_TIME, \n" +
//					"BEGIN_DATE, \n" +
//					"END_DATE)\n" +
//					"VALUES("+
//					batchDetails.getBatchName()+"','"+
//					batchDetails.getLectureDuration()+"','"+
//					batchDetails.getTotalNumberOfLectures()+"','"+
//					batchDetails.getFacultyId()+"','"+
//					batchDetails.getBatchTime()+"','"+
//					sqlBeginDate+"','"+
//					sqlEndDate+"')";
//			
//			System.out.println(query);
//			statement.executeUpdate(query);
//		}
//	}
	
	public ArrayList<BatchDetailsWrapper> getWrapperListOfBatches(Integer courseId){
		ArrayList<BatchDetailsWrapper> batchList = new ArrayList<>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT bd.BATCH_ID, bd.BATCH_NAME, (up.FIRST_NAME + ' ' + up.LAST_NAME) AS FACULTY_NAME, UP.PHOTO_LOCATION AS FACULTY_IMAGE \r\n" + 
					"FROM BATCH_DETAILS AS bd, USER_PROFILE AS up\r\n" + 
					"WHERE COURSE_ID =" + courseId + " AND bd.FACULTY_USER_ID = up.USER_ID";
			
			ResultSet resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				batchList.add(new BatchDetailsWrapper(resultSet.getInt("BATCH_ID"), resultSet.getString("BATCH_NAME"), resultSet.getString("FACULTY_NAME"), resultSet.getString("FACULTY_IMAGE")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return batchList;
		
	}
	
	public BatchDetails getBatchDetails(Integer batchId){
		BatchDetails batchDetails = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT BATCH_ID, BATCH_NAME, BATCH_TIME, COURSE_ID, FACULTY_USER_ID, BEGIN_DATE, CURRENT_LECTURE_NUMBER, LECTURE_DURATION, TOTAL_NUMBER_OF_LECTURES,\r\n" + 
					"bd.SEGMENT_TYPE_ID, END_DATE, bd.CREATED_BY, bd.CREATED_DATE, (FIRST_NAME + ' ' + LAST_NAME) AS FACULTY_NAME \r\n" + 
					"FROM BATCH_DETAILS AS bd\r\n" + 
					"INNER JOIN\r\n" + 
					"USER_PROFILE AS up\r\n" + 
					"ON USER_ID = FACULTY_USER_ID\r\n" + 
					"WHERE BATCH_ID = " + batchId;
			
			ResultSet resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				batchDetails = new BatchDetails(resultSet.getInt("BATCH_ID"), resultSet.getInt("COURSE_ID"), resultSet.getInt("FACULTY_USER_ID"), resultSet.getDate("BEGIN_DATE"), resultSet.getDate("END_DATE"),
						resultSet.getInt("CREATED_BY"), resultSet.getDate("CREATED_DATE"), resultSet.getString("BATCH_NAME"), resultSet.getInt("BATCH_TIME"), resultSet.getInt("CURRENT_LECTURE_NUMBER"),
			Integer.parseInt(resultSet.getString("LECTURE_DURATION")), resultSet.getString("FACULTY_NAME"), resultSet.getInt("TOTAL_NUMBER_OF_LECTURES"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return batchDetails;
		
	}



	public boolean doBatchExist(Integer courseId, Integer timeSlotsId, Integer facultyUserId, Integer segmentTypeId) {
		
		boolean batchExist = false;
		
		BatchDetails batchDetails = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT BEGIN_DATE\n" + 
					"from BATCH_DETAILS\n" + 
					"where COURSE_ID = "+ courseId +" and BATCH_TIME = "+ timeSlotsId +" and FACULTY_USER_ID = "+ facultyUserId +" and SEGMENT_TYPE_ID = "+ segmentTypeId +"";
			
			ResultSet resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				batchDetails = new BatchDetails(resultSet.getDate("BEGIN_DATE"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(batchDetails!=null) {
			batchExist = true;
		}
			
		return batchExist;	}
	
}
