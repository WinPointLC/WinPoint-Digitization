package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

public class StudentCourseInstallmentDetailsDao {
	public ArrayList<FeeRecordsScreenWrapper> getFeeRecordsScreenWrapperList(Integer batchId) {		
		ArrayList<FeeRecordsScreenWrapper> feeRecordsScreenWrapperList = new ArrayList<>();
		StudentCourseInstallmentDetails studentCourseInstallmentDetails = new StudentCourseInstallmentDetails(30, null, 4000, null, 4000, null, 5000, null, 4000, null, 2000, null, 0, null, 3000);
		
//		StudentCourseInstallmentDetails studentCourseInstallmentDetails1, studentCourseInstallmentDetails2, studentCourseInstallmentDetails3;
//		
//		studentCourseInstallmentDetails1 = new StudentCourseInstallmentDetails(30, null, 4000, null, 4000, null, 5000, null, 4000, null, 2000, null, 0, null, 3000);
//		studentCourseInstallmentDetails2 = new StudentCourseInstallmentDetails(30, null, 4000, null, 4000, null, 5000, null, 5000, null, 2000, null, 2000, null, 0);
//		studentCourseInstallmentDetails3 = new StudentCourseInstallmentDetails(30, null, 4000, null, 0, null, 5000, null, 0, null, 2000, null, 0, null, 11000);
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			//System.out.println(connection);
			Statement statement = connection.createStatement();
			
			String query = "SELECT USER_ID FROM STUDENT_COURSE_INSTALLMENT_DETAILS";
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				feeRecordsScreenWrapperList.add(new FeeRecordsScreenWrapper(resultSet.getInt("USER_ID"), "Name", "Paid", "cash", 
						"abc@gmail", "9090909091", studentCourseInstallmentDetails));
			}
			
			
			System.out.println(resultSet.getInt("USER_ID"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails1);
//		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails2);
//		studentCourseInstallmentDetails.add(studentCourseInstallmentDetails3);
		
		return feeRecordsScreenWrapperList;
	}
}
