package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class TransferEnquiryDetailsToUserProfileDao {
	
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

	public void functionEnquiredStudent(UserCoursesDoneWrapper user, Integer courseId, Integer batchId, ManageRevenue revenueDetail, StudentCourseInstallmentDetails studentCourseInstallmentObject) throws SQLException {
		// TODO Auto-generated method stub

//		 *	1). insert into user profile
//		 *  2). insert into studentcourseDetail
//		 *  3). delete from enquiry detail
			
		
		int latestUserId = accessLatestUserId();

		EnquiryDetails enquiryDetails = (EnquiryDetails)user.getUserProfile();
		int id = enquiryDetails.getEnquiryId();
		System.out.println("ID : "+id);
		if(enquiryDetails.getBirthDate()==null) {
			System.out.println("*************NULL****************");
		}
		
		java.sql.Date sqlBirthDate = new java.sql.Date(enquiryDetails.getBirthDate().getTime());
		java.sql.Date sqlRecieveDate = new java.sql.Date(revenueDetail.getRecieveDate().getTime());
		java.sql.Date sqActualInstallmentDate = new java.sql.Date(studentCourseInstallmentObject.getActualInstallment1Date().getTime());
		
		int active; 
		if(enquiryDetails.getActiveStatus()) {
			active = 1;
		}else {
			active = 0;
		}
		
		    PreparedStatement insertUserProfile = null;
		    PreparedStatement insertStudentCourseDetail = null;
		    PreparedStatement deleteEnquiryDetails = null;
		    PreparedStatement insertManageRevenue = null;
		    PreparedStatement insertStudentCourseInstalment = null;
		    
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
							"'"+enquiryDetails.getFirstName()+"@"+123+"',\n" + 
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
							""+active+"\n" + 
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
							"	"+latestUserId+",\n" + 
							"	"+courseId+",\n" + 
							"	"+batchId+"\n" + 
							")";

		    String insertManageRevenueQuery = "INSERT INTO REVENUE_DETAIL \n" +
					"(\n" +
					"REVENUE_TYPE_ID, \n" +
					"RECIEPT_NUMBER, \n" +
					"PAYER_DESCRIPTION, \n" +
					"COURSE_ID, \n" +
					"BATCH_ID, \n" +
					"REVENUE_AMOUNT, \n" +
					"PAYMENT_MODE_ID, \n" +
					"CHEQUE_NUMBER, \n" +
					"SEGMENT_TYPE_ID, \n" +
					"ORGANIZATION_ID, \n" +
					"USER_ID, \n" +
					"RECIEVE_DATE)\n" +
					"VALUES("+
					revenueDetail.getRevenueTypeId()+",'"+
					revenueDetail.getRecieptNumber()+"','"+
					revenueDetail.getPayerDescription()+"','"+
					revenueDetail.getCourseId()+"','"+	
					revenueDetail.getBatchId()+"','"+
					revenueDetail.getRevenueAmount()+"','"+
					revenueDetail.getPaymentModeId()+"','"+
					revenueDetail.getChequeNumber()+"','"+
					revenueDetail.getSegmentTypeId()+"','"+
					revenueDetail.getOrganizationId()+"','"+
					revenueDetail.getUserId()+"','"+
					sqlRecieveDate+"')";

		    String insertStudentCourseInstalmentQuery = "INSERT INTO STUDENT_COURSE_INSTALLMENT_DETAILS \n" +
					"(USER_ID"+","+
					"COURSE_ID"+","+
					"ACTUAL_INSTALLMENT1_DATE)\n "+
					"VALUES("+
					latestUserId+","+
					studentCourseInstallmentObject.getCourseId()+",'"+
					sqActualInstallmentDate+"')";
		    
		    String deleteEnquiryDetailsQuery = 
		    		"DELETE FROM ENQUIRY_DETAILS\n" + 
							"WHERE ENQUIRY_ID = "+id;

		    Connection connection = ConnectionManager.getConnection();
		    try {
		        connection.setAutoCommit(false);
		        insertUserProfile = connection.prepareStatement(insertUserProfileQuery);
		        insertStudentCourseDetail = connection.prepareStatement(insertStudentCourseDetailQuery);
		        insertManageRevenue = connection.prepareStatement(insertManageRevenueQuery);
		        insertStudentCourseInstalment = connection.prepareStatement(insertStudentCourseInstalmentQuery);
		        deleteEnquiryDetails = connection.prepareStatement(deleteEnquiryDetailsQuery);

		        
		        	System.out.println(insertUserProfileQuery);
		            insertUserProfile.executeUpdate();
		            System.out.println(insertStudentCourseDetailQuery);
		            insertStudentCourseDetail.executeUpdate();
		            System.out.println(insertManageRevenueQuery);
		            insertManageRevenue.executeUpdate();
		            System.out.println(insertStudentCourseInstalmentQuery);
		            insertStudentCourseInstalment.executeUpdate();
		            System.out.println(deleteEnquiryDetailsQuery);
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


	
	
	
	
	
	public void functionRegisteredStudent(UserCoursesDoneWrapper user, Integer courseId, Integer batchId, ManageRevenue revenueDetail, StudentCourseInstallmentDetails studentCourseInstallmentObject) throws SQLException {
		// TODO Auto-generated method stub

		UserProfile userDetails = user.getUserProfile();
		int id = userDetails.getUserId();
		System.out.println("ID : "+id);
		if(userDetails.getBirthDate()==null) {
			System.out.println("*************NULL****************");
		}
		
		java.sql.Date sqlRecieveDate = new java.sql.Date(revenueDetail.getRecieveDate().getTime());
		java.sql.Date sqActualInstallmentDate = new java.sql.Date(studentCourseInstallmentObject.getActualInstallment1Date().getTime());
		
		
		    PreparedStatement insertUserProfile = null;
		    PreparedStatement insertStudentCourseDetail = null;
		    PreparedStatement insertManageRevenue = null;
		    PreparedStatement insertStudentCourseInstalment = null;

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

		    String insertManageRevenueQuery = "INSERT INTO REVENUE_DETAIL \n" +
					"(\n" +
					"REVENUE_TYPE_ID, \n" +
					"RECIEPT_NUMBER, \n" +
					"PAYER_DESCRIPTION, \n" +
					"COURSE_ID, \n" +
					"BATCH_ID, \n" +
					"REVENUE_AMOUNT, \n" +
					"PAYMENT_MODE_ID, \n" +
					"CHEQUE_NUMBER, \n" +
					"SEGMENT_TYPE_ID, \n" +
					"ORGANIZATION_ID, \n" +
					"USER_ID, \n" +
					"RECIEVE_DATE)\n" +
					"VALUES("+
					revenueDetail.getRevenueTypeId()+",'"+
					revenueDetail.getRecieptNumber()+"','"+
					revenueDetail.getPayerDescription()+"','"+
					revenueDetail.getCourseId()+"','"+	
					revenueDetail.getBatchId()+"','"+
					revenueDetail.getRevenueAmount()+"','"+
					revenueDetail.getPaymentModeId()+"','"+
					revenueDetail.getChequeNumber()+"','"+
					revenueDetail.getSegmentTypeId()+"','"+
					revenueDetail.getOrganizationId()+"','"+
					revenueDetail.getUserId()+"','"+
					sqlRecieveDate+"')";

		    String insertStudentCourseInstalmentQuery = "INSERT INTO STUDENT_COURSE_INSTALLMENT_DETAILS \n" +
					"(USER_ID"+","+
					"COURSE_ID"+","+
					"ACTUAL_INSTALLMENT1_DATE)\n "+
					"VALUES("+
					id+","+
					studentCourseInstallmentObject.getCourseId()+",'"+
					sqActualInstallmentDate+"')";


		    Connection connection = ConnectionManager.getConnection();
		    try {
		        connection.setAutoCommit(false);
		        insertStudentCourseDetail = connection.prepareStatement(insertStudentCourseDetailQuery);
		        insertManageRevenue = connection.prepareStatement(insertManageRevenueQuery);
		        insertStudentCourseInstalment = connection.prepareStatement(insertStudentCourseInstalmentQuery);
		        		        
		        System.out.println(insertStudentCourseDetailQuery);
		        insertStudentCourseDetail.executeUpdate();
		        System.out.println(insertManageRevenueQuery);
		        insertManageRevenue.executeUpdate();
		        System.out.println(insertStudentCourseInstalmentQuery);
		        insertStudentCourseInstalment.executeUpdate();
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
