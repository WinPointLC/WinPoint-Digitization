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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AttendanceScreenController extends ParentFXMLController{

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private ComboBox<String> selectLectureNumber = new ComboBox<>();
    
    String[] lectureno = {"Lecture1", "Lecture2","Lecture3"};

    @FXML
    private Text selectedLectureNumberDate;

    @FXML
    private TableView<?> updateAttendanceRecordTable;
    
    @FXML
    private Button saveAttendance;

    @FXML
    private TableColumn<?, ?> updateAttendanceRecordTableStudentColumn;

    @FXML
    private TableColumn<?, ?> updateAttendanceRecordTableAttendanceColumn;

    @FXML
    private TableView<?> displayStudentAttendanceTable;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableName;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture1;

    
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			myNewScene = loader.load();
			//LectureScreenController lectureScreenController = loader.getController();
			//lectureScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
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
    void listOfLectureNumber(ActionEvent event) {
    	System.out.println(event);
    }
    
    @FXML
    void saveAttendance(ActionEvent event) {

    }

    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	selectLectureNumber.getItems().addAll(lectureno);
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
	
}
