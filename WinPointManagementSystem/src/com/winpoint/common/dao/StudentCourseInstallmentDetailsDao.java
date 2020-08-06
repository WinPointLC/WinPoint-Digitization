package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

public class StudentCourseInstallmentDetailsDao {
	
	
	//GROUP A ~ FOR REVENUE MANAGEMENT SCREEN TO INSERT IN PLANNED INSTALLMENT	
	public void getPaymentDetail(StudentCourseInstallmentDetails revenueDetail){
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
		
			java.sql.Date sqActualInstallmentDate = new java.sql.Date(revenueDetail.getActualInstallment1Date().getTime());
			
			String query = "\n" + 

			"INSERT INTO STUDENT_COURSE_INSTALLMENT_DETAILS \n" +
					"(USER_ID"+","+
					"COURSE_ID"+","+
					"ACTUAL_INSTALLMENT1_DATE)\n "+
					"VALUES("+
					revenueDetail.getUserId()+","+
					revenueDetail.getCourseId()+",'"+
					sqActualInstallmentDate+"')";
				
			 System.out.println(query);
			 statement.executeUpdate(query);
			
		}catch(SQLException e) {			
			e.printStackTrace();
		}
			
	}	

	
	public ArrayList<FeeRecordsScreenWrapper> getFeeRecordsScreenWrapperList(Integer batchId) {		
		ArrayList<FeeRecordsScreenWrapper> feeRecordsScreenWrapperList = new ArrayList<>();
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT scd1.USER_ID, up1.FIRST_NAME, up1.LAST_NAME, up1.EMAIL_ID, up1.MOBILE_NUMBER,\r\n" + 
					"scd1.FEE_STATUS, scd1.FEE_REMINDER_COUNT,DUE_AMOUNT, pm.PAYMENT_MODE_NAME,\r\n" + 
					"PLANNED_INSTALLMENT1, PLANNED_INSTALLMENT1_DATE, ACTUAL_INSTALLMENT1, ACTUAL_INSTALLMENT1_DATE,\r\n" + 
					"PLANNED_INSTALLMENT2, PLANNED_INSTALLMENT2_DATE, ACTUAL_INSTALLMENT2, ACTUAL_INSTALLMENT2_DATE,\r\n" + 
					"PLANNED_INSTALLMENT3, PLANNED_INSTALLMENT3_DATE, ACTUAL_INSTALLMENT3, ACTUAL_INSTALLMENT3_DATE\r\n" + 
					"FROM USER_PROFILE AS up1 \r\n" + 
					"INNER JOIN\r\n" + 
					"STUDENT_COURSE_DETAILS scd1\r\n" + 
					"ON up1.USER_ID = scd1.USER_ID \r\n" + 
					"INNER JOIN\r\n" + 
					"STUDENT_COURSE_INSTALLMENT_DETAILS scid1\r\n" + 
					"ON scid1.USER_ID = scd1.USER_ID AND scd1.COURSE_ID = scid1.COURSE_ID \r\n" + 
					"INNER JOIN \r\n" + 
					"REVENUE_DETAIL AS rd\r\n" + 
					"ON rd.USER_ID = scd1.USER_ID AND rd.COURSE_ID = scd1.COURSE_ID\r\n" + 
					"INNER JOIN\r\n" + 
					"PAYMENT_MODE AS pm\r\n" + 
					"ON pm.PAYMENT_MODE_ID = rd.PAYMENT_MODE_ID\r\n" + 
					"WHERE scd1.COURSE_ID =(SELECT DISTINCT COURSE_ID FROM STUDENT_COURSE_DETAILS WHERE BATCH_ID = " + batchId + ")";
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				feeRecordsScreenWrapperList.add(new FeeRecordsScreenWrapper(resultSet.getString("PAYMENT_MODE_NAME"),resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME"), 
						resultSet.getString("FEE_STATUS"),resultSet.getInt("USER_ID") ,resultSet.getString("MOBILE_NUMBER"), resultSet.getString("EMAIL_ID"), null,resultSet.getInt("FEE_REMINDER_COUNT"), 
						  new StudentCourseInstallmentDetails(resultSet.getInt("USER_ID"), null, 
								  resultSet.getInt("PLANNED_INSTALLMENT1"), resultSet.getDate("PLANNED_INSTALLMENT1_DATE"), resultSet.getInt("ACTUAL_INSTALLMENT1"), resultSet.getDate("ACTUAL_INSTALLMENT1_DATE"),
								  resultSet.getInt("PLANNED_INSTALLMENT2"), resultSet.getDate("PLANNED_INSTALLMENT2_DATE"), resultSet.getInt("ACTUAL_INSTALLMENT2"), resultSet.getDate("ACTUAL_INSTALLMENT2_DATE"), 
								  resultSet.getInt("PLANNED_INSTALLMENT3"), resultSet.getDate("PLANNED_INSTALLMENT3_DATE"), resultSet.getInt("ACTUAL_INSTALLMENT3"), resultSet.getDate("ACTUAL_INSTALLMENT3_DATE"), 
								  resultSet.getInt("DUE_AMOUNT"))));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return feeRecordsScreenWrapperList;
	}
	
}