package com.winpoint.common.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.util.sql.DateConverter;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;

public class UserProfileDao {
	
		
	public boolean updateUserProfile(UserProfile userProfile){
		
		try(Connection connection = ConnectionManager.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE USER_PROFILE SET FIRST_NAME = ?, LAST_NAME = ?,"
					+ "EMAIL_ID = ?, MOBILE_NUMBER = ?, ADDRESS = ?, BIRTHDATE = ?,"
					+ "COLLEGE = ?, DEGREE = ?, BRANCH = ?,YEAR_OF_GRADUATION = ?,"
					+ "PHOTO_LOCATION = ?, PASSWORD = ?, SECURITY_QUESTION_ID = ?,"
					+ "SECURITY_ANSWER = ?, USER_CATEGORY_ID = ?, OCCUPATION = ?,"
					+ "ORGANIZATION = ?, DESIGNATION = ?, DOMAIN = ?, ROLE = ?, EXPERIENCE = ? where USER_ID = ?");
			
			preparedStatement.setString(1, userProfile.getFirstName());
			preparedStatement.setString(2, userProfile.getLastName());
			preparedStatement.setString(3, userProfile.getEmail());
			preparedStatement.setString(4, userProfile.getMobileNumber());
			preparedStatement.setString(5, userProfile.getAddress());
			preparedStatement.setDate(6, DateConverter.convertUtilToSqlDate(userProfile.getBirthDate()));
			preparedStatement.setString(7, userProfile.getCollege());
			preparedStatement.setString(8, userProfile.getDegree());
			preparedStatement.setString(9, userProfile.getBranch());
			preparedStatement.setInt(10, userProfile.getYearOfGraduation());
			preparedStatement.setString(11, userProfile.getPhotoLocation());
			preparedStatement.setString(12, userProfile.getPassword());
			preparedStatement.setInt(13, userProfile.getSecurityQuestionId());
			preparedStatement.setString(14, userProfile.getSecurityAnswer());
			preparedStatement.setInt(15, userProfile.getUserCategoryId());
			preparedStatement.setString(16, userProfile.getOccupation());
			preparedStatement.setString(17, userProfile.getOrganisation());
			preparedStatement.setString(18, userProfile.getDesignation());
			preparedStatement.setString(19, userProfile.getDomain());
			preparedStatement.setString(20, userProfile.getRole());
			preparedStatement.setInt(21, 1);//userProfile.getExperience());
			preparedStatement.setInt(22, userProfile.getUserId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
		return true;
		
	}

	
	public ArrayList<UserProfile> getUsers() {
		ArrayList<UserProfile> allUsersList = new ArrayList<UserProfile>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "select USER_ID, FIRST_NAME, EMAIL_ID, LAST_NAME, COLLEGE, MOBILE_NUMBER\r\n" + 
					"from USER_PROFILE";
		
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				allUsersList.add(new UserProfile(rs.getInt("USER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL_ID"), rs.getString("MOBILE_NUMBER"), rs.getString("COLLEGE")));
			}
			
		} 
		catch (SQLException e) {
			allUsersList = null;
			e.printStackTrace();
		}
		
