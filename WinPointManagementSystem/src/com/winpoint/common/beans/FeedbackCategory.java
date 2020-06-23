package com.winpoint.common.beans;

public class FeedbackCategory {
private Integer feedbackCategoryId;
private String feedbackCategoryDescription;
public FeedbackCategory(Integer feedbackCategoryId, String feedbackCategoryDescription) {
	super();
	this.feedbackCategoryId = feedbackCategoryId;
	this.feedbackCategoryDescription = feedbackCategoryDescription;
}
public Integer getFeedbackCategoryId() {
	return feedbackCategoryId;
}
public void setFeedbackCategoryId(Integer feedbackCategoryId) {
	this.feedbackCategoryId = feedbackCategoryId;
}
public String getFeedbackCategoryDescription() {
	return feedbackCategoryDescription;
}
public void setFeedbackCategoryDescription(String feedbackCategoryDescription) {
	this.feedbackCategoryDescription = feedbackCategoryDescription;
}


}
