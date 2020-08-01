package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.dao.AttendanceDao;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class AttendanceHelper {
//	public ArrayList<AttendanceScreenWrapper> getStudentAttendanceForBatch(Integer batchId){
//		return new AttendanceDao().getStudentAttendanceForBatch(batchId);
//	}
	
	public ObservableList<ObservableList<String>> getStudentAttendanceForBatch(Integer batchId){
		return new AttendanceDao().getStudentsAttendanceForBatch(batchId);
	}

	public int getPercentageStudenAttendanceForBatch(int userId, int batchId) {
		// TODO Auto-generated method stub
		return new AttendanceDao().getPercentageStudenAttendanceForBatch(userId, batchId);
	}
}