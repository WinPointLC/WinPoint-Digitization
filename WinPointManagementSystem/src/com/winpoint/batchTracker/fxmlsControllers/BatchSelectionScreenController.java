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
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BatchSelectionScreenController extends ParentFXMLController {
	private static Integer courseId;
	private static String courseName;
	
    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private Text selectedCourseName;

    @FXML
    private Button batchID1;

    @FXML
    private ImageView facultyImage1;

    @FXML
    private Text facultyName1;

    @FXML
    private Button batchID2;

    @FXML
    private ImageView facultyImage2;

    @FXML
    private Text facultyName2;

    @FXML
    private Button batchID3;

    @FXML
    private ImageView facultyImage3;

    @FXML
    private Text facultyName3;

    @FXML
    private Button batchID4;

    @FXML
    private ImageView facultyImage4;

    @FXML
    private Text facultyName4;

    @FXML
    private Button batchID5;

    @FXML
    private ImageView facultyImage5;

    @FXML
    private Text facultyName5;

    @FXML
    private Button batchID6;

    @FXML
    private ImageView facultyImage6;

    @FXML
    private Text facultyName6;

    @FXML
    private Button batchID7;

    @FXML
    private ImageView facultyImage7;

    @FXML
    private Text facultyName7;

    @FXML
    private Button batchID8;

    @FXML
    private ImageView facultyImage8;

    @FXML
    private Text facultyName8;

    //author purva , suhasi , sarthak
    public void setRecievedData(ArrayList<String> recievedData) {
    	courseId = Integer.parseInt(recievedData.get(0));
    	courseName = recievedData.get(1);
    	
    	selectedCourseName.setText(courseName);
//    	for(String data:recievedData){
//    		System.out.println(data);
//    	}
    }
    
    @FXML
    void sendToLectureScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
		try {
			myNewScene = loader.load();
			LectureScreenController lectureScreenLecture = loader.getController();
			//System.out.println("Batch Id = "+((Button)event.getSource()).getId().substring(7));
			ArrayList<String> dataForLectureScreen = new ArrayList<String>();
			dataForLectureScreen.add(((Button)event.getSource()).getId().substring(7));
			dataForLectureScreen.add(((Button)event.getSource()).getText());
			
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

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/CourseSelectScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Course Select");
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
