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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NewBatchSchedularController extends ParentFXMLController {
	    @FXML
	    private ImageView logo;

	    @FXML
	    private Button cancel;
	    
	    @FXML
	    private ChoiceBox<String> engagementTypeDropBox;
	    
	    String[] choices= {"Student","Organization","Individual", "Weekends"};

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Main scene");
	    	stage.show();
	    }
	    @Override
	   	public void initialize(URL location, ResourceBundle resources) {
	   		// TODO Auto-generated method stub
	    	engagementTypeDropBox.getItems().addAll(choices);
	   		super.initialize(location, resources);
	   		logo.setImage(logoImage);
	   		
	   		
	   	}
}
