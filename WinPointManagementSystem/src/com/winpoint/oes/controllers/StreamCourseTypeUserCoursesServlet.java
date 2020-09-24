package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.controllers.ParentWEBController;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/StreamCourseTypeUserCoursesServlet")
public class StreamCourseTypeUserCoursesServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StreamCourseTypeUserCoursesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("StreamCourseTypeUserCoursesServlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		Gson gson = new Gson();
		Course course = gson.fromJson(json, Course.class);
		int streamId = course.getStreamId();
		int courseTypeId = course.getCourseTypeId();
		HttpSession session = request.getSession(false);
		int userId = (int) session.getAttribute("userId");

		// courseName, logo, --> COURSES
		// marks ---> STUDENT_COURSE_DETAILS
		// facultyName, batchName, startDate, EndDate --> BATCH_DETAILS
		// dueAmount --> STUDENT_COURSE_INSTALLMENT_DETAILS
		// percentage of attendance of the student for different courses
		List<StudentCourseDetails> studentCourseDetailsList = new StudentCourseDetailsHelper()
				.getStudentCourseDetailList(userId, streamId, courseTypeId);

		if (studentCourseDetailsList != null) {
			// String json1 = null;
			// json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL +
			// "MainCoursePage.jsp'}");
			String json1 = gson.toJson(studentCourseDetailsList);

			String jsonString = "[" + json1 + "]";
			System.out.println("Json string is " + jsonString);
			PrintWriter writer = response.getWriter();
			writer.println(jsonString);
			writer.flush();

		}
	}
}
