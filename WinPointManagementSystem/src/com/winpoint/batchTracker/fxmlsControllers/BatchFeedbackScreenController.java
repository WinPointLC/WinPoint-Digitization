package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseFeedbackHelper;
import com.winpoint.common.wrappers.BatchFeedbackScreenWrapper;

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
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BatchFeedbackScreenController extends ParentFXMLController {
	 private Integer batchId;
	 private String batchNameValue;
	 private Integer courseId;
	 private String courseName;
	
	private XYChart.Series<String, Float> question;
	
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private BarChart<String , Float> weightedResponsesGraph;

    @FXML
    private TextField overallExperience;

    @FXML
    private TextField totalFeedbacksRecieved;

    @FXML
    private Button individualFeedback;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId =  Integer.parseInt(recievedData.get(0));
    	batchNameValue =  recievedData.get(1);
    	courseId =  Integer.parseInt(recievedData.get(2));
    	courseName =  recievedData.get(3);
    	batchName.setText(batchNameValue);
    	updateScreenValues();
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
			
			dataForBatchIndividualFeedbackScreen.add(batchId.toString());
			dataForBatchIndividualFeedbackScreen.add(batchNameValue);
			dataForBatchIndividualFeedbackScreen.add(courseId.toString());
			dataForBatchIndividualFeedbackScreen.add(courseName);
			
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
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			myNewScene = loader.load();
			LectureScreenController lectureScreenLecture = loader.getController();
			ArrayList<String> dataForLectureScreen = new ArrayList<String>();
			dataForLectureScreen.add(batchId.toString());
			dataForLectureScreen.add(batchNameValue);
			dataForLectureScreen.add(courseId.toString());
			dataForLectureScreen.add(courseName);
			lectureScreenLecture.setRecievedData(dataForLectureScreen);
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Lecture Screen");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void updateScreenValues() {
    	BatchFeedbackScreenWrapper studentCount = new CourseFeedbackHelper().getFeedbackCount(courseId);
    	totalFeedbacksRecieved.setText(studentCount.getFeedbackCount().toString());
    	
    	ArrayList<Float> averageResponseList =  new CourseFeedbackHelper().getAverageResponses(courseId);
    	
    	weightedResponsesGraph.setTitle("Average Feedback");
    	question = new XYChart.Series<String, Float>();
    	
    	for(int i=0;i<averageResponseList.size()-1;i++) {
    		question = new XYChart.Series<>();
    		question.setName("Q" + (i+1));
    		question.getData().add(new XYChart.Data<>("Average",averageResponseList.get(i)));
    		weightedResponsesGraph.getData().addAll(question);
    	}   
    	
    	overallExperience.setText(new Float((float)Math.round((averageResponseList.get(averageResponseList.size()-1) * 100.0))/100.0f).toString());

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
		
		xAxis.setLabel("Questions");
    	xAxis.setAutoRanging(true);
    	xAxis.setTickLabelsVisible(true);
    	xAxis.setEndMargin(5);
    	xAxis.setTickLabelGap(10);
    	xAxis.setTickMarkVisible(true);
    	xAxis.setTickLength(8);
 
    	yAxis.setLabel("Average");
    	yAxis.setTickLabelsVisible(true);
    	yAxis.setLowerBound(0);
    	yAxis.setMinorTickCount(9);
    	yAxis.setUpperBound(5);
    	yAxis.setTickLabelGap(5);
    	yAxis.setTickLength(8);
    	yAxis.setTickUnit(1);
	}

}
