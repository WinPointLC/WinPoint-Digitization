package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.dao.UserProfileDao;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;
import javafx.util.Callback;

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


    //BatchIndividual

    public ArrayList<BatchIndividualFeedbackScreenWrapper> getBatchIndividualFeedbackScreenWrapperList(Integer batchId){
        return new UserProfileDao().getBatchIndividualFeedbackScreenWrapperList(batchId); 
    }
}