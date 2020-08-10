package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.util.EmailUtility;

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
	CourseType courseName;
	Date startDate;
	TimeSlots timeSlotsName;
	String emailSubject;
	String emailmessage;
	
    @FXML
    private Button setButton;

    @FXML
    private TextField subjectTextBox;

    @FXML
    private TextField messageTextBox;

    @FXML
    void setFrame(ActionEvent event) {    //eventSendEmail name to be changed
 	
    	EmailUtility sendEmailObject = new EmailUtility();
    	sendEmailObject.sendEmail(listOfEmailIds,subjectTextBox.getText(),messageTextBox.getText());
    	
    	// Navigation for the next Screen : 
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml"));
    	Parent myNewScene;
		try {
			myNewScene = loader.load();
			
			EmailUtilityScreenController emailUtilityScreenController = loader.getController();
			emailUtilityScreenController.sendEmail(listOfEmailIds, courseName, startDate, timeSlotsName);
			
			Stage stage = (Stage) setButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}   	
    }

    public void initialize(URL location, ResourceBundle resources) {
   		
   	}

	public void sendEmail(ArrayList<String> listOfEmailIds, CourseType courseName, Date startDate,
			TimeSlots timeSlotsName) {
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
}
