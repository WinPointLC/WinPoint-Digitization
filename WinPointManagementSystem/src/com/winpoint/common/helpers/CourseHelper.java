package com.winpoint.common.helpers;


import java.util.ArrayList;
import java.util.List;


import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseBatchDetail;
import com.winpoint.common.beans.Test;

import com.winpoint.common.dao.CourseDao;
import com.winpoint.common.wrappers.SignUpFormCourseListWrapper;


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

	public ArrayList<SignUpFormCourseListWrapper> getCourseNamesList() {
		return new CourseDao().getCoursesNamesList();
	}

	
	public ArrayList<CourseBatchDetail> getCourseBatchDetail(int streamId, int courseTypeId){
		return new CourseDao().getCourseBatchDetail(streamId, courseTypeId);
	}

}
