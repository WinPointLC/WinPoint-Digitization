 package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.CoursesNameWrapper;

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
	private Integer batchId;
    private String batchNameValue;
    private Integer courseId;
    private String courseName;
    @FXML
    private Button back;

    @FXML
    private Text batchName;

    @FXML
    private Text title;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<AssignmentsScreenWrapper> assignmentsTable;

    @FXML
    private TableColumn<String, AssignmentsScreenWrapper> assignmentsTableNameColumn;

    @FXML
    private TableColumn<String, AssignmentsScreenWrapper> assignmentsTableFeeStatusColumn;

    @FXML
    private TableColumn<String, AssignmentsScreenWrapper> assignmentsTableCoursewareColumn;

    @FXML
    private TableColumn<String, AssignmentsScreenWrapper> assignmentsTableAssignmentsIssuedColumn;

    @FXML
    private TableColumn<String, AssignmentsScreenWrapper> assignmentsTableAssignmentsSubmittedColumn;
    
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
        batchNameValue = recievedData.get(1);
        batchName.setText(batchNameValue);
        courseId = Integer.parseInt(recievedData.get(2));
        courseName = recievedData.get(3);
        ObservableList<AssignmentsScreenWrapper> assignmentDetailsList = FXCollections.observableArrayList(new StudentCourseDetailsHelper().getAssignmentScreenWrapperList(batchId));
	    
	    assignmentsTable.setItems(assignmentDetailsList);
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
			e.printStackTrace();
		}
    }
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   		
   		assignmentsTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
   		assignmentsTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("feeStatus"));
   		assignmentsTableCoursewareColumn.setCellValueFactory(new PropertyValueFactory<>("coursewareIssued"));
   		assignmentsTableAssignmentsIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsIssued"));
   		assignmentsTableAssignmentsSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsSubmitted"));

//   		ArrayList<String> data = new ArrayList<>();
//        data.add("1");
//        data.add("Batch 1");
//        data.add("1");
//        data.add("Course 1");
//
//        setRecievedData(data);
   		
	    
   	}
}
