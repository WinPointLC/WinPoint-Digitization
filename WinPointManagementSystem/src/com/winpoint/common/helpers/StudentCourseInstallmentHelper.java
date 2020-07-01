package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.dao.StudentCourseInstallmentDetailsDao;

public class StudentCourseInstallmentHelper {
	public ArrayList<StudentCourseInstallmentDetails> getStudentCourseInstallmentDetailsList() {
		return new StudentCourseInstallmentDetailsDao().getStudentCourseInstallmentDetails();
	}
}
