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

	public class NumberOfStudentsController extends ParentFXMLController{

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button email;

	    @FXML
	    private ImageView logo;
	    
	    @FXML
	    private TableView<EnquiryDetails> addToBatchTable;
	    
	    @FXML
	    private TableColumn<EnquiryDetails, String> studentCol;

	    @FXML
	    private TableColumn<EnquiryDetails, String> enquiredCol;

	    @FXML
	    private TableColumn<EnquiryDetails, String> registeredCol;

	    @FXML
	    private TableColumn<EnquiryDetails, String> startDateCol;

	    @FXML
	    private TableColumn<EnquiryDetails, String> prefferedBatchCol;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene); 
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
	    }

	    @FXML
	    void emailFrame(ActionEvent event) {
	    	System.out.println(event);
	    }
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	
	    	studentCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    	enquiredCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	    	registeredCol.setCellValueFactory(new PropertyValueFactory<>("email"));
	    	startDateCol.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	    	prefferedBatchCol.setCellValueFactory(new PropertyValueFactory<>("address"));
	    	ObservableList<EnquiryDetails>lists=FXCollections.observableArrayList(new EnquiryDetails("Aayush Agarwal", "Java Script", "No", "August", "2"),
	    			new EnquiryDetails("Abhishek Dixit", "Java Script", "Yes", "August", "5"));
	    	addToBatchTable.setItems(lists);
			super.initialize(location, resources);
			logo.setImage(logoImage);
		}
		

	}


