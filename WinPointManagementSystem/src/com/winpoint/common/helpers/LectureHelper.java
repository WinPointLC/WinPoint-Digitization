package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.dao.LectureDao;

public class LectureHelper {
	public ArrayList<Lecture> getAbsenteeListforBatch(Integer batchId){
		return new LectureDao().getAbsenteeListforBatch(batchId);
	}
	public Lecture getLectureDetailsForBatch(Integer batchId, Integer lectureNumber) {
		return new LectureDao().getLectureDetailsForBatch(batchId, lectureNumber);
	}
}
