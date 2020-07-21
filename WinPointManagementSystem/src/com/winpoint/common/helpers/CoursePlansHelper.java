package com.winpoint.common.helpers;

import com.winpoint.common.beans.CoursePlans;
import com.winpoint.common.dao.CoursePlansDao;

public class CoursePlansHelper {
	public CoursePlans getCoursePlan(Integer courseId, Integer lectureNumber) {
		return new CoursePlansDao().getCoursePlan(courseId, lectureNumber);
	}
}
