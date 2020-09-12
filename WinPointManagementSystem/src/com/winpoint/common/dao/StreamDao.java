package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.util.sql.ConnectionManager;

public class StreamDao {

	public List<Stream> getStreamList() {
		
		List<Stream> streamList = new ArrayList<Stream>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT STREAM_ID, STREAM_NAME FROM STREAMS";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int streamId = resultSet.getInt("stream_id");
				String streamName = resultSet.getString("stream_name");
				Stream stream = new Stream(streamId, streamName);
				streamList.add(stream);
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return streamList;
		
	}
	
	public Integer getStreamId(String streamName) {
		Integer streamId = null;
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "SELECT STREAM_ID \r\n" + 
					"FROM STREAMS\r\n" + 
					"WHERE STREAM_NAME = '"+ streamName +"'";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				streamId = resultSet.getInt("STREAM_ID");
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return streamId;
		
	}
	
	// Abhishek - Web
	public void createStreamList(ArrayList<Stream> newStreamArrayList) {

		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(Stream streamList: newStreamArrayList) {
			String query = "INSERT INTO STREAMS\n" + 
					"(STREAM_NAME) VALUES \n" + 
					"('"+ streamList.getStreamName() +"')";
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
	//Abhishek - Web
	public void deleteStreamList(ArrayList<Integer> deleteStreamArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteStreamString = new StringBuilder();
			for(int streamId: deleteStreamArrayList) {
				deleteStreamString.append(streamId);
				deleteStreamString.append(',');
			}
			deleteStreamString.deleteCharAt(deleteStreamString.length()-1);
			String query ="DELETE FROM STREAMS\n" + 
					"WHERE STREAM_ID IN ("+deleteStreamString.toString()+")";
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
