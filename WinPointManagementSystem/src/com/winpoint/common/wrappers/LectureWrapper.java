package com.winpoint.common.wrappers;

import java.sql.Date;

import com.winpoint.common.beans.Lecture;

public class LectureWrapper {
	private Integer currentLectureNumber;
	private Date batchStartDate;
	private Date batchEndDate;
	private Integer totalLectureEstimate;

	public LectureWrapper(Integer currentLectureNumber, Date batchStartDate, Date batchEndDate,
			Integer totalLectureEstimate) {
		super();
		this.currentLectureNumber = currentLectureNumber;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
		this.totalLectureEstimate = totalLectureEstimate;
	}
	public Integer getCurrentLectureNumber() {
		return currentLectureNumber;
	}
	public void setCurrentLectureNumber(Integer currentLectureNumber) {
		this.currentLectureNumber = currentLectureNumber;
	}
	public Date getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public Date getBatchEndDate() {
		return batchEndDate;
	}
	public void setBatchEndDate(Date batchEndDate) {
		this.batchEndDate = batchEndDate;
	}
	public Integer getTotalLectureEstimate() {
		return totalLectureEstimate;
	}
	public void setTotalLectureEstimate(Integer totalLectureEstimate) {
		this.totalLectureEstimate = totalLectureEstimate;
	}
}
