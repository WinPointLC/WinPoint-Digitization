package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.wrappers.CoursesNameWrapper;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoursesNameController extends ParentFXMLController{

    @FXML
    private ImageView logo;

    @FXML
    private TableView<CoursesNameWrapper> courseName;
    
    @FXML
    private TableColumn<String, CoursesNameWrapper> student;

    @FXML
    private TableColumn<String, CoursesNameWrapper> enquired;

    @FXML
    private TableColumn<String, CoursesNameWrapper> registered;

    @FXML
    private TableColumn<?, CoursesNameWrapper> checkBox;

    @FXML
    private TableColumn<?, CoursesNameWrapper> addButton;

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
    
    public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
 
   		// Row Population logic
   		student.setCellValueFactory(new PropertyValueFactory<String, CoursesNameWrapper>("Name"));
   		enquired.setCellValueFactory(new PropertyValueFactory<String, CoursesNameWrapper>("Enquired"));
   		registered.setCellValueFactory(new PropertyValueFactory<String, CoursesNameWrapper>("Registered"));
	    //fx:ID : getter name without writting the get.
   		
   		CoursesNameWrapper record1 = new CoursesNameWrapper("Aayush", "Agarwal", "No", "Yes");
   		CoursesNameWrapper record2 = new CoursesNameWrapper("Abhishek", "Dixit", "No", "Yes");
   		CoursesNameWrapper record3 = new CoursesNameWrapper("Soham", "Shotri", "Yes", "No");
   		
   		ObservableList<CoursesNameWrapper> courseNameRecords = FXCollections.observableArrayList(record1, record2, record3);
	    
	    courseName.setItems((ObservableList<CoursesNameWrapper>) courseNameRecords);
   	}

}

