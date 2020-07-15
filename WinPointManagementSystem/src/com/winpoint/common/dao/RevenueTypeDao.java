package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.util.sql.ConnectionManager;

public class RevenueTypeDao {
	
public List<RevenueType> getRevenueTypeList(){
		
		List<RevenueType> revenueTypeList = new ArrayList<RevenueType>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT * FROM REVENUE_TYPE";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				revenueTypeList.add(new RevenueType(rs.getInt("REVENUE_TYPE_ID"), rs.getString("REVENUE_TYPE_NAME")));
			}
			
		}catch(SQLException e) {
			revenueTypeList = null;
			e.printStackTrace();
		}
		
		return revenueTypeList;
		
	}

	
}
