package com.winpoint.common.helpers;

import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.Test;
import com.winpoint.common.dao.CourseDao;
import com.winpoint.common.dao.StreamDao;

public class CourseHelper {
	public List<Course> getCourseList(int streamId, int courseTypeId){
		return new CourseDao().getCourseList(streamId, courseTypeId);
	}

	public List<Test> getTestsList(int userId, int streamId, int courseTypeId, int courseId) {
		return new CourseDao().getTestList(userId, courseId);
	}
}
