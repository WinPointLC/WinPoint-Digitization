package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.dao.TimeSlotsDao;

public class TimeSlotsHelper {
	
	public List<TimeSlots> getTimeSlotsList(){
		return new TimeSlotsDao().getTimeSlotsList();
	}

	public void createTimeSlotsList(Object[] newTimeSlotsList) {
		ArrayList<TimeSlots> newTimeSlotsArrayList = new ArrayList<TimeSlots>();
		for(Object object: newTimeSlotsList) {
			String string = object.toString();
			newTimeSlotsArrayList.add(new TimeSlots(string.substring(1,string.length()-1)));
		}
		 new TimeSlotsDao().createTimeSlotsList(newTimeSlotsArrayList);
	}
	
	public void deleteTimeSlotsList(Object[] deleteTimeSlotsList) {
		ArrayList<Integer> deleteTimeSlotsArrayList = new ArrayList<>();
		for(Object id: deleteTimeSlotsList) {
			deleteTimeSlotsArrayList.add(Integer.parseInt(id.toString()));
		}
		 new TimeSlotsDao().deleteTimeSlotsList(deleteTimeSlotsArrayList);
	}

	
}
