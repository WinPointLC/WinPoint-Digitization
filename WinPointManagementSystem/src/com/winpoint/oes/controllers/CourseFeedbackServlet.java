package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseFeedbackHelper;

/**
 * Servlet implementation class CourseFeedbackServlet
 */
@WebServlet("/CourseFeedbackServlet")
public class CourseFeedbackServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("From CourseFeedbackServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	    
		Gson gson = new Gson();
		CourseFeedback userCourseFeedback = gson.fromJson(json, CourseFeedback.class);
		new CourseFeedbackHelper().createUserCourseFeedback(userCourseFeedback);
	}

}
