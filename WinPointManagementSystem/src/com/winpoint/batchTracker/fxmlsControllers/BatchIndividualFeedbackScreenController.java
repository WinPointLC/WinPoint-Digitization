package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BatchIndividualFeedbackScreenController extends ParentFXMLController {

    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<UserProfile> individualFeedbackTable;

    @FXML
    private TableColumn<String, UserProfile> individualFeedbackTableNameColumn;

    @FXML
    private TableColumn<?, ?> individualFeedbackTableInstructorColumn;

    @FXML
    private TableColumn<?, ?> individualFeedbackTableDuration;

    @FXML
    private TableColumn<String, UserProfile> individualFeedbackTableEmailId;

    @FXML
    private TableColumn<String, UserProfile> individualFeedbackTableMobile;

    @FXML
    private TableColumn<?, ?> individualFeedbackTableStatus;

    @FXML
    private TextField individualFeedbackQuestion1;

    @FXML
    private TextField indiindividualFeedbackQuestion2idualFeedbackQ2;

    @FXML
    private TextField individualFeedbackQuestion3;

    @FXML
    private TextField individualFeedbackQuestion4;

    @FXML
    private TextField individualFeedbackQuestion5;

    @FXML
    private TextField individualFeedbackQuestion6;

    @FXML
    private TextField individualFeedbackQuestion7;

    @FXML
    private TextField individualFeedbackQuestion8;

    @FXML
    private TextField individualFeedbackQuestion9;

    @FXML
    private TextField individualFeedbackQuestion10;

    @FXML
    private TextArea individualFeedbackQuestionA;

    @FXML
    private TextArea individualFeedbackQuestionB;

    @FXML
    private TextField individualFeedbackQuestionC;

    @FXML
    private TextField individualFeedbackQuestionD;
    
    public void setRecievedData(ArrayList<String> recievedData) {
        for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/BatchFeedbackScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Batch Feedback");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	individualFeedbackTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    	//individualFeedbackTableInstructorColumn.setCellValueFactory(new PropertyValueFactory<>(""));
    	//individualFeedbackTableDuration.setCellValueFactory(new PropertyValueFactory<>(""));
    	individualFeedbackTableEmailId.setCellValueFactory(new PropertyValueFactory<>("email")); 
    	individualFeedbackTableMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
    	//individualFeedbackTableStatus.setCellValueFactory(new PropertyValueFactory<>("atualInstallment3Date")); 
    	
    	
    	UserProfile obj=new UserProfile("Purva", "purvakhot@gmail.com", "9846738933");
    		UserProfile obj1=new UserProfile("Suhasi", "suhasib@gmail.com", "9846778933");
			ObservableList<UserProfile> data =FXCollections.observableArrayList(obj,obj1);
			UserProfile.setItems((ObservableList<UserProfile>)data);
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
