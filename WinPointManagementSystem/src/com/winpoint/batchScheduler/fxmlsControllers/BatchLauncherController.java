package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BatchLauncherController extends ParentFXMLController {
		BatchDetails batchDetails = new BatchDetails();

		 @FXML
		    private TextField lectureDuration;

		    @FXML
		    private DatePicker beginDate;

		    @FXML
		    private DatePicker endDate;

		    @FXML
		    private Label batchName;

		    @FXML
		    private Label facultyId;

		    @FXML
		    private Label timeChoice;

	
		    @FXML
		    private Button cancel;
	
		    @FXML
		    private Button launch;
	
		    @FXML
		    private ImageView logo;
	
	
		
		    
		  

	    @FXML
	    void beginDateFrame(ActionEvent event) {

	    }


	    @FXML
	    void endDateFrame(ActionEvent event) {

	    }
	    

	    @FXML
	    void validateTimeChoice(MouseEvent event) {

	    }

	    @FXML
	    void validateFacultyId(ActionEvent event) {

	    }
	 
    
    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) launch.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    
    @FXML
    void launchFrame(ActionEvent event) throws SQLException {
    	

//    	LocalDate ldBeginDate = beginDate.getValue();
//    	Calendar cBeginDate =  Calendar.getInstance();
//    	cBeginDate.set(ldBeginDate.getYear(), ldBeginDate.getMonthValue(), ldBeginDate.getDayOfMonth());
//    	Date dateBeginDate = cBeginDate.getTime();
//    	
//    	LocalDate ldEndDate = endDate.getValue();
//    	Calendar cEndDate  =  Calendar.getInstance();
//    	cEndDate .set(ldEndDate .getYear(), ldEndDate .getMonthValue(), ldEndDate .getDayOfMonth());
//    	Date dateEndDate = cEndDate .getTime();
//    	
//    	
//    	String batchId ="11";
//    	String batchNumber1="1";
//    	String courseName ="Python";
//    	Integer courseId = 3;
//    	Integer lectureDuration1  = Integer.parseInt(lectureDuration.getText());
//    	Integer totalNumberOfLecture1  = 40; //Integer.parseInt(totalNumberOfLecture.getText());
//    	Integer facultyId1  = Integer.parseInt(facultyId.getText());
//    	Integer timeChoice1 = 2;
//    	Date beginDate1 = dateBeginDate;
//    	Date endDate1 = dateEndDate;
//    	
//    	
//    	
//    	BatchDetails batchDetails1 = new BatchDetails(batchId,batchNumber1,courseName,courseId,lectureDuration1, totalNumberOfLecture1,facultyId1,timeChoice1,beginDate1,endDate1);
//    	    	
//    	new BatchDetailsHelper().create(batchDetails1);
//    	
    	Stage stage = (Stage) launch.getScene().getWindow();
    	Parent myNewScene;
		try {
			
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchDetails.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
     
    void setBatchDetails(BatchDetails batchDetails){
    	
    	System.out.println("this is set function");
    	this.batchDetails=batchDetails;
    	displayBatchDetails();
    }
    
    
    
    
    private void displayBatchDetails() {
		// TODO Auto-generated method stub
    	System.out.println("This is display function");
    	batchName.setText(batchDetails.getBatchName());
    	
		
	}


	@Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	
   		super.initialize(location, resources);
   		logo.setImage(logoImage); 
   	}
}

