package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.TestFeedback;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.dao.StreamDao;
import com.winpoint.common.dao.TestFeedbackDao;
import com.winpoint.common.dao.UserProfileDao;

public class UserProfileHelper {
	public boolean updateUserProfile(UserProfile userProfile){
		return new UserProfileDao().updateUserProfile(userProfile);
	}
	
	public ArrayList<UserProfile> getUsers(){
		return new UserProfileDao().getUsers();
	}
	
	public String getCoursesList(Integer userId) {
		return new UserProfileDao().getCoursesList(userId);
	}
}
