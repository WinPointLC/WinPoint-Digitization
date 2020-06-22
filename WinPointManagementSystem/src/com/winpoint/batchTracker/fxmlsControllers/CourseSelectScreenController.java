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
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CourseSelectScreenController extends ParentFXMLController{

    @FXML
    private ComboBox<?> selectStream;

    @FXML
    private ComboBox<?> selectCourseType;

    @FXML
    private ImageView logo;

    @FXML
    private Button courseID;

    @FXML
    void getCourseType(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getStream(ActionEvent event) {
    	System.out.println(event);
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
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
