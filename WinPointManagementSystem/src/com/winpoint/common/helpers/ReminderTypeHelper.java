package com.winpoint.common.helpers;


import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.ReminderType;
import com.winpoint.common.dao.ReminderTypeDao;


public class ReminderTypeHelper {
	public List<ReminderType> getReminderTypeList() {
		return new ReminderTypeDao().getReminderTypeList();
	}
	
	public void createReminderTypeList(Object[] newReminderTypeList) {
		ArrayList<ReminderType> newReminderTypeArrayList = new ArrayList<>();
		for(Object object: newReminderTypeList) {
			String string = object.toString();
			newReminderTypeArrayList.add(new ReminderType(string.substring(1, string.length()-1)));
		}
		
		 new ReminderTypeDao().createReminderTypeList(newReminderTypeArrayList);
	}
	
	public void deleteReminderTypeList(Object[] deleteReminderTypeList) {
		ArrayList<Integer> deleteReminderTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteReminderTypeList) {
			deleteReminderTypeArrayList.add(Integer.parseInt(id.toString()));
		}
		
		 new ReminderTypeDao().deleteReminderTypeList(deleteReminderTypeArrayList);
	}

}
