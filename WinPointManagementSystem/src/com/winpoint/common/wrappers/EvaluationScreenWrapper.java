package com.winpoint.common.wrappers;

import javafx.scene.control.Hyperlink;

public class EvaluationScreenWrapper{//extends EvaluationScreenWrapperParent{
	private String fullName;
	private String gradeId;
	private String isCertificateGiven;
	private Integer userId;
	private Integer attendance;
	private Integer marks;
	transient private Hyperlink hpl;
	public EvaluationScreenWrapper(String firstName,String lastName,Integer userId,
			Integer attendance,Integer marks, String gradeId, String isCertificateGiven) {
		
		//super(firstName, lastName, userId, attendance, marks, gradeId, isCertificateGiven);
		this.fullName = firstName + " " +lastName;
		this.userId = userId;
		this.attendance = attendance;
		this.marks = marks;
		this.gradeId = gradeId;
		this.isCertificateGiven = isCertificateGiven;
	}

	public EvaluationScreenWrapper(String firstName,String lastName, String gradeId, String isCertificateGiven) {
		//super(firstName, lastName, gradeId, isCertificateGiven);
		this.fullName =firstName + " " +lastName;
		this.gradeId = gradeId;
		this.isCertificateGiven = isCertificateGiven;
	}
	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getIsCertificateGiven() {
		return isCertificateGiven;
	}
	public void setIsCertificateGiven(String isCertificateGiven) {
		this.isCertificateGiven = isCertificateGiven;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAttendance() {
		return attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public Hyperlink getHpl() {
		return hpl;
	}

	public void setHpl(Hyperlink hpl) {
		this.hpl = hpl;
	}	
}
	