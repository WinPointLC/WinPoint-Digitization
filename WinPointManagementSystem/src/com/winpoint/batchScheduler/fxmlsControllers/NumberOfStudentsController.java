package com.winpoint.batchScheduler.fxmlsControllers;

	import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;

import com.winpoint.common.wrappers.NumberOfStudentWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

	public class NumberOfStudentsController extends ParentFXMLController{
		
		ArrayList<UserCoursesDoneWrapper> ListOfEnquiredStudents;// =  enquiredStudentsCourseMap.get(course);
	   	ArrayList<UserCoursesDoneWrapper> ListOfRegisteredStudents;// =  registeredStudentsCourseMap.get(course);
		
	    @FXML
	    private Button cancel;

	    @FXML
	    private Button email;

	    @FXML
	    private ImageView logo;
	    
	    @FXML
	    private TableView<NumberOfStudentWrapper> addToBatchTable;
	    
	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> student;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> enquired;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> registered;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> startDate;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> preferredBatch;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {
	    	
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Categorised Course Recommender");
	    	stage.show();

	    }

	    @FXML
	    void emailFrame(ActionEvent event) {
	    	System.out.println(event);
	    }
	    
	    public void displayBatchDetails(ArrayList<UserCoursesDoneWrapper> ListOfRegisteredStudents, ArrayList<UserCoursesDoneWrapper> ListOfEnquiredStudents) {
			// TODO Auto-generated method stub
	    	student.setCellValueFactory(new PropertyValueFactory<>("FullName"));	
	    	enquired.setCellValueFactory(new PropertyValueFactory<>("Enquired"));
	   		registered.setCellValueFactory(new PropertyValueFactory<>("Registered"));
	   		startDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
	   	    preferredBatch.setCellValueFactory(new PropertyValueFactory<>("PreferredBatch"));
	    	
	   	    
	   	    // hash map - array list of student - one student at each time
	   	    List<NumberOfStudentWrapper> noOfStudentWrapperList = new ArrayList<NumberOfStudentWrapper>();

	   	    System.out.println("Size of registered Array List (  ) : "+ListOfRegisteredStudents.size());
	   	    for(UserCoursesDoneWrapper userCoursesDoneWrapper : ListOfRegisteredStudents) {
	   	    	
	        	HashSet<Integer> timeSlotsIdsSet = new HashSet<Integer>();
	   	    	String timeSlotsDescription = "";
	        	String timeSlotsIdString = userCoursesDoneWrapper.getUserProfile().getTimeSlotsId();
				StringTokenizer st = new StringTokenizer(timeSlotsIdString,",");
				while(st.hasMoreTokens()) {
					int timeSlotIdOfStudent=Integer.parseInt(st.nextToken());
					timeSlotsIdsSet.add(timeSlotIdOfStudent);						
				} 	    	
	   	    	ArrayList<TimeSlots> timeSlotsList = (ArrayList<TimeSlots>) new TimeSlotsHelper().getTimeSlotsList();
				for(TimeSlots timeSlots : timeSlotsList) {
					 for(Integer time : timeSlotsIdsSet) {
						 if(time == timeSlots.getTimeSlotsId()) {
								timeSlotsDescription += timeSlots.getTimeSlotsDescription()+", ";
							}
					 }
	   	    	}
				timeSlotsDescription = timeSlotsDescription.substring(0,timeSlotsDescription.length()-1);
	   	    	noOfStudentWrapperList.add(new NumberOfStudentWrapper(userCoursesDoneWrapper.getUserProfile().getFirstName(),
	   	    			userCoursesDoneWrapper.getUserProfile().getLastName(), timeSlotsDescription, false, true ));
	   	    }
	   	    
	   	    for(UserCoursesDoneWrapper userCoursesDoneWrapper : ListOfEnquiredStudents) {
	   	    	
	        	HashSet<Integer> timeSlotsIdsSet = new HashSet<Integer>();
	   	    	String timeSlotsDescription = "";
	        	String timeSlotsIdString = userCoursesDoneWrapper.getUserProfile().getTimeSlotsId();
				StringTokenizer st = new StringTokenizer(timeSlotsIdString,",");
				while(st.hasMoreTokens()) {
					int timeSlotIdOfStudent=Integer.parseInt(st.nextToken());
					timeSlotsIdsSet.add(timeSlotIdOfStudent);						
				} 	    	
	   	    	ArrayList<TimeSlots> timeSlotsList = (ArrayList<TimeSlots>) new TimeSlotsHelper().getTimeSlotsList();
				for(TimeSlots timeSlots : timeSlotsList) {
					 for(Integer time : timeSlotsIdsSet) {
						 if(time == timeSlots.getTimeSlotsId()) {
								timeSlotsDescription += timeSlots.getTimeSlotsDescription()+", ";
							}
					 }
	   	    	}
				timeSlotsDescription = timeSlotsDescription.substring(0,timeSlotsDescription.length()-1);
	   	    	noOfStudentWrapperList.add(new NumberOfStudentWrapper(userCoursesDoneWrapper.getUserProfile().getFirstName(),
	   	    			userCoursesDoneWrapper.getUserProfile().getLastName(), timeSlotsDescription, true, false));
	   	    }
		
	   	    ObservableList<NumberOfStudentWrapper> noOfStudentRecords = FXCollections.observableArrayList(noOfStudentWrapperList);
		    
	   		addToBatchTable.setItems((ObservableList<NumberOfStudentWrapper>) noOfStudentRecords);
	    	
	   	    
		}
	    
	   
		@Override
		public void initialize(URL location, ResourceBundle resources) {
	    	
	    	super.initialize(location, resources);
			logo.setImage(logoImage);
		}

		
		

	}


