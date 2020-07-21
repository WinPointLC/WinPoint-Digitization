package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.TopicsHelper;
import com.winpoint.common.wrappers.EvaluationScreenWrapper;
import com.winpoint.common.wrappers.ProgressTrackingWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProgressTrackingScreenController extends ParentFXMLController{
	private Integer batchId;
    private String batchNameValue;
    private Integer courseId;
    private String courseName;
    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TextField progressTrackingTotalTopics;

    @FXML
    private TextField ProgressTrackingTotalDuration;

    @FXML
    private TextField progressTrackingTotalLectures;

    @FXML
    private TextField progressTrackingTopicsCovered;

    @FXML
    private TextField progressTrackingRemainingLectures;

    @FXML
    private TextField progressTrackingElapsedDuration;
    @FXML
    private TableView<ProgressTrackingWrapper> topicsTable;

    @FXML
    private TableColumn<String, ProgressTrackingWrapper> topicsTableTopicNameColumn;

    @FXML
    private TableColumn<Integer, ProgressTrackingWrapper> topicsTableTopicDurationColumn;

    @FXML
    private PieChart processTrackingPieChart;
    
    public void setRecievedData(ArrayList<String> recievedData) {
        
        	batchId = Integer.parseInt(recievedData.get(0));
            batchNameValue = recievedData.get(1);
            batchName.setText(batchNameValue);
            courseId = Integer.parseInt(recievedData.get(2));
            courseName = recievedData.get(3);
        	ArrayList<ProgressTrackingWrapper>  progressTrackingWrapperList=new TopicsHelper().getProgressTrackingWrapperTableValues(courseId,batchId);
       		ProgressTrackingWrapper  progressTrackingWrapper=new TopicsHelper().getProgressTrackingWrapperValues(courseId,batchId);
       		setTableData(progressTrackingWrapperList);
       		setPieChartValues(progressTrackingWrapper,progressTrackingWrapperList);
       		setScreenValues(progressTrackingWrapper);
        }
    
    private void setScreenValues(ProgressTrackingWrapper progressTrackingWrapper) {
    	progressTrackingTotalTopics.setText(progressTrackingWrapper.getTotalTopics().toString());
   		ProgressTrackingTotalDuration.setText(progressTrackingWrapper.getCourseDuration().toString());
   		progressTrackingTotalLectures.setText(progressTrackingWrapper.getTotalLectures().toString());
   		progressTrackingTopicsCovered.setText(progressTrackingWrapper.getTotalTopicsCovered().toString());
   		progressTrackingRemainingLectures.setText(progressTrackingWrapper.getRemainingLectures().toString());
   		progressTrackingElapsedDuration.setText((getDuration(progressTrackingWrapper.getElapsedDuration()).toString()));
	}
	Float getDuration(Integer elapsedDuration) {
		float duration=0f;
		int minutes=elapsedDuration%100;
		int hours=elapsedDuration/100;
		duration=(hours+(minutes/60.0f));
		return duration;
	}
	public void setTableData(ArrayList<ProgressTrackingWrapper> progressTrackingWrapperList) {
ObservableList<ProgressTrackingWrapper> topic = FXCollections.observableArrayList(progressTrackingWrapperList);
	    
	    topicsTable.setItems(topic);
    }
    public void setPieChartValues(ProgressTrackingWrapper progressTrackingWrapper, ArrayList<ProgressTrackingWrapper> progressTrackingWrapperList) {
    	int topicsLeft=progressTrackingWrapperList.size();
   		int totalTopics=progressTrackingWrapper.getTotalTopics();
   		int topicsCovered=totalTopics-topicsLeft;
   		
   		PieChart.Data data[]= new PieChart.Data[2];
   		String names[]= {"TOPICS COVERED","TOPICS LEFT"};
   		int values[]= {topicsCovered,topicsLeft};
   		for (int i = 0; i < 2; i++) { 
            data[i] = new PieChart.Data(names[i] , values[i]); 
        } 
   		processTrackingPieChart.setData(FXCollections.observableArrayList(data));
    	    }

    @FXML
    void GoToPreviousScreen(ActionEvent event) {
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
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   		
   		topicsTableTopicNameColumn.setCellValueFactory(new PropertyValueFactory<>("topicName"));
   		topicsTableTopicDurationColumn.setCellValueFactory(new PropertyValueFactory<>("topicDuration"));
//   		ArrayList<String> data = new ArrayList<>();
//   	  data.add("1");
//      data.add("Batch 1");
//      data.add("1");
//      data.add("Course 1");
//
//      setRecievedData(data);    
   	}
}
