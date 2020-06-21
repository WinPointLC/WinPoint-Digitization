package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BatchSelectionScreenController extends ParentFXMLController {

    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private Text selectedCourseName;

    @FXML
    private Button batchName1;

    @FXML
    private ImageView facultyImage1;

    @FXML
    private Text facultyName1;

    @FXML
    private Button batchName2;

    @FXML
    private ImageView facultyImage2;

    @FXML
    private Text facultyName2;

    @FXML
    private Button batchName3;

    @FXML
    private ImageView facultyImage3;

    @FXML
    private Text facultyName3;

    @FXML
    private Button batchName4;

    @FXML
    private ImageView facultyImage4;

    @FXML
    private Text facultyName4;

    @FXML
    private Button batchName5;

    @FXML
    private ImageView facultyImage5;

    @FXML
    private Text facultyName5;

    @FXML
    private Button batchName6;

    @FXML
    private ImageView facultyImage6;

    @FXML
    private Text facultyName6;

    @FXML
    private Button batchName7;

    @FXML
    private ImageView facultyImage7;

    @FXML
    private Text facultyName7;

    @FXML
    private Button batchName8;

    @FXML
    private ImageView facultyImage8;

    @FXML
    private Text facultyName8;

    @FXML
    void getBatchDetails1(ActionEvent event) {
    	Stage stage = (Stage) batchName1.getScene().getWindow();
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
    void getBatchDetails2(ActionEvent event) {
    	Stage stage = (Stage) batchName2.getScene().getWindow();
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
    void getBatchDetails3(ActionEvent event) {
    	Stage stage = (Stage) batchName3.getScene().getWindow();
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
    void getBatchDetails4(ActionEvent event) {
    	Stage stage = (Stage) batchName4.getScene().getWindow();
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
    void getBatchDetails5(ActionEvent event) {
    	Stage stage = (Stage) batchName5.getScene().getWindow();
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
    void getBatchDetails6(ActionEvent event) {
    	Stage stage = (Stage) batchName6.getScene().getWindow();
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
    void getBatchDetails7(ActionEvent event) {
    	Stage stage = (Stage) batchName7.getScene().getWindow();
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
    void getBatchDetails8(ActionEvent event) {
    	Stage stage = (Stage) batchName8.getScene().getWindow();
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
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/CourseSelectScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
