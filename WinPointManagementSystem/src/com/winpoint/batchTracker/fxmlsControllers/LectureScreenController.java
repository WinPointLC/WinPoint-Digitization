package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LectureScreenController extends ParentFXMLController{

	 @FXML
	    private Button backButton;

	    @FXML
	    private Text batchName;

	    @FXML
	    private ImageView logo;

	    @FXML
	    private Text currentLectureNumber;

	    @FXML
	    private Text startDateDisplay;

	    @FXML
	    private Slider lectureSelectionSlider;

	    @FXML
	    private Text endDateDisplay;

	    @FXML
	    private Button progressTrackerButton;

	    @FXML
	    private Button feesRecordsButton;

	    @FXML
	    private Button attendanceRecordsButton;

	    @FXML
	    private Button assignmentsButton;

	    @FXML
	    private Button feedbackButton;

	    @FXML
	    private Button evaluationButton;

	    @FXML
	    private Button editBatchDetailsButton;

	    @FXML
	    private Text selectedLectureDate;

	    @FXML
	    private Text selectedLectureDuration;

	    @FXML
	    private Text selectedLectureTime;

	    @FXML
	    private Text classStrengthNumber;

	    @FXML
	    private Text selectedLectureNumber;

	    @FXML
	    private TextArea displayCoursePlan;

	    @FXML
	    private TextArea displayLectureCoverage;

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchSelectionScreen.fxml"));
			myNewScene = loader.load();
			//BatchSelectionScreenController batchSelectionScreenController = loader.getController();
			//batchSelectionScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Select");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void sendToAttendanceRecordsScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/AttendanceScreen.fxml"));
			myNewScene = loader.load();
			//AttendanceScreenController attendanceScreenController = loader.getController();
			//attendanceScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Attendance Records");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void sendToBatchFeedbackScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchFeedbackScreen.fxml"));
			myNewScene = loader.load();
			//BatchFeedbackScreenController batchFeedbackScreenController = loader.getController();
			//batchFeedbackScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Feedback");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void sendToEditBatchDetailsScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/EditBatchDetailsScreen.fxml"));
			myNewScene = loader.load();
			//EditBatchDetailsScreenController editBatchDetailsScreenController = loader.getController();
			//editBatchDetailsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Edit Batch Details");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void sendToEvaluationScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/EvaluationScreen.fxml"));
			myNewScene = loader.load();
			//EvaluationScreenController evaluationScreenController = loader.getController();
			//evaluationScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Evaluation and Results");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void sendToFeeRecordsScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/FeeRecordsScreen.fxml"));
			myNewScene = loader.load();
			//FeeRecordsScreenController feeRecordsScreenController = loader.getController();
			//feeRecordsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Fee Records");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void sendToProgressTrackerScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/ProgressTrackingScreen.fxml"));
			myNewScene = loader.load();
			//ProgressTrackingScreenController progressTrackingScreenController = loader.getController();
			//progressTrackingScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Progress Tracking of Batch");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void sendToAssignmentsScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/AssignmentRecordsScreen.fxml"));
			myNewScene = loader.load();
			//AssignmentRecordsScreenController assignmentRecordsScreenController = loader.getController();
			//assignmentRecordsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Assignments and Courseware Records");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
