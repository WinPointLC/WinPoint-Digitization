package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

}
