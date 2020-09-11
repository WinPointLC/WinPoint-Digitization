package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.FeedbackCategory;
import com.winpoint.common.dao.FeedbackCategoryDao;

public class FeedbackCategoryHelper {

	public List<FeedbackCategory> getFeedbackCategoryList() {
		return new FeedbackCategoryDao().getFeedbackCategoryList();
	}
	

	//===============================================================================================
	
	
	
	public void createFeedbackCategory(Object newFeedbackCategoryList []) {
		ArrayList<FeedbackCategory>newFeedbackCategoryArrayList =new ArrayList<>();	
		for(Object feedbackCategoryObj : newFeedbackCategoryList) {
			newFeedbackCategoryArrayList.add(new FeedbackCategory(feedbackCategoryObj.toString().substring(1, feedbackCategoryObj.toString().length()-1)));
		}
		 new FeedbackCategoryDao().createFeedbackCategoryList(newFeedbackCategoryArrayList);
	}
	
	public void deleteFeedbackCategory(ArrayList<Integer> deleteFeedbackCategoryArrayList) {
		 new FeedbackCategoryDao().deleteFeedbackCategoryList(deleteFeedbackCategoryArrayList);
	}

	
}
