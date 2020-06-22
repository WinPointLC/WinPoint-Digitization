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
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CategorisedCourseRecommenderController extends ParentFXMLController {
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
	    	Stage stage = (Stage) aptiLink.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void crtClick(ActionEvent event) {
	    	Stage stage = (Stage) crtLink.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void modularClick(ActionEvent event) {
	    	Stage stage = (Stage) modularLink.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void softSkillClick(ActionEvent event) {
	    	Stage stage = (Stage) softSkillsLink.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @FXML
	    void tbcClick(ActionEvent event) {
	    	Stage stage = (Stage) tbcLink.getScene().getWindow();
	    	Parent myNewScene;
			try {
				myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
				Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
