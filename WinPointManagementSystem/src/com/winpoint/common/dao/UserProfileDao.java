package com.winpoint.common.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
		String query = null;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			query = "SELECT up.USER_ID, up.FIRST_NAME, up.LAST_NAME, up.EMAIL_ID, up.COLLEGE, up.MOBILE_NUMBER, up.COURSE_ALREADY_DONE\r\n" + 
					"FROM USER_PROFILE AS up\r\n" + 
					"INNER JOIN \r\n" + 
					"STUDENT_COURSE_DETAILS AS scd\r\n" + 
					"ON scd.USER_ID = up.USER_ID\r\n" + 
					"WHERE scd.BATCH_ID =" + batchId;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				studentList.add(new UserProfile(resultSet.getInt("USER_ID"), resultSet.getString("FIRST_NAME"), 
								resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL_ID"), resultSet.getString("MOBILE_NUMBER"), resultSet.getString("COLLEGE")));
			}
			String coursesDone = "";
			for(UserProfile user : studentList) {
				System.out.println("From UserProfile : userName = " + user.getFirstName());
				query = "SELECT COURSES.COURSE_NAME FROM  STUDENT_COURSE_DETAILS AS SC\r\n" + 
						"INNER JOIN COURSES\r\n" + 
						"ON SC.COURSE_ID = COURSES.COURSE_ID\r\n" + 
						"WHERE SC.COURSE_ID IN (SELECT SC.COURSE_ID FROM STUDENT_COURSE_DETAILS WHERE SC.USER_ID = " + user.getUserId() + ")";
				resultSet = statement.executeQuery(query);
				coursesDone = "";
				while(resultSet.next()) {
					coursesDone += resultSet.getString("COURSE_NAME") + ",";
				}
				coursesDone = coursesDone.substring(0, coursesDone.length()-1);
				System.out.println("Courses done = " + coursesDone);
				user.setCourseAlreadyDone(coursesDone);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return  studentList;	
	}
<<<<<<< HEAD

=======
>>>>>>> 9d996c3385a6aacf2c0786640f2802229f1e3650


	public UserProfile getUserProfile(int userId) {
		// TODO Auto-generated method stub
		UserProfile userProfile = null;
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT FIRST_NAME, LAST_NAME, EMAIL_ID, PASSWORD, USER_CATEGORY.USER_CATEGORY_ID, USER_CATEGORY_NAME, EMPLOYEE_CATEGORY.EMPLOYEE_CATEGORY_ID,\r\n" + 
					"PHOTO_LOCATION, MOBILE_NUMBER, ADDRESS, BIRTHDATE, COLLEGE, DEGREE, BRANCH, YEAR_OF_GRADUATION, SECURITY_QUESTION_ID, SECURITY_ANSWER, OCCUPATION,\r\n" + 
					"ORGANIZATION, DESIGNATION, DOMAIN, ROLE, EXPERIENCE, GENDER\r\n" + 
					"FROM USER_PROFILE JOIN USER_CATEGORY\r\n" + 
					"ON USER_PROFILE.USER_CATEGORY_ID = USER_CATEGORY.USER_CATEGORY_ID\r\n" + 
					"LEFT OUTER JOIN EMPLOYEE_DETAILS D\r\n" + 
					"ON USER_PROFILE.USER_ID = D.USER_ID\r\n" + 
					"LEFT OUTER JOIN EMPLOYEE_CATEGORY\r\n" + 
					"ON D.EMPLOYEE_CATEGORY_ID = EMPLOYEE_CATEGORY.EMPLOYEE_CATEGORY_ID\r\n" + 
					"WHERE USER_PROFILE.USER_ID = " + userId ; 
					//""; 
					
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String emailId = resultSet.getString("EMAIL_ID");
				String password = resultSet.getString("PASSWORD");
				Integer userCategoryId = resultSet.getInt("USER_CATEGORY_ID");
				//String userCategoryName = resultSet.getString("USER_CATEGORY_NAME");
				//String employeeCategoryId = resultSet.getString("EMPLOYEE_CATEGORY_ID");
				String photoLocation = resultSet.getString("PHOTO_LOCATION");
				String mobileNumber = resultSet.getString("Mobile_NUMBER");
				String address = resultSet.getString("ADDRESS");
				Date birthDate = DateConverter.convertSqlToUtilDate(resultSet.getDate("BIRTHDATE"));				
				String college = resultSet.getString("COLLEGE");
				String degree = resultSet.getString("DEGREE");
				String branch = resultSet.getString("BRANCH");
				Integer yearOfGraduation = resultSet.getInt("YEAR_OF_GRADUATION");
				Integer securityQuestionId = resultSet.getInt("SECURITY_QUESTION_ID");
				String securityQuestion = "Question";
				String securityAnswer = resultSet.getString("SECURITY_ANSWER");
				String occupation = resultSet.getString("OCCUPATION");
				String organisation = resultSet.getString("ORGANIZATION");
				String designation = resultSet.getString("DESIGNATION");
				String domain = resultSet.getString("DOMAIN");
				String role = resultSet.getString("ROLE");
				Integer experience = resultSet.getInt("EXPERIENCE");
				String gender = resultSet.getString("GENDER");
	           
				userProfile = new UserProfile(userId, firstName, lastName, emailId, mobileNumber,
						address, birthDate, college, degree, branch, yearOfGraduation,
						photoLocation, password, gender, securityQuestionId, securityQuestion,
						securityAnswer, userCategoryId, occupation, organisation, designation,
						domain, role, experience);
			}
			else {
				System.out.println("UserProfileDao : NO USER FOUND");
			}
		}catch(SQLException sqe){
			System.out.println("UserProfileDao : EXCEPTION" + sqe);
		}
		return userProfile;
	}


