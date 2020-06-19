package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class CourseSelectScreenController extends ParentFXMLController{

    @FXML
    private ComboBox<?> selectStream;

    @FXML
    private ComboBox<?> selectCourseType;

    @FXML
    private ImageView logo;

    @FXML
    private Button courseName;

    @FXML
    void getCourseName(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getCourseType(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void getStream(ActionEvent event) {
    	System.out.println(event);
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
