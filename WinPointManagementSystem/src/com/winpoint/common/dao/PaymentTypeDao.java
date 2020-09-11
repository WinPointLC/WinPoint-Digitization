package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.util.sql.ConnectionManager;

public class PaymentTypeDao {

	
	public List<PaymentType> getPaymentTypeList(){
		
		List<PaymentType> paymentTypeList = new ArrayList<PaymentType>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT * FROM PAYMENT_MODE";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				paymentTypeList.add(new PaymentType(rs.getInt("PAYMENT_MODE_ID"), rs.getString("PAYMENT_MODE_NAME")));
			}			
		}catch(SQLException e) {
			paymentTypeList = null;
			e.printStackTrace();
		}
		return paymentTypeList;	
	}
	
	//===============================================================================================


	public void createPaymentTypeList(ArrayList<PaymentType> newPaymentTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(PaymentType PaymentTypeList: newPaymentTypeArrayList) {
			String query = "INSERT INTO PAYMENT_MODE VALUES ('"+PaymentTypeList.getPaymentTypeName()+"')";
			statement.executeUpdate(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void deletePaymentTypeList(ArrayList<Integer> deletePaymentTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deletePaymentTypeString = new StringBuilder();
			for(int PaymentTypeId: deletePaymentTypeArrayList) {
				deletePaymentTypeString.append(PaymentTypeId);
				deletePaymentTypeString.append(',');
			}
			deletePaymentTypeString.deleteCharAt(deletePaymentTypeString.length()-1);
			String query ="DELETE FROM PAYMENT_MODE \n" + 
					"WHERE PAYMENT_MODE_ID IN  ("+ deletePaymentTypeString.toString() +")";
			statement.executeUpdate(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}
	
}
