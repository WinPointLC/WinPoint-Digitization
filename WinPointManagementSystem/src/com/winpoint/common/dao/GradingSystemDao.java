package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.GradingSystem;
import com.winpoint.common.util.sql.ConnectionManager;

public class GradingSystemDao {
	public List<GradingSystem> getGradingSystemList() {
		List<GradingSystem> gradingSystemList = new ArrayList<>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT GRADE_ID, LOWER_LIMIT, HIGHER_LIMIT FROM GRADING_SYSTEM";
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				gradingSystemList.add(new GradingSystem(rs.getString("GRADE_ID"),rs.getInt("LOWER_LIMIT"),rs.getInt("HIGHER_LIMIT")));
			}
		} 
		catch (SQLException e) {
			gradingSystemList = null;
			e.printStackTrace();
		}
		
		return gradingSystemList;
	}

}
