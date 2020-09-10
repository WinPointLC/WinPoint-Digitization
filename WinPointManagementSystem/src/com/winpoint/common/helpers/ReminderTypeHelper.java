package com.winpoint.common.helpers;


import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.ReminderType;
import com.winpoint.common.dao.ReminderTypeDao;


public class ReminderTypeHelper {
	public List<ReminderType> getReminderTypeList() {
		return new ReminderTypeDao().getReminderTypeList();
	}
	
	public void createReminderTypeList(ArrayList<ReminderType> newReminderTypeArrayList) {
		 new ReminderTypeDao().createReminderTypeList(newReminderTypeArrayList);
	}
	
	public void deleteReminderTypeList(ArrayList<Integer> deleteReminderTypeArrayList) {
		 new ReminderTypeDao().deleteReminderTypeList(deleteReminderTypeArrayList);
	}

}
