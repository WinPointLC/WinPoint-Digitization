package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.FeedbackCategory;
import com.winpoint.common.dao.FeedBackCategoryDao;

public class FeedBackCategoryHelper {

	public List<FeedbackCategory> getFeedBackCategoryList() {
		return new FeedBackCategoryDao().getFeedBackCategoryList();
	}

	
}
