package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.EnquiryDetailsHelper;

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

public class EnquiryDetailsController extends ParentFXMLController{

    @FXML
    private Button CancelButton;

    @FXML
    private ImageView logo;
        
    @FXML
    private TableView<EnquiryDetails> detailsTable;
    
    @FXML
    private TableColumn<EnquiryDetails, String> nameCol;

    @FXML
    private TableColumn<EnquiryDetails, String> courseCol;

    @FXML
    private TableColumn<EnquiryDetails, Boolean> eligibilityCol;

    @FXML
    private TableColumn<EnquiryDetails, String> suggestionCol;

    @FXML
    private TableColumn<EnquiryDetails, Boolean> updateCol= new TableColumn<>("Update");
    
   
    
    

	
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
    
    @Override
	public void initialize(URL location, ResourceBundle resources)  {
    	
    	EnquiryDetailsHelper enquiryDetailsObject = new EnquiryDetailsHelper(); 	
    	
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    	courseCol.setCellValueFactory(new PropertyValueFactory<>("college"));
    	eligibilityCol.setCellValueFactory(new PropertyValueFactory<>("eligibility"));
    	suggestionCol.setCellValueFactory(new PropertyValueFactory<>("suggestion")); 
    	updateCol.setCellValueFactory(new PropertyValueFactory<>(" activeStatus"));
    	
//			EnquiryDetails eg=new EnquiryDetails();
//			EnquiryDetails eg2=new EnquiryDetails(10, "Shraddha  ", "Agarwal", "aayush.aka44@gmail.com", "9820910220", "MUMBAI",
//					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "MALE", 2021, "AAyush", true, 3, "Rishabh", 7,
//					12, 1, "Passed", true);
				
    		ObservableList<EnquiryDetails> data =FXCollections.observableArrayList(enquiryDetailsObject.getEnquiryDetailsList());
			detailsTable.setItems(data);
		
   
			
			 
    	
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
