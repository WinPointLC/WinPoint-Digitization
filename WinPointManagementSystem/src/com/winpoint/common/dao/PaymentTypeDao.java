package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.util.sql.ConnectionManager;

public class PaymentTypeDao {

	
	public List<PaymentType> getPaymentTypeDaoList(){
		
		List<PaymentType> paymentTypeDaoList = new ArrayList<PaymentType>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT * FROM PAYMENT_MODE";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				paymentTypeDaoList.add(new PaymentType(rs.getInt("PAYMENT_MODE_ID"), rs.getString("PAYMENT_MODE_NAME")));
			}			
		}catch(SQLException e) {
			paymentTypeDaoList = null;
			e.printStackTrace();
		}
		return paymentTypeDaoList;	
	}
	
}
