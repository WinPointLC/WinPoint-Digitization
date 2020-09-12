package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.UserCategory;
import com.winpoint.common.dao.UserCategoryDao;

public class UserCategoryHelper {

	public List<UserCategory> getUserCategoryList() {
		return new UserCategoryDao().getUserCategoryList();
	}

	public void createUserCategoryList(Object[] newUserCategoryList) {
		ArrayList<UserCategory> newUserCategoryArrayList = new ArrayList<>();
		System.out.println("welcome to create helper");
		for(Object object: newUserCategoryList) {
			String string = object.toString();
			newUserCategoryArrayList.add(new UserCategory(string.substring(1, string.length()-1)));
			System.out.println("String  :"+string);
		}
		 new UserCategoryDao().createUserCategoryList(newUserCategoryArrayList);
	}
	
	public void deleteUserCategoryList(Object[] deleteUserCategoryList) {
		System.out.println("DELETE USER CATEGORY"+deleteUserCategoryList.length);
			
			ArrayList<Integer> deleteUserCategoryArrayList = new ArrayList<Integer>();
			System.out.println("welcome to delete helper");
			for(Object id: deleteUserCategoryList) {
				System.out.println(id.toString());
				deleteUserCategoryArrayList.add(Integer.parseInt(id.toString()));		
			}
			System.out.println(deleteUserCategoryArrayList.size());
			if(deleteUserCategoryArrayList.size()!=0) {
				System.out.println(deleteUserCategoryArrayList);
				new UserCategoryDao().deleteUserCategoryList(deleteUserCategoryArrayList);
			}
	}
	
}
