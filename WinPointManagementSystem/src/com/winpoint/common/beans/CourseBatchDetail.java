package com.winpoint.common.beans;

import java.util.ArrayList;
import java.util.Date;

public class CourseBatchDetail extends Course{
	//int batchId;
	ArrayList<String> batchNameList;
	
	
	public CourseBatchDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(int courseId, String courseName, int courseFees, int streamId, int courseTypeId, String iconLocation, ArrayList<String> batchNameList) {
		super(courseId, courseName, courseFees, streamId, courseTypeId, iconLocation);
		this.batchNameList  = batchNameList;
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(int courseId, String courseName, int courseTypeId) {
		super(courseId, courseName, courseTypeId);
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(Integer courseId, String courseName, Integer courseDuration, Integer courseFees,
			Integer streamId, Integer courseTypeId, String coursewareExist, Integer evaluationTypeId,
			Integer totalTests, Integer createdBy, Date createdDate) {
		super(courseId, courseName, courseDuration, courseFees, streamId, courseTypeId, coursewareExist, evaluationTypeId,
				totalTests, createdBy, createdDate);
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(Integer courseId, String courseName, Integer courseDuration, Integer courseFees,
			Integer streamId, Integer courseTypeId, String coursewareExist, Integer evaluationTypeId,
			String iconLocation, Integer totalTests, Integer createdBy, Date createdDate, String preRequisite) {
		super(courseId, courseName, courseDuration, courseFees, streamId, courseTypeId, coursewareExist, evaluationTypeId,
				iconLocation, totalTests, createdBy, createdDate, preRequisite);
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(Integer courseId, String courseName, Integer courseFees, Integer streamId,
			Integer courseTypeId, Integer courseDuration) {
		super(courseId, courseName, courseFees, streamId, courseTypeId, courseDuration);
		// TODO Auto-generated constructor stub
	}
	public CourseBatchDetail(Integer courseDuration) {
		super(courseDuration);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> getBatchListName() {
		return batchNameList;
	}
	public void setBatchListName(ArrayList<String> batchNameList) {
		this.batchNameList = batchNameList;
	}
	
}
