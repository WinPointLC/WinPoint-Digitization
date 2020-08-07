package com.winpoint.common.helpers;

import java.sql.SQLException;
import java.util.List;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.dao.TransferEnquiryDetailsToUserProfileDao;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class DaoHelper {
	
//	public void function(UserCoursesDoneWrapper userId, List<EnquiryDetails> list, Integer courseId, Integer batchId) throws SQLException {
//		new TransferEnquiryDetailsToUserProfileDao().function(userId, list, courseId, batchId);
//	}

	public void functionEnquiredStudent(UserCoursesDoneWrapper userId, Integer courseId, Integer batchId, ManageRevenue revenueDetail, StudentCourseInstallmentDetails studentCourseInstallmentObject) throws SQLException {
		new TransferEnquiryDetailsToUserProfileDao().functionEnquiredStudent(userId, courseId, batchId, revenueDetail, studentCourseInstallmentObject);
	}
	
	public void functionRegisteredStudent(UserCoursesDoneWrapper userId, Integer courseId, Integer batchId, ManageRevenue revenueDetail, StudentCourseInstallmentDetails studentCourseInstallmentObject) throws SQLException {
		new TransferEnquiryDetailsToUserProfileDao().functionRegisteredStudent(userId, courseId, batchId, revenueDetail, studentCourseInstallmentObject);
	}
	
	public Integer accessLatestUserId() {
		return new TransferEnquiryDetailsToUserProfileDao().accessLatestUserId();
	}
}		
