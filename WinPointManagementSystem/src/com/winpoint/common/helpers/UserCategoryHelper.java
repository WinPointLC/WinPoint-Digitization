package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.UserCategory;
import com.winpoint.common.dao.UserCategoryDao;

public class UserCategoryHelper {

	public List<UserCategory> getUserCategoryList() {
		return new UserCategoryDao().getUserCategoryList();
	}

}
