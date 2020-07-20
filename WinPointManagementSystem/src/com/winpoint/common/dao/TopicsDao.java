package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.ProgressTrackingWrapper;

public class TopicsDao {
	Set<Integer> topicIdsSet = new HashSet<>();
	public List<Topic> getTopicsList(int courseId) {
		List<Topic> topicsList = new ArrayList<Topic>();
		topicsList.add(new Topic("Functions",20));
		//ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
 ResultSet resultSet=null;			
			String query = "SELECT * FROM TOPICS WHERE COURSE_ID = " + courseId;
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int topicId = resultSet.getInt("topic_id");
				String topicName = resultSet.getString("topic_name");
				int minQues = resultSet.getInt("MINIMUM_NUMBER_OF_QUESTIONS_FOR_TEST");
				Topic topic = new Topic(topicId, courseId, topicName, minQues);
				topicsList.add(topic);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		return topicsList;
	}
	
	
	public ArrayList<ProgressTrackingWrapper> getProgressTrackingWrapperTableValues(int courseId,int batchId) {
		List<Topic> topicsList = new ArrayList<Topic>();
		//topicsList.add(new Topic("Functions",20));
		
		
		ArrayList<ProgressTrackingWrapper> progressTrackingWrapperList = new ArrayList<ProgressTrackingWrapper>();
		//ArrayList<ProgressTrackingWrapper> progressTrackingWrapperList1 = new ArrayList<ProgressTrackingWrapper>();
		ResultSet resultSet = null,resultSet1 = null;
		String topicsLeft;
		Integer topicsLeftDuration;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			//int topicIdsList;
			
			String query="SELECT LECTURE_COVERAGE FROM LECTURE\r\n" + 
					"WHERE BATCH_ID="+batchId;
			resultSet = statement.executeQuery(query);
			  while(resultSet.next()) {
				String topicsCovered = resultSet.getString("LECTURE_COVERAGE");
				StringTokenizer st = new StringTokenizer(topicsCovered,",");
				while(st.hasMoreTokens()) {
					int topicId=Integer.parseInt(st.nextToken());
					topicIdsSet.add(topicId);	
					} 
			  }
					
				String query1 = "select TOPIC_ID, TOPIC_NAME,TOPIC_DURATION from TOPICS where COURSE_ID= "+courseId+ "and TOPIC_ID not in "+ "("; 
				for(int topicId : topicIdsSet) {
					query1 = query1+topicId+",";
				}
				query1=query1.substring(0, query1.length()-1)+")";
				
				resultSet1 = statement.executeQuery(query1);
				
				while(resultSet1.next()) {
					 topicsLeft = resultSet1.getString("TOPIC_NAME");
					 topicsLeftDuration=resultSet1.getInt("TOPIC_DURATION");
					 progressTrackingWrapperList.add(new ProgressTrackingWrapper(topicsLeft,topicsLeftDuration,null,null,null,null,null,null));
				}
		} 
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return progressTrackingWrapperList;
	}
	public  ProgressTrackingWrapper getProgressTrackingWrapperValues(int courseId,int batchId) {
		ProgressTrackingWrapper progressTrackingWrapper = null;
		ResultSet  rs=null,resultSet = null,resultSet1 = null,resultSet2 = null,resultSet3 = null,resultSet4 = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query="SELECT LECTURE_COVERAGE FROM LECTURE\r\n" + 
					"WHERE BATCH_ID="+batchId;
			rs = statement.executeQuery(query);
			 while(rs.next()) {
					String topicsCovered = rs.getString("LECTURE_COVERAGE");
					StringTokenizer st = new StringTokenizer(topicsCovered,",");
					while(st.hasMoreTokens()) {
						int topicId=Integer.parseInt(st.nextToken());
						topicIdsSet.add(topicId);	
						} 
			 }
			int totalTopicsCovered=topicIdsSet.size();
			int totalTopics=0,duration=0,elapsedDuration=0,conductedLectures=0;
			Float totalLectures=0f,remainingLectures=0f;
			int lecDuration=0;
			String query2="SELECT DURATION FROM COURSES WHERE COURSE_ID="+courseId;
			resultSet = statement.executeQuery(query2);
			while(resultSet.next()) {
				duration=resultSet.getInt("DURATION");
				}
			String query3="SELECT LECTURE_DURATION FROM BATCH_DETAILS WHERE COURSE_ID="+courseId+
					"AND BATCH_ID="+batchId;
			resultSet1 = statement.executeQuery(query3);
			while(resultSet1.next()) {
				lecDuration=Integer.parseInt(resultSet1.getString("LECTURE_DURATION"));
				}
			String query4="SELECT COUNT(TOPIC_ID) AS TOTAL_TOPICS from TOPICS WHERE COURSE_ID="+courseId;
			resultSet2 = statement.executeQuery(query4);
			while(resultSet2.next()) {
				totalTopics=resultSet2.getInt("TOTAL_TOPICS");
				}
			String query5="SELECT COUNT(LECTURE_ID) AS CONDUCTED_LECTURES from LECTURE WHERE BATCH_ID="+batchId;
			resultSet3 = statement.executeQuery(query5);
			while(resultSet3.next()) {
				conductedLectures=resultSet3.getInt("CONDUCTED_LECTURES");
				}
			String query6="SELECT LECTURE_DURATION FROM LECTURE WHERE BATCH_ID="+batchId;
			resultSet4 = statement.executeQuery(query6);
			while(resultSet4.next()) {
				elapsedDuration+=Integer.parseInt(resultSet4.getString("LECTURE_DURATION"));
			}
			
			totalLectures=duration/getDuration(lecDuration);
			remainingLectures=totalLectures-conductedLectures;
			 progressTrackingWrapper = new ProgressTrackingWrapper(null,null,totalTopics,
					 duration,totalLectures,totalTopicsCovered,elapsedDuration,remainingLectures);
			
		} 
		
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return progressTrackingWrapper;
	}
	Float getDuration(Integer lecDuration) {
		float duration=0f;
		int minutes=lecDuration%100;
		int hours=lecDuration/100;
		duration=(hours+(minutes/60.0f));
		return duration;
	}

}
