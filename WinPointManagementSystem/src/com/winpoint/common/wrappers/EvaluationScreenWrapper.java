package com.winpoint.common.wrappers;

import javafx.scene.control.Hyperlink;

public class EvaluationScreenWrapper extends EvaluationScreenWrapperParent{
	
	private Hyperlink hpl;
	public EvaluationScreenWrapper(String firstName,String lastName,Integer userId,
			Integer attendance,Integer marks, String gradeId, String isCertificateGiven) {
		
		super(firstName, lastName, userId, attendance, marks, gradeId, isCertificateGiven);		
	}

	public EvaluationScreenWrapper(String firstName,String lastName, String gradeId, String isCertificateGiven) {
		super(firstName, lastName, gradeId, isCertificateGiven);
	}

	public Hyperlink getHpl() {
		return hpl;
	}

	public void setHpl(Hyperlink hpl) {
		this.hpl = hpl;
	}	
}
	