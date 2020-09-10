package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.UserCategory;
import com.winpoint.common.dao.UserCategoryDao;

public class UserCategoryHelper {

	public List<UserCategory> getUserCategoryList() {
		return new UserCategoryDao().getUserCategoryList();
	}

	public void createUserCategoryList(ArrayList<UserCategory> newUserCategoryArrayList) {
		 new UserCategoryDao().createUserCategoryList(newUserCategoryArrayList);
	}
	
	public void deleteUserCategoryList(ArrayList<Integer> deleteUserCategoryArrayList) {
		 new UserCategoryDao().deleteUserCategoryList(deleteUserCategoryArrayList);
	}
	
}
