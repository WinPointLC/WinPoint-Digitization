package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.helpers.AddQuestionHelper;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
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
		System.out.println("from AddQuestionServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
		Gson gson = new Gson();
		QuestionBank questionObj = gson.fromJson(json, QuestionBank.class);
		if(questionObj != null) {
			new AddQuestionHelper().createQuestion(questionObj);
			
			UserProfile userProfile = new UserProfile();
			HttpSession session = request.getSession(false);
			userProfile.setUserId((Integer)session.getAttribute("userId"));
			userProfile.setFirstName((String)session.getAttribute("firstName"));
			userProfile.setLastName((String)session.getAttribute("lastName"));
			
			String json1 = gson.toJson("{ 'success': 'true', 'location': '/OnlineEvaluationSystem/jsp/EmployeeDashboard.jsp'}");
			String json2 = gson.toJson(userProfile);
				
			List<Stream> streamList = new StreamHelper().getStreamList();
			String json3 = gson.toJson(streamList);
			
			String jsonString = "[" + json1 + "," + json2 + "," + json3 + "]";
						
			System.out.println("Json string is " + jsonString);
			PrintWriter writer = response.getWriter();
			writer.println(jsonString);
			writer.flush();
		}
	}
}
