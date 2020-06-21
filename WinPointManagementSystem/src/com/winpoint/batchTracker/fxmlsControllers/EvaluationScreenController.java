package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> evaluationTable;

    @FXML
    private TableColumn<?, ?> evaluationTableNameColumn;

    @FXML
    private TableColumn<?, ?> evaluationTableUserIDColumn;

    @FXML
    private TableColumn<?, ?> evaluationTableEvaluationDoneColumn;

    @FXML
    private TableColumn<?, ?> evaluationTableGradeColumn;

    @FXML
    private TableColumn<?, ?> evaluationTableCertificateIssuedColumn;

    @FXML
    void getAttendance(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getCertificateStatus(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getEvaluationStatus(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getGrades(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getMarks(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getName(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void getUserID(ActionEvent event) {
    	System.out.println(event);
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}
}
