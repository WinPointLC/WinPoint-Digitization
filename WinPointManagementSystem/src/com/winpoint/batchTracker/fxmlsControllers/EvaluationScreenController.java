package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
	private String Name;
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
	    private TableColumn<String,EvaluationScreenWrapper> evaluationTableGradeColumn;

	    @FXML
	    private TableColumn<String, EvaluationScreenWrapper> evaluationTableCertificateIssuedColumn;

    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	batchName.setText(batchNameValue);
    	courseId = Integer.parseInt(recievedData.get(2));
    	ArrayList<EvaluationScreenWrapper>  evaluationWrapperList= new StudentCourseDetailsHelper().getStudentEvaluationDetails(batchId);
    	setTableData(evaluationWrapperList);
    	setScreenValues(evaluationWrapperList); 
    	
    }
   
   
    private void setTableData(ArrayList<EvaluationScreenWrapper> evaluationWrapperList) {
ObservableList<EvaluationScreenWrapper> evaluationScreenRecords = FXCollections.observableArrayList( evaluationWrapperList);
	    
	    evaluationTable.setItems(evaluationScreenRecords);
	}


	private void setScreenValues(ArrayList<EvaluationScreenWrapper> evaluationWrapperList) {
    	for (EvaluationScreenWrapper evaluationScreenWrapper : evaluationWrapperList) {
  		   String fullName=evaluationScreenWrapper.getFullName();	   
         Hyperlink hpl= new Hyperlink(fullName);
         hpl.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent e) {
               	evaluationUserID.setText(evaluationScreenWrapper.getUserId().toString());
            		evaluationName.setText(evaluationScreenWrapper.getFullName());
            		evaluationMarks.setText(evaluationScreenWrapper.getMarks().toString());
            		evaluationGrade.setText(evaluationScreenWrapper.getGradeId());
            		evaluationCertificateIssued.setText(evaluationScreenWrapper.getIsCertificateGiven());
            	
                }
               });
         evaluationScreenWrapper.setHpl(hpl);
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
   		
   		evaluationTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("hpl"));
   		evaluationTableGradeColumn.setCellValueFactory(new PropertyValueFactory<>("gradeId"));
   		evaluationTableCertificateIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("isCertificateGiven"));
   		
//   		ArrayList<String> data = new ArrayList<>();
//        data.add("1");
//        data.add("Batch 1");
//        data.add("1");
//        data.add("Course 1");
//
//        setRecievedData(data);
   	 
   		
   	}



}
