package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.List;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.BatchDetailsDao;
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

	public void create(EnquiryDetails enquiryDetailsObject) throws SQLException {
		new EnquiryDetailsDao().create(enquiryDetailsObject);
	}
	
	public void update(EnquiryDetails enquiryDetailsObject) throws SQLException {
		new EnquiryDetailsDao().update(enquiryDetailsObject);
	}
	
	public EnquiryDetails getStartDate() {
		return new EnquiryDetailsDao().getStartDate();
	}
	
}
