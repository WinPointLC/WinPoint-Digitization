package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
@WebServlet("/EntityServlet")
public class EntityServlet extends ParentWEBController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntityServlet() {
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
		System.out.println("From EntityServlet");
		ArrayList<?> entityDescList = null;
		String entityInfoParam = request.getParameter("entityInfoParam");
		String className = "com.winpoint.common.helpers." + entityInfoParam + "Helper";
		try {
			Class<?> entityClass = Class.forName(className);
			Object entity= entityClass.newInstance();
			String methodName = "get" + entityInfoParam + "List";
			System.out.println("Method name = " + methodName);
			Method invokeMethod = entity.getClass().getDeclaredMethod(methodName);
			entityDescList = (ArrayList<?>) invokeMethod.invoke(entity);
			System.out.println("EntityServlet " + entityDescList.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
					
		//String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "ClientDashboard-New.jsp'}");
		String json2 = gson.toJson(entityDescList);
				
		//String jsonString = "[" + json1  + "," + json2 + "]";
		String jsonString = "[" +  json2 + "]";
		System.out.println(jsonString);
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);
		writer.flush();
	}
}
