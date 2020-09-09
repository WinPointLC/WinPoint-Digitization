package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.EditBatchDetailsWrapper;

public class LectureDao {
	public ArrayList<Lecture> getAbsenteeListforBatch(Integer batchId){
		
		ArrayList<Lecture> lectureAbsenteeList = new ArrayList<Lecture>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT LECTURE_NUMBER, ABSENTEES\r\n" + 
					"FROM LECTURE\r\n" + 
					"WHERE BATCH_ID =" + batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				lectureAbsenteeList.add(new Lecture(resultSet.getInt("LECTURE_NUMBER"), resultSet.getString("ABSENTEES")));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  lectureAbsenteeList;
		
	}
	@SuppressWarnings("null")
	public Lecture getLectureDetailsForBatch(Integer batchId, Integer lectureNumber){
		Lecture lecture = null;
		ResultSet resultSet1, resultSet2;
		String[] topicNameList = null;
		StringTokenizer stringTopicList = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT lecture.START_TIME, lecture.LECTURE_DURATION, lecture.LECTURE_DATE, lecture.LECTURE_COVERAGE \r\n" + 
					"FROM LECTURE AS lecture\r\n" + 
					"WHERE lecture.LECTURE_NUMBER = " + lectureNumber + " AND lecture.BATCH_ID = " + batchId;
			
			resultSet1 = statement.executeQuery(query1);
			while(resultSet1.next()) {
				lecture  = new Lecture(batchId, lectureNumber, Integer.parseInt(resultSet1.getString("LECTURE_DURATION")),
						resultSet1.getTime("START_TIME"), null, resultSet1.getDate("LECTURE_DATE"));		
				stringTopicList = new StringTokenizer(resultSet1.getString("LECTURE_COVERAGE"),",");
			}
			int i = 0;
			topicNameList = new String[stringTopicList.countTokens()];
			while(stringTopicList.hasMoreTokens()){
				
				String query2 = "SELECT TOPIC_NAME\r\n" + 
						"FROM TOPICS\r\n" + 
						"WHERE TOPIC_ID =" + Integer.parseInt(stringTopicList.nextToken());
				
				resultSet2 = statement.executeQuery(query2);
				
				while(resultSet2.next()) {
					topicNameList[i] = resultSet2.getString("TOPIC_NAME");
				}
				i++;
			}
			lecture.setLectureCoverage(topicNameList);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  lecture;
	}
	
