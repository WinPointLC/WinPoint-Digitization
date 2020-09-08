package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseBatchDetail;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/StreamCourseTypeCoursesServlet")
public class StreamCourseTypeCoursesServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamCourseTypeCoursesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StreamCourseTypeCoursesServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	   
		Gson gson = new Gson();
		Course course = gson.fromJson(json, Course.class);
		int streamId =  course.getStreamId();
		int courseTypeId =  course.getCourseTypeId();
		System.out.println("StreamId = " + streamId + "CourseTypeId = " + courseTypeId);
		ArrayList<CourseBatchDetail> courseList = new CourseHelper().getCourseBatchDetail(streamId, courseTypeId);
		for(CourseBatchDetail courseBatchDetail : courseList) {
			System.out.println(courseBatchDetail.getCourseName());
			for(String batchList: courseBatchDetail.getBatchListName()) {
				System.out.println( courseBatchDetail.getCourseName() + ":" +  batchList);
			}
		}
		//Total Number of participants
		//Include List of Batches for every course --> STUDENT_COURSE_DETAILS
		if(courseList != null) {
			String json1 = null;
		   json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "MainCoursePage.jsp'}");
		   String json2 = gson.toJson(courseList);
		  		   
		   String jsonString = "[" + json2  + "]";
		   System.out.println("Json string is " + jsonString);
		   PrintWriter writer = response.getWriter();
		   writer.println(jsonString);
		   writer.flush();
		   
		   
		}
	}
}
