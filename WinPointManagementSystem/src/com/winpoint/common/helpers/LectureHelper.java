package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.dao.LectureDao;
import com.winpoint.common.wrappers.EditBatchDetailsWrapper;

public class LectureHelper {
	public ArrayList<Lecture> getAbsenteeListforBatch(Integer batchId){
		return new LectureDao().getAbsenteeListforBatch(batchId);
	}
	public Lecture getLectureDetailsForBatch(Integer batchId, Integer lectureNumber) {
		return new LectureDao().getLectureDetailsForBatch(batchId, lectureNumber);
	}
	public EditBatchDetailsWrapper getLectureDetails(Integer courseId,Integer lecnum,Integer batchId){
		return new LectureDao().getLectureDetails(courseId,lecnum,batchId);
	}
	public ArrayList<Integer> getLectureCoverageIds(Integer lecnum,Integer batchId){
		return new LectureDao().getLectureCoverageIds(lecnum,batchId);
	}
	public ArrayList<EditBatchDetailsWrapper> getLectureNumber(Integer batchId){
		return new LectureDao().getLectureNumber(batchId);
	}
	public void updateLectureDetails(EditBatchDetailsWrapper updateLecDetails,Integer batchId,Integer lecnum) {
		new LectureDao().updateLectureDetails(updateLecDetails,batchId,lecnum);
	}
}
