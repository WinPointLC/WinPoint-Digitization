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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SignUpFormController extends ParentFXMLController {
	 

	@FXML
    private Button cancelButton;
	
	@FXML
    private TextField firstNameLabel;

    @FXML
    private Button submitButton;

    @FXML
    private ImageView logo;
    
    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField emailidLabel;

    @FXML
    private TextField adressLabel;

    @FXML
    private TextField genderLabel;

    @FXML
    private TextField mobileLabel;

    @FXML
    private TextField collegeLabel;

    @FXML
    private TextField branchLabel;

    @FXML
    private TextField passOutLabel;

    @FXML
    void cancelClick(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void submitClick(ActionEvent event){
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/StudentDetails.fxml").openStream());
			StudentDetailsController studentDetailsController = loader.getController();
	    	studentDetailsController.setLabel(firstNameLabel.getText());
	    	Stage stage = (Stage) submitButton.getScene().getWindow();
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
    	// TODO Auto-generated method stub
    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }
    
  
    
    
}
