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
	import javafx.scene.image.ImageView;
import javafx.stage.Stage;

	public class NumberOfStudentsController extends ParentFXMLController{

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button email;

	    @FXML
	    private ImageView logo;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml").openStream());
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
	    }

	    @FXML
	    void emailFrame(ActionEvent event) {
	    	System.out.println(event);
	    }
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			super.initialize(location, resources);
			logo.setImage(logoImage);
		}
		

	}


