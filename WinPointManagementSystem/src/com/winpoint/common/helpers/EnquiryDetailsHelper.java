package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.EnquiryDetailsDao;


public class EnquiryDetailsHelper {
	public List<EnquiryDetails> getEnquiryDetailsList() {
		return new EnquiryDetailsDao().getEnquiryDetailsList();
	}
}
