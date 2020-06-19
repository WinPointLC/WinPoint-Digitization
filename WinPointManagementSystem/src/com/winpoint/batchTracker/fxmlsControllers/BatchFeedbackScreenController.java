package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BatchFeedbackScreenController extends ParentFXMLController {

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private BarChart<?, ?> weightedResponsesGraph;

    @FXML
    private TextField overallExperience;

    @FXML
    private TextField totalFeedbacksRecieved;

    @FXML
    private Button individualFeedback;

    @FXML
    void getIndividualFeedback(ActionEvent event) {
    	System.out.println(event);

    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	System.out.println(event);

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
