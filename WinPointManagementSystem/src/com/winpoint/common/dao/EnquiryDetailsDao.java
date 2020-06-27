package com.winpoint.common.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.EnquiryDetails;

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

}
