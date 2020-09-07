package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Course;
<<<<<<< HEAD
import com.winpoint.common.beans.CourseBatchDetail;
import com.winpoint.common.beans.CourseType;
=======
>>>>>>> db5c7d332b1b5a0b62d101bb0de1925c868c1a44
import com.winpoint.common.beans.Test;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.SignUpFormCourseListWrapper;


public class CourseDao {
	
	
public ArrayList<Course> getBatchCourseDurationList() {
		
		ArrayList<Course> getBatchCourseDurationList = new ArrayList<Course>();
				
		getBatchCourseDurationList.add(new Course(2));
		getBatchCourseDurationList.add(new Course(3));
		getBatchCourseDurationList.add(new Course(4));
		
		return getBatchCourseDurationList;
		//changes are saved

	}
	

	public List<Course> getCourseList(int streamId, int courseTypeId) {
		
		List<Course> courseList = new ArrayList<Course>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();

			String query = "SELECT\r\n" + 
					"	/*STREAMS.STREAM_ID,\r\n" + 
					"	STREAMS.STREAM_NAME,\r\n" + 
					"	COURSE_TYPE.COURSE_TYPE_ID,\r\n" + 
					"	COURSE_TYPE.COURSE_TYPE_NAME,*/\r\n" + 
					"	COURSES.COURSE_ID,\r\n" + 
					"	COURSES.COURSE_NAME,\r\n" + 
					"	LOGO_LOCATION\r\n" + 
					"	FROM \r\n" + 
					"	STREAMS STREAMS JOIN COURSES COURSES\r\n" + 
					"	ON STREAMS.STREAM_ID = COURSES.STREAM_ID\r\n" + 
					"		JOIN COURSE_TYPE COURSE_TYPE\r\n" + 
					"		ON COURSES.COURSE_TYPE_ID = COURSE_TYPE.COURSE_TYPE_ID\r\n" + 
					"WHERE " + streamId + "= STREAMS.STREAM_ID and " + courseTypeId + " = COURSE_TYPE.COURSE_TYPE_ID\r\n" + 
					"ORDER BY STREAMS.STREAM_ID, COURSE_TYPE.COURSE_TYPE_ID, COURSES.COURSE_ID";
			/*query = "SELECT			\r\n" + 
					"		COURSES.COURSE_ID, \r\n" + 
					"		COURSES.COURSE_NAME, \r\n" + 
					"		LOGO_LOCATION,\r\n" + 
					"		BATCH_DETAILS.BATCH_ID,\r\n" + 
					"		BATCH_NAME,\r\n" + 
					"		STUDENT_COURSE_DETAILS.USER_ID\r\n" + 
					"FROM\r\n" + 
					"		STREAMS STREAMS JOIN COURSES COURSES \r\n" + 
					"		ON STREAMS.STREAM_ID = COURSES.STREAM_ID \r\n" + 
					"			JOIN COURSE_TYPE COURSE_TYPE\r\n" + 
					"		ON COURSES.COURSE_TYPE_ID = COURSE_TYPE.COURSE_TYPE_ID\r\n" + 
					"		JOIN BATCH_DETAILS\r\n" + 
					"		ON BATCH_DETAILS.COURSE_ID  = COURSES.COURSE_ID\r\n" + 
					"		JOIN STUDENT_COURSE_DETAILS\r\n" + 
					"		ON STUDENT_COURSE_DETAILS.BATCH_ID = BATCH_DETAILS.BATCH_ID\r\n" + 
					"WHERE  STREAMS.STREAM_ID = 1 and COURSE_TYPE.COURSE_TYPE_ID = 1 AND STUDENT_COURSE_DETAILS.BATCH_ID IN (BATCH_DETAILS.BATCH_ID)\r\n" + 
					"ORDER BY COURSES.COURSE_ID, BATCH_ID\r\n" + 
					"";*/
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int courseId = resultSet.getInt("course_id");
				String courseName = resultSet.getString("course_name");
				String logoLocation = resultSet.getString("logo_location");
				Course course = new Course(courseId, courseName, streamId, courseTypeId, logoLocation);
				courseList.add(course);
			}
		} 
		catch (SQLServerException e) {	
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return courseList;
		
	}
	

	public List<Test> getTestList(int userId, int courseId) {
		List<Test> testList = new ArrayList<Test>();
		
		ResultSet resultSet = null;

		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();

			String query = "SELECT \r\n" + 
					"		UTD.USER_ID,\r\n" + 
					"		CRS.COURSE_NAME,\r\n" + 
					"		EVAL.EVALUATION_TYPE_NAME,\r\n" + 
					"		TD.TEST_DETAIL_ID, \r\n" + 
					"		TD.TEST_FEES,\r\n" + 
					"		UTD.FEE_STATUS,\r\n" + 
					"		UTD.MARKS_RECEIVED,\r\n" + 
					"		UTD.ATTEMPTED\r\n" +
					"		FROM\r\n" + 
					"		COURSES CRS JOIN EVALUATION_TYPE EVAL\r\n" + 
					"		ON EVAL.EVALUATION_TYPE_ID =  CRS.EVALUATION_TYPE_ID\r\n" + 
					"			JOIN TEST_DETAILS TD\r\n" + 
					"			ON CRS.COURSE_ID = TD.COURSE_ID\r\n" + 
					"				JOIN USER_TEST_DETAILS UTD\r\n" + 
					"				ON TD.TEST_DETAIL_ID = UTD.TEST_DETAIL_ID\r\n" + 
					"WHERE UTD.USER_ID = " + userId + "AND CRS.COURSE_ID = " + courseId ;
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				String courseName = resultSet.getString("COURSE_NAME");
				String evaluationTypeName = resultSet.getString("EVALUATION_TYPE_NAME");
				int testDetailId = resultSet.getInt("TEST_DETAIL_ID");
				int testFees = resultSet.getInt("TEST_FEES");
				int fee_status = resultSet.getInt("FEE_STATUS");
				int marksRceived = resultSet.getInt("MARKS_RECEIVED");
				int attempted = resultSet.getInt("ATTEMPTED");
				Test test = new Test(userId, courseName, evaluationTypeName, testDetailId, testFees, fee_status, marksRceived, attempted);
				testList.add(test);
			}
		}
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return testList;
	}
	  
	
	//group A - sign up form - shraddha
	public ArrayList<SignUpFormCourseListWrapper> getCoursesNamesList(){
		
			ArrayList<SignUpFormCourseListWrapper> courseList = new ArrayList<SignUpFormCourseListWrapper>();
			
			ResultSet resultSet = null;

			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
				
				
				String query = "select C.COURSE_ID , C.COURSE_NAME,C.COURSE_TYPE_ID,CD.COURSE_TYPE_NAME\n" + 
						"FROM COURSES AS C JOIN\n" + 
						"COURSE_TYPE AS CD ON \n" + 
						"C.COURSE_TYPE_ID = CD.COURSE_TYPE_ID";
						
				resultSet = statement.executeQuery(query);
				
				while(resultSet.next()) {
					courseList.add(new SignUpFormCourseListWrapper(resultSet.getInt("COURSE_ID"),resultSet.getString("COURSE_NAME"),
							resultSet.getInt("COURSE_TYPE_ID"),resultSet.getString("COURSE_TYPE_NAME")));
					
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return courseList;
	}


	public List<Course> getUserCourseList(int userId, int streamId, int courseTypeId) {
		// TODO Auto-generated method stub
		ArrayList<Course> userCourses = new ArrayList<>();
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			String query = "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCourses;
	}


	public ArrayList<CourseBatchDetail> getCourseBatchDetail(int streamId, int courseTypeId) {
		// TODO Auto-generated method stub
		ArrayList<CourseBatchDetail> courseList = new ArrayList<CourseBatchDetail>();
		
		ResultSet resultSet = null;
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();

			/*String query = "SELECT			\r\n" + 
					"		COURSES.COURSE_ID, \r\n" + 
					"		COURSES.COURSE_NAME, \r\n" + 
					"		LOGO_LOCATION,\r\n" + 
					"		BATCH_DETAILS.BATCH_ID,\r\n" + 
					"		BATCH_NAME,\r\n" + 
					"		STUDENT_COURSE_DETAILS.USER_ID\r\n" + 
					"FROM\r\n" + 
					"		STREAMS STREAMS JOIN COURSES COURSES \r\n" + 
					"		ON STREAMS.STREAM_ID = COURSES.STREAM_ID \r\n" + 
					"			JOIN COURSE_TYPE COURSE_TYPE\r\n" + 
					"		ON COURSES.COURSE_TYPE_ID = COURSE_TYPE.COURSE_TYPE_ID\r\n" + 
					"		JOIN BATCH_DETAILS\r\n" + 
					"		ON BATCH_DETAILS.COURSE_ID  = COURSES.COURSE_ID\r\n" + 
					"		JOIN STUDENT_COURSE_DETAILS\r\n" + 
					"		ON STUDENT_COURSE_DETAILS.BATCH_ID = BATCH_DETAILS.BATCH_ID\r\n" + 
					"WHERE  STREAMS.STREAM_ID = 1 and COURSE_TYPE.COURSE_TYPE_ID = 1 AND STUDENT_COURSE_DETAILS.BATCH_ID IN (BATCH_DETAILS.BATCH_ID)\r\n" + 
					"ORDER BY COURSES.COURSE_ID, BATCH_ID";*/
			String query = "SELECT			\r\n" + 
					"							COURSES.COURSE_ID, \r\n" + 
					"							COURSES.COURSE_NAME, \r\n" + 
					"							LOGO_LOCATION \r\n" + 
					"							--BATCH_DETAILS.BATCH_ID, \r\n" + 
					"							--BATCH_NAME\r\n" + 
					"							--STUDENT_COURSE_DETAILS.USER_ID \r\n" + 
					"					FROM\r\n" + 
					"							STREAMS STREAMS JOIN COURSES COURSES  \r\n" + 
					"							ON STREAMS.STREAM_ID = COURSES.STREAM_ID  \r\n" + 
					"								JOIN COURSE_TYPE COURSE_TYPE\r\n" + 
					"							ON COURSES.COURSE_TYPE_ID = COURSE_TYPE.COURSE_TYPE_ID \r\n" + 
					"							--JOIN BATCH_DETAILS\r\n" + 
					"							--ON BATCH_DETAILS.COURSE_ID  = COURSES.COURSE_ID \r\n" + 
					"							--JOIN STUDENT_COURSE_DETAILS\r\n" + 
					"							--ON STUDENT_COURSE_DETAILS.BATCH_ID = BATCH_DETAILS.BATCH_ID \r\n" + 
					"					WHERE  STREAMS.STREAM_ID = 1 and COURSE_TYPE.COURSE_TYPE_ID = 1 \r\n" + 
					"					ORDER BY COURSES.COURSE_ID";		
			resultSet = statement.executeQuery(query);
						
			while(resultSet.next()) {
				int courseId = resultSet.getInt("course_id");
				String courseName = resultSet.getString("course_name");
				String logoLocation = resultSet.getString("logo_location");
				CourseBatchDetail course = new CourseBatchDetail(courseId, courseName, streamId, courseTypeId, logoLocation, null);
				courseList.add(course);
			}
			for (CourseBatchDetail course : courseList) {
				ArrayList<String> batchNameList = new ArrayList<>();
				String query2 = "SELECT BATCH_ID, BATCH_NAME FROM BATCH_DETAILS WHERE COURSE_ID = " + course.getCourseId();
				ResultSet resultSet2 = statement.executeQuery(query2);
				while(resultSet2.next()) {
					int batchId = resultSet2.getInt("batch_Id");
					String batchName = resultSet2.getString("batch_name");
					batchNameList.add(batchId + "/" + batchName);
				}
				course.setBatchListName(batchNameList);
			}
			for (CourseBatchDetail course : courseList) {
				int studentCount=0;
				ArrayList<String> batchNameList =  course.getBatchListName();
				
				for(int i=0; i<batchNameList.size(); i++) {
					String batchName = batchNameList.get(i);
					String query3 = "SELECT COUNT(*) AS TOTAL_BATCH_STUDENTS FROM STUDENT_COURSE_DETAILS WHERE BATCH_ID =  " + batchName.substring(0, batchName.indexOf('/'));
					ResultSet resultSet3 = statement.executeQuery(query3);
					while(resultSet3.next()) {
						studentCount = resultSet3.getInt("TOTAL_BATCH_STUDENTS");
						System.out.println("StudentCount = " + studentCount);
					}
					batchNameList.set(i, batchName + "/" + studentCount);
				}
				course.setBatchListName(batchNameList);
			}
		} 
		catch (SQLServerException e) {	
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return courseList;
	}
}



