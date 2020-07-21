package com.winpoint.common.wrappers;

public class BatchFeedbackScreenWrapper {
	
	private Integer feedbackCount;

	
	public BatchFeedbackScreenWrapper(Integer feedbackCount) {
		super();
		this.feedbackCount = feedbackCount;
	}

	public Integer getFeedbackCount() {
		return feedbackCount;
	}

	public void setFeedbackCount(Integer feedbackCount) {
		this.feedbackCount = feedbackCount;
	}

}
