package com.winpoint.common.wrappers;

import java.util.HashSet;

import com.winpoint.common.beans.UserProfile;

public class UserCoursesDoneWrapper {
	
	
	UserProfile userProfile;
	HashSet<String> coursesDone;
	
	
		
	public UserCoursesDoneWrapper(UserProfile userProfile, HashSet<String> coursesDone) {
		this.userProfile = userProfile;                                 
		this.coursesDone =  coursesDone;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public HashSet<String> getCoursesDoneSet() {
		return coursesDone;
	}
	
	public void setCoursesDoneSet(HashSet <String> coursesDoneSet) {
		this.coursesDone =  coursesDoneSet;
	}
	
	
}
