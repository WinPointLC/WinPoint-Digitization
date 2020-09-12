package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Test;
import com.winpoint.common.dao.CourseDao;
import com.winpoint.common.dao.CourseTypeDao;

public class CourseTypeHelper {
	public List<CourseType> getCourseTypeList(int streamId){
		return new CourseTypeDao().getCourseTypeList(streamId);
	}

	public List<CourseType> getCourseTypeList(){
		return new CourseTypeDao().getCourseTypeList();
	}

	public Integer getCourseTypeId(String courseTypeName) {
		return new CourseTypeDao().getCourseTypeId(courseTypeName);
	}

	public List<Test> getTestsList(int userId, int streamId, int courseTypeId, int courseId) {
		return new CourseDao().getTestList(streamId, courseTypeId);
	}

	public CourseType getCourseTypeName(Integer courseTypeId) {
		return new CourseTypeDao().getCourseTypeName(courseTypeId);
	}


	public List<CourseType> getCourseType() {
		System.out.println("From CourseTypeHelper");
		return new CourseTypeDao().getCoursesTypeList();
	}

	public void createCourseTypeList(Object[] courseTypes) {
		System.out.println("From Course Type Helper");

		ArrayList<CourseType>newCourseTypeList =new ArrayList<>();
		for(Object courseTypeObj : courseTypes) {
			String string = courseTypeObj.toString();
			newCourseTypeList.add(new CourseType(string.substring(1, string.length()-1)));
		}
		new CourseTypeDao().createCourseTypeList(newCourseTypeList);
	}

	public void deleteCourseTypeList(Object[] deleteCourseTypeList) {
		System.out.println("From Delete Course Type Helper ");
		ArrayList<Integer> deleteCourseTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteCourseTypeList) {
			deleteCourseTypeArrayList.add(Integer.parseInt(id.toString()));
		}
		if(deleteCourseTypeArrayList.size()!=0) {
			new CourseTypeDao().deleteCourseTypeList(deleteCourseTypeArrayList);
		}
	}
}
