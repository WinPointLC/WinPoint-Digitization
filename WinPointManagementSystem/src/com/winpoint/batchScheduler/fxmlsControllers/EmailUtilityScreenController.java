package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.util.EmailUtility;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmailUtilityScreenController {

	ArrayList<String> listOfEmailIds;
	String courseName;
	Date startDate;
	String timeSlotsName;
	String emailSubject;
	String emailmessage;
	
    @FXML
    private Button setButton;

    @FXML
    private TextField subjectTextBox;

    @FXML
    private TextField messageTextBox;
	private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents = new ArrayList<UserCoursesDoneWrapper>();
	private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents = new ArrayList<UserCoursesDoneWrapper>();
	private int selectedCourseId;
	private int selectedSegmentTypeId;
	private int preferedTime;
	private int facultyId;
	private String generatedBatchName1;
	private Integer selectedbatchId;

    @FXML
    void setFrame(ActionEvent event) {    //eventSendEmail name to be changed
 	
    	EmailUtility sendEmailObject = new EmailUtility();
    	sendEmailObject.sendEmail(listOfEmailIds,subjectTextBox.getText(),messageTextBox.getText());
    	
    	Parent myNewScene = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml"));
		try {
			myNewScene = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		CoursesNameController coursesNameController = loader.getController();
		coursesNameController.setListOfStudents(
				listOfRegisteredStudents, 
				listOfEnquiredStudents,
				selectedCourseId,
				selectedSegmentTypeId,
				preferedTime,
				facultyId,
				generatedBatchName1,
				selectedbatchId, null, null, null
		);
		
    	Stage stage = (Stage) setButton.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
   		
   	}

	public void sendEmail(ArrayList<String> listOfEmailIds, String courseName, Date startDate,
			String timeSlotsName) {
		// TODO Auto-generated method stub
		this.listOfEmailIds = listOfEmailIds;
		this.courseName = courseName;
		this.startDate = startDate;
		this.timeSlotsName = timeSlotsName;
		
		emailSubject = "Launch of a new Batch for the "+courseName+" course";
		emailmessage = "Hello,"+ 
				 "New "+courseName+" batch is going start from "+startDate+" in the "+timeSlotsName+"";
				
		subjectTextBox.setText(emailSubject);
		messageTextBox.setText(emailmessage);
		
	}
	
	public void setStudentData(
			ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1,
			ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1, 
			int selectedCourseId1, 
			int selectedSegmentTypeId,
			int preferedTime, 
			int facultyId,
			String generatedBatchName, 
			Integer selectedbatchId2
			) {
				
//		this.userProfile = userProfile;
		this.generatedBatchName1 = generatedBatchName;
		this.selectedbatchId = selectedbatchId2;
//		this.isEnquired = isEnquired;
//		this.user = enquiredStudent;
		this.listOfRegisteredStudents.addAll(listOfRegisteredStudents1);
		this.listOfEnquiredStudents.addAll(listOfEnquiredStudents1);
		this.selectedCourseId = selectedCourseId1;
		this.selectedSegmentTypeId = selectedSegmentTypeId;
		this.preferedTime = preferedTime;
		this.facultyId = facultyId;
		
//		batchNumber.setText(generatedBatchName1);
	}

}
