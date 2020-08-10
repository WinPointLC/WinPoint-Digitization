package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.FacultySkills;
import com.winpoint.common.util.sql.ConnectionManager;

public class FacultySkillsDao {
	
	// Abhishek
	public List<FacultySkills> getAvailableFaculty(Integer timeSlotsId, Integer courseId){
		
		List<FacultySkills> availableFaculty = new ArrayList<FacultySkills>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"\n" + 
					"select * from FACULTY_SKILLS\n" + 
					" where (\n" + 
					"TIME_SLOTS_IDS like '%,' + '"+timeSlotsId+"' + ',%' or\n" + 
					" TIME_SLOTS_IDS like  '"+timeSlotsId+"' + ',%' or\n" + 
					" TIME_SLOTS_IDS like '%,' + '"+timeSlotsId+"'  or\n" + 
					" TIME_SLOTS_IDS = '"+timeSlotsId+"'\n" + 
					" )\n" + 
					" AND(SKILL_SET_IDS like '%,' + '"+courseId+"' + ',%' or\n" + 
					" SKILL_SET_IDS like  '"+courseId+"' + ',%' or\n" + 
					" SKILL_SET_IDS like '%,' + '"+courseId+"'  or\n" + 
					" SKILL_SET_IDS = '"+courseId+"'\n" + 
					" )";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				availableFaculty.add(new FacultySkills(rs.getInt("FACULTY_USER_ID")));
			}
			
		}catch(SQLException e) {
			availableFaculty = null;
			e.printStackTrace();
		}
	    
		return availableFaculty;		
	}
	
}
