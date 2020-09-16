package com.winpoint.common.wrappers;

import java.util.ArrayList;

public class QuestionAnswerWrapper {

		int questionNo;
		String questionStatement;
		ArrayList<String>options;
		int selectedOption;
		int correctOption;
		int marks;
		String explanation;
		
		public QuestionAnswerWrapper() {
			// TODO Auto-generated constructor stub
		}
		
		
		public QuestionAnswerWrapper(int questionNo, String questionStatement, ArrayList<String> options,
				int selectedOption, int correctOption, int marks) {
			super();
			this.questionNo = questionNo;
			this.questionStatement = questionStatement;
			this.options = options;
			this.selectedOption = selectedOption;
			this.correctOption = correctOption;
			this.marks = marks;
		}
		

		public int getQuestionNo() {
			return questionNo;
		}
		
		public void setQuestionNo(int questionNo) {
			this.questionNo = questionNo;
		}
		
		public String getQuestionStatement() {
			return questionStatement;
		}
		
		public void setQuestionStatement(String questionStatement) {
			this.questionStatement = questionStatement;
		}
		
		public ArrayList<String> getOptions() {
			return options;
		}
		
		public void setOptions(ArrayList<String> options) {
			this.options = options;
		}
		
		public int getSelectedOption() {
			return selectedOption;
		}
		
		public void setSelectedOption(int selectedOption) {
			this.selectedOption = selectedOption;
		}
		
		public int getCorrectOption() {
			return correctOption;
		}
		
		public void setCorrectOption(int correctOption) {
			this.correctOption = correctOption;
		}
		
		public int getMarks() {
			return marks;
		}
		
		
		public String getExplanation() {
			return explanation;
		}


		public void setExplanation(String explanation) {
			this.explanation = explanation;
		}


		public void setMarks(int marks) {
			this.marks = marks;
		}
		

}
