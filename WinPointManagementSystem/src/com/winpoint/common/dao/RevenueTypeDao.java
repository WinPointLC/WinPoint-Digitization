package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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

	public void createRevenueTypeList(ArrayList<RevenueType> newRevenueTypeArrayList) {
	
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(RevenueType revenueTypeList: newRevenueTypeArrayList) {
			String query = "INSERT INTO REVENUE_TYPE\n" + 
					"(REVENUE_TYPE_NAME) VALUES\n" + 
					"('"+ revenueTypeList.getRevenueTypeName() +"')";
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
	
	public void deleteRevenueTypeList(ArrayList<Integer> deleteRevenueTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteRevenueTypeString = new StringBuilder();
			for(int revenueTypeId: deleteRevenueTypeArrayList) {
				deleteRevenueTypeString.append(revenueTypeId);
				deleteRevenueTypeString.append(',');
			}
			deleteRevenueTypeString.deleteCharAt(deleteRevenueTypeString.length()-1);
			String query ="DELETE FROM REVENUE_TYPE\n" + 
					"WHERE REVENUE_TYPE_ID IN ("+ deleteRevenueTypeString.toString() +")";
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
