package com.winpoint.common.wrappers;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PriorityListOfCoursesWrapper {
	
	private Integer courseId;
	private String courseName;
	private HashMap<Integer , String > timeSlots= new HashMap<>();
	private Integer segmentTypeId;
	private String segmentTypeName;
	private Integer noOfStudents;
	private Date startDate;
	private Integer fee;
	private HashMap<Integer , String >facultyDetails= new HashMap<>();	
	private ArrayList<NumberOfStudentWrapper>studentList=new ArrayList<>();
=======
import java.util.Date;

public class PriorityListOfCoursesWrapper {

	Integer courseId;
	String courseName;
	Integer segmentTypeId;
	String segmentTypeName;
	Integer timeSlotsId;
	String timeSlotsName;
	Integer enquiryId;
	Integer userProfileId;
	Date startDate;
	Integer fee;
	Integer facultyId;
	String facultyName;
	
	public PriorityListOfCoursesWrapper(Integer courseId, String courserName, Integer segmentTypeId, String segmentTypeName, Integer timeSlotsId, String timeSlotsName, Integer EnquiryId, Integer UserProfileId, Date startDate, Integer fee, Integer facultyId, Integer facultyName){
		
	}
	
	
>>>>>>> 01fa1a49deaf5d62d570ba920894d1aa08fac0bd
	
}
