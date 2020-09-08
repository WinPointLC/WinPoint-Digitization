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
import com.google.gson.Gson;
import com.winpoint.common.beans.StudentCourseFeesBean;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.FeeDetailsHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;

/**
 * Servlet implementation class FeeDetailsServlet
 */
@WebServlet("/FeeDetailsServlet")
public class FeeDetailsServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StudentCourseFeesBean> unpaidStudentsList = new FeeDetailsHelper().getFeeDetails();
		request.setAttribute("unpaidStudentsList", unpaidStudentsList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("From FeeDetailsServlet");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }

		Gson gson = new Gson();
		StudentCourseFeesBean studentCourseFeesBean = gson.fromJson(json, StudentCourseFeesBean.class);
		if(studentCourseFeesBean != null) {
			int userId = studentCourseFeesBean.getUserId();
			int courseId = studentCourseFeesBean.getCourseId();
			
			StudentCourseDetailsHelper studentCourseDetailsHelper = new StudentCourseDetailsHelper();
			studentCourseDetailsHelper.updateStudentCourseDetails(userId, courseId);
			
			String json1 = null;
			json1 = gson.toJson("{ 'success': 'true'}");
			
			String jsonString = "[" + json1 + "]";
			PrintWriter writer = response.getWriter();
			writer.println(jsonString);
		}

	}

}
