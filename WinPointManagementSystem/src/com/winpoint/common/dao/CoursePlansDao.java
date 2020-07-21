package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import com.winpoint.common.beans.CoursePlans;
import com.winpoint.common.util.sql.ConnectionManager;

public class CoursePlansDao {
	public CoursePlans getCoursePlan(Integer courseId, Integer lectureNumber){
		CoursePlans coursePlans = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringTokenizer topicIds = null;
			String[] topicList = null;
			String query = "SELECT * FROM COURSE_PLANS\r\n" + 
					"WHERE COURSE_ID = " + courseId + " AND LECTURE_NUMBER = " + lectureNumber;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				topicIds = new StringTokenizer(resultSet.getString("LECTURE_PLAN"), ",");
			}
			
			int i = 0;
			topicList = new String[topicIds.countTokens()];
			while(topicIds.hasMoreTokens()){
				
				String query2 = "SELECT TOPIC_NAME\r\n" + 
						"FROM TOPICS\r\n" + 
						"WHERE TOPIC_ID =" + Integer.parseInt(topicIds.nextToken());
				
				ResultSet resultSet2 = statement.executeQuery(query2);
				
				while(resultSet2.next()) {
					topicList[i] = resultSet2.getString("TOPIC_NAME");
				}
				i++;
			}
//			for(String s: topicList) {
//				System.out.println(s);
//			}
			
			coursePlans = new CoursePlans(courseId, lectureNumber, topicList);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  coursePlans;
		
	}
}
