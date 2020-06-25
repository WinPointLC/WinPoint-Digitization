package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AssignmentRecordsScreenController extends ParentFXMLController {

    @FXML
    private Button back;

    @FXML
    private Text batchName;

    @FXML
    private Text title;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<StudentCourseDetails> assignmentsTable;

    @FXML
    private TableColumn<?, ?> assignmentsTableNameColumn;

    @FXML
    private TableColumn<String, StudentCourseDetails> assignmentsTableFeeStatusColumn;

    @FXML
    private TableColumn<String, StudentCourseDetails> assignmentsTableCoursewareColumn;

    @FXML
    private TableColumn<String, StudentCourseDetails> assignmentsTableAssignmentsIssuedColumn;

    @FXML
    private TableColumn<String, StudentCourseDetails> assignmentsTableAssignmentsSubmittedColumn;
    
    
    public void setRecievedData(ArrayList<String> recievedData) {
        for(String data : recievedData) {
            System.out.println(data);
        }
    }
    
    
    public void setBackButton(String s) {
    	
    }
    @FXML
    void GoToPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) back.getScene().getWindow();
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
    	
    	/*FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load(getClass().getResource("../../resources/fxmls/LectureSceneController.fxml").openStream());
        LectureSceneController lectureSceneController = loader.getController();
        lectureSceneController.setRevenueType(label);
        stage = (Stage) sceneButton1.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("/mvc/view/scene1.fxml"));
      Scene scene = new Scene(myNewScene);
    stage.setScene(scene);
    stage.setTitle("My New Scene");
    stage.show();*/
    }
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
 
   		// Row Population logic
   		//assignmentsTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
   		assignmentsTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("feeStatus"));
   		assignmentsTableCoursewareColumn.setCellValueFactory(new PropertyValueFactory<>("coursewareIssued"));
   		assignmentsTableAssignmentsIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsIssued"));
   		assignmentsTableAssignmentsSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsSubmitted"));
	    //fx:ID : Column Name
   		
	    ObservableList<StudentCourseDetails> studentCourseDetailRecord = FXCollections.observableArrayList(new StudentCourseDetails("Paid","yes","yes","yes"));
	    
	    assignmentsTable.setItems((ObservableList<StudentCourseDetails>) studentCourseDetailRecord);
   	}
}
