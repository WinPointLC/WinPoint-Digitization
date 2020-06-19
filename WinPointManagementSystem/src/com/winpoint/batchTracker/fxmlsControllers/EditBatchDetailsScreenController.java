package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class EditBatchDetailsScreenController extends ParentFXMLController{

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private DatePicker batchStartDate;

    @FXML
    private DatePicker batchEndDate;

    @FXML
    private TextField estimateLectureDuration;

    @FXML
    private Button removeLecture;

    @FXML
    private Button addLecture;

    @FXML
    private Button addStudent;

    @FXML
    private Button editStudent;

    @FXML
    private Button saveBatchDetails;

    @FXML
    private ComboBox<?> selectlecture;

    @FXML
    private DatePicker lectureDate;

    @FXML
    private TextField lectureStartTime;

    @FXML
    private TextField lectureSessionDuration;

    @FXML
    private TextArea lectureComments;

    @FXML
    private ComboBox<?> lectureTopics;

    @FXML
    private Button resetLecture;

    @FXML
    private Button saveLecture;

    @FXML
    void addLectureToBatch(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void addStudentToLecture(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void editStudentInLecture(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getLectureDate(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getLectureList(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getLectureSessionDuration(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getLectureStartTime(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void listOfLectureTopics(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void removeLectureFromBatch(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void resetLectureDetails(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void saveLectureDetails(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void saveUpdatedBatchDetails(ActionEvent event) {
    	System.out.println(event);
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
