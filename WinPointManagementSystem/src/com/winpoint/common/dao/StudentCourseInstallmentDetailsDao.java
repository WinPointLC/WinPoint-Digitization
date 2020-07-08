package com.winpoint.common.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseInstallmentDetails;

public class StudentCourseInstallmentDetailsDao {
	public ArrayList<StudentCourseInstallmentDetails> getStudentCourseInstallmentDetails() {		
		ArrayList<StudentCourseInstallmentDetails> studentCourseInstallmentDetails = new ArrayList<StudentCourseInstallmentDetails>();
		
		StudentCourseInstallmentDetails studentCourseInstallmentDetails1, studentCourseInstallmentDetails2, studentCourseInstallmentDetails3;
		
		studentCourseInstallmentDetails1 = new StudentCourseInstallmentDetails(30, null, 4000, null, 4000, null, 5000, null, 4000, null, 2000, null, 0, null, 3000);
		studentCourseInstallmentDetails2 = new StudentCourseInstallmentDetails(30, null, 4000, null, 4000, null, 5000, null, 5000, null, 2000, null, 2000, null, 0);
		studentCourseInstallmentDetails3 = new StudentCourseInstallmentDetails(30, null, 4000, null, 0, null, 5000, null, 0, null, 2000, null, 0, null, 11000);
		
		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails1);
		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails2);
		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails3);
		
		return studentCourseInstallmentDetails;
	}
}
