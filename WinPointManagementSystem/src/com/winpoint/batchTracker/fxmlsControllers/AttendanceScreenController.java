package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    	System.out.println(event);
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
