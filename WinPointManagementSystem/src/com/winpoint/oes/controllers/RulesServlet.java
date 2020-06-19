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
import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.Test;
import com.winpoint.common.beans.TestDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.QuestionBankHelper;
import com.winpoint.common.helpers.RulesHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/RulesServlet")
public class RulesServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RulesServlet() {
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
		System.out.println("From RulesServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }

	   	Gson gson = new Gson();
	   	TestDetails testDetails = gson.fromJson(json, TestDetails.class);
		int testDetailId =  testDetails.getTestDetailId();

		int userId = 0;
		List<Rules> rulesList = new RulesHelper().getRulesList(testDetailId);
		
		List<QuestionBank> questionsList = new QuestionBankHelper().getQuestionsList(testDetailId);
		System.out.println("Question List size =  " + questionsList.size());

		if(rulesList != null && questionsList != null) {
		   String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "RulesPage.jsp'}");
		   String json2 = gson.toJson(rulesList);
		   String json3 = gson.toJson(questionsList);
		   String json4 = gson.toJson(testDetails);		
		   
		   String jsonString = "[" + json1  + "," + json2 + "," + json3 + "," + json4 +"]";
		   //String jsonString = "[" + json3 +"]";
		   System.out.println(jsonString);
		   PrintWriter writer = response.getWriter();
		   writer.println(jsonString);
		   writer.flush();
		}
	}
}
