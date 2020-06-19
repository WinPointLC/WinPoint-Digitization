package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AssignmentRecordsScreenController extends ParentFXMLController {

    @FXML
    private Button back;

    @FXML
    private Text batchName;

    @FXML
    private Text title;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<?> assignmentsTable;

    @FXML
    private TableColumn<?, ?> assignmentsTableNameColumn;

    @FXML
    private TableColumn<?, ?> assignmentsTableFeeStatus;

    @FXML
    private TableColumn<?, ?> assignmentsTableCourseware;

    @FXML
    private TableColumn<?, ?> assignmentsTableAssignmentsIssued;

    @FXML
    private TableColumn<?, ?> assignmentsTableAssignmentsSubmitted;

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
