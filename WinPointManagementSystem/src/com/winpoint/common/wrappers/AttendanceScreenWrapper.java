package com.winpoint.common.wrappers;

import java.util.ArrayList;
import java.util.HashMap;

import com.winpoint.common.beans.Lecture;

/*
key - lecture Id
value - boolean present/absent

create this hashmap for each student.
 */


public class AttendanceScreenWrapper {
	Integer userId;
	String firstName;
	String lastName;
	HashMap<Integer, Boolean> attendanceMap;
	
	public AttendanceScreenWrapper(Integer userId, String firstName, String lastName,
			HashMap<Integer, Boolean> attendanceMap) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.attendanceMap = attendanceMap;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public HashMap<Integer, Boolean> getAttendanceMap() {
		return attendanceMap;
	}

	public void setAttendanceMap(HashMap<Integer, Boolean> attendanceMap) {
		this.attendanceMap = attendanceMap;
	}

	 
	
}
