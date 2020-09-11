package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.EvaluationType;
import com.winpoint.common.util.sql.ConnectionManager;

public class EvaluationTypeDao {

	public List<EvaluationType> getEvaluationTypeList() {
		// TODO Auto-generated method stub
			
			List<EvaluationType> evaluationTypeList = new ArrayList<EvaluationType>();
		
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
			
				String query = "\n" + 
						"SELECT EVALUATION_TYPE_ID, EVALUATION_TYPE_NAME, OFFLINE_CHECK FROM EVALUATION_TYPE";
			
				ResultSet rs = statement.executeQuery(query);
			
				while(rs.next()) {
					evaluationTypeList.add(new EvaluationType(rs.getInt("EVALUATION_TYPE_ID"), rs.getString("EVALUATION_TYPE_NAME"), rs.getString("OFFLINE_CHECK")));
				}
			
			}catch(SQLException e) {
				evaluationTypeList = null;
				e.printStackTrace();
			}
		
			return evaluationTypeList;

	}
	//===============================================================================================
	
	
	public void createEvaluationTypeList(ArrayList<EvaluationType> newEvaluationTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(EvaluationType EvaluationTypeList: newEvaluationTypeArrayList) {
			String query = "INSERT INTO EVALUATION_TYPE VALUES ('"+EvaluationTypeList.getEvaluationTypeName()+"','yes',NULL,NULL)";
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

	

	public void deleteEvaluationTypeList(ArrayList<Integer> deleteEvaluationTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteEvaluationTypeString = new StringBuilder();
			for(int EvaluationTypeId: deleteEvaluationTypeArrayList) {
				deleteEvaluationTypeString.append(EvaluationTypeId);
				deleteEvaluationTypeString.append(',');
			}
			deleteEvaluationTypeString.deleteCharAt(deleteEvaluationTypeString.length()-1);
			String query ="DELETE FROM EVALUATION_TYPE \n" + 
					"WHERE EVALUATION_TYPE_ID IN  ("+ deleteEvaluationTypeString.toString() +")";
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
