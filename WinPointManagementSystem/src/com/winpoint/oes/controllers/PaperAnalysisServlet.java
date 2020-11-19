package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.jasper.compiler.JspUtil;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.TopicWisePerformance;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.helpers.AnalyticsHelper;
import com.winpoint.common.helpers.ResultHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserTestDetailsHelper;
import com.winpoint.common.wrappers.PaperAnalysisWrapper;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.dao.UserTestDetailsDao;
import com.winpoint.common.controllers.*;
/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/PaperAnalysisServlet")
public class PaperAnalysisServlet extends ParentWEBController{

	private static final long serialVersionUID = 1L;  // ??

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperAnalysisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   //??
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From PaperAnalysis Servlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }    	    
	    Gson gson = new Gson();
	    		
//		String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "Paper_Analysis.jsp'}");
//        String json2 = null;
        String jsonString = null;
		int courseId = 0;
		int userId = 0;
		
		Course course = gson.fromJson(json, Course.class);
		if(course != null) {
			System.out.println("Course is Not NULL");
		   courseId = course.getCourseId();
		}
		System.out.println("COURSEID : "+courseId+"   &&&&&&&&&&&&&&&&&&&&&");
		System.out.println("");
		
		
        HttpSession session = request.getSession(false);
		userId = (int) session.getAttribute("userId");	
		
		PaperAnalysisWrapper paperAnalysisWrapper = new ResultHelper().getResultSet(userId, courseId);
		if (paperAnalysisWrapper != null) {
	       	jsonString = gson.toJson(paperAnalysisWrapper);
	    }
		System.out.println(paperAnalysisWrapper);
		System.out.println(paperAnalysisWrapper.getMarksReceived());
//		System.out.println(paperAnalysisWrapper.get);
//	    jsonString = "[" + json1  + "," + json2 + "]";
			
		
        System.out.println("PaperAnalysisjsonString: " + jsonString);
	    PrintWriter writer = response.getWriter();
		writer.println(jsonString);
		writer.flush();
	}
	
}
