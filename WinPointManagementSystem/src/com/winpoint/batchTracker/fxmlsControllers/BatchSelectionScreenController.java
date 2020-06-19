package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BatchSelectionScreenController extends ParentFXMLController{

    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private Text selectedCourseName;

    @FXML
    private Button batchName1;

    @FXML
    private ImageView facultyImage1;

    @FXML
    private Text facultyName1;

    @FXML
    private Button batchName2;

    @FXML
    private ImageView facultyImage2;

    @FXML
    private Text facultyName2;

    @FXML
    private Button batchName3;

    @FXML
    private ImageView facultyImage3;

    @FXML
    private Text facultyName3;

    @FXML
    private Button batchName4;

    @FXML
    private ImageView facultyImage4;

    @FXML
    private Text facultyName4;

    @FXML
    private Button batchName5;

    @FXML
    private ImageView facultyImage5;

    @FXML
    private Text facultyName5;

    @FXML
    private Button batchName6;

    @FXML
    private ImageView facultyImage6;

    @FXML
    private Text facultyName6;

    @FXML
    private Button batchName7;

    @FXML
    private ImageView facultyImage7;

    @FXML
    private Text facultyName7;

    @FXML
    private Button batchName8;

    @FXML
    private ImageView facultyImage8;

    @FXML
    private Text facultyName8;

    @FXML
    void getBatchDetails(ActionEvent event) {
    	System.out.println(event);

    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	System.out.println(event);

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
