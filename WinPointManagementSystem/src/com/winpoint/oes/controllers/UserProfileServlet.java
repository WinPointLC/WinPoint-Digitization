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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.Test;
import com.winpoint.common.beans.UserCategory;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;
import com.winpoint.common.helpers.UserCategoryHelper;
import com.winpoint.common.helpers.UserProfileHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
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
		System.out.println("From UserProfileServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	   
//	    GsonBuilder gsonBuilder = new GsonBuilder();
//      gsonBuilder.setDateFormat("yyyy-MM-dd");
//      Gson gson = gsonBuilder.create();
	    
	    Gson gson = new Gson();
		UserProfile userProfile = gson.fromJson(json, UserProfile.class);
		boolean isUpdated = new UserProfileHelper().updateUserProfile(userProfile);
		String json1 = "";
		if(isUpdated) {
			json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "User.jsp'}");//"?varid=" + userProfile + "}");   
		}
		else {
			json1 = gson.toJson("{ 'success': 'false', 'location': '" + jspURL + "User.jsp'}");//"?varid=" + userProfile + "}");
		}
		
		String json2 = gson.toJson(userProfile);
		String jsonString = "[" + json1  + "," + json2 + "]";
		   
		   PrintWriter writer = response.getWriter();
		   writer.println(jsonString);
		   writer.flush();
	}
}
