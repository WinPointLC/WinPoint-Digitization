package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.winpoint.common.beans.EnquiryDetails;

import com.winpoint.common.util.sql.ConnectionManager;

public class EnquiryDetailsDao {
	
	// Group A - to delete the data from ENQUIRY_DETAILS - Abhishek
//	public void deleteEnquiryDetailsOfStudent(Integer userId) {
//		
//		try(Connection connection = ConnectionManager.getConnection()){
//			Statement statement = connection.createStatement();
//			String query2 = "DELETE FROM ENQUIRY_DETAILS\n" + 
//					"WHERE ENQUIRY_ID = "+userId;
//			statement.executeUpdate(query2);
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	// Group A - To access the Data of a particular student for Manage revenue Screen - Abhishek
	public ArrayList<EnquiryDetails> getEnquiryDetailsOfStudent(Integer userId){

		List<EnquiryDetails> enquiryDetailList = new ArrayList<EnquiryDetails>();

		Connection connection = ConnectionManager.getConnection();
		try{
			Statement statement = connection.createStatement();
			String query2 = "SELECT * FROM ENQUIRY_DETAILS"
					+ " WHERE ENQUIRY_ID = "+userId;
			ResultSet rs = statement.executeQuery(query2);
			while(rs.next()) {
				enquiryDetailList.add(new EnquiryDetails(
						rs.getInt("ENQUIRY_ID"), 
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("EMAIL_ID"),
						rs.getString("MOBILE_NO"),
						rs.getString("ADDRESS"),
						rs.getDate("BIRTH_DATE"),
						rs.getString("COLLEGE"),
						rs.getString("DEGREE"),
						rs.getString("BRANCH"),
						rs.getString("OCCUPATION"),
						rs.getString("ORGANISATION"),
						rs.getString("DESIGNATION"),
						rs.getString("DOMAIN"),
						rs.getString("ROLE"),
						rs.getInt("EXPERIENCE"),
						rs.getInt("CREATED_BY"),
						rs.getDate("DATE_OF_ENQUIRY"),
						rs.getString("GENDER"),
						rs.getInt("YEAR_OF_GRADUATION"),
						rs.getString("RECOMMENDATION"),
						rs.getBoolean("ELIGIBILITY"),
						rs.getString("COURSE_INTERESTED_IN"),
						rs.getString("REFERENCE"),
						rs.getString("TIME_SLOTS_ID"),
						rs.getString("COURSE_ALREADY_DONE"),
						rs.getDate("START_DATE"),
						rs.getInt("SEGMENT_TYPE_ID"),
						rs.getString("SUGGESTION"),
						rs.getBoolean("ACTIVE_STATUS")));
			}
		}
		catch (SQLException e) {
			enquiryDetailList = null;
			e.printStackTrace();
		}
		return  (ArrayList<EnquiryDetails>) enquiryDetailList;
	}
	
