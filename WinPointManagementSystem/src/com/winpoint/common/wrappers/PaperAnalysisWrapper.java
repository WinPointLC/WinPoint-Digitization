package com.winpoint.common.wrappers;

import java.util.ArrayList;
import java.util.List;

public class PaperAnalysisWrapper {
	
	private int totalQuestions;
	private int marksReceived;
	private int totalMarks;
    List<QuestionAnswerWrapper> questionAnswerWrappers =  new ArrayList<QuestionAnswerWrapper>();
	
	
    public PaperAnalysisWrapper() {
		super();
	}
    
    
	public PaperAnalysisWrapper(int totalQuestions, int marksReceived, int totalMarks, List<QuestionAnswerWrapper> questionAnswerWrappers) {
		super();
		this.totalQuestions = totalQuestions;
		this.marksReceived = marksReceived;
		this.totalMarks = totalMarks;
		this.questionAnswerWrappers = questionAnswerWrappers;
	}
	
	
	
	public int getTotalQuestions() {
		return totalQuestions;
	}
	
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	public int getMarksReceived() {
		return marksReceived;
	}
	
	public void setMarksReceived(int marksReceived) {
		this.marksReceived = marksReceived;
	}
	
	public int getTotalMarks() {
		return totalMarks;
	}
	
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public List<QuestionAnswerWrapper> getQuestionAnswersWrappers() {
		return questionAnswerWrappers;
	}
	
	public void setQuestionAnswersWrappers(ArrayList<QuestionAnswerWrapper> questionAnswersWrappers) {
		this.questionAnswerWrappers = questionAnswersWrappers;
	}
}
