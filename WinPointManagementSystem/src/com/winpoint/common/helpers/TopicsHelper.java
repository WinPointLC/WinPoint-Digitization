package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.Topic;
import com.winpoint.common.dao.TopicsDao;
import com.winpoint.common.wrappers.ProgressTrackingWrapper;

public class TopicsHelper {

	public List<Topic> getTopicsList(int courseId) {
		return new TopicsDao().getTopicsList(courseId);
	}
	
	public ArrayList<ProgressTrackingWrapper> getProgressTrackingWrapperTableValues(int courseId,int batchId) {
		return new TopicsDao().getProgressTrackingWrapperTableValues(courseId,batchId);
}
	public   ProgressTrackingWrapper getProgressTrackingWrapperValues(int courseId,int batchId) {
		return new TopicsDao().getProgressTrackingWrapperValues(courseId,batchId);
}
}
