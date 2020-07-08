package com.winpoint.batchScheduler.fxmlsControllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.PriorityCoursesListHelper;
import com.winpoint.common.wrappers.PriorityListOfCoursesWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class PriorityListOfCoursesController extends ParentFXMLController{
    @FXML
    private ImageView logo;

    @FXML
    private Button cancel;
    
    
    

    @FXML
    void cancelFrame(ActionEvent event) {
   
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   		List<PriorityListOfCoursesWrapper>priorityCoursesList = new PriorityCoursesListHelper().getPriorityCoursesList();
   	}

}
