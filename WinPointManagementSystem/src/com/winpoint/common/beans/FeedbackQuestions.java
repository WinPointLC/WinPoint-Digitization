package com.winpoint.common.beans;

import java.util.Date;

public class FeedbackQuestions {
	private Integer feedbackQuestionId;
	private String feedbackQuestion;
	private String feedbackQuestionType;
	private Integer createdBy;
	private Date createdDate;
	private Integer feedbackCategoryId;
	/**
	 * @param feedbackQuestionId
	 * @param feedbackQuestion
	 * @param createdBy
	 * @param createdDate
	 */
	public FeedbackQuestions(Integer feedbackQuestionId, String feedbackQuestion, Integer createdBy, Date createdDate) {
		super();
		this.feedbackQuestionId = feedbackQuestionId;
		this.feedbackQuestion = feedbackQuestion;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	public FeedbackQuestions() {
		
	}
	
	/**
	 * @return the feedbackQuestionId
	 */
	public Integer getFeedbackQuestionId() {
		return feedbackQuestionId;
	}
	
	/**
	 * @param feedbackQuestionId the feedbackQuestionId to set
	 */
	public void setFeedbackQuestionId(Integer feedbackQuestionId) {
		this.feedbackQuestionId = feedbackQuestionId;
	}
	
	/**
	 * @return the feedbackQuestion
	 */
	public String getFeedbackQuestion() {
		return feedbackQuestion;
	}
	
	/**
	 * @param feedbackQuestion the feedbackQuestion to set
	 */
	public void setFeedbackQuestion(String feedbackQuestion) {
		this.feedbackQuestion = feedbackQuestion;
	}
	
	
	public String getFeedbackQuestionType() {
		return feedbackQuestionType;
	}

	public void setFeedbackQuestionType(String feedbackQuestionType) {
		this.feedbackQuestionType = feedbackQuestionType;
	}

	
	public FeedbackQuestions(Integer feedbackQuestionId, String feedbackQuestion, String feedbackQuestionType,
			Integer createdBy, Date createdDate, Integer feedbackCategoryId) {
		super();
		this.feedbackQuestionId = feedbackQuestionId;
		this.feedbackQuestion = feedbackQuestion;
		this.feedbackQuestionType = feedbackQuestionType;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.feedbackCategoryId = feedbackCategoryId;
	}

	public Integer getFeedbackCategoryId() {
		return feedbackCategoryId;
	}

	public void setFeedbackCategoryId(Integer feedbackCategoryId) {
		this.feedbackCategoryId = feedbackCategoryId;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
