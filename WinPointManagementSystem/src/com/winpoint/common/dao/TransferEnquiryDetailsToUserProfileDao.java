package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class TransferEnquiryDetailsToUserProfileDao {

//	public void transactionMethod(Integer userId, List<EnquiryDetails> list, Integer courseId, Integer batchId) {
//		
////	 *	1). insert into user profile
////	 *  2). insert into studentcourseDetail
////	 *  3). delete from enquiry detail
//		
////		
////		UserProfileHelper userProfileHelper = new UserProfileHelper();
////		userProfileHelper.create(userId,list);
////		
////		StudentCourseDetailsHelper studentCourseDetailsHelper = new StudentCourseDetailsHelper();
////		studentCourseDetailsHelper.create(userId,courseId,batchId);
////		
////		EnquiryDetailsHelper enquiryDetailsHelper = new EnquiryDetailsHelper();
////		enquiryDetailsHelper.getEnquiryDetailsOfStudent(userId);
//		
//	}
	
	public int accessLatestUserId() {
		
		System.out.println("WELCOME TO ACCESSLATESTUSERID");
//		UserProfile userId = null;
		int userId = 0;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "select max (user_id) as USER_ID\n" + 
					"from USER_PROFILE";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
//				userId = new UserProfile(resultSet.getInt("USER_ID"));
				userId = resultSet.getInt("USER_ID");
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("USER ID ACCESSED : "+userId);
		return userId;
	}
	
	
	public void function(UserCoursesDoneWrapper user, List<EnquiryDetails> list, Integer courseId, Integer batchId)
		    throws SQLException {

//		 *	1). insert into user profile
//		 *  2). insert into studentcourseDetail
//		 *  3). delete from enquiry detail
		System.out.println("Function call");
		int accessedUserId = accessLatestUserId();
		System.out.println("GOT THE ID : "+accessedUserId);
		
		
		EnquiryDetails enquiryDetails = (EnquiryDetails)user.getUserProfile();
		int id = enquiryDetails.getEnquiryId();
		System.out.println("ID : "+id);
		if(enquiryDetails.getBirthDate()==null) {
			System.out.println("*************NULL****************");
		}
		
		java.sql.Date sqlBirthDate = new java.sql.Date(enquiryDetails.getBirthDate().getTime());

		
		    PreparedStatement insertUserProfile = null;
		    PreparedStatement insertStudentCourseDetail = null;
		    PreparedStatement deleteEnquiryDetails = null;
		    
		    
		    
		    String insertUserProfileQuery =
		    		"INSERT INTO USER_PROFILE\n" + 
							"(\n" + 
							"	FIRST_NAME,\n" + 
							"	LAST_NAME,\n" + 
							"	EMAIL_ID,\n" + 
							"	MOBILE_NUMBER,\n" + 
							"	ADDRESS,\n" + 
							"	BIRTHDATE,\n" + 
							"	COLLEGE,\n" + 
							"	DEGREE,\n" + 
							"	BRANCH,\n" + 
							"	PASSWORD,\n" + 
							"	OCCUPATION,\n" + 
							"	ORGANIZATION,\n" + 
							"	DESIGNATION,\n" + 
							"	DOMAIN,\n" + 
							"	ROLE,\n" + 
							"	EXPERIENCE,\n" + 
							"	GENDER,\n" + 
							"	YEAR_OF_GRADUATION,\n" + 
							"	TIME_SLOTS_IDS,\n" + 
							"	SEGMENT_TYPE_ID,\n" + 
							"	COURSE_ALREADY_DONE,\n" + 
							"	ACTIVE_STATUS\n" + 
							")\n" + 
							"VALUES(\n" + 
							"'"+enquiryDetails.getFirstName()+"',\n" + 
							"'"+enquiryDetails.getLastName()+"',\n" + 
							"'"+enquiryDetails.getEmail()+"',\n" + 
							"'"+enquiryDetails.getMobileNumber()+"',\n" + 
							"'"+enquiryDetails.getAddress()+"',\n" + 
							"'"+sqlBirthDate+"',\n" + 
							"'"+enquiryDetails.getCollege()+"',\n" + 
							"'"+enquiryDetails.getDegree()+"',\n" + 
							"'"+enquiryDetails.getBranch()+"',\n" + 
							"'"+enquiryDetails.getFirstName()+"@"+sqlBirthDate+"',\n" + 
							"'"+enquiryDetails.getOccupation()+"',\n" + 
							"'"+enquiryDetails.getOrganisation()+"',\n" + 
							"'"+enquiryDetails.getDesignation()+"',\n" + 
							"'"+enquiryDetails.getDomain()+"',\n" + 
							"'"+enquiryDetails.getRole()+"',\n" + 
							""+enquiryDetails.getExperience()+",\n" + 
							"'"+enquiryDetails.getGender()+"',\n" + 
							""+enquiryDetails.getYearOfGraduation()+",\n" + 
							"'"+enquiryDetails.getTimeSlotsId()+"',\n" + 
							""+enquiryDetails.getSegmentTypeId()+",\n" + 
							"'"+enquiryDetails.getCourseAlreadyDone()+"',\n" + 
							""+enquiryDetails.getActiveStatus()+"\n" + 
							")";


		    String insertStudentCourseDetailQuery =
		    		"INSERT INTO STUDENT_COURSE_DETAILS\n" + 
							"(\n" + 
							"	USER_ID,\n" + 
							"	COURSE_ID,\n" + 
							"	BATCH_ID\n" + 
							")\n" + 
							"VALUES\n" + 
							"(\n" + 
							"	"+accessedUserId+",\n" + 
							"	"+courseId+",\n" + 
							"	"+batchId+"\n" + 
							")";


		    String deleteEnquiryDetailsQuery = 
		    		"DELETE FROM ENQUIRY_DETAILS\n" + 
							"WHERE ENQUIRY_ID = "+accessedUserId;

		    Connection connection = ConnectionManager.getConnection();
		    try {
		        connection.setAutoCommit(false);
		        insertUserProfile = connection.prepareStatement(insertUserProfileQuery);
		        insertStudentCourseDetail = connection.prepareStatement(insertStudentCourseDetailQuery);
		        deleteEnquiryDetails = connection.prepareStatement(deleteEnquiryDetailsQuery);

		        	System.out.println(insertUserProfileQuery);
		            insertUserProfile.executeUpdate();
		            insertStudentCourseDetail.executeUpdate();
		            deleteEnquiryDetails.executeUpdate();
		            connection.commit();
		            
		    } catch (SQLException e ) {
		        //JDBCTutorialUtilities.printSQLException(e);
		        if (connection != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                connection.rollback();
		            } catch(SQLException excep) {
		                //JDBCTutorialUtilities.printSQLException(excep);
		            }
		        }
		    } finally {
		        if (insertUserProfile != null) {
		            insertUserProfile.close();
		        }
		        if (insertStudentCourseDetail != null) {
		            insertStudentCourseDetail.close();
		        }
		        connection.setAutoCommit(true);
		    }
		}

	public void function(UserCoursesDoneWrapper user, Integer courseId, Integer batchId) throws SQLException {
		// TODO Auto-generated method stub

//		 *	1). insert into user profile
//		 *  2). insert into studentcourseDetail
//		 *  3). delete from enquiry detail
			

		EnquiryDetails enquiryDetails = (EnquiryDetails)user.getUserProfile();
		int id = enquiryDetails.getEnquiryId();
		System.out.println("ID : "+id);
		if(enquiryDetails.getBirthDate()==null) {
			System.out.println("*************NULL****************");
		}
		
		java.sql.Date sqlBirthDate = new java.sql.Date(enquiryDetails.getBirthDate().getTime());

		
		    PreparedStatement insertUserProfile = null;
		    PreparedStatement insertStudentCourseDetail = null;
		    PreparedStatement deleteEnquiryDetails = null;
		    
		    String insertUserProfileQuery =
		    		"INSERT INTO USER_PROFILE\n" + 
							"(\n" + 
							"	FIRST_NAME,\n" + 
							"	LAST_NAME,\n" + 
							"	EMAIL_ID,\n" + 
							"	MOBILE_NUMBER,\n" + 
							"	ADDRESS,\n" + 
							"	BIRTHDATE,\n" + 
							"	COLLEGE,\n" + 
							"	DEGREE,\n" + 
							"	BRANCH,\n" + 
							"	PASSWORD,\n" + 
							"	OCCUPATION,\n" + 
							"	ORGANIZATION,\n" + 
							"	DESIGNATION,\n" + 
							"	DOMAIN,\n" + 
							"	ROLE,\n" + 
							"	EXPERIENCE,\n" + 
							"	GENDER,\n" + 
							"	YEAR_OF_GRADUATION,\n" + 
							"	TIME_SLOTS_IDS,\n" + 
							"	SEGMENT_TYPE_ID,\n" + 
							"	COURSE_ALREADY_DONE,\n" + 
							"	ACTIVE_STATUS\n" + 
							")\n" + 
							"VALUES(\n" + 
							"'"+enquiryDetails.getFirstName()+"',\n" + 
							"'"+enquiryDetails.getLastName()+"',\n" + 
							"'"+enquiryDetails.getEmail()+"',\n" + 
							"'"+enquiryDetails.getMobileNumber()+"',\n" + 
							"'"+enquiryDetails.getAddress()+"',\n" + 
							"'"+sqlBirthDate+"',\n" + 
							"'"+enquiryDetails.getCollege()+"',\n" + 
							"'"+enquiryDetails.getDegree()+"',\n" + 
							"'"+enquiryDetails.getBranch()+"',\n" + 
							"'"+enquiryDetails.getFirstName()+"@"+sqlBirthDate+"',\n" + 
							"'"+enquiryDetails.getOccupation()+"',\n" + 
							"'"+enquiryDetails.getOrganisation()+"',\n" + 
							"'"+enquiryDetails.getDesignation()+"',\n" + 
							"'"+enquiryDetails.getDomain()+"',\n" + 
							"'"+enquiryDetails.getRole()+"',\n" + 
							""+enquiryDetails.getExperience()+",\n" + 
							"'"+enquiryDetails.getGender()+"',\n" + 
							""+enquiryDetails.getYearOfGraduation()+",\n" + 
							"'"+enquiryDetails.getTimeSlotsId()+"',\n" + 
							""+enquiryDetails.getSegmentTypeId()+",\n" + 
							"'"+enquiryDetails.getCourseAlreadyDone()+"',\n" + 
							""+enquiryDetails.getActiveStatus()+"\n" + 
							")";


		    String insertStudentCourseDetailQuery =
		    		"INSERT INTO STUDENT_COURSE_DETAILS\n" + 
							"(\n" + 
							"	USER_ID,\n" + 
							"	COURSE_ID,\n" + 
							"	BATCH_ID\n" + 
							")\n" + 
							"VALUES\n" + 
							"(\n" + 
							"	"+id+",\n" + 
							"	"+courseId+",\n" + 
							"	"+batchId+"\n" + 
							")";


		    String deleteEnquiryDetailsQuery = 
		    		"DELETE FROM ENQUIRY_DETAILS\n" + 
							"WHERE ENQUIRY_ID = "+id;

		    Connection connection = ConnectionManager.getConnection();
		    try {
		        connection.setAutoCommit(false);
		        insertUserProfile = connection.prepareStatement(insertUserProfileQuery);
		        insertStudentCourseDetail = connection.prepareStatement(insertStudentCourseDetailQuery);
		        deleteEnquiryDetails = connection.prepareStatement(deleteEnquiryDetailsQuery);

		        	System.out.println(insertUserProfileQuery);
		            insertUserProfile.executeUpdate();
		            insertStudentCourseDetail.executeUpdate();
		            deleteEnquiryDetails.executeUpdate();
		            connection.commit();
		    } catch (SQLException e ) {
		        //JDBCTutorialUtilities.printSQLException(e);
		        if (connection != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                connection.rollback();
		            } catch(SQLException excep) {
		                //JDBCTutorialUtilities.printSQLException(excep);
		            }
		        }
		    } finally {
		        if (insertUserProfile != null) {
		            insertUserProfile.close();
		        }
		        if (insertStudentCourseDetail != null) {
		            insertStudentCourseDetail.close();
		        }
		        connection.setAutoCommit(true);
		    }
		    
	}
	
}
