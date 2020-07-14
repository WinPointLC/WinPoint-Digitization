package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
}
