package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PriorityListOfCoursesController extends ParentFXMLController{
    @FXML
    private ImageView logo;

    @FXML
    private Button cancel;
    
    
    

    @FXML
    void cancelFrame(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/CategorisedCourseRecommenderFxml.fxml").openStream());
    	Stage stage = (Stage) cancel.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    
    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   		List<PriorityListOfCoursesWrapper>priorityCoursesList = new PriorityCoursesListHelper().getPriorityCoursesList();
   	}

}
