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
		
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				manageRevenueList.add(new ManageRevenue(rs.getInt("REVENUE_DETAIL_ID"),rs.getInt("REVENUE_TYPE_ID"),
						rs.getString("RECIEPT_NUMBER"),rs.getString("PAYER_DESCRIPTION"),rs.getInt("COURSE_ID"),rs.getInt("BATCH_ID"),
						rs.getFloat("REVENUE_AMOUNT"),rs.getInt("PAYMENT_MODE_ID"),rs.getString("CHEQUE_NUMBER"),rs.getInt("SEGMENT_TYPE_ID"),
						rs.getInt("ORGANIZATION_ID"),rs.getInt("USER_ID"),rs.getDate("RECIEVE_DATE")));
			}			
			
			
//			public ManageRevenue(Integer revenueDetailId, Integer revenueTypeId, String recieptNumber,
//					String payerDescription, Integer courseId, Integer batchId, float revenueAmount, Integer paymentModeId,
//					String chequeNumber, Integer segmentTypeId, Integer organizationId, Integer userId,
//					Date recieveDate)
			
			
			
		}catch(SQLException e) {
			manageRevenueList = null;
			e.printStackTrace();
		}
			
	}	
}
