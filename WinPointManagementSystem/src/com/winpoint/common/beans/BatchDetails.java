package com.winpoint.common.beans;

import java.util.Date;

/**
 * The class to store the Batch details of each course at WinPoint.
 * @author Sanika Gandhe
 * 
 */
public class BatchDetails {
	
	private Integer batchId;
	private Integer courseId;	
	private Integer facultyId;
	private Date startDate;
	private Date endDate;
	private Integer createdBy;
	private Date createdDate;
	private String batchName;
	private Integer batchTime;
	private Integer currentLectureNumber;
	private Integer lectureDuration; 
	private String facultyName;
	private Integer totalNumberOfLectures;
	/**
	 * @param batchId
	 * @param courseId
	 * @param faculty
	 * @param beginDate
	 * @param endDate
	 * @param createdBy
	 * @param createdDate
	 */
	
	// this Constructor is Created for the testing purpose ~ Abhishek
	public BatchDetails (Integer batchId, Integer facultyId) {
		this.batchId = batchId;
		this.facultyId = facultyId;
		System.out.println(" Default Constructor ");
	}
	
	public BatchDetails ( Integer facultyId) {
		
		this.facultyId = facultyId;
		
	}
	
	public BatchDetails(Integer batchId, Integer courseId, Integer facultyId, Date startDate, Date endDate,
			Integer createdBy, Date createdDate, String batchName, Integer batchTime, Integer currentLectureNumber,
			Integer lectureDuration, String facultyName, Integer totalNumberOfLectures) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.batchName = batchName;
		this.batchTime = batchTime;
		this.currentLectureNumber = currentLectureNumber;
		this.lectureDuration = lectureDuration;
		this.facultyName = facultyName;
		this.totalNumberOfLectures = totalNumberOfLectures;
	}

	public BatchDetails(Integer batchId, Integer courseId, Integer facultyId, Date startDate, Date endDate,
			Integer createdBy, Date createdDate, String batchName, Integer batchTime, Integer currentLectureNumber,
			Integer lectureDuration, String facultyName) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.batchName = batchName;
		this.batchTime = batchTime;
		this.currentLectureNumber = currentLectureNumber;
		this.lectureDuration = lectureDuration;
		this.facultyName = facultyName;
	}

	public BatchDetails (Integer batchId, Integer courseId, Integer facultyId, Integer batchTime, Date startDate, Date endDate, Integer createdBy, Date createdDate) {
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.batchTime = batchTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	public BatchDetails (Integer batchId, Integer courseId, Integer facultyId, Integer batchTime, Date startDate, Date endDate, Integer createdBy, Date createdDate,String facultyName) {
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.batchTime = batchTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.facultyName=facultyName;
	}
	public BatchDetails(Integer batchId, Integer courseId, Integer facultyId, Date startDate, Date endDate,
			Integer createdBy, Date createdDate, String batchName, Integer batchTime, Integer currentLectureNumber,
			Integer lectureDuration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.batchName = batchName;
		this.batchTime = batchTime;
		this.currentLectureNumber = currentLectureNumber;
		this.lectureDuration = lectureDuration;
		
		
}

//	public BatchDetails(String string, String string2, String string3, String string4, String string5, String string6,
//			String string7, String string8) {
//		this.batchId = batchId;
//		this.courseId = courseId;
//		this.facultyId = facultyId;
//		this.batchTime = batchTime;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.createdBy = createdBy;
//		this.createdDate = createdDate;
//	}
//
//	

	//shraddha
	public BatchDetails(String batchId,String batchNumber1, String courseName,Integer courseId,Integer lectureDuration1, Integer totalNumberOfLecture1, Integer facultyId1,
			Integer timeChoice1,Date beginDate1, Date endDate1) {
		// TODO Auto-generated constructor stub
		
		System.out.println("BatchDetailsConstructor");
		System.out.println(courseName +"-"+ courseId +"." + batchNumber1);
		//this.batchId=batchId;
		this.batchName= courseName +"-"+courseId+"." +batchNumber1;
		//this.batchId=batchNumber1;
		this.lectureDuration= lectureDuration1;
		this.totalNumberOfLectures= totalNumberOfLecture1;
		this.facultyId = facultyId1;
		this.batchTime=timeChoice1;
		this.startDate = beginDate1;
		this.endDate = endDate1;

	}

	public BatchDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Integer getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(Integer batchTime) {
		this.batchTime = batchTime;
	}

	public Integer getCurrentLectureNumber() {
		return currentLectureNumber;
	}

	public void setCurrentLectureNumber(Integer currentLectureNumber) {
		this.currentLectureNumber = currentLectureNumber;
	}

	public Integer getLectureDuration() {
		return lectureDuration;
	}

	public void setLectureDuration(Integer lectureDuration) {
		this.lectureDuration = lectureDuration;
	}

	/**
	 * @return the batchId of the batch.
	 */
	public Integer getBatchId() {
		return batchId;
	}
	
	/**
	 * @param batchId the batchId of the batch you want to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	
	/**
	 * @return the courseId of the course.
	 */
	public Integer getCourseId() {
		return courseId;
	}
	
	/**
	 * @param courseId the courseId of the course you want to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * @return the facultyId of the faculty.
	 */ 
	public Integer getFacultyId() {
		return facultyId;
	}
	
	/**
	 * @param facultyId of the faculty you want to set
	 */
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}
	
	/**
	 * @return the startDate of the batch.
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate of the batch you want to set
	 */
	public void setStartDate(Date beginDate) {
		this.startDate = beginDate;
	}
	
	/**
	 * @return the endDate of the batch
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate the endDate of the batch you want to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the createdBy the userId of the user which would reside in the session
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @param createdBy the userId of the user you want to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * @return the createdDate which contains the time stamp of the batch
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * @param createdDate the time stamp of the batch you want to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public Integer getTotalNumberOfLectures() {
		return totalNumberOfLectures;
	}

	public void setTotalNumberOfLectures(Integer totalNumberOfLectures) {
		this.totalNumberOfLectures = totalNumberOfLectures;
	}
	
}
