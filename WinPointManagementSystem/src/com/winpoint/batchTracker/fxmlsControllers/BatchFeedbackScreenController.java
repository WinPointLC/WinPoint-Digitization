package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseFeedbackHelper;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private BarChart<Axis , Axis> weightedResponsesGraph;

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
    	
//    	Axis xAxis = new CategoryAxis();   
//        
//    	xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Average"))); 
//    	xAxis.setLabel("Questions");  
//
//    	Axis<Number> yAxis = new NumberAxis(); 
//    	yAxis.setLabel("Average");
//    	ArrayList<Float> averageResponseList =  new CourseFeedbackHelper().getAverageResponses(1);
//    	weightedResponsesGraph = new BarChart<Axis,Axis>(xAxis, yAxis);
//    	weightedResponsesGraph.setTitle("Average Feedback");
//    	XYChart.Series<String, Float> q1 = new XYChart.Series<>();
//    	q1.setName("Q1");
//    	q1.getData().add(new XYChart.Data<>("Average",averageResponseList.get(0)));
//    	
//    	XYChart.Series<String, Float> q2 = new XYChart.Series<>();
//    	q2.setName("Q2");
//    	q2.getData().add(new XYChart.Data<>("Average",averageResponseList.get(1)));
//		for(Float avg: averageResponseList) {
//			System.out.println(avg);
//		}
//    	weightedResponsesGraph.getData().add(q1,q2);
    	
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
