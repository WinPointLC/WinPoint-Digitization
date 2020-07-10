package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.dao.AttendanceDao;

public class AttendanceHelper {
	public ArrayList<Lecture> getAttendance(){		
		return new AttendanceDao().getAttendance();	
	}
}