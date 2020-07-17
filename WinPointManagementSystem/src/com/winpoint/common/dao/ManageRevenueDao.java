package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.winpoint.common.beans.ManageRevenue;

import com.winpoint.common.util.sql.ConnectionManager;

public class ManageRevenueDao {
	public void getRevenueDetailList(ManageRevenue revenueDetail){
		
		List<ManageRevenue> manageRevenueList = new ArrayList<ManageRevenue>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			java.sql.Date sqlRecieveDate = new java.sql.Date(revenueDetail.getRecieveDate().getTime());
			ResultSet resultSet;
			String query = "\n" + 

			"INSERT INTO REVENUE_DETAIL \n" +
					"(REVENUE_DETAIL_ID, \n" +
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
					"VALUES('"+
					revenueDetail.getRevenueDetailId()+"','"+
					revenueDetail.getRevenueTypeId()+"','"+
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
		
			
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				manageRevenueList.add(new ManageRevenue(resultSet.getInt("REVENUE_DETAIL_ID"),
						resultSet.getInt("REVENUE_TYPE_ID"),
						resultSet.getString("RECIEPT_NUMBER"),
						resultSet.getString("PAYER_DESCRIPTION"),
						resultSet.getInt("COURSE_ID"),
						resultSet.getInt("BATCH_ID"),
						resultSet.getFloat("REVENUE_AMOUNT"),
						resultSet.getInt("PAYMENT_MODE_ID"),
						resultSet.getString("CHEQUE_NUMBER"),
						resultSet.getInt("SEGMENT_TYPE_ID"),
						resultSet.getInt("ORGANIZATION_ID"),
						resultSet.getInt("USER_ID"),
						resultSet.getDate("RECIEVE_DATE")));
			}			
				
		}catch(SQLException e) {
			manageRevenueList = null;
			e.printStackTrace();
		}
			
	}	
}
