package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditBatchDetailsScreenController extends ParentFXMLController {

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
    
    private ComboBox<String> selectLecture = new ComboBox<>();
    
    String[] lecture = {"Lecture1", "Lecture2","Lecture3"};

    @FXML
    private DatePicker lectureDate;

    @FXML
    private TextField lectureStartTime;

    @FXML
    private TextField lectureSessionDuration;

    @FXML
    private TextArea lectureComments;

    @FXML
    private ComboBox<String> lectureTopics = new ComboBox<>();
    
    String[] topics = {"Operators", "Arrays","Pointers", "Structures"};

    @FXML
    private Button resetLecture;

    @FXML
    private Button saveLecture;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void addLectureToBatch(ActionEvent event) {

    }

    @FXML
    void addStudentToLecture(ActionEvent event) {

    }

    @FXML
    void editStudentInLecture(ActionEvent event) {

    }

    @FXML
    void getLectureList(ActionEvent event) {

    }


    @FXML
    void goToPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Lecture Screen");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void listOfLectureTopics(ActionEvent event) {

    }

    @FXML
    void removeLectureFromBatch(ActionEvent event) {

    }
    
    @FXML
    void resetLectureDetails(ActionEvent event) {

    }

    @FXML
    void saveLectureDetails(ActionEvent event) {

    }

    @FXML
    void saveUpdatedBatchDetails(ActionEvent event) {

    }
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	selectLecture.getItems().addAll(lecture);
    	lectureTopics.getItems().addAll(topics);
    	
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
