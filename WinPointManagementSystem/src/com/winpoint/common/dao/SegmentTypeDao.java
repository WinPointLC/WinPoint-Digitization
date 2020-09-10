package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.util.sql.ConnectionManager;

public class SegmentTypeDao {

	public List<SegmentType> getSegmentTypeList(){
		
			List<SegmentType> segmentTypeList = new ArrayList<SegmentType>();
		
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
			
				String query = "\n" + 
						"SELECT * FROM SEGMENT_TYPE";
			
				ResultSet rs = statement.executeQuery(query);
			
				while(rs.next()) {
					segmentTypeList.add(new SegmentType(rs.getInt("SEGMENT_TYPE_ID"), rs.getString("SEGMENT_TYPE_NAME")));
				}
			
			}catch(SQLException e) {
				segmentTypeList = null;
				e.printStackTrace();
			}
		
			return segmentTypeList;
		
		}
	//Abhishek - Web 
	public void createSegmentTypeList(ArrayList<SegmentType> newSegmentTypeArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(SegmentType segmentType: newSegmentTypeArrayList) {
			String query = "INSERT INTO SEGMENT_TYPE\n" + 
					"(SEGMENT_TYPE_NAME) VALUES \n" + 
					"('"+ segmentType.getSegmentTypeName() +"')";
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

	public void deleteSegmentTypeList(ArrayList<Integer> deleteSegmentTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteSegmentTypeString = new StringBuilder();
			for(int segmentTypeId: deleteSegmentTypeArrayList) {
				deleteSegmentTypeString.append(segmentTypeId);
				deleteSegmentTypeString.append(',');
			}
			deleteSegmentTypeString.deleteCharAt(deleteSegmentTypeString.length()-1);
			String query ="DELETE FROM SEGMENT_TYPE\n" + 
					"WHERE SEGMENT_TYPE_ID IN ("+ deleteSegmentTypeString.toString() +")";
			statement.executeQuery(query);
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		
	}

	
}
