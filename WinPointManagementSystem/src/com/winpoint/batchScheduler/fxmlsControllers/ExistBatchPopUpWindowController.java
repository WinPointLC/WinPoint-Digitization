package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ExistBatchPopUpWindowController {

    @FXML
    private Button closeButton;

    @FXML
    void validateCloseButton(ActionEvent event) {
    	Stage stage = (Stage) closeButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

}
