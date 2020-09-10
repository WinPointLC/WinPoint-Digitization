package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.DifficultyLevel;
import com.winpoint.common.util.sql.ConnectionManager;

public class DifficultyLevelDao {

	public List<DifficultyLevel> getDifficultyLevelList() {
		
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
	
	//===============================================================================================

	public void createDifficultyLevelList(ArrayList<DifficultyLevel> newDifficultyLevelArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(DifficultyLevel DifficultyLevelList: newDifficultyLevelArrayList) {
			String query = "INSERT INTO DIFFICULTY_LEVEL VALUES ("+DifficultyLevelList.getDifficultyLevelName()+",NULL,NULL)";
			statement.executeQuery(query);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
	}

	public void deleteDifficultyLevelList(ArrayList<Integer> deleteDifficultyLevelArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteDifficultyLevelString = new StringBuilder();
			for(int DifficultyLevelId: deleteDifficultyLevelArrayList) {
				deleteDifficultyLevelString.append(DifficultyLevelId);
				deleteDifficultyLevelString.append(',');
			}
			deleteDifficultyLevelString.deleteCharAt(deleteDifficultyLevelString.length()-1);
			String query ="DELETE FROM DIFFICULTY_LEVEL \n" + 
					"WHERE DIFFICULTY_LEVEL_ID IN  ("+ deleteDifficultyLevelString.toString() +")";
			statement.executeQuery(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}
	//===============================================================================================

}
