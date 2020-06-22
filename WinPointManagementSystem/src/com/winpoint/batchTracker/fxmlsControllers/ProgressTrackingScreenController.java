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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProgressTrackingScreenController extends ParentFXMLController{

    @FXML
    private Button back;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TextField progressTrackingTotalLectures;

    @FXML
    private TextField ProgressTrackingTotalDuration;

    @FXML
    private TextField progressTrackingElapsedDuration;

    @FXML
    private TextField progressTrackingTotalTopics;

    @FXML
    private TextField progressTrackingRemainingTopics;

    @FXML
    private TableView<?> topicsTable;

    @FXML
    private TableColumn<?, ?> topicsTableTopicNameColumn;

    @FXML
    private TableColumn<?, ?> topicsTableTopicDurationColumn;

    @FXML
    private PieChart processTrackingPieChart;
    
    public void setRecievedData(ArrayList<String> recievedData) {
        for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void GoToPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)back.getScene().getWindow();
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
