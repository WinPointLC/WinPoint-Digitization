package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

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

	
	private int selectedCourseId;
	private int selectedSegmentTypeId;
	private int preferedTime;
	private int facultyId;
	private String generatedBatchName1;
	private Integer selectedbatchId;
	ArrayList<String> listOfEmailIds;
	String timeSlotsName;
	String emailSubject;
	String emailmessage;
	String courseName;
	Date startDate;
	
    @FXML
    private Button setButton;
    @FXML
    private TextField subjectTextBox;
    @FXML
    private TextField messageTextBox;
	private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents = new ArrayList<UserCoursesDoneWrapper>();
	private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents = new ArrayList<UserCoursesDoneWrapper>();
	
	public void initialize(URL location, ResourceBundle resources) {
	   		
   	}

    @FXML
    void sendEmail(ActionEvent event) {    
    	
    	EmailUtility sendEmailObject = new EmailUtility();
    	sendEmailObject.sendEmail(listOfEmailIds,subjectTextBox.getText(),messageTextBox.getText());
    	
    	Parent myNewScene = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml"));
		try {
			myNewScene = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Loader of the next Screen : 
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

    // Setting the details to the variable : 
	public void sendEmail(ArrayList<String> listOfEmailIds, String courseName, Date startDate,
			String timeSlotsName) {
		
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
	
	// Setting the to pass back to the previous Screen : 
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
				
		this.generatedBatchName1 = generatedBatchName;
		this.selectedbatchId = selectedbatchId2;
		this.listOfRegisteredStudents.addAll(listOfRegisteredStudents1);
		this.listOfEnquiredStudents.addAll(listOfEnquiredStudents1);
		this.selectedCourseId = selectedCourseId1;
		this.selectedSegmentTypeId = selectedSegmentTypeId;
		this.preferedTime = preferedTime;
		this.facultyId = facultyId;
		
	}

}
