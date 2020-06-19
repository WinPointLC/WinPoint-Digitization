package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    private TableColumn<?, ?> topicsTableTopicName;

    @FXML
    private TableColumn<?, ?> topicsTableTopicDuration;

    @FXML
    private PieChart processTrackingPieChart;

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
