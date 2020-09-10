package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	//public void createCourseTypeList(ArrayList<CourseType> newCourseTypeArrayList) {
		public void createCourseTypeList(Object[] courseTypes) {
		System.out.println("From Course Type Helper");
		for(Object courseTypeObj : courseTypes) {
			Arrays courseTypeArray = (Arrays)courseTypeObj;
			System.out.println(courseTypeArray);
		}
		 //new CourseTypeDao().createCourseTypeList(newCourseTypeArrayList);
	}
	
	public void deleteCourseType(ArrayList<Integer> deleteCourseTypeArrayList) {
		 new CourseTypeDao().deleteCourseTypeList(deleteCourseTypeArrayList);
	}
}
