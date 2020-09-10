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

import com.microsoft.sqlserver.jdbc.SQLServerException;
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



//===============================================================================================

	public void createOrganizationTypeList(ArrayList<OrganizationType> newOrganizationTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){			
			Statement statement = connection.createStatement();
			
			for(OrganizationType OrganizationTypeList: newOrganizationTypeArrayList) {
			String query = "INSERT INTO ORGANIZATION_TYPE VALUES ("+OrganizationTypeList.getOrganizationTypeName()+")";
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

	public void deleteOrganizationTypeList(ArrayList<Integer> deleteOrganizationTypeArrayList) {
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			StringBuilder deleteOrganizationTypeString = new StringBuilder();
			for(int OrganizationTypeId: deleteOrganizationTypeArrayList) {
				deleteOrganizationTypeString.append(OrganizationTypeId);
				deleteOrganizationTypeString.append(',');
			}
			deleteOrganizationTypeString.deleteCharAt(deleteOrganizationTypeString.length()-1);
			String query ="DELETE FROM ORGANIZATION_TYPE \n" + 
					"WHERE ORGANIZATION_TYPE_ID IN  ("+ deleteOrganizationTypeString.toString() +")";
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
