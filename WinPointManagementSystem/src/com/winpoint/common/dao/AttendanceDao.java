package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Lecture;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.util.sql.ConnectionManager;

public class AttendanceDao {
	public ArrayList<Lecture> getAttendance(){
		ArrayList<Lecture> attendance = new ArrayList<Lecture>();
		Lecture lecture1, lecture2, lecture3;
		
		lecture1 = new Lecture(105, null, 1, 2, null, null, null, null);
		lecture2 = new Lecture(106, null, 2, 2, null, null, null, null);
		lecture3 = new Lecture(107, null, 3, 2, null, null, null, null);
		
		attendance.add(lecture1);
		attendance.add(lecture2);
		attendance.add(lecture3);
		
		return attendance;	
	}
}
