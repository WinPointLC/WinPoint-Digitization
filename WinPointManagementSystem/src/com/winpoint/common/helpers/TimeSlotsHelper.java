package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.dao.TimeSlotsDao;

public class TimeSlotsHelper {
	
	public List<TimeSlots> getTimeSlotsList(){
		return new TimeSlotsDao().getTimeSlotsList();
	}

}
