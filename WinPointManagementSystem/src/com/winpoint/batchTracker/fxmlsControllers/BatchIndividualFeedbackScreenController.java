package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import com.winpoint.common.beans.CourseFeedback;
import com.winpoint.common.beans.FeedbackQuestions;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseFeedbackHelper;
import com.winpoint.common.helpers.FeedbackQuestionsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.BatchIndividualFeedbackScreenWrapper;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BatchIndividualFeedbackScreenController extends ParentFXMLController {
	
	ArrayList<TextArea> individualFeedbackResponseList;
	ArrayList<TextArea> individualFeedbackQuestionList;
	ArrayList<TextArea> subjectiveResponseList;

	 
	 private Integer batchId;
	 private String batchNameValue;
	 private Integer courseId = 1;
	 private String courseName;

    @FXML
    private Button backButton;
    
    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<BatchIndividualFeedbackScreenWrapper> individualFeedbackTable;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableNameColumn;

    @FXML
    private TableColumn<Integer, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableInstructorColumn;

    @FXML
    private TableColumn<Integer, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableDuration;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableEmailId;

    @FXML
    private TableColumn<String, BatchIndividualFeedbackScreenWrapper> individualFeedbackTableMobile;

    @FXML
    private TableColumn<Boolean,BatchIndividualFeedbackScreenWrapper > individualFeedbackTableStatus;

    @FXML
    private TextArea individualFeedbackQuestion1Text;

    @FXML
    private TextArea individualFeedbackQuestion1;

    @FXML
    private TextArea individualFeedbackQuestion2Text;

    @FXML
    private TextArea individualFeedbackQuestion2;

    @FXML
    private TextArea individualFeedbackQuestion3Text;

    @FXML
    private TextArea individualFeedbackQuestion3;

    @FXML
    private TextArea individualFeedbackQuestion4Text;

    @FXML
    private TextArea individualFeedbackQuestion4;

    @FXML
    private TextArea individualFeedbackQuestion5Text;

    @FXML
    private TextArea individualFeedbackQuestion5;

    @FXML
    private TextArea individualFeedbackQuestion6Text;

    @FXML
    private TextArea individualFeedbackQuestion6;

    @FXML
    private TextArea individualFeedbackQuestion7Text;

    @FXML
    private TextArea individualFeedbackQuestion7;

    @FXML
    private TextArea individualFeedbackQuestion8Text;

    @FXML
    private TextArea individualFeedbackQuestion8;

    @FXML
    private TextArea individualFeedbackQuestion9Text;

    @FXML
    private TextArea individualFeedbackQuestion9;

    @FXML
    private TextArea individualFeedbackQuestion10Text;

    @FXML
    private TextArea individualFeedbackQuestion10;

    @FXML
    private TextArea individualFeedbackQuestion11Text;

    @FXML
    private TextArea individualFeedbackQuestion11;

    @FXML
    private TextArea individualFeedbackQuestion12Text;

    @FXML
    private TextArea individualFeedbackQuestion12;

    @FXML
    private TextArea individualFeedbackQuestion13Text;

    @FXML
    private TextArea individualFeedbackQuestion13;

    @FXML
    private TextArea individualFeedbackQuestion14Text;

    @FXML
    private TextArea individualFeedbackQuestion14;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId =  Integer.parseInt(recievedData.get(0));
    	batchNameValue =  recievedData.get(1);
    	courseId =  Integer.parseInt(recievedData.get(2));
    	courseName =  recievedData.get(3);
    	//getStudentCourseFeedback(22,1);  //(userId,courseId)
        displayDetails();
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchFeedbackScreen.fxml"));
			myNewScene = loader.load();
			BatchFeedbackScreenController batchFeedbackScreen = loader.getController();
			ArrayList<String> dataForBatchFeedbackScreen = new ArrayList<String>();
			dataForBatchFeedbackScreen.add(batchId.toString());
			dataForBatchFeedbackScreen.add(batchNameValue);
			dataForBatchFeedbackScreen.add(courseId.toString());
			dataForBatchFeedbackScreen.add(courseName);
			batchFeedbackScreen.setRecievedData(dataForBatchFeedbackScreen);
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Feedback");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    public void getStudentCourseFeedback(Integer userId, Integer courseId) {
    	ArrayList<CourseFeedback> feedBackResponses =  new ArrayList<>();
    	ArrayList<FeedbackQuestions> feedBackQuestions =  new ArrayList<>();
    	
    	feedBackResponses = (ArrayList<CourseFeedback>) new CourseFeedbackHelper().getResponses(userId,courseId);
    	feedBackQuestions = new FeedbackQuestionsHelper().getResponsesQuestion(1); // 1 for course feedback
    	
    	int i, j;
    	for(i = 0; i < feedBackQuestions.size(); i++) {
    		individualFeedbackQuestionList.get(i).setText(feedBackQuestions.get(i).getFeedbackQuestion());
			individualFeedbackResponseList.get(i).setText(feedBackResponses.get(i).getStudentResponse());
    	}
    }
    
    void displayDetails() {
    	batchName.setText(batchNameValue);
    	ObservableList<BatchIndividualFeedbackScreenWrapper> batchIndividualList = FXCollections.observableArrayList(new UserProfileHelper().getBatchIndividualFeedbackScreenWrapperList(batchId));
 	
    	for(BatchIndividualFeedbackScreenWrapper batchIndividual: batchIndividualList) {
    		Hyperlink hpl = new Hyperlink();
    		hpl.setText(batchIndividual.getFullName());
    		hpl.setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent e) {
    				getStudentCourseFeedback(batchIndividual.getUserId(),courseId);
               }
              });
    		batchIndividual.setHpl(hpl);
    	}
    	individualFeedbackTable.setItems(batchIndividualList);
    } 
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	    	
		individualFeedbackQuestionList = new ArrayList<TextArea>();
		individualFeedbackQuestionList.add(individualFeedbackQuestion1Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion2Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion3Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion4Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion5Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion6Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion7Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion8Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion9Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion10Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion11Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion12Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion13Text);
        individualFeedbackQuestionList.add(individualFeedbackQuestion14Text);
        
        
        individualFeedbackResponseList = new ArrayList<TextArea>();
        individualFeedbackResponseList.add(individualFeedbackQuestion1);
        individualFeedbackResponseList.add(individualFeedbackQuestion2);
        individualFeedbackResponseList.add(individualFeedbackQuestion3);
        individualFeedbackResponseList.add(individualFeedbackQuestion4);
        individualFeedbackResponseList.add(individualFeedbackQuestion5);
        individualFeedbackResponseList.add(individualFeedbackQuestion6);
        individualFeedbackResponseList.add(individualFeedbackQuestion7);
        individualFeedbackResponseList.add(individualFeedbackQuestion8);
        individualFeedbackResponseList.add(individualFeedbackQuestion9);
        individualFeedbackResponseList.add(individualFeedbackQuestion10);
        individualFeedbackResponseList.add(individualFeedbackQuestion11);
        individualFeedbackResponseList.add(individualFeedbackQuestion12);
        individualFeedbackResponseList.add(individualFeedbackQuestion13);
        individualFeedbackResponseList.add(individualFeedbackQuestion14);
        
		individualFeedbackTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("hpl"));
    	individualFeedbackTableInstructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
    	individualFeedbackTableDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    	individualFeedbackTableEmailId.setCellValueFactory(new PropertyValueFactory<>("email"));
    	individualFeedbackTableMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	individualFeedbackTableStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    	
//      ArrayList<String> data = new ArrayList<>();
//    	data.add("1");
//    	data.add("Batch 1");
//    	data.add("1");
//    	data.add("Course 1");
//    	
//    	setRecievedData(data);
        	
    }


}
