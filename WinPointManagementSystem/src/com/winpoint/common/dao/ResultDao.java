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
import com.winpoint.common.util.sql.ConnectionManager;
import com.winpoint.common.wrappers.PaperAnalysisWrapper;
import com.winpoint.common.wrappers.QuestionAnswerWrapper;

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
			ArrayList<String>optionList;
			ArrayList<QuestionAnswerWrapper>questionAnswerWrappersList = new ArrayList<>();
	
			PaperAnalysisWrapper paperAnalysisWrapper = new PaperAnalysisWrapper();
			QuestionAnswerWrapper questionAnswerWrapper;
			
			try(Connection connection = ConnectionManager.getConnection()){
				Statement statement = connection.createStatement();
				String query = "SELECT COURSE_TYPE.COURSE_TYPE_NAME, COURSES.COURSE_ID, COURSES.COURSE_NAME\n" + 
						"FROM COURSES JOIN COURSE_TYPE  \n" + 
						"ON COURSES.COURSE_TYPE_ID =  COURSE_TYPE.COURSE_TYPE_ID \n"+
						"JOIN STREAMS\n" + 
						"ON COURSES.STREAM_ID = STREAMS.STREAM_ID"+
						"WHERE COURSES.COURSE_ID ="+courseId  ;
				
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					resultTableName = "STUDENT_TEST_RESULT_"+resultSet.getString("COURSE_NAME").toUpperCase()+
							"_"+resultSet.getString("COURSE_TYPE_NAME").toUpperCase();
					
					System.out.println(resultTableName);
					questionBankTableName = resultSet.getString("STREAM_NAME").toUpperCase()+"_QUESTION_BANKS";
				}
				
				query ="SELECT A.USER_TEST_ID,A.MARKS_RECEIVED, B.TOTAL_QUESTIONS FROM USER_TEST_DETAILS A\n" + 
						"				JOIN TEST_DETAILS B\n" + 
						"				ON A.TEST_DETAIL_ID = B.TEST_DETAIL_ID\n" + 
						"				WHERE A.USER_ID = "+ userId +" AND B.COURSE_ID = "+courseId;
				
				
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					userTestId = resultSet.getInt("USER_TEST_ID");
					paperAnalysisWrapper.setMarksReceived(resultSet.getInt("MARKS_RCEIVED"));
				}
				
				query = "SELECT A.Q_NUMBER,A.STUDENT_RESPONSE,A.IS_CORRECT,B.EXPLANATION,B.MARKS,B.OPTION_1,B.OPTION_2,"
						+ "B.OPTION_3,B.OPTION_4,B.QUESTION,B.CORRECT_OPTION FROM " + resultTableName + 
						" A JOIN "+ questionBankTableName +" B\n" + 
						"ON A.QUESTION_ID = B.QUESTION_ID \n"+ 
						"WHERE USER_TEST_ID =" + userTestId;
				
				while(resultSet.next()) {
					questionAnswerWrapper = new QuestionAnswerWrapper();
					optionList = new ArrayList<>();
					totalMarks += resultSet.getInt("B.MARKS");
					questionAnswerWrapper.setCorrectOption(resultSet.getInt(""));
					for(int i = 1; i<= 4; i++) {
						String col = "OPTION_"+Integer.toString(i);
						optionList.add(resultSet.getString(col));
					}
					questionAnswerWrapper.setOptions(optionList);
					questionAnswerWrapper.setCorrectOption(resultSet.getInt("B.CORRECT_OPTION"));
					questionAnswerWrapper.setQuestionNo(resultSet.getInt("A.Q_NUMBER"));
					questionAnswerWrapper.setMarks(resultSet.getInt("B.MARKS"));
					questionAnswerWrapper.setSelectedOption(resultSet.getInt("A.STUDENT_RESPONSE"));
					questionAnswerWrapper.setQuestionStatement(resultSet.getString("B.QUESTION"));
					questionAnswerWrapper.setExplanation(resultSet.getString("B.EXPLANATION"));
					questionAnswerWrappersList.add(questionAnswerWrapper);
				}
				paperAnalysisWrapper.setTotalMarks(totalMarks);
				paperAnalysisWrapper.setQuestionAnswersWrappers(questionAnswerWrappersList);			
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
