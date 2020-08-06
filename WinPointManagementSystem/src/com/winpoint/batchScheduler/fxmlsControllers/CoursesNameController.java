package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.wrappers.CoursesNameWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoursesNameController extends ParentFXMLController{

	int selectedbatchId;
	int selectedCourseId;
	int selectedSegmentTypeId; 
	int preferedTime;
	int facultyId;
	String generatedBatchName;
	
    @FXML
    private ImageView logo;

    @FXML
    private TableView<CoursesNameWrapper> courseName;
    
    @FXML
    private TableColumn<String, CoursesNameWrapper> student;

    @FXML
    private TableColumn<Boolean, CoursesNameWrapper> enquired;

    @FXML
    private TableColumn<Boolean, CoursesNameWrapper> registered;

    @FXML
    private TableColumn<CheckBox, CoursesNameWrapper> checkBox;

    @FXML
    private TableColumn<Button, CoursesNameWrapper> add;
   
//	private Button addStudent;
    
	private CheckBox checkbox;
	
    @FXML
    private Button cancel;

    @FXML
    private Button email;

	private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1 = new ArrayList<UserCoursesDoneWrapper>();

	private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1 = new ArrayList<UserCoursesDoneWrapper>();

    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) cancel.getScene().getWindow();
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

    @FXML
    void emailFrame(ActionEvent event) {

    }
    
	public void setListOfStudents (
			ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents,
			ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents, 
			int selectedCourseId1, 
			int selectedSegmentTypeId1, 
			int preferedTime1, 
			int facultyId1, String generatedBatchName1, Integer selectedbatchId) {

		this.selectedbatchId = selectedbatchId;
   		listOfRegisteredStudents1.addAll(listOfRegisteredStudents);
   		listOfEnquiredStudents1.addAll(listOfEnquiredStudents);
   		
   		selectedCourseId = selectedCourseId1;
		selectedSegmentTypeId = selectedSegmentTypeId1; 
		preferedTime = preferedTime1;
		facultyId = facultyId1;
		generatedBatchName = generatedBatchName1;
    	// Row Population logic
   		student.setCellValueFactory(new PropertyValueFactory<String, CoursesNameWrapper>("Name"));
   		enquired.setCellValueFactory(new PropertyValueFactory<Boolean, CoursesNameWrapper>("Enquired"));
   		registered.setCellValueFactory(new PropertyValueFactory<Boolean, CoursesNameWrapper>("Registered"));
   		checkBox.setCellValueFactory(new PropertyValueFactory<CheckBox, CoursesNameWrapper>("CheckBox"));
   		add.setCellValueFactory(new PropertyValueFactory<Button, CoursesNameWrapper>("AddStudent"));
	    //fx:ID : getter name without writting the get.

   		List<CoursesNameWrapper> coursesNameWrapperList = new ArrayList<CoursesNameWrapper>();
   		
   		for( UserCoursesDoneWrapper registeredStudent: listOfRegisteredStudents1 ) {
   			HashSet<Integer> timeSlotsIdsSet = new HashSet<Integer>();
   	    	String timeSlotsIdString = registeredStudent.getUserProfile().getTimeSlotsId();
   			StringTokenizer st = new StringTokenizer(timeSlotsIdString,",");
   			while(st.hasMoreTokens()) {
   				int timeSlotIdOfStudent=Integer.parseInt(st.nextToken());
   				timeSlotsIdsSet.add(timeSlotIdOfStudent);	
   			}
   			for( Integer time : timeSlotsIdsSet ) {
   				if( time == preferedTime ) {
   					Button addStudent = new Button("Add Student"); 
   	   		   		EventHandler<ActionEvent> eventaddStudent = new EventHandler<ActionEvent>() { 
   	   		             public void handle(ActionEvent e) 
   	   		             { 
   	   		           System.out.println("Entered into the Handler registered");
   	   		                FXMLLoader loader = new FXMLLoader();
   	   		             	Parent myNewScene = null;
   	   		 				try {
   	   		 					myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/ManageRevenue.fxml").openStream());
   	   		 				} catch (IOException e1) {
   	   		 					// TODO Auto-generated catch block
   	   		 					e1.printStackTrace();
   	   		 				}
   	   		 				
   	   		 			System.out.println("User : "+registeredStudent.getUserProfile().getUserId());
   	   		 			
   	   		 			ManageRevenueContoller manageRevenueController = loader.getController();

   	   		 			System.out.println("REGISTERED GENERATED BATCH NAME : "+generatedBatchName); 	   		 			
   	   		 		  		 			
	   	   		 		manageRevenueController.setStudentData(
		   	   		 			registeredStudent, 
		   	   		 			listOfRegisteredStudents1, 
		   	   					listOfEnquiredStudents1, 
		   	   					selectedCourseId, 
		   	   					selectedSegmentTypeId, 
		   	   					preferedTime, 
		   	   					facultyId,
		   	   					false,
		   	   					generatedBatchName,
		   	   					selectedbatchId
	   	   		 			);
   	   		 			
   	   		             	Stage stage = (Stage) addStudent.getScene().getWindow();
   	   		             	Scene scene = new Scene(myNewScene);
   	   		             	stage.setScene(scene);
   	   		             	stage.setTitle("Main Scene");
   	   		             	stage.show();
   	   		             } 
   	   		         }; 
   	   	   			addStudent.setOnAction(eventaddStudent);
   	   	   			checkbox = new CheckBox();
   	   	   			coursesNameWrapperList.add(new CoursesNameWrapper(registeredStudent.getUserProfile().getFirstName(),
   	   	   					registeredStudent.getUserProfile().getLastName(), false, true, checkbox, addStudent));
   				}
   			}
   		}
   		
   		for( UserCoursesDoneWrapper enquiredStudent: listOfEnquiredStudents1 ) {
   			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
   			System.out.println((EnquiryDetails)enquiredStudent.getUserProfile());
//   			System.out.println("Enquired : "+enquiredStudent.getUserProfile().getFirstName());
   			Button addStudent = new Button("Add Student");
   			
	   		EventHandler<ActionEvent> eventaddStudent = new EventHandler<ActionEvent>() { 
	             public void handle(ActionEvent e) 
	             { 
	            	 System.out.println("Entered into the Handler Enquired");
	                FXMLLoader loader = new FXMLLoader();
	             	Parent myNewScene = null;
	 				try {
	 					myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/ManageRevenue.fxml").openStream());
	 				} catch (IOException e1) {
	 					// TODO Auto-generated catch block
	 					e1.printStackTrace();
	 				}
	 				
	 				ManageRevenueContoller manageRevenueController = loader.getController();
	   		 				
	 				System.out.println("Enquired GENERATED BATCH NAME : "+generatedBatchName); 	   		 			
	 				
	   		 		manageRevenueController.setStudentData(
	   		 					enquiredStudent,
	   		 					listOfRegisteredStudents1,
	   		 					listOfEnquiredStudents1,
	   		 					selectedCourseId,
	   		 					selectedSegmentTypeId,
	   		 					preferedTime,
	   		 					facultyId,
	   		 					true,
	   		 					generatedBatchName,
	   		 					selectedbatchId
	   		 				);	

	             	Stage stage = (Stage) addStudent.getScene().getWindow();
	             	Scene scene = new Scene(myNewScene);
	             	stage.setScene(scene);
	             	stage.setTitle("Main Scene");
	             	stage.show();
	             } 
	         }; 
   			addStudent.setOnAction(eventaddStudent);
   			checkbox = new CheckBox();
   			coursesNameWrapperList.add(new CoursesNameWrapper(enquiredStudent.getUserProfile().getFirstName(), enquiredStudent.getUserProfile().getLastName(), true, false, checkbox, addStudent));
   		}
   		
   		ObservableList<CoursesNameWrapper> courseNameRecords = FXCollections.observableArrayList(coursesNameWrapperList);
	    
	    courseName.setItems((ObservableList<CoursesNameWrapper>) courseNameRecords);
		
	}

    public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}


}