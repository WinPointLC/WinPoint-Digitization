package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
    private TextArea individualFeedbackQuestionA;

    @FXML
    private TextArea individualFeedbackQuestionB;

    @FXML
    private TextField individualFeedbackQuestionC;

    @FXML
    private TextField individualFeedbackQuestionD;
    
    public void setRecievedData(ArrayList<String> recievedData) {
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
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	//individualFeedbackQuestion1.setText("3");
    	
    	ArrayList<CourseFeedback> feedBackResponses1 =  new ArrayList<>();
    	feedBackResponses1 = (ArrayList<CourseFeedback>) new CourseFeedbackHelper().getResponses();
    	for (CourseFeedback courseFeedback : feedBackResponses1) {
			System.out.println(courseFeedback.getStudentResponse());
		}
    	
		ArrayList<BatchDetails> batchDetailsList = new BatchDetailsHelper().getBatchInstructorList();
		ArrayList<Course> courseList =  new CourseHelper().getBatchCourseDurationList();
   		ArrayList<StudentCourseDetails> CourseDetailsList= new StudentCourseDetailsHelper().getBatchFeedback();
   		// Row Population logic
   		individualFeedbackTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
    	individualFeedbackTableInstructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
    	individualFeedbackTableDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    	individualFeedbackTableEmailId.setCellValueFactory(new PropertyValueFactory<>("email"));
    	individualFeedbackTableMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	individualFeedbackTableStatus.setCellValueFactory(new PropertyValueFactory<>("status")); 
	    //fx:ID : Column Name
   		/*ArrayList<BatchIndividualFeedbackScreenWrapper> batchWrapperList = new ArrayList<BatchIndividualFeedbackScreenWrapper>();
   		int i=0;
   		
   		while(userProfileList.size()>i) {
   			BatchIndividualFeedbackScreenWrapper batchFeedbackScreenWrapper= new BatchIndividualFeedbackScreenWrapper(
   					userProfileList.get(i).getFirstName() + " " +
   					userProfileList.get(i).getLastName(),
   					batchDetailsList.get(i).getFacultyId(),
   					courseList.get(i).getCourseDuration(),
   					userProfileList.get(i).getEmail(),
   					userProfileList.get(i).getMobileNumber(),
   					CourseDetailsList.get(i).getIsFeedbackGiven());
   			
   			i++;
   					batchWrapperList.add(batchFeedbackScreenWrapper);
   			
   		}*/
	    ObservableList<BatchIndividualFeedbackScreenWrapper> batchIndividualList = FXCollections.observableArrayList(new UserProfileHelper().getBatchIndividualFeedbackScreenWrapperList(1));
	    
	    individualFeedbackTable.setItems(batchIndividualList);
	    
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
