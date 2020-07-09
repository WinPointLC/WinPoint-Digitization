package com.winpoint.common.wrappers;

public class EvaluationScreenWrapper {
	private String fullName;
	private String evaluationDone;
	private String gradeId;
	private String isCertificateGiven;
	public EvaluationScreenWrapper(String firstName,String lastName, String evaluationDone, String gradeId, String isCertificateGiven) {
		super();
		this.fullName =firstName + " " +lastName;
		this.evaluationDone = evaluationDone;
		this.gradeId = gradeId;
		this.isCertificateGiven = isCertificateGiven;
	}
	public String getEvaluationDone() {
		return evaluationDone;
	}
	public void setEvaluationDone(String evaluationDone) {
		this.evaluationDone = evaluationDone;
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
	
}
	