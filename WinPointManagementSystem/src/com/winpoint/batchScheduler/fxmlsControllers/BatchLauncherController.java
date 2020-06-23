package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BatchLauncherController extends ParentFXMLController {

	@FXML
    private TextField batchnumber;
    public void getbatchnumber() {
     	String bd = batchnumber.getText();
    	System.out.println(bd);
    }
    
    @FXML
    private TextField lecturenumber;
    int ln;
    public void getlecturenumber() {
    	ln = Integer.parseInt(lecturenumber.getText());
    }

    @FXML
    private TextField totalnumberoflecture;
    public void gettotalnumberoflecture() {
    	totalnumberoflecture.getText();
    }
    @FXML
    private TextField faculty;
    int facultyid;
    public void getfaculty() {
    	facultyid = Integer.parseInt(faculty.getText());
    }
    
    @FXML
    private DatePicker begindate = new DatePicker();
    //begindate.setOnAction(new EventHandler());
    public void getbegindate() {
    	begindate.getValue();
    }
    
    @FXML
    private DatePicker enddate;
    public void getenddate() {
    	enddate.getValue();
    }

    @FXML
    private CheckBox morning;
    
    @FXML
    private CheckBox evening;

    @FXML
    private CheckBox weekend;

    @FXML
    private Button cancel;

    @FXML
    private Button launch;

    @FXML
    private ImageView logo;

    @FXML
    void beginDateFrame(ActionEvent event) {
    	
    }
    
    @FXML
    void endDateFrame(ActionEvent event) {

    }
    
    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) launch.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void launchFrame(ActionEvent event) {
    	
    	Stage stage = (Stage) launch.getScene().getWindow();
    	Parent myNewScene;
		try {
			
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchDetails.fxml"));
			//adds the data to the DataBase
			BatchDetails obj = new BatchDetails(batchnumber.getText(),facultyid);

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
   	}
}

