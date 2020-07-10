package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.CoursesNameWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CoursesNameController extends ParentFXMLController{

    @FXML
    private ImageView logo;

    @FXML
    private TableView<CoursesNameWrapper> courseName;
    
    @FXML
    private TableColumn<String, CoursesNameWrapper> student;

    @FXML
    private TableColumn<Boolean, CoursesNameWrapper> enquired;

    @FXML
    private TableColumn<Boolean, CoursesNameWrapper> registered;

    @FXML
    private TableColumn<CheckBox, CoursesNameWrapper> checkBox;

    @FXML
    private TableColumn<Button, CoursesNameWrapper> add;
   
	private Button addStudent;
    
	private CheckBox checkbox;
	
    @FXML
    private Button cancel;

    @FXML
    private Button email;

    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) cancel.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/BatchDetails.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void emailFrame(ActionEvent event) {

    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	
   		List<UserProfile> userProfileList = new UserProfileHelper().getEligibleUsers();
   		List<EnquiryDetails> enquiryDetailsList = new EnquiryDetailsHelper().getEligibleUsers();
 
   		// Row Population logic
   		student.setCellValueFactory(new PropertyValueFactory<String, CoursesNameWrapper>("Name"));
   		enquired.setCellValueFactory(new PropertyValueFactory<Boolean, CoursesNameWrapper>("Enquired"));
   		registered.setCellValueFactory(new PropertyValueFactory<Boolean, CoursesNameWrapper>("Registered"));
   		checkBox.setCellValueFactory(new PropertyValueFactory<CheckBox, CoursesNameWrapper>("CheckBox"));
   		add.setCellValueFactory(new PropertyValueFactory<Button, CoursesNameWrapper>("AddStudent"));
	    //fx:ID : getter name without writting the get.
   		
   		List<CoursesNameWrapper> coursesNameWrapperList = new ArrayList<CoursesNameWrapper>();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
               FXMLLoader loader = new FXMLLoader();
            	Parent myNewScene = null;
				try {
					myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/ManageRevenue.fxml").openStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	Stage stage = (Stage) cancel.getScene().getWindow();
            	Scene scene = new Scene(myNewScene);
            	stage.setScene(scene);
            	stage.setTitle("Main Scene");
            	stage.show();
            } 
        }; 
            
   		
   		
   		for( UserProfile userProfile: userProfileList ) {
   			addStudent = new Button("Add Student");
   			addStudent.setOnAction(event);
   			checkbox = new CheckBox();
   			coursesNameWrapperList.add(new CoursesNameWrapper(userProfile.getFirstName(), userProfile.getLastName(), false, true, checkbox, addStudent));
   		}
   		
   		for( EnquiryDetails enquiryDetails: enquiryDetailsList ) {
   			addStudent = new Button("Add Student");
   			addStudent.setOnAction(event);
   			checkbox = new CheckBox();
   			coursesNameWrapperList.add(new CoursesNameWrapper(enquiryDetails.getFirstName(), enquiryDetails.getLastName(), true, false, checkbox, addStudent));
   		}
   		
   		ObservableList<CoursesNameWrapper> courseNameRecords = FXCollections.observableArrayList(coursesNameWrapperList);
	    
	    courseName.setItems((ObservableList<CoursesNameWrapper>) courseNameRecords);
	    
	    
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}