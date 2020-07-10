package com.winpoint.common.wrappers;

public class ProgressTrackingWrapper {
 private String topicName;
 private Integer topicDuration;
public ProgressTrackingWrapper(String topicName, Integer topicDuration) {
	super();
	this.topicName = topicName;
	this.topicDuration = topicDuration;
}
public String getTopicName() {
	return topicName;
}
public void setTopicName(String topicName) {
	this.topicName = topicName;
}
public Integer getTopicDuration() {
	return topicDuration;
}
public void setTopicDuration(Integer topicDuration) {
	this.topicDuration = topicDuration;
}
 
}