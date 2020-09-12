package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.FeedbackQuestions;
import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Result;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.Test;
import com.winpoint.common.beans.TopicWisePerformance;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.AnalyticsHelper;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.FeedbackQuestionsHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.ResultHelper;
import com.winpoint.common.helpers.StreamHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/AnalyticsServlet")
public class AnalyticsServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsServlet() {
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
		System.out.println("From Analytics Servlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	        	    
	    Gson gson = new Gson();
	    		
		String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "Analytics.jsp'}");
        String json2 = null;
        String json3 = null;
        String jsonString = null;
		String getInfoParam = request.getParameter("getInfoParam");
		System.out.println("action = " + getInfoParam);
		int courseId = 0;
		int userId = 0;
		if(getInfoParam.equals("courseDetails")) {
			
		    if(br != null){
		    	json = br.readLine();
		    }
		   
			UserProfile userProfile = gson.fromJson(json, UserProfile.class);
			ArrayList <StudentCourseDetails>studentCourseDetailsList =  new StudentCourseDetailsHelper().getStudentCourseDetailsList(userProfile.getUserId());
			
			if (studentCourseDetailsList != null) {
	        	json2 = gson.toJson(studentCourseDetailsList);
	        }
			
			ArrayList <StudentCourseDetails>studentGACourseDetailsList = new StudentCourseDetailsHelper().getStudentGACourseDetailsList(userProfile.getUserId());
			
			if (studentGACourseDetailsList != null) {
	        	json3 = gson.toJson(studentGACourseDetailsList);
	        }
			jsonString = "[" + json1  + "," + json2 + "," + json3 + "]";
		}
		else if(getInfoParam.equals("topicDetails")) {
			String view = request.getParameter("view");
			
			if(view.equals("ClientDash")){
				
			    Course course = gson.fromJson(json, Course.class);
				if(course != null) 
				   courseId = course.getCourseId();
				
		        HttpSession session = request.getSession(false);
				userId = (int) session.getAttribute("userId");	
			}
			else if (view.equals("userModal")) {
				System.out.println(json);
				System.out.println(StudentCourseDetails.class);
				StudentCourseDetails studentCourseDetail = gson.fromJson(json, StudentCourseDetails.class);
				System.out.println("***********"+studentCourseDetail);
				System.out.println("###########"+userId);

				userId = studentCourseDetail.getUserId();
				courseId = studentCourseDetail.getCourseId();
			}
			ArrayList<TopicWisePerformance > topicPerfoList = new AnalyticsHelper().getStudentTestAnalysis(userId, courseId);
	        if (topicPerfoList != null) {
	        	json2 = gson.toJson(topicPerfoList);
	        }
	        jsonString = "[" + json1  + "," + json2 + "]";
		}
        System.out.println("AnalyticsjsonString: " + jsonString);
	    PrintWriter writer = response.getWriter();
		writer.println(jsonString);
		writer.flush();
	}
}
