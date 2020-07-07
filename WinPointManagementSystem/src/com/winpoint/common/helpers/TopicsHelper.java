package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.Topic;
import com.winpoint.common.dao.TopicsDao;
import com.winpoint.common.wrappers.ProgressTrackingWrapper;

public class TopicsHelper {

	public List<Topic> getTopicsList(int courseId) {
		return new TopicsDao().getTopicsList(courseId);
	}
	public List<ProgressTrackingWrapper> getProgressTrackingWrapper1(int courseId,int batchId) {
		return new TopicsDao().getProgressTrackingWrapper1(courseId,batchId);
	}
}
