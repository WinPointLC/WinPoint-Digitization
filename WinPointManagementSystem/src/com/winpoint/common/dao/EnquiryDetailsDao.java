package com.winpoint.common.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enquiryDetailsList;

	}

	public ArrayList<EnquiryDetails> getEligibleUsers(){
	
		List<EnquiryDetails> enquiryDetailsList = new ArrayList<EnquiryDetails>();
	
		enquiryDetailsList.add(new EnquiryDetails("Shraddha", "Padalkar"));
		enquiryDetailsList.add(new EnquiryDetails("Purva", "Khot"));
		enquiryDetailsList.add(new EnquiryDetails("Suhasi", "Buche"));
		enquiryDetailsList.add(new EnquiryDetails("Sarthak", "Bapte"));
		
		return  (ArrayList<EnquiryDetails>) enquiryDetailsList;
	
	}



}
