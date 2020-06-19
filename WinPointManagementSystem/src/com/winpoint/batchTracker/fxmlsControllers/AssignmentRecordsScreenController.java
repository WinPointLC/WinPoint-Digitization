package com.winpoint.batchTracker.fxmlsControllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AssignmentRecordsScreenController extends ParentFXMLController{
	  @FXML
	    private Button back;

	    @FXML
	    private Text batchname;

	    @FXML
	    private Text title;

	    @FXML
	    private ImageView logo;

	    @FXML
	    private TableColumn<?, ?> name;

	    @FXML
	    private TableColumn<?, ?> feestatus;

	    @FXML
	    private TableColumn<?, ?> courseware;

	    @FXML
	    private TableColumn<?, ?> assignmentsissued;

	    @FXML
	    private TableColumn<?, ?> assignmentssubmitted;

	    @FXML
	    void GoToPreviousScreen(ActionEvent event) {
	    	System.out.println(event);
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			super.initialize(location, resources);
			logo.setImage(logoImage);
		}

}
