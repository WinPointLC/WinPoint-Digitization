package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.dao.StudentCourseDetailsDao;

public class StudentCourseDetailsHelper {
	/*public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentCourseDetailsList(userId);
	}*/
	
	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(){
		return new StudentCourseDetailsDao().getStudentCourseDetails();
	}
	

	/*public void createStudentCourseDetails(int userId, int courseId, String courseName, int streamId, int courseTypeId, String feeStatus) {
		new StudentCourseDetailsDao().createStudentCourseDetails(userId, courseId, courseName, streamId, feeStatus);
	}*/
	
	/*public void updateStudentCourseDetails(int userId, int courseId) {
		new StudentCourseDetailsDao().updateStudentCourseDetails(userId, courseId);
	}*/

	

	
}
