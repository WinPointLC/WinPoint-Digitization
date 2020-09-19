package com.winpoint.common.helpers;

import com.winpoint.common.dao.UserTestDetailsDao;

public class UserTestDetailsHelper {
	
	public boolean getTestStatus(int userId, int courseId) {
		return new UserTestDetailsDao().getTestStatus(userId, courseId);
	}
	
}
