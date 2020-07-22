package com.winpoint.common.testClient;

import java.util.ArrayList;
import java.util.HashMap;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.dao.PriorityCoursesListDao;
import com.winpoint.common.helpers.PriorityCoursesListHelper;
import com.winpoint.common.wrappers.EnquiredStudetnsCourseWrapper;

public class testMain {

	public static void main(String[] args) {

		HashMap<Course, ArrayList<EnquiryDetails>> i = new PriorityCoursesListHelper().getEnquiredStudentListWithCourses();
		
		
		for(Course course : i.keySet()) {
			System.out.println(course.getCourseName()+"-");
			for(EnquiryDetails e : i.get(course)) {
				System.out.println(e.getFirstName());
			}
			System.out.println("\n\n");
		}
		
		
//		HashMap<EnquiryDetails, EnquiredStudetnsCourseWrapper> i = new PriorityCoursesListDao().EnquiryDeatails();
//		for(EnquiryDetails enq: i.keySet()) {
//			System.out.println("\n\n\n");
//			System.out.println(enq.getFirstName());
//			EnquiredStudetnsCourseWrapper wrp = i.get(enq);
//			System.out.print("courses Interested - ");
//			for(String courDo: wrp.getCoursesInterestedInSet()) {
//				System.out.print(courDo+", ");
//			}
//			System.out.println();
//			System.out.print("courses Done - ");
//			for(String courDo: wrp.getCoursesAlreadyDoneSet()) {
//				System.out.print(courDo+", ");
//			}
//			
//		}
	}
}
