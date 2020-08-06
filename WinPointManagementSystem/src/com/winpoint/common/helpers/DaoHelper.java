package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.List;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.TransferEnquiryDetailsToUserProfileDao;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class DaoHelper {
	
//	public void transactionMethod(Integer userId, List<EnquiryDetails> list, Integer courseId, Integer batchId) {
//		new TransferEnquiryDetailsToUserProfileDao().transactionMethod(userId, list, courseId, batchId);
//	}
	
	public void function(UserCoursesDoneWrapper userId, List<EnquiryDetails> list, Integer courseId, Integer batchId) throws SQLException {
		new TransferEnquiryDetailsToUserProfileDao().function(userId, list, courseId, batchId);
	}

	public void function(UserCoursesDoneWrapper userId, Integer courseId, Integer batchId) throws SQLException {
		// TODO Auto-generated method stub
		new TransferEnquiryDetailsToUserProfileDao().function(userId, courseId, batchId);
	}
	
}		
