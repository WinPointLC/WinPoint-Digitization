package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.dao.LectureDao;
import com.winpoint.common.wrappers.LectureWrapper;

public class LectureHelper {
	public ArrayList<Lecture> getAttendanceforBatch(Integer batchId){
		return new LectureDao().getAttendanceforBatch(batchId);
	}
	public Lecture getLectureDetailsForBatch(Integer batchId, Integer lectureNumber) {
		return new LectureDao().getLectureDetailsForBatch(batchId, lectureNumber);
	}
}
