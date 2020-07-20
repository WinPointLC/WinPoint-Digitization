package com.winpoint.common.wrappers;

public class ProgressTrackingWrapper {
 private String topicName;
 private Integer topicDuration;
 private Integer totalTopics;
 private Integer courseDuration;
 private Float totalLectures;
 private Integer totalTopicsCovered;
 private Integer elapsedDuration;
 private Float remainingLectures;

public ProgressTrackingWrapper(String topicName, Integer topicDuration, Integer totalTopics, Integer courseDuration,
		Float totalLectures, Integer totalTopicsCovered, Integer elapsedDuration, Float remainingLectures) {
	super();
	this.topicName = topicName;
	this.topicDuration = topicDuration;
	this.totalTopics = totalTopics;
	this.courseDuration = courseDuration;
	this.totalLectures = totalLectures;
	this.totalTopicsCovered = totalTopicsCovered;
	this.elapsedDuration = elapsedDuration;
	this.remainingLectures = remainingLectures;
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
public Integer getTotalTopics() {
	return totalTopics;
}
public void setTotalTopics(Integer totalTopics) {
	this.totalTopics = totalTopics;
}
public Integer getCourseDuration() {
	return courseDuration;
}
public void setCourseDuration(Integer courseDuration) {
	this.courseDuration = courseDuration;
}
public Float getTotalLectures() {
	return totalLectures;
}
public void setTotalLectures(Float totalLectures) {
	totalLectures = totalLectures;
}
public Integer getTotalTopicsCovered() {
	return totalTopicsCovered;
}
public void setTotalTopicsCovered(Integer totalTopicsCovered) {
	this.totalTopicsCovered = totalTopicsCovered;
}
public Integer getElapsedDuration() {
	return elapsedDuration;
}
public void setElapsedDuration(Integer elapsedDuration) {
	this.elapsedDuration = elapsedDuration;
}
public Float getRemainingLectures() {
	return remainingLectures;
}
public void setRemainingLectures(Float remainingLectures) {
	this.remainingLectures = remainingLectures;
}
 
}