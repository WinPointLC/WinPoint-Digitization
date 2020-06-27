package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;

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
    private TableView<EnquiryDetails> courseName;
    
    @FXML
    private TableColumn<String, EnquiryDetails> student;

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
    
    public void initialize(URL location, ResourceBundle resources) {
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
 
   		// Row Population logic
   		student.setCellValueFactory(new PropertyValueFactory<>("Student"));
	    //fx:ID : Column Name.
	    ObservableList<EnquiryDetails> courseNameRecords = FXCollections.observableArrayList(new EnquiryDetails("Aayush"));
	    
	    courseName.setItems((ObservableList<EnquiryDetails>) courseNameRecords);
   	}

}

