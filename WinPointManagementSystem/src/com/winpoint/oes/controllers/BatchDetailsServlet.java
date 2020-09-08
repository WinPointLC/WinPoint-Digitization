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
import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.beans.Test;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.AttendanceHelper;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.LoginHelper;
import com.winpoint.common.helpers.StreamHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.StudentCourseInstallmentHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;
import com.winpoint.common.wrappers.EvaluationScreenWrapperParent;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

import javafx.collections.ObservableList;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/BatchDetailsServlet")
public class BatchDetailsServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchDetailsServlet() {
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
		System.out.println("From BatchDetailsServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	    String json = "";
	    if(br != null){
	    	json = br.readLine();
	    }
	   
		Gson gson = new Gson();
		BatchDetails batchDetails = gson.fromJson(json, BatchDetails.class);
		//int streamId =  course.getStreamId();
		//int courseTypeId =  course.getCourseTypeId();
		int batchId = batchDetails.getBatchId();
		//String courseName = course.getCourseName();
		ArrayList<FeeRecordsScreenWrapper> feeRecordsOfBatch = null;
		String batchInfoParam = request.getParameter("batchInfoParam");
		System.out.println("action = " + batchInfoParam);
		/*HttpSession session = request.getSession(false);
		int userId = (int) session.getAttribute("userId");*/
		//session.setAttribute("courseName", courseName);
		
		  /*String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "EmployeeDashboard-New.jsp'}");
		   String json2 = gson.toJson(batchDetails);
		   String json3 = gson.toJson(studentsEvaluationDetailsList);
		   String json4 = gson.toJson(feeRecordsOfBatch);
		   String json5 = gson.toJson(attendanceList);*/
			String json1 = null;
			if(batchInfoParam.equals("batchDetails")) {
				/* Batch Details of the selected batchId */
				batchDetails = new BatchDetailsHelper().getBatchDetails(batchId);
				json1 = gson.toJson(batchDetails);
			}
			else if(batchInfoParam.equals("evaluation")){
				/* marks of all students  --> STUDENT_COURSE_DETAILS*/
				System.out.println("From Evaluation");
				ArrayList<EvaluationScreenWrapper> studentsEvaluationDetailsList = new StudentCourseDetailsHelper().getStudentEvaluationDetails(batchId);
				for(EvaluationScreenWrapper x : studentsEvaluationDetailsList) {
				   System.out.println(x.getAttendance());
				}
				json1 = gson.toJson(studentsEvaluationDetailsList);
			}
			else if(batchInfoParam.equals("feeRecords")){
				/*Fee status of all students  --> STUDENT_COURSE_DETAILS*/
				//ArrayList<FeeRecordsScreenWrapper> feeRecordsOfBatch = new StudentCourseInstallmentHelper().getFeeRecordsScreenWrapperList(batchId);
				feeRecordsOfBatch = new StudentCourseInstallmentHelper().getFeeRecordsScreenWrapperList(batchId);
				json1 = gson.toJson(feeRecordsOfBatch);
			}
			else if(batchInfoParam.equals("attendance")){
				/*Percentage of Attendance of all the students for this batch */
				//ObservableList<ObservableList<String>> attendanceList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
				ObservableList<ObservableList> attendanceList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
				//int i=0;
				/*for (ObservableList<String> temp : attendanceList) {
					for(int i=0; i<temp.size(); i++) {
					    String temp1 = temp.get(i);
					    System.out.print(temp1 +" ");
					}
				}*/
				json1 = gson.toJson(attendanceList);
			}
			else if(batchInfoParam.equals("studentDetails")) {
				System.out.println("From BatchDetails-studentDetails");
				ArrayList<UserProfile> usersList = new UserProfileHelper().getStudentListForBatch(batchId);
				json1 = gson.toJson(usersList);
				System.out.println("UserList: " + json1);
			}
			//json1 = gson.toJson(feeRecordsOfBatch);
		   //String jsonString = "[" + json1  + "," + json2 + "," + json3 + "," + json4 + "," + json5 + "]";
		   String jsonString = "[" + json1 + "]";
		   PrintWriter writer = response.getWriter();
		   writer.println(jsonString);
		   writer.flush();		   
	}
}