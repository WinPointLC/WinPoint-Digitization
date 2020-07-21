package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.AttendanceHelper;
import com.winpoint.common.helpers.LectureHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AttendanceScreenController extends ParentFXMLController{
	private Integer batchId = 1;
	private String batchNameValue;
	private Integer courseId;
	private String courseName;
	
	private ArrayList<AttendanceScreenWrapper> attendanceScreenWrapperList;
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
    private TableView<AttendanceScreenWrapper> updateAttendanceRecordTable;

    @FXML
    private TableColumn<AttendanceScreenWrapper, String> updateAttendanceRecordTableStudentColumn;

    @FXML
    private TableColumn<AttendanceScreenWrapper, String> updateAttendanceRecordTableAttendanceColumn;

    @FXML
    private Button saveAttendance;
    
    @FXML
    private TableView<List<StringProperty>> displayStudentAttendanceTable;

    @FXML
    private TableColumn<List<StringProperty>, String> displayStudentAttendanceTableName;

    @FXML
    private TableColumn<AttendanceScreenWrapper, String> displayStudentAttendanceTableLecture1;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	courseId = Integer.parseInt(recievedData.get(2));
    	courseName = recievedData.get(3);
    	batchName.setText(batchNameValue);
    	
    	attendanceScreenWrapperList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
//    	Integer lectureCount = attendanceScreenWrapperList.get(0).getAttendanceMap().size();
//    	int i = 0;
//    	for(i = 0; i < lectureCount; i++) {
//    		createColumn("Lecture" + (i+1), i);
//    	}
//    	
//    	final ObservableMap<String, String> obsMap = FXCollections.observableHashMap();
//    	for (i = 0; i < 3; i++)  obsMap.put("Lecture" + (i+1), "Present");
//    	
//    	TableView<ObservableMap.Entry<String, String>> sampleTable = new TableView(FXCollections.observableArrayList(obsMap.entrySet()));
//    	
//        TableColumn<ObservableMap.Entry<String, String>,String> attendance = new TableColumn<>("key");
//    	
//    	
    	displayStudentAttendanceTableName.setCellValueFactory(new PropertyValueFactory<AttendanceScreenWrapper, String>("Name"));
    	
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
//    	attendanceScreenWrapperList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
//    	
//    	
//    	System.out.println("\n");
//    	int i, j;
//    	for(i = 0; i < attendanceScreenWrapperList.size(); i++) {
//    		System.out.println("UserId: " + attendanceScreenWrapperList.get(i).getUserId());
//        	System.out.println(attendanceScreenWrapperList.get(i).getFirstName() + " " + attendanceScreenWrapperList.get(i).getLastName());
//        	j = 1;
//        	while(j <= attendanceScreenWrapperList.get(i).getAttendanceMap().size()) {
//        		System.out.println("Lecture " + j + ": " + attendanceScreenWrapperList.get(i).getAttendanceMap().get(j));
//        		j++;
//        	}
//        	System.out.println();        	
//    	}
//    	
    }
    
    void displayTable() {
    	ArrayList<UserProfile> studentList = new UserProfileHelper().getStudentListForBatch(batchId);
    	ArrayList<Lecture> lectureAbsenteeList = new LectureHelper().getAttendanceforBatch(batchId);
    	Integer currentLecture = lectureAbsenteeList.size();
    	ArrayList<String> columnHeaders = new ArrayList<String>();
    	ArrayList<String> records = new ArrayList<String>();
    	ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();
    	try {
    		int columnIndex = 0;
    		TableColumn[] columns = new TableColumn[currentLecture];
    		for(int i = 0; i < currentLecture; i++) {
    			columns[i].setCellValueFactory(data -> data.getValue().get(i));
    		}
    		
    		
    	}catch(Exception e) {
    		 System.out.println(e);
    	}
    	
    	
    	for(UserProfile student : studentList) {
    		int i = 0;
    		for(i = 0; i < currentLecture; i++) {
    			
    		}
    	}
    }

//    private TableColumn<AttendanceScreenWrapper, String> createColumn(String columnTitle) {
//	    TableColumn<AttendanceScreenWrapper, String> column = new TableColumn<>();
//	    column.setText(columnTitle);
//	    column.setCellValueFactory(new PropertyValueFactory<AttendanceScreenWrapper, String>("attendanceMap"));
//	    return column;
//    }
//    private TableColumn<AttendanceScreenWrapper, String> createColumn(String columnTitle, Integer columnIndex) {
//	    TableColumn<AttendanceScreenWrapper, String> column = new TableColumn<>();
//	    column.setText(columnTitle);
//	    column.setCellValueFactory((p) -> {return new SimpleStringProperty(p.getValue().getKey());
//	    return column;
//    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	selectLectureNumber.getItems().addAll(lectureno);
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
	
}
