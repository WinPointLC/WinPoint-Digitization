package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.CourseFeedbackHelper;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;


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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BatchIndividualFeedbackScreenController extends ParentFXMLController {
	
	ArrayList<TextField> individualFeedbackQuestionList;
	 
	 private Integer batchId;
	 private String batchName;
	 private Integer courseId;
	 private String courseName;

    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<BatchIndividualFeedbackScreenWrapper> individualFeedbackTable;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableNameColumn;

    @FXML
    private TableColumn<Integer, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableInstructorColumn;

    @FXML
    private TableColumn<Integer, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableDuration;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableEmailId;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableMobile;

    @FXML
    private TableColumn<Boolean,BatchIndividualFeedbackScreenWrapper > individualFeedbackTableStatus;

    @FXML
    private TextField individualFeedbackQuestion1;

    @FXML
    private TextField individualFeedbackQuestion2;

    @FXML
    private TextField individualFeedbackQuestion3;

    @FXML
    private TextField individualFeedbackQuestion4;

    @FXML
    private TextField individualFeedbackQuestion5;

    @FXML
    private TextField individualFeedbackQuestion6;

    @FXML
    private TextField individualFeedbackQuestion7;

    @FXML
    private TextField individualFeedbackQuestion8;

    @FXML
    private TextField individualFeedbackQuestion9;

    @FXML
    private TextField individualFeedbackQuestion10;

    @FXML
    private TextField individualFeedbackQuestion11;

    @FXML
    private TextField individualFeedbackQuestion12;

    @FXML
    private TextField individualFeedbackQuestion13;

    @FXML
    private TextField individualFeedbackQuestion14;
    
    public void setRecievedData(ArrayList<String> recievedData) {
//    	batchId =  Integer.parseInt(recievedData.get(0));
//    	batchName =  recievedData.get(1);
//    	courseId =  Integer.parseInt(recievedData.get(2));
//    	courseName =  recievedData.get(3);
        for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/BatchFeedbackScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Feedback");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
    
    public void getStudentFeedback(Integer userId, Integer courseId) {
    	ArrayList<CourseFeedback> feedBackResponses =  new ArrayList<>();
    	
    	feedBackResponses = (ArrayList<CourseFeedback>) new CourseFeedbackHelper().getResponses(userId,courseId);
    	
    	int i=0;
    	for (CourseFeedback courseFeedback : feedBackResponses) {
    		System.out.println(courseFeedback.getStudentResponse());
			individualFeedbackQuestionList.get(i).setText(courseFeedback.getStudentResponse());
			
			i++;
		}
    	
    	ObservableList<BatchIndividualFeedbackScreenWrapper> batchIndividualList = FXCollections.observableArrayList(new UserProfileHelper().getBatchIndividualFeedbackScreenWrapperList(1));
	    
	    individualFeedbackTable.setItems(batchIndividualList);
    	
    }
    
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
	    	
	    	
	    	individualFeedbackQuestionList = new ArrayList<TextField>();
	        individualFeedbackQuestionList.add(individualFeedbackQuestion1);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion2);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion3);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion4);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion5);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion6);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion7);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion8);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion9);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion10);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion11);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion12);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion13);
	        individualFeedbackQuestionList.add(individualFeedbackQuestion14);
        	
        
       		// Row Population logic
       		individualFeedbackTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        	individualFeedbackTableInstructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        	individualFeedbackTableDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        	individualFeedbackTableEmailId.setCellValueFactory(new PropertyValueFactory<>("email"));
        	individualFeedbackTableMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        	individualFeedbackTableStatus.setCellValueFactory(new PropertyValueFactory<>("status")); 
        	
        	
        	getStudentFeedback(22,1);
        	
        	
    	    
    		// TODO Auto-generated method stub
    		super.initialize(location, resources);
    		logo.setImage(logoImage);
    	}


}
