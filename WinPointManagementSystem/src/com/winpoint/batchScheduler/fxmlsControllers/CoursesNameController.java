package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

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
	
	// Required Variables are Declared :
	int selectedbatchId;
	int selectedCourseId;
	int selectedSegmentTypeId; 
	int preferedTime;
	int facultyId;
	private Date startDate;
	String selectedcourseName;
	String prefreredTimeName;	
	String generatedBatchName;
    @FXML
    private ImageView logo;
    @FXML
    private Button cancel;
    @FXML
    private Button email;
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
	private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
	private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
	private ArrayList<String> listOfEmailIds = new ArrayList<String>();
	/******************************************************************************************************************************/
	
    @FXML
    void cancelClick(ActionEvent event) {
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
    void sendEmail(ActionEvent event) {

    	// Navigation for the next Screen : 
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/EmailUtilityScreen.fxml"));
    	Parent myNewScene;
		try {
			myNewScene = loader.load();
			
			// Loader of the next Screen
			EmailUtilityScreenController emailUtilityScreenController = loader.getController();
			emailUtilityScreenController.sendEmail(listOfEmailIds, selectedcourseName, startDate, prefreredTimeName);
			emailUtilityScreenController.setStudentData(
					listOfRegisteredStudents1, 
					listOfEnquiredStudents1, 
					selectedCourseId, 
					selectedSegmentTypeId,
					preferedTime, 
					facultyId, 
					generatedBatchName, 
					selectedbatchId
				);
			
			Stage stage = (Stage) email.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}	    	
    }
    
    // Setting Data passed from the Previous Screen :
	public void setListOfStudents (
			ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents,
			ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents, 
			int selectedCourseId1, 
			int selectedSegmentTypeId1, 
			int preferedTime1, 
			int facultyId1, 
			String generatedBatchName1, 
			Integer selectedbatchId, Date startDate, String selectedcourseName2, String prefreredTimeName2) {

		this.startDate = startDate;
		this.selectedbatchId = selectedbatchId;
   		this.listOfRegisteredStudents1.addAll(listOfRegisteredStudents);
   		this.listOfEnquiredStudents1.addAll(listOfEnquiredStudents); 		
   		
   		selectedcourseName = selectedcourseName2;
   		prefreredTimeName = prefreredTimeName2;
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
   		
   		// Registered List : 
   		for( UserCoursesDoneWrapper registeredStudent: listOfRegisteredStudents1 ) {
   			
   			// Setting data as required : 
   			HashSet<Integer> timeSlotsIdsSet = new HashSet<Integer>();
   	    	String timeSlotsIdString = registeredStudent.getUserProfile().getTimeSlotsId();
   			StringTokenizer st = new StringTokenizer(timeSlotsIdString,",");
   			while(st.hasMoreTokens()) {
   				int timeSlotIdOfStudent=Integer.parseInt(st.nextToken());
   				timeSlotsIdsSet.add(timeSlotIdOfStudent);	
   			}
   			
   			// Filter for time slots :
   			for( Integer time : timeSlotsIdsSet ) {
   				if( time == preferedTime ) {
   					CheckBox checkbox = new CheckBox("Email");
   					EventHandler<ActionEvent> eventAddEmailId = new EventHandler<ActionEvent>() {					
						@Override
						public void handle(ActionEvent event) {
							// Selected : Adding data to the list.
							if (checkbox.isSelected()) {
					        	checkbox.setSelected(true);
					        	listOfEmailIds.add(registeredStudent.getUserProfile().getEmail());
					        }
					        else {
					        	checkbox.setSelected(false);	
					        	listOfEmailIds.remove(registeredStudent.getUserProfile().getEmail());
					        }
						}
					};
					checkbox.setOnAction(eventAddEmailId);

					// Add Student : 
   					Button addStudent = new Button("Add Student"); 
   	   		   		EventHandler<ActionEvent> eventaddStudent = new EventHandler<ActionEvent>() { 
   	   		             public void handle(ActionEvent e) 
   	   		             { 
   	   		                FXMLLoader loader = new FXMLLoader();
   	   		             	Parent myNewScene = null;
   	   		 				try {
   	   		 					myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/ManageRevenue.fxml").openStream());
   	   		 				} catch (IOException e1) {
   	   		 					e1.printStackTrace();
   	   		 				}
   	   		 			
   	   		 			// Manage Revenue Controller :
   	   		 			ManageRevenueContoller manageRevenueController = loader.getController();	   		 					 			
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
   	   	   			coursesNameWrapperList.add(new CoursesNameWrapper(registeredStudent.getUserProfile().getFirstName(),
   	   	   					registeredStudent.getUserProfile().getLastName(), false, true, checkbox, addStudent));
   				}
   			}
   		}
   		
   		// Enquired List :
   		for( UserCoursesDoneWrapper enquiredStudent: listOfEnquiredStudents1 ) {
   			CheckBox checkbox = new CheckBox("Email");
				EventHandler<ActionEvent> eventAddEmailId = new EventHandler<ActionEvent>() {					
				@Override
				public void handle(ActionEvent event) {
					// Selected
					if (checkbox.isSelected()) {
			        	checkbox.setSelected(true);
			        	listOfEmailIds.add(enquiredStudent.getUserProfile().getEmail());
			        }
			        else {
			        	checkbox.setSelected(false);	
			        	listOfEmailIds.remove(enquiredStudent.getUserProfile().getEmail());
			        }
				}
			};
			checkbox.setOnAction(eventAddEmailId);

			// Add Button :
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
	 					e1.printStackTrace();
	 				}
	 				
	 				// Manage Revenue :
	 				ManageRevenueContoller manageRevenueController = loader.getController();
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
   			coursesNameWrapperList.add(new CoursesNameWrapper(enquiredStudent.getUserProfile().getFirstName(),
   					enquiredStudent.getUserProfile().getLastName(), true, false, checkbox, addStudent));
   		}
   		ObservableList<CoursesNameWrapper> courseNameRecords = FXCollections.observableArrayList(coursesNameWrapperList);  
	    courseName.setItems((ObservableList<CoursesNameWrapper>) courseNameRecords);		
	}

    public void initialize(URL location, ResourceBundle resources) {
    	
    	// Adding logo :
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   		
   	}


}