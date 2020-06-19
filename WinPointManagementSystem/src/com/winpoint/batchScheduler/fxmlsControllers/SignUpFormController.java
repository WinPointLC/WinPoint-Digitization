package com.winpoint.batchScheduler.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SignUpFormController extends ParentFXMLController {
	 

	@FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    @FXML
    private ImageView logo;

    @FXML
    void cancelClick(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void submitClick(ActionEvent event) {
    	System.out.println(event);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// TODO Auto-generated method stub
    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }
}
