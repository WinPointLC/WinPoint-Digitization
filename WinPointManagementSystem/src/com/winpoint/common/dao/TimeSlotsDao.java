package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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

	public void createTimeSlotsList(ArrayList<TimeSlots> newTimeSlotsArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(TimeSlots timeSlots: newTimeSlotsArrayList) {
			String query = "INSERT INTO TIME_SLOTS\n" + 
					"(TIME_SLOTS_DESCRIPTION) VALUES \n" + 
					"('"+ timeSlots.getTimeSlotsDescription() +"')";
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

	public void deleteTimeSlotsList(ArrayList<Integer> deleteTimeSlotsArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteTimeSlotsString = new StringBuilder();
			for(int courseId: deleteTimeSlotsArrayList) {
				deleteTimeSlotsString.append(courseId);
				deleteTimeSlotsString.append(',');
			}
			deleteTimeSlotsString.deleteCharAt(deleteTimeSlotsString.length()-1);
			String query ="\n" + 
					"DELETE FROM TIME_SLOTS\n" + 
					"WHERE TIME_SLOTS_ID IN ("+ deleteTimeSlotsString.toString() +")";
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
