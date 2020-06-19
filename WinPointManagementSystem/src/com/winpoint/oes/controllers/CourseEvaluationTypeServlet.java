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
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/CourseEvaluationTypeServlet")
public class CourseEvaluationTypeServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEvaluationTypeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From CourseEvaluationTypeServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	   
		Gson gson = new Gson();
		Stream stream = gson.fromJson(json, Stream.class);
		int streamId =  stream.getStreamId();
		
		List<CourseType> courseTypeList = new CourseTypeHelper().getCourseTypeList(streamId);
		if(courseTypeList != null) {
			System.out.println(courseTypeList);
			String json1 = null;
		    json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "MainCoursePage.jsp'}");
		    String json2 = gson.toJson(courseTypeList);
		  		   
		    String jsonString = "[" + json2  + "]";
		    PrintWriter writer = response.getWriter();
		    writer.println(jsonString);
		    writer.flush();
		}
	}
}
