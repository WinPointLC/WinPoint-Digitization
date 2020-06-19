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
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/OnlineEvaluationServlet")
public class OnlineEvaluationServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineEvaluationServlet() {
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
		System.out.println("From OnlineEvalutionServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	    
		Gson gson = new Gson();
		
		String isReg = request.getParameter("isReg");
		String json1 = null;
		List<Stream> streamList = new StreamHelper().getStreamList();
		List<CourseType> courseTypeList = new CourseTypeHelper().getCourseTypeList(streamList.get(0).getStreamId());
		
		if(streamList != null && courseTypeList != null) {
		   PrintWriter writer = response.getWriter();
		   if(Integer.parseInt(isReg) == 1)
			   json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "CourseRegistration.jsp'}");
		   else
		       json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "MainCoursePage.jsp'}");
		   String json2 = gson.toJson(streamList);
		   String json3 = gson.toJson(courseTypeList);
		   
		   String jsonString = "[" + json1 + "," + json2 + "," + json3 + "]";
		   writer.println(jsonString);
		   writer.flush();
		}
	}
}
