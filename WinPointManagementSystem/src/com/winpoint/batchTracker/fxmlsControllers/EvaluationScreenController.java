package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.AssignmentsScreenWrapper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EvaluationScreenController extends ParentFXMLController {

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TextField evaluationName;

    @FXML
    private TextField evaluationUserID;

    @FXML
    private TextField evaluationAttendance;

    @FXML
    private TextField evaluationStatus;

    @FXML
    private TextField evaluationMarks;

    @FXML
    private TextField evaluationGrade;

    @FXML
    private TextField evaluationCertificateIssued;

    @FXML
    private TableView<EvaluationScreenWrapper> evaluationTable;

    @FXML
    private TableColumn<String, EvaluationScreenWrapper> evaluationTableNameColumn;


    @FXML
    private TableColumn<?, EvaluationScreenWrapper> evaluationTableEvaluationDoneColumn;

    @FXML
    private TableColumn<String,EvaluationScreenWrapper> evaluationTableGradeColumn;

    @FXML
    private TableColumn<String, EvaluationScreenWrapper> evaluationTableCertificateIssuedColumn;
    
    public void setRecievedData(ArrayList<String> recievedData) {
        for(String data : recievedData) {
            System.out.println(data);
        }
    }
   

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
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
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   		ArrayList<UserProfile> userProfileList = new UserProfileHelper().getUsersForBatchTracker();
   		ArrayList<StudentCourseDetails> studentCourseDetailsList =  new StudentCourseDetailsHelper().getStudentCourseDetailsList();
   		
   		StudentCourseDetailsHelper studentCourseDetailsHelper= new StudentCourseDetailsHelper();
   		evaluationTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
   		evaluationTableEvaluationDoneColumn.setCellValueFactory(new PropertyValueFactory<>("evaluationDone"));
   		evaluationTableGradeColumn.setCellValueFactory(new PropertyValueFactory<>("gradeId"));
   		evaluationTableCertificateIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("isCertificateGiven"));
	    //fx:ID : Column Name
   		ArrayList<EvaluationScreenWrapper> evaluationScreenWrapperList = new ArrayList<EvaluationScreenWrapper>();
   		int i=0;
   		while(userProfileList.size()>i) {
   			EvaluationScreenWrapper evaluationScreenWrapper= new EvaluationScreenWrapper(
   					userProfileList.get(i).getFirstName(),
   					userProfileList.get(i).getLastName(),null,
   					studentCourseDetailsList.get(i).getGradeId(), 
   					studentCourseDetailsList.get(i).getIsCertificateGiven());
   				i++;
   				evaluationScreenWrapperList.add(evaluationScreenWrapper);
   			
   		}
   	  ObservableList<EvaluationScreenWrapper> evaluationdetailsList = FXCollections.observableArrayList(evaluationScreenWrapperList);
	    
   	evaluationTable.setItems( evaluationdetailsList);
   	}
}
