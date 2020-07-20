package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.LectureWrapper;

public class LectureDao {
	public ArrayList<Lecture> getAttendanceforBatch(Integer batchId){
		
		ArrayList<Lecture> lectureAttendanceList = new ArrayList<Lecture>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT LECTURE_NUMBER, ABSENTEES\r\n" + 
					"FROM LECTURE\r\n" + 
					"WHERE BATCH_ID =" + batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				lectureAttendanceList.add(new Lecture(resultSet.getInt("LECTURE_NUMBER"), resultSet.getString("ABSENTEES")));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  lectureAttendanceList;
		
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
}
