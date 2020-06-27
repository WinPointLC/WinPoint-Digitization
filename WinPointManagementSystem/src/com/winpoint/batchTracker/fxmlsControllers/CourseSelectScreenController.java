package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CourseSelectScreenController extends ParentFXMLController{

    @FXML
    private ComboBox<String> selectStream = new ComboBox<>();
    
    String[] streams = {"Technical", "Soft Skills","Behavioural Skills"};


    @FXML
    private ComboBox<String> selectCourseType = new ComboBox<>();
    
    String[] courses = {"Modular", "CRT","TBC"};

    @FXML
    private ImageView logo;

    @FXML
    private Button courseID1;
    
    @FXML
    private Button courseID2;
    
    @FXML
    private Button courseID3;
    
    @FXML
    private Button courseID4;
    
    @FXML
    private Button courseID5;
    
    @FXML
    private Button courseID6;
    
    @FXML
    private Button courseID7;
    
    @FXML
    private Button courseID8;

    @FXML
    void getCourseType(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getStream(ActionEvent event) {
    	

    }
    
    @FXML
    void sendToBatchSelectionScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchSelectionScreen.fxml"));
			myNewScene = loader.load();
			BatchSelectionScreenController batchSelectionScreenController = loader.getController();
			batchSelectionScreenController.setSelectedCourseName(((Button)event.getSource()).getText());
			
			ArrayList<String> dataForBatchSelection = new ArrayList<String>();
			dataForBatchSelection.add(((Button)event.getSource()).getText());
			dataForBatchSelection.add(((Button)event.getSource()).getId());
			dataForBatchSelection.add("StreamID");
			dataForBatchSelection.add("CourseTypeID");
			dataForBatchSelection.add("FacultyName");
			dataForBatchSelection.add("FacultyImage");
			
			batchSelectionScreenController.setRecievedData(dataForBatchSelection);
			
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Select");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	  
    	selectCourseType.getItems().addAll(courses);
    	selectStream.getItems().addAll(streams);
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
