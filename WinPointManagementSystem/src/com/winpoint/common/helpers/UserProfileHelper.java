package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.dao.UserProfileDao;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;

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


    public List<UserProfile> getRegisteredUsers(){
        return new UserProfileDao().getRegisteredUsers();
    }

    public List<UserProfile> getFaculty(){
        return new UserProfileDao().getFaculty();
    }

    public ArrayList<BatchIndividualFeedbackScreenWrapper> getBatchIndividualFeedbackScreenWrapperList(Integer batchId){
        return new UserProfileDao().getBatchIndividualFeedbackScreenWrapperList(batchId); 
    }
    
    public ArrayList<UserProfile> getStudentListForBatch(Integer batchId){
	    return new UserProfileDao().getStudentListForBatch(batchId);
	}


	public UserProfile getUserProfile(int userId) {
		// TODO Auto-generated method stub
		return new UserProfileDao().getUserProfile(userId);
	}

//	public void create(Integer userId, List<EnquiryDetails> list) {
//		 new UserProfileDao().create(userId,list);
//	}

}