		return allUsersList;
	}

	//Group A : Faculty Access ~ Abhishek
	public ArrayList<UserProfile> getFaculty(){
		
		List<UserProfile> facultyList = new ArrayList<UserProfile>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "select * from USER_PROFILE\n" + 
					"where USER_CATEGORY_ID = 2" + 
					"";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				facultyList.add(new UserProfile(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getInt("USER_ID")));
				
			}
			
		} 
		catch (SQLException e) {
			facultyList = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<UserProfile>) facultyList;
		
	}
	
	public String getCoursesList(Integer userId) {
		StringBuilder coursesString = new StringBuilder("");		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "select COURSE_NAME\r\n" + 
					"from STUDENT_COURSE_DETAILS join COURSES on COURSES.COURSE_ID = STUDENT_COURSE_DETAILS.COURSE_ID\r\n" + 
					"where USER_ID = " + userId;
			
			ResultSet rs = statement.executeQuery(query);


			while(rs.next()) {
				coursesString.append(rs.getString("COURSE_NAME") + ", ");
			}
			
			if(coursesString.toString().equals("")) {
				coursesString.append("None");
			}
			else {
				coursesString.replace(coursesString.length() - 2, coursesString.length(), " ");
			}
			
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coursesString.toString();
	}
	 
	public ArrayList<UserProfile> getRegisteredUsers(){
		
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT FIRST_NAME, LAST_NAME FROM USER_PROFILE\n" + 
					"";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				userProfileList.add(new UserProfile(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),true));
				
			}
			
		} 
		catch (SQLException e) {
			userProfileList = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<UserProfile>) userProfileList;
		
	}

	public ArrayList<BatchIndividualFeedbackScreenWrapper> getBatchIndividualFeedbackScreenWrapperList(Integer batchId) {
		
		ArrayList<BatchIndividualFeedbackScreenWrapper> batchWrapperList = new ArrayList<BatchIndividualFeedbackScreenWrapper>();
		BatchIndividualFeedbackScreenWrapper batchIndividualFeedbackScreenWrapper;
		ResultSet resultSet = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT up1.USER_ID, up1.FIRST_NAME, up1.LAST_NAME, up2.FIRST_NAME + ' ' + up2.LAST_NAME AS INSTRUCTOR_NAME, up1.EMAIL_ID, up1.MOBILE_NUMBER, c.DURATION, scd1.FEEDBACK_GIVEN \r\n" + 
					"FROM USER_PROFILE AS up1 \r\n" + 
					"INNER JOIN\r\n" + 
					"STUDENT_COURSE_DETAILS AS scd1\r\n" + 
					"ON up1.USER_ID = scd1.USER_ID\r\n" + 
					"INNER JOIN\r\n" + 
					"COURSES AS c\r\n" + 
					"ON c.COURSE_ID = scd1.COURSE_ID\r\n" + 
					"INNER JOIN\r\n" + 
					"USER_PROFILE AS up2\r\n" + 
					"ON up2.USER_ID = (SELECT FACULTY_USER_ID FROM BATCH_DETAILS WHERE BATCH_ID = "+ batchId + ")\r\n" + 
					"WHERE scd1.BATCH_ID = " + batchId;
			
			
			resultSet  = statement.executeQuery(query1);
			String feedbackGiven;
			
			while(resultSet.next()) {
				feedbackGiven = (resultSet.getString("FEEDBACK_GIVEN")==null)?"NO":"YES";
				batchIndividualFeedbackScreenWrapper = new BatchIndividualFeedbackScreenWrapper(resultSet.getInt("USER_ID"),resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"),resultSet.getString("INSTRUCTOR_NAME"), 
						resultSet.getInt("DURATION"),resultSet.getString("EMAIL_ID"), 
						resultSet.getString("MOBILE_NUMBER"), feedbackGiven);
						batchWrapperList.add(batchIndividualFeedbackScreenWrapper);			}

		} 
		catch (SQLException e) {
			batchWrapperList = null;
			e.printStackTrace();
		}
		
		return  batchWrapperList;
	}	
	
	public ArrayList<UserProfile> getStudentListForBatch(Integer batchId){
		
		ArrayList<UserProfile> studentList = new ArrayList<UserProfile>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT up.USER_ID, up.FIRST_NAME, up.LAST_NAME\r\n" + 
					"FROM USER_PROFILE AS up\r\n" + 
					"INNER JOIN \r\n" + 
					"STUDENT_COURSE_DETAILS AS scd\r\n" + 
					"ON scd.USER_ID = up.USER_ID\r\n" + 
					"WHERE scd.BATCH_ID =" + batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				studentList.add(new UserProfile(resultSet.getInt("USER_ID"), resultSet.getString("FIRST_NAME"), 
								resultSet.getString("LAST_NAME"), null, null, null));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  studentList;	
	}
}
