package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.DifficultyLevel;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.util.sql.ConnectionManager;

public class DifficultyLevelDao {

	public List<DifficultyLevel> getDifficultyLevelsList() {
		
		List<DifficultyLevel> difficultyLevelsList = new ArrayList<DifficultyLevel>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT  * from DIFFICULTY_LEVEL";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int difficultyLevelId = resultSet.getInt("DIFFICULTY_LEVEL_ID");
				String difficultyLevelName = resultSet.getString("DIFFICULTY_LEVEL_NAME");
				DifficultyLevel difficultyLevel = new DifficultyLevel(difficultyLevelId, difficultyLevelName);
				difficultyLevelsList.add(difficultyLevel);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return difficultyLevelsList;
		
	}
}
