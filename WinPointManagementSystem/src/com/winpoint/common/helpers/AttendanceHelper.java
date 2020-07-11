package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.dao.AttendanceDao;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

public class AttendanceHelper {
	public ArrayList<AttendanceScreenWrapper> getStudentAttendanceForBatch(Integer batchId){
		return new AttendanceDao().getStudentAttendanceForBatch(batchId);
	}
}