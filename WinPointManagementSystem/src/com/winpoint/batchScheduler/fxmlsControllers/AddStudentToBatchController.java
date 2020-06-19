package com.winpoint.batchScheduler.fxmlsControllers;




	import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.image.ImageView;

	public class AddStudentToBatchController extends ParentFXMLController{

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button email;

	    @FXML
	    private ImageView logo;

	    @FXML
	    void cancelFrame(ActionEvent event) {
	    	System.out.println(event);
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


