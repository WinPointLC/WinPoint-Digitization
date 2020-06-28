package com.winpoint.common.helpers;

import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.dao.StudentCourseInstallmentDetailsDao;

public class FeeRecordsHelper {
	public ObservableList<FeeRecordsScreenWrapper> getFeeRecordsScreenWrapper() {
		ArrayList<StudentCourseDetails> studentCourseDetails = new StudentCourseDetailsDao().getStudentCourseDetails();
		ArrayList<StudentCourseInstallmentDetails> studentCourseInstallmentDetails = new StudentCourseInstallmentDetailsDao().getStudentCourseInstallmentDetails();
		
		ObservableList<FeeRecordsScreenWrapper> feeRecordsScreenWrapper = FXCollections.observableArrayList(
				new FeeRecordsScreenWrapper(studentCourseDetails.get(0), studentCourseInstallmentDetails.get(0)),
				new FeeRecordsScreenWrapper(studentCourseDetails.get(1), studentCourseInstallmentDetails.get(1)),
				new FeeRecordsScreenWrapper(studentCourseDetails.get(2), studentCourseInstallmentDetails.get(2)));
		return feeRecordsScreenWrapper;
	}
}
