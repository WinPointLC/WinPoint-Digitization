package com.winpoint.common.beans;

public class FeedbackQuestionType {
	
	private Integer feedbackQuestionTypeId;
	private String feedbackQuestionType;
	
	
	public FeedbackQuestionType(Integer feedbackQuestionTypeId, String feedbackQuestionType) {
		super();
		this.feedbackQuestionTypeId = feedbackQuestionTypeId;
		this.feedbackQuestionType = feedbackQuestionType;
	}
	public Integer getFeedbackQuestionTypeId() {
		return feedbackQuestionTypeId;
	}
	public void setFeedbackQuestionTypeId(Integer feedbackQuestionTypeId) {
		this.feedbackQuestionTypeId = feedbackQuestionTypeId;
	}
	public String getFeedbackQuestionType() {
		return feedbackQuestionType;
	}
	public void setFeedbackQuestionType(String feedbackQuestionType) {
		this.feedbackQuestionType = feedbackQuestionType;
	}

}
