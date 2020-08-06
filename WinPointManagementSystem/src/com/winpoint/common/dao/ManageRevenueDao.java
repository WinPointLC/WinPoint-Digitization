package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.winpoint.common.beans.ManageRevenue;

import com.winpoint.common.util.sql.ConnectionManager;

public class ManageRevenueDao {
	public void getRevenueDetailList(ManageRevenue revenueDetail){
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			java.sql.Date sqlRecieveDate = new java.sql.Date(revenueDetail.getRecieveDate().getTime());
			String query = "\n" + 

			"INSERT INTO REVENUE_DETAIL \n" +
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
		
			System.out.println(query);
			statement.executeUpdate(query);
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}	
}
