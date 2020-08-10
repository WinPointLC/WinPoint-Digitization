package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.wrappers.EnquiryDetailsWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class EnquiryDetailsController extends ParentFXMLController{
	
	// Declaration of required Variable : 
	private Button update; 
    @FXML
    private Button CancelButton;
    @FXML
    private ImageView logo;  
    @FXML
    private TableView<EnquiryDetailsWrapper> detailsTable;
    @FXML
    private TableColumn<EnquiryDetailsWrapper, String> nameCol;
    @FXML
    private TableColumn<EnquiryDetailsWrapper, String> courseCol;
    @FXML
    private TableColumn<EnquiryDetailsWrapper, Boolean> eligibilityCol;
    @FXML
    private TableColumn<EnquiryDetailsWrapper, String> suggestionCol;
    @FXML
    private TableColumn<EnquiryDetailsWrapper, Button> updateCol; 
    
    @FXML
    void CancelClick(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
    	Stage stage = (Stage) CancelButton.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    }
   
    void UpdateClick(ActionEvent event) throws IOException {   	
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
    	Stage stage = (Stage) CancelButton.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    }
        
    @Override
	public void initialize(URL location, ResourceBundle resources)  {
    	// Enquiry Details list : 
    	List<EnquiryDetails> enquiryDetailsList = new EnquiryDetailsHelper().getEnquiryDetails();
    	// Row Population Logic : 
    	nameCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("FullName"));
    	courseCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("CoursesInterestedIn"));
    	eligibilityCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, Boolean>("Eligibility"));
    	suggestionCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("Suggestion")); 
    	updateCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, Button>("update")); 	
    	//Enquiry Details Wrapper : 
    	List<EnquiryDetailsWrapper> enquiryDetailsWrapperList  = new ArrayList<EnquiryDetailsWrapper>();
    	// Populating in Table
        for(EnquiryDetails enquiryDetail : enquiryDetailsList){
        	update = new Button("Update");
        	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                    Parent myNewScene = null;
    				try {
    					FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/UpdateForm.fxml"));
    					myNewScene = loader.load(); 
    					/* Passing enquiryDetails to next Screen : Update Form Screen */
    					UpdateFormController studentDetailController = loader.getController();
    					studentDetailController.setStudentDetail(enquiryDetail); 
    					
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
                	Stage stage = (Stage) update.getScene().getWindow();
                	Scene scene = new Scene(myNewScene);
                	stage.setScene(scene);
                	stage.setTitle("Main Scene");
                	stage.show();
                } 
            }; 	
        	update.setOnAction(event);	
        	enquiryDetailsWrapperList.add(new EnquiryDetailsWrapper(enquiryDetail.getFirstName(),
        	enquiryDetail.getLastName(),enquiryDetail.getCoursesInterestedIn(),enquiryDetail.getEligibility(),enquiryDetail.getSuggestion(),update));
        }
    	ObservableList<EnquiryDetailsWrapper> data =FXCollections.observableArrayList(enquiryDetailsWrapperList);
		detailsTable.setItems(data);
		
		// Adding the logo : 
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}