	public EditBatchDetailsWrapper getLectureDetails(Integer courseId,Integer lecnum,Integer batchId){
		
		EditBatchDetailsWrapper editBatchDetails =null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			ArrayList<Integer> topicsList=getLectureCoverageIds(lecnum,batchId);
			//topicsList=new TopicsDao().getTopicNamesForComboBox(courseId);
			String query = "SELECT  LECTURE_DATE, START_TIME,\r\n" + 
					"LECTURE_DURATION,LECTURE_COVERAGE, COMMENTS\r\n" + 
					"FROM LECTURE\r\n" + 
					"WHERE BATCH_ID ="+batchId+"AND LECTURE_NUMBER="+lecnum;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
			 
				String startTime =resultSet.getTime("START_TIME").toString();
				editBatchDetails=new EditBatchDetailsWrapper(null,
						resultSet.getDate("LECTURE_DATE"),startTime,
						resultSet.getString("LECTURE_DURATION"),resultSet.getString("COMMENTS"),topicsList);
			}
			
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  editBatchDetails;
		
	}
	public ArrayList<EditBatchDetailsWrapper> getLectureNumber(Integer batchId){
		
		ArrayList<EditBatchDetailsWrapper> editBatchDetailsLecList = new ArrayList<EditBatchDetailsWrapper>();
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = " SELECT LECTURE_NUMBER FROM LECTURE WHERE BATCH_ID="+batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
			 
				
				editBatchDetailsLecList.add(new EditBatchDetailsWrapper(resultSet.getInt("LECTURE_NUMBER"),
						null,null,null,null,null));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  editBatchDetailsLecList;
		
	}
	public ArrayList<Integer> getLectureCoverageIds(Integer lecnum,Integer batchId){
		
		ArrayList<Integer> lecCoverageIds = new ArrayList<Integer>();
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT LECTURE_COVERAGE FROM LECTURE WHERE LECTURE_NUMBER="+lecnum+" AND BATCH_ID="+batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				String topicsCovered = resultSet.getString("LECTURE_COVERAGE");
				String topicsIds[]=topicsCovered.split(",");
				for( String topicId :topicsIds) {
					lecCoverageIds.add(Integer.parseInt(topicId));
				}
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  lecCoverageIds;
		
	}
	public void updateLectureDetails(EditBatchDetailsWrapper updateLecDetails,Integer batchId,Integer lecnum) {
		java.sql.Date sqlLecDate = new java.sql.Date(updateLecDetails.getLectureDate().getTime());
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "UPDATE LECTURE SET LECTURE_DATE ='"+sqlLecDate+
					"', START_TIME ='"+updateLecDetails.getStartTime()+"', \r\n" + 
					"LECTURE_DURATION ='"+ updateLecDetails.getLectureDuration()+
					"', COMMENTS ='"+updateLecDetails.getComments()+
					"',LECTURE_COVERAGE='"+updateLecDetails.getLecCoverage() +"'\r\n" + 
					"WHERE BATCH_ID = "+batchId+" AND LECTURE_NUMBER= "+lecnum;
			int resultSet = statement.executeUpdate(query);
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addLecToBatch(Integer batchId) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "INSERT INTO LECTURE(BATCH_ID,LECTURE_NUMBER)\r\n" + 
					"VALUES ("+batchId+", (SELECT MAX(LECTURE_NUMBER)+1 FROM LECTURE WHERE BATCH_ID="+batchId+")) ";
			System.out.println(query);
			int resultSet = statement.executeUpdate(query);
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delLecFromBatch(Integer batchId,Integer lecNum) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
	//		String query="SELECT MAX(LECTURE_NUMBER) FROM LECTURE WHERE BATCH_ID="+batchId;
	//		ResultSet resultSet=statement.executeQuery(query);
	//		System.out.println(resultSet);
			String query = "DELETE FROM LECTURE WHERE BATCH_ID="+batchId+" AND LECTURE_NUMBER="+lecNum;
			System.out.println(query);
			int resultSet = statement.executeUpdate(query);
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public EditBatchDetailsWrapper accessMaxLecture(Integer batchId) {
		EditBatchDetailsWrapper maxlec=null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			//int maxlec;
			
		String query="SELECT MAX(LECTURE_NUMBER)AS MAX_LEC_COUNT FROM LECTURE WHERE BATCH_ID="+batchId;
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				 maxlec=new EditBatchDetailsWrapper(resultSet.getInt("MAX_LEC_COUNT"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return maxlec;
	}
	
	public void updateLectureAttendance(ArrayList<String> absenteeNames, Integer lectureNumber, Integer batchId) {
		ResultSet resultSet1;
		String absentee = ""; 
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String query1 = "SELECT up.USER_ID, (up.FIRST_NAME + ' ' + up.LAST_NAME) AS FULL_NAME \r\n" + 
					"FROM USER_PROFILE AS up\r\n" + 
					"INNER JOIN\r\n" + 
					"STUDENT_COURSE_DETAILS AS scd\r\n" + 
					"ON up.USER_ID = scd.USER_ID\r\n" + 
					"WHERE scd.BATCH_ID = " + batchId;
			
			resultSet1 = statement.executeQuery(query1);
			for(String s : absenteeNames) {
				while(resultSet1.next()) {
					if(resultSet1.getString("FULL_NAME").equals(s)) {
						absentee += resultSet1.getInt("USER_ID") + ",";
					}
				}
				resultSet1.beforeFirst();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(absentee.length() > 0)
			absentee = absentee.substring(0, absentee.length()-1);
		
		//System.out.println("UserIds: " + absentee);
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query2 = "update LECTURE\r\n" + 
					"SET ABSENTEES = '" + absentee + "'\r\n" + 
					"WHERE LECTURE_NUMBER = " + lectureNumber + " AND BATCH_ID = " + batchId;
			
			statement.executeUpdate(query2);
			//resultSet2.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
