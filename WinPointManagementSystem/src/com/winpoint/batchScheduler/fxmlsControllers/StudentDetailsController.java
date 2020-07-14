package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StudentDetailsController extends ParentFXMLController {

	private EnquiryDetails enquiryDetailsObject = new EnquiryDetails();
	
    @FXML
    private ImageView logo;

    @FXML
    private Button cancelButton;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private TableView<EnquiryDetails> eligibilityTable;

    @FXML
    private TableColumn<EnquiryDetails, String> courseCol;

    @FXML
    private TableColumn<EnquiryDetails, String> eligiblityCol;

    @FXML
    private Label collegeLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label branchLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label dateofEnquiryLabel;

    @FXML
    private Label contactLabel;

    @FXML
    private Label suggestionLabel;

    @FXML
    private Label coursesInterestedLabel;
    
    public void setLabel(String s){ 
    	nameLabel.setText(s);
    }

    @FXML
    void cancelClick(ActionEvent event) {
    	  	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
			Stage stage = (Stage) cancelButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	   	

    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }

	public void setStudentDetail(EnquiryDetails enquiryDetailsObject) {
		// TODO Auto-generated method stub
		System.out.println("Setter of the StudentDetailsScreen");
		this.enquiryDetailsObject = enquiryDetailsObject;
		displayEnquiryDetails();
	}

	private void displayEnquiryDetails() {
		// TODO Auto-generated method stub
		nameLabel.setText(enquiryDetailsObject.getFirstName()+" "+enquiryDetailsObject.getLastName());
		collegeLabel.setText(enquiryDetailsObject.getCollege());
    	yearLabel.setText(enquiryDetailsObject.getDegree());
    	branchLabel.setText(enquiryDetailsObject.getBranch());
    	emailLabel.setText(enquiryDetailsObject.getEmail());
       	contactLabel.setText(enquiryDetailsObject.getMobileNumber());
    	dateofEnquiryLabel.setText(enquiryDetailsObject.getDateofEnquiry().toString());
    	suggestionLabel.setText(enquiryDetailsObject.getSuggestion());
    	coursesInterestedLabel.setText(enquiryDetailsObject.getCoursesInterestedIn());
    	
    	courseCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    	eligiblityCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    	ObservableList<EnquiryDetails>list=FXCollections.observableArrayList(new EnquiryDetails("C", "YES", "", "", ""), new EnquiryDetails("CPP", "YES", "", "", ""));
    	eligibilityTable.setItems(list);
    	
	}    
}
