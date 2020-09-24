package com.winpoint.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.winpoint.common.beans.QuestionBank;
import com.winpoint.common.beans.Result;
import com.winpoint.common.beans.UserTestResponses;
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.PaperAnalysisWrapper;

public class ResultDao {
	public boolean updateStudentTestResponses(int userId, List<QuestionBank> questionsList, Integer[] answersList, Integer[] isCorrectList, Result result){
		
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
			
			int userTestId = 0;
			String query = "";
			ResultSet resultSet = null;
			int testDetailId = getTestDetailID(questionsList);
			Iterator<QuestionBank> iter = questionsList.iterator();
			QuestionBank firstQuestion = iter.next();
			int courseId = firstQuestion.getCourseId();
			
			query = "SELECT USER_TEST_ID FROM USER_TEST_DETAILS WHERE USER_ID = " + userId + "AND TEST_DETAIL_ID = " + testDetailId;
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			   
			   userTestId = resultSet.getInt("USER_TEST_ID");
			}
			
			String courseName = "";
			String courseTypeName = "";
			query = "SELECT COURSE_TYPE.COURSE_TYPE_NAME, COURSES.COURSE_ID, COURSES.COURSE_NAME\r\n" + 
					"					FROM COURSES JOIN COURSE_TYPE  \r\n" + 
					"						ON COURSES.COURSE_TYPE_ID =  COURSE_TYPE.COURSE_TYPE_ID \r\n" + 
					"							\r\n" + 
					"					WHERE COURSES.COURSE_ID =" + courseId;
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				courseName = resultSet.getString("COURSE_NAME");
				courseTypeName = resultSet.getString("COURSE_TYPE_NAME");
			}
			
			int totalMarks = result.getTotalMarks();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENT_COURSE_DETAILS SET COURSE_AGGR=?, " + 
					"	   GRADE_ID=(SELECT GRADE_ID FROM GRADING_SYSTEM \r\n" + 
					"				 WHERE LOWER_LIMIT<=? AND ?<=HIGHER_LIMIT)\r\n" + 
					"WHERE USER_ID=?  AND COURSE_ID= ?");
			preparedStatement.setInt(1, result.getMarks());
			preparedStatement.setInt(2, totalMarks);
			preparedStatement.setInt(3, totalMarks);
			preparedStatement.setInt(4, userId);
			preparedStatement.setInt(5, courseId);
			System.out.println("" + preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			String tableName = "STUDENT_TEST_RESULT_" + courseName.toUpperCase() + "_" + courseTypeName.toUpperCase();
			System.out.println(tableName + "***" + answersList[0]);
			/*QuestionBank[] questionsListArr = (QuestionBank[])questionsList.toArray();
			Integer[] answersListArr = (Integer[])answersList.toArray();
			Integer[] isCorrectArr = (Integer[])isCorrectList.toArray();*/
			for(int i=0; i<questionsList.size(); i++){
				int ansStr = answersList[i].intValue();
				int isCorrStr = isCorrectList[i].intValue();
				//System.out.println("stud res = " + answersList.get(i));
				query = "INSERT INTO " + tableName +
						"           (USER_TEST_ID" + 
						"           ,Q_NUMBER" + 
						"           ,QUESTION_ID" +  
						"           ,STUDENT_RESPONSE" +
						"           ,IS_CORRECT" + ")" +
						"     VALUES" + 
						"           (" + userTestId + 
						"           ," + i +  
						"           ," + questionsList.get(i).getQuestionId() +
						"           ," + ansStr +
						"           ," + isCorrStr + ")";
				System.out.println(query);
				statement.executeUpdate(query);
			}
			
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return true;	
	}
	
	public int getTestDetailID(List<QuestionBank> questionsList) {
		int testDetailId = 0;
		try(Connection connection = ConnectionManager.getConnection()){
			Statement statement = connection.createStatement();
//			int userTestId = 0;
			Iterator<QuestionBank> iter = questionsList.iterator();
			QuestionBank firstQuestion = iter.next();
			int courseId = firstQuestion.getCourseId();
			String query = "SELECT TEST_DETAIL_ID FROM TEST_DETAILS WHERE TEST_NUMBER =1 AND COURSE_ID = " + courseId;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			   testDetailId = resultSet.getInt("TEST_DETAIL_ID");
			}
		} 
		catch (SQLServerException e) {
			e.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return testDetailId;
	}
	
	
	
	public PaperAnalysisWrapper getResultSet(int userId, int courseId) {
			
			ResultSet resultSet = null;
			String resultTableName = null;
			String questionBankTableName = null;
			int userTestId = 0;
			int totalMarks=0;
			int attempted = 0;
			ArrayList<UserTestResponses>userTestResponsesList = new ArrayList<>();
	
			PaperAnalysisWrapper paperAnalysisWrapper = new PaperAnalysisWrapper();
			UserTestResponses userTestResponses;
			
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
				String query = "SELECT STREAM_NAME,COURSE_TYPE.COURSE_TYPE_NAME, COURSES.COURSE_ID, COURSES.COURSE_NAME\n" + 
						"FROM COURSES JOIN COURSE_TYPE  \n" + 
						"ON COURSES.COURSE_TYPE_ID =  COURSE_TYPE.COURSE_TYPE_ID \n"+
						"JOIN STREAMS\n" + 
						"ON COURSES.STREAM_ID = STREAMS.STREAM_ID "+
						"WHERE COURSES.COURSE_ID ="+courseId  ;
				System.out.println("##  ######################################################################");
				System.out.println(query);
				System.out.println("########################################################################");
				
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					resultTableName = "STUDENT_TEST_RESULT_"+resultSet.getString("COURSE_NAME").toUpperCase()+
							"_"+resultSet.getString("COURSE_TYPE_NAME").toUpperCase();
					
					System.out.println(resultTableName);
					questionBankTableName = resultSet.getString("STREAM_NAME").toUpperCase()+"_QUESTION_BANK";
				}
				
				query ="SELECT A.ATTEMPTED, A.USER_TEST_ID,A.MARKS_RECEIVED, B.TOTAL_QUESTIONS FROM USER_TEST_DETAILS A\n" + 
						"				JOIN TEST_DETAILS B\n" + 
						"				ON A.TEST_DETAIL_ID = B.TEST_DETAIL_ID\n" + 
						"				WHERE A.USER_ID = "+ userId +" AND B.COURSE_ID = "+courseId;
				
				
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					userTestId = resultSet.getInt("USER_TEST_ID");
					paperAnalysisWrapper.setMarksReceived(resultSet.getInt("MARKS_RECEIVED"));
					paperAnalysisWrapper.setTotalQuestions(resultSet.getInt("TOTAL_QUESTIONS"));
					int testAttempted = resultSet.getInt("ATTEMPTED");
					if(testAttempted == 1)
						paperAnalysisWrapper.setTestAttempted(1);
					else
						paperAnalysisWrapper.setTestAttempted(0);
				}
				
				query = "SELECT A.Q_NUMBER,A.STUDENT_RESPONSE,A.IS_CORRECT,B.EXPLANATION,B.MARKS,B.OPTION_1,B.OPTION_2,"
						+ "B.OPTION_3,B.OPTION_4,B.QUESTION,B.CORRECT_OPTION, C.DIFFICULTY_LEVEL_NAME,E.TOPIC_NAME FROM " + resultTableName + 
						" A JOIN "+ questionBankTableName +" B\n" + 
						"ON A.QUESTION_ID = B.QUESTION_ID JOIN DIFFICULTY_LEVEL C\n" + 
						"ON B.DIFFICULTY_LEVEL_ID = C.DIFFICULTY_LEVEL_ID\n" + 
						"JOIN TOPICS E \n" + 
						"ON E.TOPIC_ID = B.TOPIC_ID AND E.COURSE_ID = B.COURSE_ID \n"+ 
						"WHERE USER_TEST_ID =" + userTestId + " ORDER BY Q_NUMBER";
				
				resultSet = statement.executeQuery(query);
				
				
				System.out.println("@@@@@@@@@@@@@@");
				System.out.println(query);
				System.out.println("@@@@@@@@@@@@@@");
				
				while(resultSet.next()) {
					userTestResponses = new UserTestResponses();
					totalMarks += resultSet.getInt("MARKS");
					System.out.println("total marks = = = = "+totalMarks);
					System.out.println(resultSet.getInt("IS_CORRECT"));
					userTestResponses.setIsCorrect(resultSet.getInt("IS_CORRECT"));
//					userTestResponses.setCorrectOptionInt(resultSet.getInt("B.CORRECT_OPTION"));
					
					userTestResponses.setOption1(resultSet.getString("OPTION_1"));
					userTestResponses.setOption2(resultSet.getString("OPTION_2"));
					userTestResponses.setOption3(resultSet.getString("OPTION_3"));
					userTestResponses.setOption4(resultSet.getString("OPTION_4"));
					userTestResponses.setDifficultyLevelName(resultSet.getString("DIFFICULTY_LEVEL_NAME"));
					userTestResponses.setTopicName(resultSet.getString("TOPIC_NAME"));
					userTestResponses.setCorrectOption(resultSet.getString("CORRECT_OPTION"));
					userTestResponses.setQuestionNo(resultSet.getInt("Q_NUMBER"));
					userTestResponses.setTotalMarks(resultSet.getInt("MARKS"));
					userTestResponses.setSelectedOption((char)(resultSet.getInt("STUDENT_RESPONSE")+64));
					userTestResponses.setQuestion(resultSet.getString("QUESTION"));
					userTestResponses.setExplanation(resultSet.getString("EXPLANATION"));
					userTestResponsesList.add(userTestResponses);
					if((Integer)resultSet.getInt("STUDENT_RESPONSE")!= null) {
						attempted+=1;
					}
				}
				paperAnalysisWrapper.setQuestionsAttempted(attempted);
				paperAnalysisWrapper.setTotalMarksOutOf(totalMarks);
				System.out.println("TOTAL MARKS : "+paperAnalysisWrapper.getTotalMarksOutOf()+"   "+totalMarks);
				paperAnalysisWrapper.setUserTestResponses(userTestResponsesList);			
			} 
			
			
			catch (SQLServerException e) {
				e.printStackTrace();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			} 
			return paperAnalysisWrapper;
		}
		
}
