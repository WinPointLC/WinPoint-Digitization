package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.dao.TopicsDao;

import javafx.util.Callback;

public class StudentCourseDetailsHelper {
	public ArrayList<StudentCourseDetails> getStudentCourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentCourseDetailsList(userId);
	}
	
	public ArrayList<StudentCourseDetails> getStudentGACourseDetailsList(int userId){
		return new StudentCourseDetailsDao().getStudentGACourseDetailsList(userId);
	}

	public void createStudentCourseDetails(int userId, int courseId, String courseName, int streamId, int courseTypeId, String feeStatus) {
		new StudentCourseDetailsDao().createStudentCourseDetails(userId, courseId, courseName, streamId, feeStatus);
	}
	
	public void updateStudentCourseDetails(int userId, int courseId) {
		new StudentCourseDetailsDao().updateStudentCourseDetails(userId, courseId);
	}

	public List<StudentCourseDetails> getStudentCourseDetailsList1(int courseId) {
		return new StudentCourseDetailsDao().getStudentCourseDetailsList1(courseId);
	}

	
}
