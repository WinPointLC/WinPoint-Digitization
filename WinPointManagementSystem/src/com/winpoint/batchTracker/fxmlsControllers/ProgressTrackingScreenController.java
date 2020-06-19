package com.winpoint.batchTracker.fxmlsControllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProgressTrackingScreenController extends ParentFXMLController {
    @FXML
    private Button back;

    @FXML
    private ImageView logo;

    @FXML
    private TextField totallectures;

    @FXML
    private TextField totalduration;

    @FXML
    private TextField elapsedduration;

    @FXML
    private TextField totaltopics;

    @FXML
    private TextField remainingtopics;

    @FXML
    private TableView<?> topicstable;

    @FXML
    private TableColumn<?, ?> topicName;

    @FXML
    private TableColumn<?, ?> topicDuration;

    @FXML
    private PieChart piechart;

    @FXML
    void GoToPreviousScreen(ActionEvent event) {
    	System.out.println(event);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
	}

}
