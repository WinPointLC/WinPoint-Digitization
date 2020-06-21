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
    private ComboBox<?> selectLectureNumber;

    @FXML
    private Text selectedLectureNumberDate;

    @FXML
    private TableView<?> updateAttendanceRecordTable;

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

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture2;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture3;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture4;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture5;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture6;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture7;

    @FXML
    private TableColumn<?, ?> displayStudentAttendanceTableLecture8;

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
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
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
	
}
