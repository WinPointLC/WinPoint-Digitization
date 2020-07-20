package com.winpoint.common.wrappers;

import java.util.HashSet;

public class EnquiredStudetnsCourseWrapper {
	HashSet<String>corsesInterestedInSet = new HashSet<>();
	HashSet<String>coursesAlreadyDoneSet = new HashSet<>();
	
	
	public EnquiredStudetnsCourseWrapper(HashSet<String> corsesInterestedInSet, HashSet<String> coursesAlreadyDoneSet) {
		super();
		this.corsesInterestedInSet = corsesInterestedInSet;
		this.coursesAlreadyDoneSet = coursesAlreadyDoneSet;
	}
	
	
	public HashSet<String> getCoursesInterestedInSet() {
		return corsesInterestedInSet;
	}
	
	public void setCoursesInterestedInSet(HashSet<String> corsesDoneSet) {
		this.corsesInterestedInSet = corsesDoneSet;
	}
	
	public HashSet<String> getCoursesAlreadyDoneSet() {
		return coursesAlreadyDoneSet;
	}
	
	public void setCoursesAlreadyDoneSet(HashSet<String> coursesAlreadyDoneSet) {
		this.coursesAlreadyDoneSet = coursesAlreadyDoneSet;
	}
	
	
}
