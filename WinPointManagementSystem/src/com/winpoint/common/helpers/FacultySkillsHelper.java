package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.FacultySkills;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.dao.FacultySkillsDao;
import com.winpoint.common.dao.TimeSlotsDao;

public class FacultySkillsHelper {

	
	public List<FacultySkills> getAvailableFaculty(Integer timeSlotsId, Integer courseId){
		return new FacultySkillsDao().getAvailableFaculty(timeSlotsId, courseId);
	}
}