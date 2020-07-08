package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.Lecture;
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
	private static Integer batchId;
	private static String batchNameValue;
	
	Lecture dataObject;
	
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

    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	System.out.println(batchId);
    	batchNameValue = recievedData.get(1);
    	batchName.setText(batchNameValue);
//        for(String data : recievedData) {
//            System.out.println(data);
//        }
    }    
	    
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
			AttendanceScreenController attendanceScreenController = loader.getController();
			//attendanceScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			
			ArrayList<String> dataForAttendanceScreen = new ArrayList<String>();
			dataForAttendanceScreen.add("BatchID");
			dataForAttendanceScreen.add("BatchName");
			dataForAttendanceScreen.add("LectureName");
			dataForAttendanceScreen.add("LectureDate");
			dataForAttendanceScreen.add("LectureID");
			dataForAttendanceScreen.add("Lecture1Absentee");
			dataForAttendanceScreen.add("Lecture2Absentee");
			dataForAttendanceScreen.add("LectureNAbsentee");
			
			attendanceScreenController.setRecievedData(dataForAttendanceScreen);
			
			
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
			BatchFeedbackScreenController batchFeedbackScreenController = loader.getController();
			//batchFeedbackScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForBatchFeedbackScreen = new ArrayList<String>();
			dataForBatchFeedbackScreen.add("BatchName");
			dataForBatchFeedbackScreen.add("BatchID");
			dataForBatchFeedbackScreen.add("LectureName");
			dataForBatchFeedbackScreen.add("WeightedAverageQ1");
			dataForBatchFeedbackScreen.add("WeightedAverageQ2");
			dataForBatchFeedbackScreen.add("WeightedAverageQ10");
			dataForBatchFeedbackScreen.add("OverallFeedback");
			dataForBatchFeedbackScreen.add("FeedbackCount");
			
			batchFeedbackScreenController.setRecievedData(dataForBatchFeedbackScreen);
			
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
			EditBatchDetailsScreenController editBatchDetailsScreenController = loader.getController();
			//editBatchDetailsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForEditBatchDetailsScreen = new ArrayList<String>();
			dataForEditBatchDetailsScreen.add("BatchID");
			dataForEditBatchDetailsScreen.add(batchNameValue);
			dataForEditBatchDetailsScreen.add("LectureName");
			dataForEditBatchDetailsScreen.add("LectureStartDate");
			dataForEditBatchDetailsScreen.add("LectureEndDate");
			dataForEditBatchDetailsScreen.add("LectureDuration");
			dataForEditBatchDetailsScreen.add("LectureDate");
			dataForEditBatchDetailsScreen.add("LectureStartTime");
			dataForEditBatchDetailsScreen.add("LectureList");
			
			
			editBatchDetailsScreenController.setRecievedData(dataForEditBatchDetailsScreen);
			
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
			EvaluationScreenController evaluationScreenController = loader.getController();
			//evaluationScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForEvaluationScreen = new ArrayList<String>();
			dataForEvaluationScreen.add("BatchID");
			dataForEvaluationScreen.add(batchNameValue);
			dataForEvaluationScreen.add("StudentName");
			dataForEvaluationScreen.add("StudentUserID");
			dataForEvaluationScreen.add("StudentEvaluationDone");
			dataForEvaluationScreen.add("StudentGrade");
			dataForEvaluationScreen.add("StudentCertificateIssued");
			dataForEvaluationScreen.add("StudentAttendancePercentage");
			
			evaluationScreenController.setRecievedData(dataForEvaluationScreen);
			
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
			FeeRecordsScreenController feeRecordsScreenController = loader.getController();
			//feeRecordsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForFeeRecordsScreen = new ArrayList<String>();
			dataForFeeRecordsScreen.add(batchId.toString());
			dataForFeeRecordsScreen.add(batchNameValue);
			
			feeRecordsScreenController.setRecievedData(dataForFeeRecordsScreen);
			
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
			ProgressTrackingScreenController progressTrackingScreenController = loader.getController();
			//progressTrackingScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForProgressTrackerScreen = new ArrayList<String>();
			dataForProgressTrackerScreen.add("BatchID");
			dataForProgressTrackerScreen.add(batchNameValue);
			dataForProgressTrackerScreen.add("TotalLectures");
			dataForProgressTrackerScreen.add("TotalCourseDuration");
			dataForProgressTrackerScreen.add("ElapsedDuration");
			dataForProgressTrackerScreen.add("TotalTopics");
			dataForProgressTrackerScreen.add("RemainingTopic");
			dataForProgressTrackerScreen.add("RemainingTopicsName");
			dataForProgressTrackerScreen.add("RemainingTopicsDuration");
			
			progressTrackingScreenController.setRecievedData(dataForProgressTrackerScreen);
			
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
			AssignmentRecordsScreenController assignmentRecordsScreenController = loader.getController();
			//assignmentRecordsScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForAssignmentRecordsScreen = new ArrayList<String>();
			dataForAssignmentRecordsScreen.add(batchId.toString());
			dataForAssignmentRecordsScreen.add(batchNameValue);
			dataForAssignmentRecordsScreen.add("StudentName");
			dataForAssignmentRecordsScreen.add("StudentFeeStatus");
			dataForAssignmentRecordsScreen.add("CourseWare");
			dataForAssignmentRecordsScreen.add("AssignmentIssued");
			dataForAssignmentRecordsScreen.add("AssignmentSubmitted");
			
			assignmentRecordsScreenController.setRecievedData(dataForAssignmentRecordsScreen);
			
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
