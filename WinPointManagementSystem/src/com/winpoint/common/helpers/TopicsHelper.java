package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.Topic;
import com.winpoint.common.dao.TopicsDao;

public class TopicsHelper {

	public List<Topic> getTopicsList(int courseId) {
		return new TopicsDao().getTopicsList(courseId);
	}
}
