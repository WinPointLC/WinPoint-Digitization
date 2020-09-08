package com.winpoint.common.helpers;


import java.util.List;

import com.winpoint.common.beans.ReminderType;
import com.winpoint.common.dao.ReminderTypeDao;


public class ReminderTypeHelper {
	public List<ReminderType> getReminderType() {
		return new ReminderTypeDao().getReminderType();
	}
}
