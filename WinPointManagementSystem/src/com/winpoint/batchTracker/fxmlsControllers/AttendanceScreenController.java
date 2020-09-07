package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.Lecture;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.AttendanceHelper;
import com.winpoint.common.helpers.LectureHelper;
import com.winpoint.common.util.EditingCell;
import com.winpoint.common.wrappers.AttendanceScreenWrapper;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
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
	private ObservableList<ObservableList> lectureAttendance = FXCollections.observableArrayList();
	
    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private ComboBox<String> selectLectureNumber = new ComboBox<>();

    @FXML
    private Text selectedLectureNumberDate;

    @FXML
    private TableView<ObservableList> updateAttendanceRecordTable;

    @FXML
    private TableColumn<ObservableList , String> updateAttendanceRecordTableStudentColumn;

    @FXML
    private TableColumn<ObservableList , String> updateAttendanceRecordTableAttendanceColumn;

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
    	
    	selectLectureNumber.getItems().clear();
    	ArrayList<Lecture> lectureList = new LectureHelper().getAbsenteeListforBatch(batchId);
    	for(Lecture l: lectureList) {
    		selectLectureNumber.getItems().add("Lecture " + l.getLectureNumber());
    	}
    	updateTable(new LectureHelper().getAbsenteeListforBatch(batchId).size());
    	displayTable();
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
    	fillObservableList(Integer.parseInt(selectLectureNumber.getValue().substring(8)));
    }
    
    @FXML
    void saveAttendance(ActionEvent event) {
    	//Read Data
    	boolean entryFlag = false;
    	if(selectLectureNumber.getValue() != null) {
    		Integer lectureNumber = Integer.parseInt(selectLectureNumber.getValue().substring(8));
    		ArrayList<String> newAbsenteeList = new ArrayList<String>();
        	for(int i = 0; i < updateAttendanceRecordTable.getItems().size(); i++) {
//        		if(updateAttendanceRecordTable.getColumns().get(1).getCellObservableValue(i).getValue().toString() == " ") {
//        			entryFlag = true;
//        			break;
//        		}
//        		if(updateAttendanceRecordTable.getColumns().get(1).getCellObservableValue(i).getValue().toString() == "A") {
//        			newAbsenteeList.add(updateAttendanceRecordTable.getColumns().get(0).getCellObservableValue(i).getValue().toString());
//        		}
        		//System.out.println(updateAttendanceRecordTable.getColumns().get(1).getCellFactory().call(updateAttendanceRecordTableAttendanceColumn));
        		//System.out.println(updateAttendanceRecordTable.getColumns().get(1).getCellObservableValue(0));
        		if(updateAttendanceRecordTable.getColumns().get(1).getCellData(i).equals(" ")) {
        			entryFlag = true;
        			break;
        		}
        		if(updateAttendanceRecordTable.getColumns().get(1).getCellData(i).equals("A")) {
        			newAbsenteeList.add(updateAttendanceRecordTable.getColumns().get(0).getCellObservableValue(i).getValue().toString());
        		}
        		
        	}
        	System.out.println(newAbsenteeList);
        	//Store Data in DB
        	
        	if(!entryFlag) {
        		new LectureHelper().updateLectureAttendance(newAbsenteeList, lectureNumber, batchId);
        	}else {
        		System.out.println("Enter all records!!!");
        	}
        	
        	//Update and Display Data
        	displayTable();
    	}
    }
    
    void fillObservableList(int lectureNumber) {
    	lectureAttendance.clear();
    	for(int i = 0; i < displayStudentAttendanceTable.getItems().size(); i++) {
    		ObservableList<String> row = FXCollections.observableArrayList();
    		row.addAll(displayStudentAttendanceTable.getColumns().get(0).getCellObservableValue(i).getValue().toString()); //Name column
        	row.add(displayStudentAttendanceTable.getColumns().get(lectureNumber).getCellObservableValue(i).getValue().toString().substring(0, 1)); // Attendance column
        	System.out.println(row);
        	lectureAttendance.add(row);
    	}
    	
    	updateAttendanceRecordTable.setItems(lectureAttendance);
    }
    
    void displayTable() {
    	displayStudentAttendanceTable.getItems().clear();
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
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
 
		updateAttendanceRecordTableStudentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){

			@Override
			public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(param.getValue().get(0).toString());
			}
		});
		updateAttendanceRecordTableAttendanceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){

			@Override
			public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(param.getValue().get(1).toString());
			}
		});
		
		 Callback<TableColumn<ObservableList, String>, TableCell<ObservableList, String>> cellFactory = new Callback<TableColumn<ObservableList, String>, TableCell<ObservableList, String>>() {				
			 @Override
				public TableCell<ObservableList, String> call(TableColumn<ObservableList, String> param) {
					// TODO Auto-generated method stub
					return new EditingCell();
				}
	        };
		
		updateAttendanceRecordTableAttendanceColumn.setCellFactory(cellFactory);
	            
		
//    	ArrayList<String> data = new ArrayList<>();
//    	data.add("1");
//    	data.add("Batch 1");
//    	data.add("1");
//    	data.add("Course 1");
//    	
//    	setRecievedData(data);
	}
	
}

