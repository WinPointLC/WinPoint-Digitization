package com.winpoint.common.helpers;

import java.util.ArrayList;


import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;

public class StudentCourseDetailsHelper {
	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentCourseDetailsList(userId);
	}
	
<<<<<<< HEAD
	public ArrayList<StudentCourseDetails> getStudentGACourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentGACourseDetailsList(userId);
	}
	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(){
		return new StudentCourseDetailsDao().getStudentCourseDetails();
=======
	public ArrayList<AssignmentsScreenWrapper> getAssignmentScreenWrapperList(Integer batchId){
		return new StudentCourseDetailsDao().getAssignmentScreenWrapperList(batchId);
>>>>>>> 62d63d13b282f6b4845cfa0ce0e0fb1c25375f95
	}
	public ArrayList<StudentCourseDetails> getBatchFeedback(){
		return (ArrayList<StudentCourseDetails>)new StudentCourseDetailsDao().getBatchFeedback();
	} 
	public ArrayList<EvaluationScreenWrapper> getStudentEvaluationDetails(Integer batchId){
		return new StudentCourseDetailsDao().getStudentEvaluationDetails(batchId);
	}
	
	
	public ArrayList<StudentCourseDetails> getStudentCountInCourse(Integer courseId){
		return (ArrayList<StudentCourseDetails>)new StudentCourseDetailsDao().getStudentCountInCourse(courseId);
	}

	public void createStudentCourseDetails(int userId, int courseId, String courseName, int streamId, int courseTypeId, String feeStatus) {
		new StudentCourseDetailsDao().createStudentCourseDetails(userId, courseId, courseName, streamId, feeStatus);
	}
	
	public void updateStudentCourseDetails(int userId, int courseId) {
		new StudentCourseDetailsDao().updateStudentCourseDetails(userId, courseId);
	}

	

	
}
