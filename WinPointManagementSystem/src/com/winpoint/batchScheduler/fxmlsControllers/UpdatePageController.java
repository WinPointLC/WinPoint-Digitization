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

public class UpdatePageController extends ParentFXMLController{

    @FXML
    private ImageView logo;

    @FXML
    private Button cancelButton;

    @FXML
    private Button reset;

    @FXML
    private Button submit;

    @FXML
    void cancelClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/StudentDetails.fxml").openStream());
			Stage stage = (Stage) cancelButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void resetFrame(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void submitClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/StudentDetails.fxml").openStream());
			Stage stage = (Stage) cancelButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }
}
