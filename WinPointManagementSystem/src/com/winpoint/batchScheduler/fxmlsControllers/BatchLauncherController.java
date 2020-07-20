package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
	    private Label totalNumberOfLectures;

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button launch;

	    @FXML
	    private ImageView logo;
	    
	    @FXML
	    private Button setLectureDuration;

	    @FXML
	    void validateLectureDuration(ActionEvent event) {
	    	
	    }
	    
	    @FXML
	    void validateSetLectureDuration(ActionEvent event) {

	    	String lectureDurationString = lectureDuration.getText();
	    	int lectureDuration1 = Integer.parseInt(lectureDurationString);
			int totalNumberOfLectures1 = (80/lectureDuration1);		
			String totalNumberOfLecturesString = Integer.toString(totalNumberOfLectures1);
			totalNumberOfLectures.setText(totalNumberOfLecturesString);                      // Total Number Of Lectures
			
			int totalNumberOfDays;
			if(timeChoice.getText().equals("MORNING")||timeChoice.getText().equals("EVENING"))
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 1.4);
			else
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 3.5);
			
			//Given Date in String format
			String oldDate = "2020-09-23";  
			System.out.println("Date before Addition: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, totalNumberOfDays);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
			
			try {
		        endDate.setValue(LOCAL_DATE(newDate));
		    } catch (NullPointerException e) {
		    }
	    	
	    }
	
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
    	

    	LocalDate ldBeginDate = beginDate.getValue();
    	Calendar cBeginDate =  Calendar.getInstance();
    	cBeginDate.set(ldBeginDate.getYear(), ldBeginDate.getMonthValue(), ldBeginDate.getDayOfMonth());
    	Date dateBeginDate = cBeginDate.getTime();
    	
    	LocalDate ldEndDate = endDate.getValue();
    	Calendar cEndDate  =  Calendar.getInstance();
    	cEndDate .set(ldEndDate .getYear(), ldEndDate .getMonthValue(), ldEndDate .getDayOfMonth());
    	Date dateEndDate = cEndDate .getTime();
    	
    	
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
    	
    	
    	
//    	BatchDetails batchDetails1 = new BatchDetails(batchId,batchNumber1,courseName,courseId,lectureDuration1, totalNumberOfLecture1,facultyId1,timeChoice1,beginDate1,endDate1);
    	    	
//    	new BatchDetailsHelper().create(batchDetails1);
    	
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
    
    public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
    
	@Override
   	public void initialize(URL location, ResourceBundle resources) {
	
		//String date = enquiryDetails.getBirthDate().toString();
		try {
	        beginDate.setValue(LOCAL_DATE("2020-09-23"));
	    } catch (NullPointerException e) {
	    }
		
		batchName.setText("Modular"+"-"+"Java"+"-"+"2020"+"-"+"5");
		facultyId.setText("Anjali Parkhi");
		timeChoice.setText("MORNING");
		

   		super.initialize(location, resources);
   		logo.setImage(logoImage); 
   	}
}

