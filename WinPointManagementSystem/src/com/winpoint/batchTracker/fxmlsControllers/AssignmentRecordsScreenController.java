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
   		System.out.println("Assignment Screen");
   		ArrayList<UserProfile> userProfileList = new UserProfileHelper().getUsersForBatchTracker();
   		ArrayList<StudentCourseDetails> studentCourseDetailsList =  new StudentCourseDetailsHelper().getStudentCourseDetailsList();
   		
   		//StudentCourseDetailsHelper studentCourseDetailsHelper= new StudentCourseDetailsHelper();
   		// Row Population logic
   		//assignmentsTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
   		assignmentsTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("feeStatus"));
   		assignmentsTableCoursewareColumn.setCellValueFactory(new PropertyValueFactory<>("coursewareIssued"));
   		assignmentsTableAssignmentsIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsIssued"));
   		assignmentsTableAssignmentsSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("assignmentsSubmitted"));
	    //fx:ID : Column Name
   		ArrayList<AssignmentsScreenWrapper> assignmentsScreenWrapperList = new ArrayList<AssignmentsScreenWrapper>();
     	//	int i=0;
   		for(StudentCourseDetails studentCourseDetails : studentCourseDetailsList) {
   			assignmentsScreenWrapperList.add(new AssignmentsScreenWrapper(studentCourseDetails.getFeeStatus(),studentCourseDetails.getCoursewareIssued(),studentCourseDetails.getAssignmentsIssued(),studentCourseDetails.getAssignmentsSubmitted()));
   		}
   		/*while(userProfileList.size()>i) {
   			AssignmentsScreenWrapper assignmentsScreenWrapper= new AssignmentsScreenWrapper(
   					userProfileList.get(i).getFirstName(),
   					userProfileList.get(i).getLastName(),
   					studentCourseDetailsList.get(i).getFeeStatus(), 
   					studentCourseDetailsList.get(i).getCoursewareIssued(),
   					studentCourseDetailsList.get(i).getAssignmentsIssued(), 
   					studentCourseDetailsList.get(i).getAssignmentsSubmitted());
   				i++;
   			assignmentsScreenWrapperList.add(assignmentsScreenWrapper);
   			
   		}*/
   		
   		
	    ObservableList<AssignmentsScreenWrapper> assignmentDetailsList = FXCollections.observableArrayList(assignmentsScreenWrapperList);
	    
	    assignmentsTable.setItems(assignmentDetailsList);
   	}
}
