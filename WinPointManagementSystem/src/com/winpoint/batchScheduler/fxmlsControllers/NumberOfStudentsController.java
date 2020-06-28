package com.winpoint.batchScheduler.fxmlsControllers;

	import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.UserProfileHelper;

import com.winpoint.common.wrappers.NumberOfStudentWrapper;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

	public class NumberOfStudentsController extends ParentFXMLController{

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button email;

	    @FXML
	    private ImageView logo;
	    
	    @FXML
	    private TableView<NumberOfStudentWrapper> addToBatchTable;
	    
	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> student;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> enquired;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> registered;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> startDate;

	    @FXML
	    private TableColumn<NumberOfStudentWrapper, String> preferredBatch;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene); 
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
	    }

	    @FXML
	    void emailFrame(ActionEvent event) {
	    	System.out.println(event);
	    }
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	
	    	List<UserProfile> userProfileList = new UserProfileHelper().getEligibleUsers();
	   		List<EnquiryDetails> enquiryDetailsList = new EnquiryDetailsHelper().getEligibleUsers();
	    	
	    	student.setCellValueFactory(new PropertyValueFactory<>("Name"));	
	    	enquired.setCellValueFactory(new PropertyValueFactory<>("Enquired"));
	   		registered.setCellValueFactory(new PropertyValueFactory<>("Registered"));
	   		startDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
	   	    preferredBatch.setCellValueFactory(new PropertyValueFactory<>("PreferredBatch"));
	   	    
	   	    List<NumberOfStudentWrapper> noOfStudentWrapperList = new ArrayList<NumberOfStudentWrapper>();
	   	    Date d1 = new Date(0);
	   		
	   	    for( UserProfile userProfile: userProfileList ) {
	   			noOfStudentWrapperList.add(new NumberOfStudentWrapper(userProfile.getFirstName(), userProfile.getLastName(),false, true, d1,"B1"));
	   		}
	   		
	   		for( EnquiryDetails enquiryDetails: enquiryDetailsList ) {
	   			noOfStudentWrapperList.add(new NumberOfStudentWrapper(enquiryDetails.getFirstName(), enquiryDetails.getLastName(), true, false,d1,"B2"));
	   		}
	   		
	   		ObservableList<NumberOfStudentWrapper> noOfStudentRecords = FXCollections.observableArrayList(noOfStudentWrapperList);
		    
	   		addToBatchTable.setItems((ObservableList<NumberOfStudentWrapper>) noOfStudentRecords);
	    	
	    	super.initialize(location, resources);
			logo.setImage(logoImage);
		}
		

	}


