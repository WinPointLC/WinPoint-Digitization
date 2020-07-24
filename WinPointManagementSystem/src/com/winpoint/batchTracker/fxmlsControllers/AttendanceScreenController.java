package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.AttendanceHelper;
import com.winpoint.common.helpers.LectureHelper;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AttendanceScreenController extends ParentFXMLController{
	private Integer batchId;
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
    private TableView<Attendance> updateAttendanceRecordTable;

    @FXML
    private TableColumn<Attendance, String> updateAttendanceRecordTableStudentColumn;

    @FXML
    private TableColumn<Attendance, Boolean> updateAttendanceRecordTableAttendanceColumn;

    @FXML
    private Button saveAttendance;
    
    @FXML
    private TableView<ObservableList> displayStudentAttendanceTable;

    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	courseId = Integer.parseInt(recievedData.get(2));
    	courseName = recievedData.get(3);
    	batchName.setText(batchNameValue);
    	displayTable();
    	//attendanceScreenWrapperList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
    	//addColumns(10);
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

    }
    
    void displayTable() {
    	updateTable(new LectureHelper().getAbsenteeListforBatch(batchId).size());
    	ObservableList<ObservableList> attendanceList = new AttendanceHelper().getStudentAttendanceForBatch(batchId);
    	displayStudentAttendanceTable.setItems(attendanceList);
    }
    void updateTable(Integer lectureCount) {
    	displayStudentAttendanceTable.getColumns().clear();
    	TableColumn<ObservableList, String> column;
    	
    	column = new TableColumn<ObservableList, String>("Name");
    	column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){

			@Override
			public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
				// TODO Auto-generated method stub
				//System.out.println(param);
				return new SimpleStringProperty(param.getValue().get(0).toString());
			}
			
		});
    	displayStudentAttendanceTable.getColumns().add(column);
    	
    	for(int i = 1; i <= lectureCount; i++) {
			final int j = i;
			column = new TableColumn<ObservableList, String>("Lecture" + i);
			column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){

				@Override
				public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
					// TODO Auto-generated method stub
					//System.out.println(param);
					return new SimpleStringProperty(param.getValue().get(j).toString());
				}
				
			});
			displayStudentAttendanceTable.getColumns().add(column);
		}
    }
    
    void updateAttendanceTable() {
    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	selectLectureNumber.getItems().addAll(lectureno);
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
		//displayTable();
		
		updateAttendanceRecordTableStudentColumn.setCellValueFactory(new PropertyValueFactory<Attendance, String>("fullName"));
		updateAttendanceRecordTableAttendanceColumn.setCellValueFactory(cellData -> cellData.getValue().getPresent());
		
    	ArrayList<String> data = new ArrayList<>();
    	data.add("1");
    	data.add("Batch 1");
    	data.add("1");
    	data.add("Course 1");
    	
    	setRecievedData(data);
	}
	
}

class Attendance{
	Integer userId;
	String fullName;
	CheckBox isPresent;
	BooleanProperty present = new SimpleBooleanProperty();
	
	public Attendance(Integer userId, String fullName, BooleanProperty present){
		this.userId = userId;
		this.fullName = fullName;
		this.present = present;
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public CheckBox getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(CheckBox isPresent) {
		this.isPresent = isPresent;
	}

	public BooleanProperty getPresent() {
		return present;
	}

	public void setPresent(BooleanProperty present) {
		this.present = present;
	}
	
}
