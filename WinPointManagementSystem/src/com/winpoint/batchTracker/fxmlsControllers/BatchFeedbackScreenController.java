package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void sendToIndividualFeedback(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchIndividualFeedbackScreen.fxml"));
			myNewScene = loader.load();
			BatchIndividualFeedbackScreenController batchIndividualFeedbackScreenController = loader.getController();
			
			ArrayList<String> dataForBatchIndividualFeedbackScreen = new ArrayList<String>();
			dataForBatchIndividualFeedbackScreen.add("BatchID");
			dataForBatchIndividualFeedbackScreen.add("BatchName");
			dataForBatchIndividualFeedbackScreen.add("StudentName");
			dataForBatchIndividualFeedbackScreen.add("Instructor");
			dataForBatchIndividualFeedbackScreen.add("Duration");
			dataForBatchIndividualFeedbackScreen.add("StudentEmail");
			dataForBatchIndividualFeedbackScreen.add("StudentMobile");
			dataForBatchIndividualFeedbackScreen.add("Status");
			dataForBatchIndividualFeedbackScreen.add("Q1");
			dataForBatchIndividualFeedbackScreen.add("Q2");
			dataForBatchIndividualFeedbackScreen.add("Q10");
			dataForBatchIndividualFeedbackScreen.add("QA");
			dataForBatchIndividualFeedbackScreen.add("QD");
			
			batchIndividualFeedbackScreenController.setRecievedData(dataForBatchIndividualFeedbackScreen);
			
			
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Individual Feedback");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Lecture Screen");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