	// group A - for inserting the values in the table.( SIGNUP FORM ) ~ Abhishek
	public void create(EnquiryDetails enquiryDetails) throws SQLException {
		java.sql.Date sqlBirthDate = new java.sql.Date(enquiryDetails.getBirthDate().getTime());
		java.sql.Date sqlDateOfEnquiry = new java.sql.Date(enquiryDetails.getDateofEnquiry().getTime());
		java.sql.Date sqlStartDate = new java.sql.Date(enquiryDetails.getStartDate().getTime());

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "\n" +
					"INSERT INTO ENQUIRY_DETAILS \n" +
					"(FIRST_NAME, \n" +
					"LAST_NAME, \n" +
					"EMAIL_ID, \n" +
					"MOBILE_NO, \n" +
					"ADDRESS, \n" +
					"BIRTH_DATE, \n" +
					"COLLEGE, \n" +
					"DEGREE, \n" +
					"BRANCH, \n" +
					"OCCUPATION, \n" +
					"ORGANISATION, \n" +
					"DESIGNATION, \n" +
					"DOMAIN, \n" +
					"DATE_OF_ENQUIRY, \n" +
					"GENDER, \n" +
					"YEAR_OF_GRADUATION, \n" +
					"ROLE, \n" +
					"EXPERIENCE, \n" +
					"CREATED_BY, \n" +	
					"RECOMMENDATION, \n" +
					"ELIGIBILITY,\n" +
					"COURSE_INTERESTED_IN,\n" +
					"REFERENCE, \n" +
					"TIME_SLOTS_ID, \n" +
					"COURSE_ALREADY_DONE,\n" +
					"START_DATE, \n" +
					"SEGMENT_TYPE_ID, \n" +
					"SUGGESTION, \n" +
					"ACTIVE_STATUS)\n" +
					"VALUES('"+
					enquiryDetails.getFirstName()+"','"+
					enquiryDetails.getLastName()+"','"+
					enquiryDetails.getEmail()+"','"+
					enquiryDetails.getMobileNumber()+"','"+
					enquiryDetails.getAddress()+"','"+
					sqlBirthDate+"','"+
					enquiryDetails.getCollege()+"','"+
					enquiryDetails.getDegree()+"','"+
					enquiryDetails.getBranch()+"','"+
					enquiryDetails.getOccupation()+"','"+
					enquiryDetails.getOrganisation()+"','"+
					enquiryDetails.getDesignation()+"','"+
					enquiryDetails.getDomain()+"','"+
					sqlDateOfEnquiry+"','"+
					enquiryDetails.getGender()+"','"+
					enquiryDetails.getYearOfGraduation()+"','"+
					enquiryDetails.getRole()+"','"+
					enquiryDetails.getExperience()+"','"+
					enquiryDetails.getCreatedBy()+"','"+
					enquiryDetails.getRecommendation()+"','"+
					enquiryDetails.getEligibility()+"','"+
					enquiryDetails.getCoursesInterestedIn()+"','"+
					enquiryDetails.getReference()+"','"+
					enquiryDetails.getTimeSlotsId()+"','"+
					enquiryDetails.getCourseAlreadyDone()+"','"+
					sqlStartDate+"','"+
					enquiryDetails.getSegmentTypeId()+"','"+
					enquiryDetails.getSuggestion()+"','"+
					enquiryDetails.getActiveStatus()+"')";
			System.out.println(query);
			statement.executeUpdate(query);
		}
	}
	// Group A - Update Page ~ Shraddha
	public void update(EnquiryDetails enquiryDetailsObject) {
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
					"        EXPERIENCE="+ enquiryDetailsObject.getExperience()+",\n" +
					"        GENDER='"+ enquiryDetailsObject.getGender()+"',\n" +
					"        YEAR_OF_GRADUATION="+ enquiryDetailsObject. getYearOfGraduation()+",\n" +
					"        COURSE_INTERESTED_IN='"+ enquiryDetailsObject. getCoursesInterestedIn()+"',\n" +
					"        COURSE_ALREADY_DONE='"+ enquiryDetailsObject.getCourseAlreadyDone()+"',\n" +
					"        SUGGESTION='"+ enquiryDetailsObject.getSuggestion()+"',\n" +
					"        ACTIVE_STATUS='"+ enquiryDetailsObject. getActiveStatus()+"'\n" +
					"        WHERE ENQUIRY_ID="+ enquiryDetailsObject.getEnquiryId()+"\n" +
					"        " +
					"";
				System.out.println(query1);
				statement.executeUpdate(query1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Group A - get start date ~ Abhishek
	public EnquiryDetails getStartDate() {
		
		EnquiryDetails startDate = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();

			
			
			
			String query1 = "SELECT top 1 START_DATE from ENQUIRY_DETAILS\n" + 
					"Order by START_DATE DESC";
			
			ResultSet resultSet = statement.executeQuery(query1);
				
			while(resultSet.next()) {
				startDate = new EnquiryDetails(resultSet.getDate("START_DATE"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return startDate;
		
	}
	

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

//  GROUP A
	public ArrayList<EnquiryDetails> getEligibleUsers(){

		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();


			//we have to access the course name from the previous screen
//			String q2 = "SELECT E.FIRST_NAME, E.LAST_NAME\n" +
//					"FROM ENQUIRY_DETAILS AS E\n" +
//					"JOIN COURSES AS C\n" +
//					"ON CAST(E.COURSE_ALREADY_DONE AS VARCHAR(30)) = C.PRE_REQUISITE\n" +
//					"WHERE C.COURSE_NAME = 'writing skills'";
			String q2 = "SELECT * FROM ENQUIRY_DETAILS";
			ResultSet rs = statement.executeQuery(q2);

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
			String query = "SELECT * FROM ENQUIRY_DETAILS"+
					"";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				enquiryDetailList.add(new EnquiryDetails(
						rs.getInt("ENQUIRY_ID"), 
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("EMAIL_ID"),
						rs.getString("MOBILE_NO"),
						rs.getString("ADDRESS"),
						rs.getDate("BIRTH_DATE"),
						rs.getString("COLLEGE"),
						rs.getString("DEGREE"),
						rs.getString("BRANCH"),
						rs.getString("OCCUPATION"),
						rs.getString("ORGANISATION"),
						rs.getString("DESIGNATION"),
						rs.getString("DOMAIN"),
						rs.getString("ROLE"),
						rs.getInt("EXPERIENCE"),
						rs.getInt("CREATED_BY"),
						rs.getDate("DATE_OF_ENQUIRY"),
						rs.getString("GENDER"),
						rs.getInt("YEAR_OF_GRADUATION"),
						rs.getString("RECOMMENDATION"),
						rs.getBoolean("ELIGIBILITY"),
						rs.getString("COURSE_INTERESTED_IN"),
						rs.getString("REFERENCE"),
						rs.getString("TIME_SLOTS_ID"),
						rs.getString("COURSE_ALREADY_DONE"),
						rs.getDate("START_DATE"),
						rs.getInt("SEGMENT_TYPE_ID"),
						rs.getString("SUGGESTION"),
						rs.getBoolean("ACTIVE_STATUS")));
			}
			for(EnquiryDetails enquiry: enquiryDetailList) {
				String coursesInterestedIn = enquiry.getCoursesInterestedIn();
				StringTokenizer st1 = new StringTokenizer(coursesInterestedIn,",");
				String coursesInterested = "";
				while(st1.hasMoreTokens()) {
					int courseId =Integer.parseInt(st1.nextToken());
					query = "SELECT C.COURSE_ID, CT.COURSE_TYPE_NAME+'-'+C.COURSE_NAME AS NAME, C.COURSE_TYPE_ID\n" + 
							"FROM COURSES C\n" + 
							"INNER JOIN COURSE_TYPE CT\n" + 
							"ON C.COURSE_TYPE_ID = CT.COURSE_TYPE_ID\n" + 
							"WHERE C.COURSE_ID = "+courseId;
					rs = statement.executeQuery(query);
					
					while(rs.next()) {
						coursesInterested += courseId+"/"+rs.getString("NAME")+",";
					}
				}
				coursesInterested = coursesInterested.substring(0,coursesInterested.length()-1);
				enquiry.setCoursesInterestedIn(coursesInterested);
				String coursesAlreadyDone = enquiry.getCourseAlreadyDone();				
				StringTokenizer st2 = new StringTokenizer(coursesAlreadyDone, ",");
				String courseDone = "";
				while(st2.hasMoreTokens()) {
					int courseId =Integer.parseInt(st2.nextToken());
					query = "SELECT C.COURSE_ID, CT.COURSE_TYPE_NAME+'-'+C.COURSE_NAME AS NAME, C.COURSE_TYPE_ID\n" + 
							"FROM COURSES C\n" + 
							"INNER JOIN COURSE_TYPE CT\n" + 
							"ON C.COURSE_TYPE_ID = CT.COURSE_TYPE_ID\n" + 
							"WHERE C.COURSE_ID = "+courseId;
					rs = statement.executeQuery(query);
					
					while(rs.next()) {
						courseDone += courseId+"/"+rs.getString("NAME")+",";
					}
				}
				courseDone = courseDone.substring(0,courseDone.length()-1);
				enquiry.setCourseAlreadyDone(courseDone);
			}
		}
		catch (SQLException e) {
			enquiryDetailList = null;
			e.printStackTrace();
		}
		return  (ArrayList<EnquiryDetails>) enquiryDetailList;
	}
	
}
