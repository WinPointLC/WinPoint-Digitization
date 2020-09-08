package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
