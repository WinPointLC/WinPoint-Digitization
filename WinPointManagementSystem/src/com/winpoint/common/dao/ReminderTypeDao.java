package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.ReminderType;
import com.winpoint.common.util.sql.ConnectionManager;

public class ReminderTypeDao {
	public List<ReminderType> getReminderTypeList() {
		List<ReminderType> reminderTypeList = new ArrayList<>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM REMINDER_TYPE";
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				reminderTypeList.add(new ReminderType(rs.getInt("REMINDER_TYPE_ID"),rs.getString("REMINDER_TYPE_CATEGORY")));
			}
		} 
		catch (SQLException e) {
			reminderTypeList = null;
			e.printStackTrace();
		}
		
		return reminderTypeList;
	}
	
	public void createReminderTypeList(ArrayList<ReminderType> newReminderTypeArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(ReminderType reminderType: newReminderTypeArrayList) {
			String query = "INSERT INTO REMINDER_TYPE\n" + 
					"(REMINDER_TYPE_CATEGORY) VALUES\n" + 
					"('"+ reminderType.getReminderTypeCategory() +"')";
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

	public void deleteReminderTypeList(ArrayList<Integer> deleteReminderTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteReminderTypeString = new StringBuilder();
			for(int reminderTypeId: deleteReminderTypeArrayList) {
				deleteReminderTypeString.append(reminderTypeId);
				deleteReminderTypeString.append(',');
			}
			deleteReminderTypeString.deleteCharAt(deleteReminderTypeString.length()-1);
			String query ="DELETE FROM REMINDER_TYPE\n" + 
					"WHERE REMINDER_TYPE_ID IN ("+ deleteReminderTypeString +")";
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
