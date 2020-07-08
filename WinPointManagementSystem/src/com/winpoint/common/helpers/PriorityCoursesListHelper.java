package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.dao.PriorityCoursesListDao;
import com.winpoint.common.wrappers.PriorityListOfCoursesWrapper;

public class PriorityCoursesListHelper {
	public List<PriorityListOfCoursesWrapper> getPriorityCoursesList() {
		return new PriorityCoursesListDao().getPriorityCoursesList();
	}

}
