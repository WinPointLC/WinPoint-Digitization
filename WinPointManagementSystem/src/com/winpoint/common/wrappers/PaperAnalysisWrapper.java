package com.winpoint.common.wrappers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.UserTestResponses;

public class PaperAnalysisWrapper {
	
	private int totalQuestions;
	private int questionsAttempted;
	private int marksReceived;
	private int totalMarksOutOf;
	private int testAttempted;

    
	public PaperAnalysisWrapper(int totalQuestions, int marksReceived, int totalMarks, List<UserTestResponses> userTestResponses) {
		super();
		this.totalQuestions = totalQuestions;
		this.marksReceived = marksReceived;
		this.totalMarksOutOf = totalMarks;
		this.userTestResponses = userTestResponses;
		
		
	}
    public int getTestAttempted() {
		return testAttempted;
	}


	public void setTestAttempted(int testAttempted) {
		this.testAttempted = testAttempted;
	}


	public List<UserTestResponses> getUserTestResponses() {
		return userTestResponses;
	}


	public void setUserTestResponses(List<UserTestResponses> userTestResponses) {
		this.userTestResponses = userTestResponses;
	}


	List<UserTestResponses> userTestResponses =  new ArrayList<UserTestResponses>();
	
	
    public PaperAnalysisWrapper() {
		super();
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
	
	public int getTotalMarksOutOf() {
		return totalMarksOutOf;
	}
	
	public void setTotalMarksOutOf(int totalMarks) {
		this.totalMarksOutOf = totalMarks;
	}
	
	public List<UserTestResponses> getQuestionAnswersWrappers() {
		return userTestResponses;
	}
	
	public void setUserTestResponses(ArrayList<UserTestResponses> userTestResponses) {
		this.userTestResponses = userTestResponses;
	}
	
	public int getQuestionsAttempted() {
		return questionsAttempted;
	}
	public void setQuestionsAttempted(int questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.getMarksReceived()+"   "+this.getTotalMarksOutOf()+"   "+this.getTotalQuestions();
	}
	
	
	
}
