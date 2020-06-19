package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LectureSceneController extends ParentFXMLController {

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
    void getAssignments(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getAttendanceRecords(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getEditBatchDetails(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getEvaluation(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getFeedback(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getFeesRecords(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getProgressTracker(ActionEvent event) {
    	System.out.println(event);
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}
}
