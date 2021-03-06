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
	
	
	
	public void createFeedbackCategoryList(Object newFeedbackCategoryList []) {
		ArrayList<FeedbackCategory>newFeedbackCategoryArrayList =new ArrayList<>();	
		for(Object feedbackCategoryObj : newFeedbackCategoryList) {
			String str  = feedbackCategoryObj.toString();
			newFeedbackCategoryArrayList.add(new FeedbackCategory(str.substring(1, str.length()-1)));
		}                
		 new FeedbackCategoryDao().createFeedbackCategoryList(newFeedbackCategoryArrayList);
	}
	
	public void deleteFeedbackCategoryList(Object deleteFeedbackCategoryList []) {
		ArrayList<Integer> deleteFeedbackCategoryArrayList = new ArrayList<Integer>();
		for(Object id: deleteFeedbackCategoryList) {
			deleteFeedbackCategoryArrayList.add(Integer.parseInt(id.toString()));
		}	
		if(deleteFeedbackCategoryArrayList.size()!=0)
			new FeedbackCategoryDao().deleteFeedbackCategoryList(deleteFeedbackCategoryArrayList);
	}

	
}
