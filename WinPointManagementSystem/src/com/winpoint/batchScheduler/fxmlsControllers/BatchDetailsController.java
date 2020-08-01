package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.wrappers.BatchDetailsWrapper;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BatchDetailsController extends ParentFXMLController{

		Stage primaryStage;		

	    @FXML
	    private Button cancel;

	    @FXML
	    private ImageView logo;

	    @FXML
	    private TableView<BatchDetailsWrapper> batchDetails;

	    @FXML
	    private TableColumn<String, BatchDetailsWrapper> batchId;

	    @FXML
	    private TableColumn<String, BatchDetailsWrapper> courseId;

	    @FXML
	    private TableColumn<String, BatchDetailsWrapper> faculty;

	    @FXML
	    private TableColumn<String, BatchDetailsWrapper> time;

	    @FXML
	    private TableColumn<Date, BatchDetailsWrapper> beginDate;

	    @FXML
	    private TableColumn<Date, BatchDetailsWrapper> endDate;

	    @FXML
	    private TableColumn<Integer, BatchDetailsWrapper> createdBy;

	    @FXML
	    private TableColumn<Date, BatchDetailsWrapper> createDate;

	    @FXML
	    private TableColumn<Button, BatchDetailsWrapper> addStudent;
	    
	    private Button add;

		private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents;

		private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents;

	    @FXML
	    void cancelFrame(ActionEvent event) {
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchLauncher.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    void setListOfStudent(ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents, ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents) {
	    	this.listOfRegisteredStudents = listOfRegisteredStudents;
	    	this.listOfEnquiredStudents = listOfEnquiredStudents;
	    }

    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   		
   		List<BatchDetailsWrapper> batchDetailsList = new BatchDetailsHelper().getBatchDetailsList(); 
   		
		// Row Population logic
   		batchId.setCellValueFactory(new PropertyValueFactory<String, BatchDetailsWrapper>("BatchName"));
   		courseId.setCellValueFactory(new PropertyValueFactory<String, BatchDetailsWrapper>("CourseName"));
   		faculty.setCellValueFactory(new PropertyValueFactory<String, BatchDetailsWrapper>("FacultyName"));
   		time.setCellValueFactory(new PropertyValueFactory<String, BatchDetailsWrapper>("BatchTimeDescription"));
   		beginDate.setCellValueFactory(new PropertyValueFactory<Date, BatchDetailsWrapper>("StartDate"));
   		endDate.setCellValueFactory(new PropertyValueFactory<Date, BatchDetailsWrapper>("EndDate"));
   		createdBy.setCellValueFactory(new PropertyValueFactory<Integer, BatchDetailsWrapper>("CreatedBy"));
   		createDate.setCellValueFactory(new PropertyValueFactory<Date, BatchDetailsWrapper>("CreatedDate"));
   		addStudent.setCellValueFactory(new PropertyValueFactory<Button, BatchDetailsWrapper>("add"));
   		//fx:ID : Column Name
   		
   		List<BatchDetailsWrapper> batchDetailsWrapperList = new ArrayList<BatchDetailsWrapper>();
   		
   		for( BatchDetailsWrapper batchDetail : batchDetailsList ) {
   			add= new Button("Add");
   			EventHandler <ActionEvent> eventAddButton = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Parent myNewScene = null;
    				try {
    					FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml"));
    					myNewScene = loader.load();

    					CoursesNameController coursesNameController = loader.getController();
    					coursesNameController.setListOfStudents(listOfRegisteredStudents, listOfEnquiredStudents);
    	            	
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
                	Stage stage = (Stage) add.getScene().getWindow();
                	Scene scene = new Scene(myNewScene);
                	stage.setScene(scene);
                	stage.setTitle("Main Scene");
                	stage.show();
				}
			};
			add.setOnAction(eventAddButton); 
   			batchDetailsWrapperList.add(new BatchDetailsWrapper(batchDetail.getBatchName(), batchDetail.getCourseName(), batchDetail.getFacultyName(), batchDetail.getBatchTimeDescription(), batchDetail.getStartDate(), batchDetail.getEndDate(), batchDetail.getCreatedBy(), batchDetail.getCreatedDate(),add));
   		}
   		
   		ObservableList<BatchDetailsWrapper> batchDetailRecords = FXCollections.observableArrayList(batchDetailsWrapperList);

   		batchDetails.setItems((ObservableList<BatchDetailsWrapper>) batchDetailRecords);
   		
   	}
}






