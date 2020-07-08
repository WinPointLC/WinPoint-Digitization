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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UpdatePageController extends ParentFXMLController{

	   @FXML
       private TextField firstName;
	
	   @FXML
	    private TextField college;

	    @FXML
	    private TextField role;

	    @FXML
	    private TextField domain;

	    @FXML
	    private TextField experience;

	    @FXML
	    private TextField company;

	    @FXML
	    private TextField designation;

	    @FXML
	    private TextField suggestion;

	    @FXML
	    private TextField coursesInterestedIn;

	    @FXML
	    private TextField email;
	    
	    @FXML
	    private ChoiceBox<String> yearChoice = new ChoiceBox<>();
	    String[] choices= {"2019","2020","2021","2022"};    
		
	    

	    @FXML
	    private DatePicker dateOfEnquiry;
	    
	    @FXML
	    private ImageView logo;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private Button reset;

	    @FXML
	    private Button submit;

    @FXML
    void cancelFrame(ActionEvent event) {
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
    	//System.out.println(event);
    	firstName.clear();
    	college.clear();
    	yearChoice.setValue(null);
    	email.clear();
    	dateOfEnquiry.setValue(null);
    	role.clear();
    	domain.clear();
    	experience.clear();
    	company.clear();
    	designation.clear();
    	suggestion.clear();
    	coursesInterestedIn.clear();
    	
    }

    @FXML
    void submitFrame(ActionEvent event) {
    
    	
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	yearChoice.getItems().addAll(choices);
    	
    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }
}
