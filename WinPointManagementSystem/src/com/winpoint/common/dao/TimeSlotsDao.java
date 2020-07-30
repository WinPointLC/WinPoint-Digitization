package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.util.sql.ConnectionManager;

public class TimeSlotsDao {

	public List<TimeSlots> getTimeSlotsList(){
		
		List<TimeSlots> timeSlotsList = new ArrayList<TimeSlots>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT * FROM TIME_SLOTS";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				timeSlotsList.add(new TimeSlots(rs.getInt("TIME_SLOTS_ID"), rs.getString("TIME_SLOTS_DESCRIPTION")));
			}
			
		}catch(SQLException e) {
			timeSlotsList = null;
			e.printStackTrace();
		}
		
		return timeSlotsList;
		
	}

}
