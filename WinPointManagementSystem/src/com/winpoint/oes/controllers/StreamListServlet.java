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
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/StreamListServlet")
public class StreamListServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From StreamListServlet");
		List<Stream> streamList = new StreamHelper().getStreamList();
		Gson gson = new Gson();
		String streamListJSON = gson.toJson(streamList);
		request.setAttribute("streamList", streamListJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From StreamListServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	    
		Gson gson = new Gson();
		UserProfile userProfile = gson.fromJson(json, UserProfile.class);
		
		if(userProfile != null) {
			String email = userProfile.getEmail();
			String password = userProfile.getPassword();
			
			UserProfile userProfileRecd = new LoginHelper().validateLogin(email, password);			
			if(userProfileRecd != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userProfileRecd.getUserId());
				session.setAttribute("firstName", userProfileRecd.getFirstName());
				session.setAttribute("lastName", userProfileRecd.getLastName());
				
				String json1 = null;
				String jsonString = null;
				
				String json2 = gson.toJson(userProfileRecd);
				
				int userCategoryId;
			
				PrintWriter writer = response.getWriter();
				userCategoryId =  userProfileRecd.getUserCategoryId();
				System.out.println("userCategoryId = " + userCategoryId);
				List<Stream> streamList = new StreamHelper().getStreamList();
				String json3 = gson.toJson(streamList);
				if (userCategoryId == 1) {
				   json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "ClientDashboard-New.jsp'}");
				   jsonString = "[" + json1 + "," + json2 + "," + json3 + "]";
				}
				else if(userCategoryId == 2) {
					/*List<Stream> streamList = new StreamHelper().getStreamList();
					String json3 = gson.toJson(streamList);*/
					json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "EmployeeDashboard-New.jsp'}");
					jsonString = "[" + json1 + "," + json2 + "," + json3 + "]";
				}
				System.out.println(jsonString);
				writer.println(jsonString);
				writer.flush();
			}
		}
	}

}
