package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.EnquiryDetails;

import com.winpoint.common.util.sql.ConnectionManager;

public class EnquiryDetailsDao {

	public List<EnquiryDetails> getEnquiryDetailsList() {
		
		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();
				
//		try {
//			enquiryDetailsList.add(new EnquiryDetails(10, "Aayush ", "Agarwal", "aayush.aka44@gmail.com", "9820910220", "MUMBAI",
//					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "MALE", 2021, "AAyush", true, 3, "Rishabh", 7,
//					12, 1, "Passed", true));
//			
//			enquiryDetailsList.add(new EnquiryDetails(11, "Shraddha ", "Padalkar", "shraddha8888@gmail.com", "9820910220", "MUMBAI",
//					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "FEMALE", 2021, "Shraddha", true, 3, "Purva", 7,
//					12, 1, "Passed", true));
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
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
	
	public ArrayList<EnquiryDetails> getEnquiryDetails(){
		
		List<EnquiryDetails> enquiryDetailList = new ArrayList<EnquiryDetails>();
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query2 = "SELECT FIRST_NAME,LAST_NAME,COURSE_INTERESTED_IN,ELIGIBILITY,SUGGESTION FROM ENQUIRY_DETAILS";
			
			ResultSet rs = statement.executeQuery(query2);
			
			while(rs.next()) {
				enquiryDetailList.add(new EnquiryDetails(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getInt("COURSE_INTERESTED_IN"),rs.getBoolean("ELIGIBILITY"),rs.getString("SUGGESTION")));
			}

		} 
		catch (SQLException e) {
			enquiryDetailList = null;
			e.printStackTrace();
		}
		
		return  (ArrayList<EnquiryDetails>) enquiryDetailList;
	
	}
	
	
	public void create(EnquiryDetails enquiryDetailsObject) {
		// TODO Auto-generated method stub
		

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			String query1 = "UPDATE ENQUIRY_DETAILS \n" + 
					"        SET FIRST_NAME='"+enquiryDetailsObject.getFirstName()+"',\n" + 
					"        LAST_NAME='"+ enquiryDetailsObject.getLastName()+"',\n" + 
					"        EMAIL_ID='"+ enquiryDetailsObject.getEmail()+"',\n" +  
					"        MOBILE_NO='"+ enquiryDetailsObject.getMobileNumber()+"',\n" + 
					"        COLLEGE='"+ enquiryDetailsObject.getCollege()+"',\n" +  
					"        DEGREE='"+ enquiryDetailsObject.getDegree()+"',\n" + 
					"        BRANCH='"+ enquiryDetailsObject.getBranch()+"',\n" + 
					"        OCCUPATION='"+ enquiryDetailsObject.getOccupation()+"',\n" + 
					"        ORGANISATION='"+ enquiryDetailsObject.getOrganisation()+"',\n" + 
					"        DESIGNATION='"+ enquiryDetailsObject.getDesignation()+"',\n" + 
					"        DOMAIN='"+ enquiryDetailsObject.getDomain()+"',\n" +  
					"        ROLE='"+ enquiryDetailsObject.getRole()+"',\n" +  
					"        EXPERIENCE='"+ enquiryDetailsObject.getExperience()+"',\n" + 
					"        GENDER='"+ enquiryDetailsObject.getGender()+"',\n" + 
					"        YEAR_OF_GRADUATION='"+ enquiryDetailsObject. getYearOfGraduation()+"',\n" +
					"        COURSE_ALREADY_DONE='"+ enquiryDetailsObject.getCourseAlreadyDone()+"',\n" +
					"        ACTIVE_STATUS='"+ enquiryDetailsObject. getActiveStatus()+"'\n" +
					"        WHERE ENQUIRY_ID='"+ 112+"'\n" +
					"        " + 
					"";
			
				statement.executeUpdate(query1);
			
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
