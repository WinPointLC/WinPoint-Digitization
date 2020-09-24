package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;

public class StudentCourseDetailsHelper {
	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentCourseDetailsList(userId);
	}

	public ArrayList<StudentCourseDetails> getStudentGACourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentGACourseDetailsList(userId);
	}
	public ArrayList<AssignmentsScreenWrapper> getAssignmentScreenWrapperList(Integer batchId){
		return new StudentCourseDetailsDao().getAssignmentScreenWrapperList(batchId);
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

	public List<StudentCourseDetails> getStudentCourseDetailList(int userId, int streamId, int courseTypeId) {
		// TODO Auto-generated method stub
		return new StudentCourseDetailsDao().getStudentCourseDetailList(userId, streamId, courseTypeId);
	}

}
