package com.winpoint.common.helpers;

import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.Test;
import com.winpoint.common.dao.CourseDao;
import com.winpoint.common.dao.CourseTypeDao;
import com.winpoint.common.dao.StreamDao;

public class CourseTypeHelper {
	public List<CourseType> getCourseTypeList(int streamId){
		return new CourseTypeDao().getCourseTypeList(streamId);
	}

	public List<Test> getTestsList(int userId, int streamId, int courseTypeId, int courseId) {
		return new CourseDao().getTestList(streamId, courseTypeId);
	}
}