//	public void create(Integer userId, List<EnquiryDetails> list) {
//		//java.sql.Date sqlBirthDate = new java.sql.Date(enquiryDetails.getBirthDate().getTime());
//		java.sql.Date sqlBirthDate = new java.sql.Date(list.get(userId).getBirthDate().getTime());
//		
//		try(Connection connection = ConnectionManager.getConnection()){
//			Statement statement = connection.createStatement();
//			
//			String query = "INSERT INTO USER_PROFILE\n" + 
//					"(\n" + 
//					"	FIRST_NAME,\n" + 
//					"	LAST_NAME,\n" + 
//					"	EMAIL_ID,\n" + 
//					"	MOBILE_NUMBER,\n" + 
//					"	ADDRESS,\n" + 
//					"	BIRTHDATE,\n" + 
//					"	COLLEGE,\n" + 
//					"	DEGREE,\n" + 
//					"	BRANCH,\n" + 
//					"	PASSWORD,\n" + 
//					"	OCCUPATION,\n" + 
//					"	ORGANIZATION,\n" + 
//					"	DESIGNATION,\n" + 
//					"	DOMAIN,\n" + 
//					"	ROLE,\n" + 
//					"	EXPERIENCE,\n" + 
//					"	GENDER,\n" + 
//					"	YEAR_OF_GRADUATION,\n" + 
//					"	TIME_SLOTS_IDS,\n" + 
//					"	SEGMENT_TYPE_ID,\n" + 
//					"	COURSE_ALREADY_DONE,\n" + 
//					"	ACTIVE_STATUS\n" + 
//					")\n" + 
//					"VALUES(\n" + 
//					"'"+list.get(userId).getFirstName()+"',\n" + 
//					"'"+list.get(userId).getLastName()+"',\n" + 
//					"'"+list.get(userId).getEmail()+"',\n" + 
//					"'"+list.get(userId).getMobileNumber()+"',\n" + 
//					"'"+list.get(userId).getAddress()+"',\n" + 
//					"'"+sqlBirthDate+"',\n" + 
//					"'"+list.get(userId).getCollege()+"',\n" + 
//					"'"+list.get(userId).getDegree()+"',\n" + 
//					"'"+list.get(userId).getBranch()+"',\n" + 
//					"'"+list.get(userId).getFirstName()+"@"+sqlBirthDate+"',\n" + 
//					"'"+list.get(userId).getOccupation()+"',\n" + 
//					"'"+list.get(userId).getOrganisation()+"',\n" + 
//					"'"+list.get(userId).getDesignation()+"',\n" + 
//					"'"+list.get(userId).getDomain()+"',\n" + 
//					"'"+list.get(userId).getRole()+"',\n" + 
//					""+list.get(userId).getExperience()+",\n" + 
//					"'"+list.get(userId).getGender()+"',\n" + 
//					""+list.get(userId).getYearOfGraduation()+",\n" + 
//					"'"+list.get(userId).getTimeSlotsId()+"',\n" + 
//					""+list.get(userId).getSegmentTypeId()+",\n" + 
//					"'"+list.get(userId).getCourseAlreadyDone()+"',\n" + 
//					""+list.get(userId).getActiveStatus()+"\n" + 
//					")";
//			
//			statement.executeUpdate(query);
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
	
<<<<<<< HEAD

=======
>>>>>>> 9d996c3385a6aacf2c0786640f2802229f1e3650
}
