package com.winpoint.common.beans;


public class UserTestResponses extends QuestionBank{
	int isCorrect;
	int selectedOption;
	int questionNo;
	String DifficultyLevelName;
	public String getDifficultyLevelName() {
		return DifficultyLevelName;
	}

	public void setDifficultyLevelName(String difficultyLevelName) {
		DifficultyLevelName = difficultyLevelName;
	}

	public String getTopicName() {
		return TopicName;
	}

	public void setTopicName(String topicName) {
		TopicName = topicName;
	}

	String TopicName;
	
	
	public UserTestResponses() {
		// TODO Auto-generated constructor stub
	}
	
	public UserTestResponses(int isCorrect, int selectedOption, String question, String option1,
			String option2, String option3, String option4, Integer correctOption, Integer totalMarks, String explanation) {
		
		super(question,  option1,option2,  option3,  option4,  correctOption,  totalMarks,  explanation);
		this.isCorrect = isCorrect;
		this.selectedOption = selectedOption;
		
	}

	public int getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(int isCorrect) {
		this.isCorrect = isCorrect;
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	
	
	
}
