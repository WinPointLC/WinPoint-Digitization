package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.dao.TimeSlotsDao;

public class TimeSlotsHelper {
	
	public List<TimeSlots> getTimeSlotsList(){
		return new TimeSlotsDao().getTimeSlotsList();
	}

	public void createTimeSlotsList(ArrayList<TimeSlots> newTimeSlotsArrayList) {
		 new TimeSlotsDao().createTimeSlotsList(newTimeSlotsArrayList);
	}
	
	public void deleteTimeSlotsList(ArrayList<Integer> deleteTimeSlotsArrayList) {
		 new TimeSlotsDao().deleteTimeSlotsList(deleteTimeSlotsArrayList);
	}

	
}
