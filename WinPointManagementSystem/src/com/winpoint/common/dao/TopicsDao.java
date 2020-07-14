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

	public List<Topic> getTopicsList(int courseId) {
		List<Topic> topicsList = new ArrayList<Topic>();
		topicsList.add(new Topic("Functions",20));
		//ResultSet resultSet = null;
		
		/*try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
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
		}*/ 
		return topicsList;
	}
	public ArrayList<ProgressTrackingWrapper> getProgressTrackingWrapper1(int courseId,int batchId) {
		List<Topic> topicsList = new ArrayList<Topic>();
		//topicsList.add(new Topic("Functions",20));
		
		
		ArrayList<ProgressTrackingWrapper> progressTrackingWrapperList = new ArrayList<ProgressTrackingWrapper>();
		ResultSet resultSet = null,resultSet1 = null;
		String topicsLeft;
		Integer topicsLeftDuration;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			//int topicIdsList;
			
			String query="SELECT LECTURE_COVERAGE FROM LECTURE\r\n" + 
					"WHERE BATCH_ID="+batchId;
			resultSet = statement.executeQuery(query);
			Set<Integer> topicIdsSet = new HashSet<>();
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
					//System.out.println(topicId);
					query1 = query1+topicId+",";
				}
				query1=query1.substring(0, query1.length()-1)+")";
				
				resultSet1 = statement.executeQuery(query1);
				
				while(resultSet1.next()) {
					 topicsLeft = resultSet1.getString("TOPIC_NAME");
					 topicsLeftDuration=resultSet1.getInt("TOPIC_DURATION");
					 progressTrackingWrapperList.add(new ProgressTrackingWrapper(topicsLeft,topicsLeftDuration));
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

}
