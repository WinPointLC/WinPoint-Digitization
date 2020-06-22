package com.winpoint.batchScheduler.fxmlsControllers;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoursesNameController extends ParentFXMLController {

    @FXML
    private ImageView logo;

    @FXML
    private Button cancel;

    @FXML
    private Button email;

    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) cancel.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchDetails.fxml"));
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
    void emailFrame(ActionEvent event) {
    	System.out.println(event);
    }
    @Override
  	public void initialize(URL location, ResourceBundle resources) {
  		// TODO Auto-generated method stub
  		super.initialize(location, resources);
  		logo.setImage(logoImage);
  	}
  	

}
