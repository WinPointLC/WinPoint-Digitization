package com.winpoint.common.wrappers;

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
	
}
