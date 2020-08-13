package com.winpoint.common.helpers;

import java.sql.SQLException;

import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.dao.TransferEnquiryDetailsToUserProfileDao;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class DaoHelper {
	
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
