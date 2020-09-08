package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.beans.FeedbackQuestions;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseFeedbackHelper;
import com.winpoint.common.helpers.FeedbackQuestionsHelper;
import com.winpoint.common.helpers.StreamHelper;
import com.winpoint.common.helpers.UserProfileHelper;

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
		System.out.println("From CourseFeedbackServlet GET");
		ArrayList<FeedbackQuestions> feedbackQuestionsList = new FeedbackQuestionsHelper().getFeedbackQuestions(1);
		Gson gson = new Gson();
		String feedbackQuestionsListJSON = gson.toJson(feedbackQuestionsList);
		request.setAttribute("feedbackQuestionsList", feedbackQuestionsListJSON);
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
	    String jsonString = json.toString();
		Gson gson = new Gson();
		CourseFeedback[] userCourseFeedback = gson.fromJson(jsonString, CourseFeedback[].class);
		System.out.println("**************************");
		for(CourseFeedback courseFeedback : userCourseFeedback) {
			System.out.println(courseFeedback.getFeedbackId() + ": " + courseFeedback.getStudentResponse());
		}
		System.out.println("**************************");
		HttpSession session = request.getSession(false);
		int userId = (int) session.getAttribute("userId");
		System.out.println("1");
		new CourseFeedbackHelper().createUserCourseFeedback(userId, userCourseFeedback);
		System.out.println(2);
		/*UserProfile userProfile = new UserProfileHelper().getUserProfile(userId);
		System.out.println("CourseFeedbackServlet : " + userProfile.getFirstName() + userProfile.getLastName());
		String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "ClientDashboard-New.jsp'}");
		String json2 = gson.toJson(userProfile);
		System.out.println(json2);
		List<Stream> streamList = new StreamHelper().getStreamList();
		String json3 = gson.toJson(streamList);
		System.out.println(json3);
		jsonString = "[" + json1 + "," + json2 + "," + json3 + "]";
		System.out.println("CFS *****" + jsonString);
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);
		writer.flush();*/
	}

}
