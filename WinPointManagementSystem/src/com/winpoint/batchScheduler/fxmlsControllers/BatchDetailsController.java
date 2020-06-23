package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
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

public class BatchDetailsController extends ParentFXMLController{

		Stage primaryStage;		

	    @FXML
	    private Button cancel;

	    @FXML
	    private ImageView logo;

	    @FXML
	    private TableView<BatchDetails> batchDetails;

	    @FXML
	    private TableColumn<String, BatchDetails> batchId;

	    @FXML
	    private TableColumn<Integer, BatchDetails> courseId;

	    @FXML
	    private TableColumn<Integer, BatchDetails> faculty;

	    @FXML
	    private TableColumn<Integer, BatchDetails> time;

	    @FXML
	    private TableColumn<Date, BatchDetails> beginDate;

	    @FXML
	    private TableColumn<Date, BatchDetails> endDate;

	    @FXML
	    private TableColumn<Integer, BatchDetails> createdBy;

	    @FXML
	    private TableColumn<Date, BatchDetails> createDate;

	    @FXML
	    private TableColumn<?, ?> addStudent;

	    @FXML
	    void cancelFrame(ActionEvent event) {
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchLauncher.fxml"));
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
 
   		// Row Population logic
	    batchId.setCellValueFactory(new PropertyValueFactory<>("batchId"));
	    faculty.setCellValueFactory(new PropertyValueFactory<>("facultyId"));
	    //fx:ID : Column Name
	    ObservableList<BatchDetails> batchDetailRecords = FXCollections.observableArrayList(new BatchDetails(" 1 ",2),new BatchDetails(" 2 ",3));
	    
   		batchDetails.setItems((ObservableList<BatchDetails>) batchDetailRecords);
   	}
}

