package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.omg.CORBA.StructMember;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.Lecture;
import com.winpoint.common.beans.Rules;
import com.winpoint.common.beans.SecurityQuestions;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class AttendanceDao {
//	public ArrayList<AttendanceScreenWrapper> getStudentAttendanceForBatch(Integer batchId){
//		ArrayList<AttendanceScreenWrapper> attendanceScreenWrapperList = new ArrayList<AttendanceScreenWrapper>();
//		
//		ResultSet resultSet1 = null;
//		ResultSet resultSet2 = null;
//		
//		try(Connection connection = ConnectionManager.getConnection()){
//			Statement statement1 = connection.createStatement();
//			Statement statement2 = connection.createStatement();
//			
//			ArrayList<Integer> userIdList = new ArrayList<Integer>();
//			ArrayList<String> firstNameList = new ArrayList<String>();
//			ArrayList<String> lastNameList = new ArrayList<String>();
//			
//			String query1 = "SELECT up.USER_ID, up.FIRST_NAME, up.LAST_NAME\r\n" + 
//					"	FROM USER_PROFILE AS up\r\n" + 
//					"	INNER JOIN \r\n" + 
//					"	STUDENT_COURSE_DETAILS scd\r\n" + 
//					"	ON scd.USER_ID = up.USER_ID\r\n" + 
//					"	WHERE scd.BATCH_ID =" + batchId;
//			
//			resultSet1 = statement1.executeQuery(query1);
//			
////			while(resultSet1.next()) {
////				userIdList.add(resultSet1.getInt("USER_ID"));
////				firstNameList.add(resultSet1.getString("FIRST_NAME"));
////				lastNameList.add(resultSet1.getString("LAST_NAME"));				
////			}			
//			int i = 0;
//			
//			while(resultSet1.next()) {
//				HashMap<String, String> attendanceMap = new HashMap<String, String>(); //<lectureId,Status>		
//				String query2 = "SELECT LECTURE_NUMBER, ABSENTEES \r\n" + 
//						"FROM LECTURE\r\n" + 
//						"WHERE BATCH_ID =" + batchId;
//				
//				resultSet2 = statement2.executeQuery(query2);
//				
//				while(resultSet2.next()) {
//					StringTokenizer absentStudents = new StringTokenizer(resultSet2.getString("ABSENTEES"), ",");
//					List<Integer> absentStudentsList = new ArrayList<>();
//			
//					while(absentStudents.hasMoreTokens()) {
//						absentStudentsList.add(Integer.parseInt(absentStudents.nextToken()));
//					}
//					
//					if(absentStudentsList.contains(resultSet1.getInt("USER_ID"))) {
//						attendanceMap.put("Lecture" + resultSet2.getString("LECTURE_NUMBER"), "ABSENT");
//					}else {
//						attendanceMap.put("Lecture" + resultSet2.getString("LECTURE_NUMBER"), "PRESENT");
//					}
//					
//					//System.out.println("UserID: " + resultSet1.getInt("USER_ID") + "\tLectNo: " + resultSet2.getInt("LECTURE_NUMBER") + "\tStatus : " + attendanceMap.get(resultSet2.getInt("LECTURE_NUMBER")));
//				}
//				
//				attendanceScreenWrapperList.add(new AttendanceScreenWrapper(resultSet1.getInt("USER_ID"), resultSet1.getString("FIRST_NAME"), resultSet1.getString("LAST_NAME"), attendanceMap));
//				i++;			
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}				
//		return attendanceScreenWrapperList;	
//	}	
	
	
	public ObservableList<ObservableList<String>> getStudentsAttendanceForBatch(Integer batchId){
		ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String query1 = "SELECT up.USER_ID, (up.FIRST_NAME + ' ' + up.LAST_NAME) AS FULL_NAME \r\n" + 
					"FROM USER_PROFILE AS up\r\n" + 
					"INNER JOIN\r\n" + 
					"STUDENT_COURSE_DETAILS AS scd\r\n" + 
					"ON up.USER_ID = scd.USER_ID\r\n" + 
					"WHERE scd.BATCH_ID = " + batchId;
			
			ResultSet resultSet1 = statement1.executeQuery(query1);
			
			String query2 = "SELECT LECTURE_NUMBER, ABSENTEES \r\n" + 
					"FROM LECTURE\r\n" + 
					"WHERE BATCH_ID =" + batchId;
			
			ResultSet resultSet2 = statement2.executeQuery(query2);
			
			resultSet1.beforeFirst();
			while(resultSet1.next()){
				ObservableList<String> row = FXCollections.observableArrayList();
				String fullName = resultSet1.getString("FULL_NAME");
				Integer userId = resultSet1.getInt("USER_ID");
				row.addAll(fullName);
				int j = 0;
				resultSet2.beforeFirst();
				while(resultSet2.next()) {
					//String[] status = new String[columnCount];
					StringTokenizer absentStudents = new StringTokenizer(resultSet2.getString("ABSENTEES"), ",");
					List<Integer> absentStudentsList = new ArrayList<>();
					
					while(absentStudents.hasMoreTokens()) {
						absentStudentsList.add(Integer.parseInt(absentStudents.nextToken()));
					}
					
					if(absentStudentsList.contains(userId)) {
						//Absent
						row.add("Absent");
					}else {
						//Present
						row.add("Present");
					} 
				}
				data.add(row);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public int getPercentageStudenAttendanceForBatch(int userId, int batchId) {
		int percentage = 0;
		int present=0;
		int noOfLectures=0;
		try(Connection connection = ConnectionManager.getConnection()){
			
			Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String query2 = "SELECT LECTURE_NUMBER, ABSENTEES \r\n" + 
					"FROM LECTURE\r\n" + 
					"WHERE BATCH_ID =" + batchId;
			
			ResultSet resultSet = statement2.executeQuery(query2);
			
			
			while(resultSet.next()) {
					//String[] status = new String[columnCount];
					StringTokenizer absentStudents = new StringTokenizer(resultSet.getString("ABSENTEES"), ",");
					List<Integer> absentStudentsList = new ArrayList<>();
					
					while(absentStudents.hasMoreTokens()) {
						absentStudentsList.add(Integer.parseInt(absentStudents.nextToken()));
					}
					
					if(absentStudentsList.contains(userId)) {
						//Absent
						present++;
					}
					noOfLectures++;
					percentage = (present/noOfLectures) * 100;
					System.out.println("Percentage = " + percentage);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return percentage;
	}
}
