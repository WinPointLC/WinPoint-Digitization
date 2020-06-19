package com.winpoint.batchScheduler.fxmlsControllers;



import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;

public class CourseRecommenderController extends ParentFXMLController {
    @FXML
    private Button cancelButton;

    @FXML
    private ImageView logo;
	 
	 @FXML
	    private Hyperlink modularLink;

	    @FXML
	    private Hyperlink tbcLink;

	    @FXML
	    private Hyperlink crtLink;

	    @FXML
	    private Hyperlink softSkillsLink;

	    @FXML
	    private Hyperlink aptiLink;

	    @FXML
	    void aptiClick(ActionEvent event) {
	    	System.out.println("Will take the user to priority page with Aptitude Subject");
	    }

	    @FXML
	    void crtClick(ActionEvent event) {
	    	System.out.println("Will take the user to priority page with CRT courses");
	    }

	    @FXML
	    void modularClick(ActionEvent event) {
	    	System.out.println("Will take the user to priority page with modular subjects");
	    }

	    @FXML
	    void softSkillClick(ActionEvent event) {
	    	System.out.println("Will take the user to priority page with soft skills courses");
	    }

	    @FXML
	    void tbcClick(ActionEvent event) {
	    	System.out.println("Will take the user to priority page with TBC subjects");
	    }
	    
	    
	    @FXML
	    void cancelClick(ActionEvent event) {
	    	System.out.println(event);
	    }
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	// TODO Auto-generated method stub
	    	super.initialize(location, resources);
	    	logo.setImage(logoImage);
	    }
}
