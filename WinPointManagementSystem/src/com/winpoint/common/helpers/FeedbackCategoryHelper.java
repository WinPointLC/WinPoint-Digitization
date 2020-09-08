package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.FeedbackCategory;
import com.winpoint.common.dao.FeedbackCategoryDao;

public class FeedbackCategoryHelper {

	public List<FeedbackCategory> getFeedbackCategoryList() {
		return new FeedbackCategoryDao().getFeedbackCategoryList();
	}

	
}
