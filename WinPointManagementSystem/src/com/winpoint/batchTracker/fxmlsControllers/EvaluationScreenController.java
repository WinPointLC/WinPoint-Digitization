package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.UserTestDetailsHelper;
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
	private Integer batchId;
	private String batchNameValue;
	private Integer courseId;
	private String courseName;
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
    private TableColumn<String,EvaluationScreenWrapper> evaluationTableEvaluationDoneColumn;

    @FXML
    private TableColumn<String,EvaluationScreenWrapper> evaluationTableGradeColumn;

    @FXML
    private TableColumn<String, StudentCourseDetails> evaluationTableCertificateIssuedColumn;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	batchName.setText(batchNameValue);
    	courseId = Integer.parseInt(recievedData.get(2));
//        for(String data : recievedData) {
//            System.out.println(data);
//        }
    	 ObservableList<EvaluationScreenWrapper> evaluationScreenRecords = FXCollections.observableArrayList( new StudentCourseDetailsHelper().getStudentEvaluationDetails(batchId));
 	    
 	    evaluationTable.setItems((ObservableList<EvaluationScreenWrapper>) evaluationScreenRecords);
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
   		//StudentCourseDetailsHelper studentCourseDetailsHelper= new StudentCourseDetailsHelper();
   		evaluationTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
   		evaluationTableEvaluationDoneColumn.setCellValueFactory(new PropertyValueFactory<>("evaluationDone"));
   		evaluationTableGradeColumn.setCellValueFactory(new PropertyValueFactory<>("gradeId"));
   		evaluationTableCertificateIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("isCertificateGiven"));
	    //fx:ID : Column Name
//	    ObservableList<EvaluationScreenWrapper> evaluationScreenRecords = FXCollections.observableArrayList( new StudentCourseDetailsHelper().getStudentEvaluationDetails(batchId));
//	    
//	    evaluationTable.setItems((ObservableList<EvaluationScreenWrapper>) evaluationScreenRecords);
   	}
}
