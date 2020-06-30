package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.util.sql.ConnectionManager;

public class EnquiryDetailsDao {

	public List<EnquiryDetails> getEnquiryDetailsList() {
		
		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();
				
		try {
			enquiryDetailsList.add(new EnquiryDetails(10, "Aayush ", "Agarwal", "aayush.aka44@gmail.com", "9820910220", "MUMBAI",
					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "MALE", 2021, "AAyush", true, 3, "Rishabh", 7,
					12, 1, "Passed", true));
			
			enquiryDetailsList.add(new EnquiryDetails(11, "Shraddha ", "Padalkar", "shraddha8888@gmail.com", "9820910220", "MUMBAI",
					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "FEMALE", 2021, "Shraddha", true, 3, "Purva", 7,
					12, 1, "Passed", true));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return enquiryDetailsList;

	}

	public ArrayList<EnquiryDetails> getEligibleUsers(){
	
		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT FIRST_NAME, LAST_NAME FROM ENQUIRY_DETAILS";
			
			ResultSet rs = statement.executeQuery(query1);
			
			while(rs.next()) {
				enquiryDetailsList.add(new EnquiryDetails(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME")));
			}

		} 
		catch (SQLException e) {
			enquiryDetailsList = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<EnquiryDetails>) enquiryDetailsList;
	
	}



}
