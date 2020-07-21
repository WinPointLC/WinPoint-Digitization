package com.winpoint.common.dao;
/**
 * @author Abhishek Dixit
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.util.sql.ConnectionManager;

public class OrganizationTypeDao {

	
public List<OrganizationType> getOrganizationTypeList(){
		
		List<OrganizationType> organizationTypeList = new ArrayList<OrganizationType>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT * FROM ORGANIZATION_TYPE";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				organizationTypeList.add(new OrganizationType(rs.getInt("ORGANIZATION_TYPE_ID"), rs.getString("ORGANIZATION_TYPE_DESCRIPTION")));
			}			
		}catch(SQLException e) {
			organizationTypeList = null;
			e.printStackTrace();
		}
		return organizationTypeList;	
	}	
}
