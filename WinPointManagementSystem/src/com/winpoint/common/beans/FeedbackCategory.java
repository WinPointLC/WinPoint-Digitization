package com.winpoint.common.beans;

public class FeedbackCategory {
private Integer FeedbackCategoryId;
private String FeedbackCategoryDescription;
public FeedbackCategory(Integer feedbackCategoryId, String feedbackCategoryDescription) {
	super();
	FeedbackCategoryId = feedbackCategoryId;
	FeedbackCategoryDescription = feedbackCategoryDescription;
}
public Integer getFeedbackCategoryId() {
	return FeedbackCategoryId;
}
public void setFeedbackCategoryId(Integer feedbackCategoryId) {
	FeedbackCategoryId = feedbackCategoryId;
}
public String getFeedbackCategoryDescription() {
	return FeedbackCategoryDescription;
}
public void setFeedbackCategoryDescription(String feedbackCategoryDescription) {
	FeedbackCategoryDescription = feedbackCategoryDescription;
}

}
