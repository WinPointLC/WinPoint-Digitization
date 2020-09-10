package com.winpoint.oes.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.UpdateEntity;
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
		//String helperClassName = "com.winpoint.common.helpers." + entityInfoParam + "Helper";
		String action = request.getParameter("activity");
		System.out.println("action = " + action);
		Gson gson = new Gson();
		String jsonString = null;
		try {
			String helperClassName = "com.winpoint.common.helpers." + entityInfoParam + "Helper";
			Class<?> entityClass = Class.forName(helperClassName);
			Object entity= entityClass.newInstance();
			if(action.equals("read")) {
				System.out.println("Get the entity details");
				String methodName = "get" + entityInfoParam + "List";
				System.out.println("Method name = " + methodName);
				Method invokeMethod = entity.getClass().getDeclaredMethod(methodName);
				entityDescList = (ArrayList<?>) invokeMethod.invoke(entity);
				System.out.println("EntityServlet " + entityDescList.size());
				jsonString = gson.toJson(entityDescList);
				System.out.println(jsonString);
			}
			else if(action.equals("update")) {
				BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			    String json = "";
			    if(br != null){
			    	json = br.readLine();
			    }
			    jsonString = json.toString();
			    System.out.println("**************************");
			    UpdateEntity entityUpdateDetails = gson.fromJson(jsonString, UpdateEntity.class);
			    Object[] addRows = entityUpdateDetails.getAddRows();
			    int[] delRowIds = entityUpdateDetails.getDelRowIds();
			    /*String beanClassName = "com.winpoint.common.beans." + entityInfoParam;
			    Class<?> beanClass = Class.forName(beanClassName);
			    Object bean= entityClass.newInstance();*/
			    for (Object row : addRows) {
			    	System.out.println(row);
			    }
			    for (int id : delRowIds) {
			    	System.out.println(id);
			    }
				System.out.println("**************************");
			
				String methodName = "create" + entityInfoParam + "List";
				System.out.println("Method name = " + methodName);
				Class<?>[] paramType = new Class[] { Object[].class };
				Method invokeMethod = entity.getClass().getDeclaredMethod(methodName, paramType);
				Object[] argumentArray = new Object[] { addRows };
				invokeMethod.invoke(entity, argumentArray);
				System.out.println("After create from EntityServlet");
			}
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
		
		/*Gson gson = new Gson();
					
		//String json1 = gson.toJson("{ 'success': 'true', 'location': '" + jspURL + "ClientDashboard-New.jsp'}");
		String json2 = gson.toJson(entityDescList);
				
		//String jsonString = "[" + json1  + "," + json2 + "]";
		//String jsonString = "[" +  json2 + "]";
		String jsonString = json2;
		System.out.println(jsonString);*/
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);
		writer.flush();
	}
}
