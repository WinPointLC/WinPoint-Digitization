package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoursesNameController {

    @FXML
    private ImageView logo;

    @FXML
    private TableView<?> courseName;
    
    @FXML
    private TableColumn<?, ?> student;

    @FXML
    private TableColumn<?, ?> enquired;

    @FXML
    private TableColumn<?, ?> registered;

    @FXML
    private TableColumn<?, ?> checkBox;

    @FXML
    private TableColumn<?, ?> addButton;

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
			e.printStackTrace();
		}
    }

    @FXML
    void emailFrame(ActionEvent event) {

    }

}

