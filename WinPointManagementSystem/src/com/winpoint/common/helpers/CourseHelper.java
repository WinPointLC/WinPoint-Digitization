package com.winpoint.common.helpers;


import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.Course;

import com.winpoint.common.beans.Test;

import com.winpoint.common.dao.CourseDao;


public class CourseHelper {
	public List<Course> getCourseList(int streamId, int courseTypeId){
		return new CourseDao().getCourseList(streamId, courseTypeId);
	}

	public List<Test> getTestsList(int userId, int streamId, int courseTypeId, int courseId) {
		return new CourseDao().getTestList(userId, courseId);
	}
	
	
	public ArrayList<Course> getBatchCourseDurationList() {
		return (ArrayList<Course>)new CourseDao().getBatchCourseDurationList();
		
	}
}

