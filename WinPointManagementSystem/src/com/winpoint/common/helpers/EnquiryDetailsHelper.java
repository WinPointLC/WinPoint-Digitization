package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.List;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.EnquiryDetailsDao;


public class EnquiryDetailsHelper {
	
	public List<EnquiryDetails> getEnquiryDetailsList() {
		return new EnquiryDetailsDao().getEnquiryDetailsList();
	}
	
	public List<EnquiryDetails> getEligibleUsers(){
		return new EnquiryDetailsDao().getEligibleUsers();
	}
	
	public List<EnquiryDetails> getEnquiryDetails(){
		return new EnquiryDetailsDao().getEnquiryDetails();
	}

	public void update(EnquiryDetails enquiryDetailsObject) {
		// TODO Auto-generated method stub
		new EnquiryDetailsDao().update(enquiryDetailsObject);
		
	}
	
	// Insertion of the data
	public void create(EnquiryDetails enquiryDetails) throws SQLException {
		new EnquiryDetailsDao().create(enquiryDetails);		
	}
	
}
