package com.winpoint.common.helpers;


import com.winpoint.common.dao.AttendanceDao;

import javafx.collections.ObservableList;

public class AttendanceHelper {
//	public ArrayList<AttendanceScreenWrapper> getStudentAttendanceForBatch(Integer batchId){
//		return new AttendanceDao().getStudentAttendanceForBatch(batchId);
//	}
	
	public ObservableList<ObservableList> getStudentAttendanceForBatch(Integer batchId){
		return new AttendanceDao().getStudentsAttendanceForBatch(batchId);
	}

	public int getPercentageStudenAttendanceForBatch(int userId, int batchId) {
		// TODO Auto-generated method stub
		return new AttendanceDao().getPercentageStudenAttendanceForBatch(userId, batchId);
	}
}