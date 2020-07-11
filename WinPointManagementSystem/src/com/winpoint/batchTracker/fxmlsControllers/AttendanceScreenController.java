package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.AttendanceHelper;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

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
	private static Integer batchId;
	private String batchNameValue;
	private static Integer courseId;
	private String courseName;
	
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
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	courseId = Integer.parseInt(recievedData.get(2));
    	courseName = recievedData.get(3);
    	batchName.setText(batchNameValue);
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			myNewScene = loader.load();
			LectureScreenController lectureScreenController = loader.getController();
			
			ArrayList<String> dataForLectureScreen = new ArrayList<String>();
			dataForLectureScreen.add(batchId.toString());
			dataForLectureScreen.add(batchNameValue);
			dataForLectureScreen.add(courseId.toString());
			dataForLectureScreen.add(courseName);
			lectureScreenController.setRecievedData(dataForLectureScreen);
			
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
    	
    }
    
    @FXML
    void saveAttendance(ActionEvent event) {
    	ArrayList<AttendanceScreenWrapper> attendanceScreenWrapperList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
    	
    	/*
    	System.out.println("\n");
    	int i, j;
    	for(i = 0; i < attendanceScreenWrapperList.size(); i++) {
    		System.out.println("UserId: " + attendanceScreenWrapperList.get(i).getUserId());
        	System.out.println(attendanceScreenWrapperList.get(i).getFirstName() + " " + attendanceScreenWrapperList.get(i).getLastName());
        	j = 1;
        	while(j <= attendanceScreenWrapperList.get(i).getAttendanceMap().size()) {
        		System.out.println("Lecture " + j + ": " + attendanceScreenWrapperList.get(i).getAttendanceMap().get(j));
        		j++;
        	}
        	System.out.println();        	
    	}
    	*/
    }
    
    void displayTable() {
    	ArrayList<AttendanceScreenWrapper> attendanceScreenWrapperList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
    	Integer lectureCount = attendanceScreenWrapperList.get(0).getAttendanceMap().size();
    	TableColumn[] tableColumns = new TableColumn[lectureCount+1];
    	
    }

    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	selectLectureNumber.getItems().addAll(lectureno);
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
	
}
