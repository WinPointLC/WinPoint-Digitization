package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.dao.AttendanceDao;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

public class AttendanceHelper {
	public ArrayList<AttendanceScreenWrapper> getAttendance(Integer batchId){
		return new AttendanceDao().getAttendance(batchId);
	}
}