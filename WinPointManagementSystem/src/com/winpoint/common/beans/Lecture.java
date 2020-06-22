package com.winpoint.common.beans;

import java.sql.Date;

public class Lecture {
private Integer LectureId;
private Integer BatchId;
private Integer LectureNumber;
private Integer LectureDuration;
private Integer StartTime;
private String LectureCoverage;
private Date LectureDate;
private String Comments;
public Lecture(Integer lectureId, Integer batchId, Integer lectureNumber, Integer lectureDuration, Integer startTime,
		String lectureCoverage, Date lectureDate, String comments) {
	super();
	LectureId = lectureId;
	BatchId = batchId;
	LectureNumber = lectureNumber;
	LectureDuration = lectureDuration;
	StartTime = startTime;
	LectureCoverage = lectureCoverage;
	LectureDate = lectureDate;
	Comments = comments;
}
public Integer getLectureId() {
	return LectureId;
}
public void setLectureId(Integer lectureId) {
	LectureId = lectureId;
}
public Integer getBatchId() {
	return BatchId;
}
public void setBatchId(Integer batchId) {
	BatchId = batchId;
}
public Integer getLectureNumber() {
	return LectureNumber;
}
public void setLectureNumber(Integer lectureNumber) {
	LectureNumber = lectureNumber;
}
public Integer getLectureDuration() {
	return LectureDuration;
}
public void setLectureDuration(Integer lectureDuration) {
	LectureDuration = lectureDuration;
}
public Integer getStartTime() {
	return StartTime;
}
public void setStartTime(Integer startTime) {
	StartTime = startTime;
}
public String getLectureCoverage() {
	return LectureCoverage;
}
public void setLectureCoverage(String lectureCoverage) {
	LectureCoverage = lectureCoverage;
}
public Date getLectureDate() {
	return LectureDate;
}
public void setLectureDate(Date lectureDate) {
	LectureDate = lectureDate;
}
public String getComments() {
	return Comments;
}
public void setComments(String comments) {
	Comments = comments;
}


}
