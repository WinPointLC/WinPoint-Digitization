package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SignUpFormController extends ParentFXMLController {
	public ArrayList<EnquiryDetails>enquiryDetailRecords=new ArrayList<>();


	@FXML
    private Button cancelButton;
	
	@FXML
    private TextField firstNameLabel;

    @FXML
    private Button submitButton;

    @FXML
    private ImageView logo;
    
    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField emailidLabel;

    @FXML
    private TextField adressLabel;

    @FXML
    private TextField genderLabel;

    @FXML
    private TextField mobileLabel;

    @FXML
    private TextField collegeLabel;

    @FXML
    private TextField branchLabel;

    @FXML
    private TextField passOutLabel;
    
    @FXML
    private DatePicker dobBox;
    
    @FXML
    private ChoiceBox<String> degreeChoice = new ChoiceBox<>(); 
    
    String[] choices= {"First Year","Second Year","Third Year", "B. Tech"};

    

    @FXML
    void cancelClick(ActionEvent event) {
    	System.out.println(event);
    }

    @FXML
    void submitClick(ActionEvent event) throws ParseException{
    	
    	System.out.println(degreeChoice.getValue());
//    	public EnquiryDetails(Integer enquiryId, String firstName, String lastName, String email, String mobileNumber,
//    			String address, Date birthDate, String college, String degree, String branch, Integer createdBy,
//    			Date dateofEnquiry, String gender, Integer yearOfGraduation, String recommendation, Boolean eligibility,
//    			Integer coursesInterestedIn, String reference, Integer timeSlotsId, Integer courseAlreadyDone,
//    			Integer segmentTypeId, String suggestion, Boolean activeStatus) 
    	
    	EnquiryDetails enquiryDetails= new EnquiryDetails(10, "Aayush ", "Agarwal", "aayush.aka44@gmail.com", "9820910220", "MUMBAI",
    			new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "VIT", "B. TECH", "IT", 4, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "MALE", 2021, "AAyush", true, 3, "Rishabh", 7,
    			12, 1, "Passed", true);
    	enquiryDetailRecords.add(enquiryDetails);
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml").openStream());
			//StudentDetailsController studentDetailsController = loader.getController();
	    	//studentDetailsController.setLabel(firstNameLabel.getText());
	    	Stage stage = (Stage) submitButton.getScene().getWindow();
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
    	
    	
    	degreeChoice.getItems().addAll(choices);
    	
    	
    	// TODO Auto-generated method stub
    	super.initialize(location, resources);
    	logo.setImage(logoImage);
    }
    
  
    
    
}
