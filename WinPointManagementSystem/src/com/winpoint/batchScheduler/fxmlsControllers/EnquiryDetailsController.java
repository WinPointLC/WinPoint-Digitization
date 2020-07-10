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
   
    private Button update;  
	
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

    	List<EnquiryDetails> enquiryDetailsList = new EnquiryDetailsHelper().getEnquiryDetails();    	
  
    	nameCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("FullName"));
    	courseCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("CoursesInterestedIn"));
    	eligibilityCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, Boolean>("Eligibility"));
    	suggestionCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, String>("Suggestion")); 
    	updateCol.setCellValueFactory(new PropertyValueFactory<EnquiryDetailsWrapper, Button>("update"));
 
		
    	List<EnquiryDetailsWrapper> enquiryDetailsWrapperList  = new ArrayList<EnquiryDetailsWrapper>();

  
         EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
             public void handle(ActionEvent e) 
             { 
                FXMLLoader loader = new FXMLLoader();
             	Parent myNewScene = null;
				try {
					myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/UpdateForm.fxml").openStream());
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
    	
    	for(EnquiryDetails enquiryDetail : enquiryDetailsList){
    		update = new Button("Update");
    		update.setOnAction(event);
    		System.out.println(enquiryDetail.getFirstName()+enquiryDetail.getLastName());
    		enquiryDetailsWrapperList.add(new EnquiryDetailsWrapper(enquiryDetail.getFirstName(),enquiryDetail.getLastName(),enquiryDetail.getCoursesInterestedIn(),enquiryDetail.getEligibility(),enquiryDetail.getSuggestion(),update));
    	}
    	
    	ObservableList<EnquiryDetailsWrapper> data =FXCollections.observableArrayList(enquiryDetailsWrapperList);
		detailsTable.setItems(data);
		
 
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}