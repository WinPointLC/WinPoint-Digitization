package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.HashMap;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.PriorityCoursesListDao;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

public class PriorityCoursesListHelper {
	
	public HashMap<Course, ArrayList<UserCoursesDoneWrapper>> getEnquiredStudentListWithCourses() {
		return new PriorityCoursesListDao().coursesEligibleEnquiredStudentsMaps();
	}
	
	public HashMap<Course, ArrayList<UserCoursesDoneWrapper>> getRegisteredStudentListWithCourses() {
		return new PriorityCoursesListDao().coursesStudentsEligibleMap();
	}
}
