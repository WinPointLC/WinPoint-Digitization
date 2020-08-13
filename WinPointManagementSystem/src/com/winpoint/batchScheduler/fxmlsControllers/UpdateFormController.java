package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateFormController extends ParentFXMLController {
	
	// Declaration of required Variables : 
	private EnquiryDetails enquiryDetails = new EnquiryDetails();
	@FXML
    private ImageView logo;
	@FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField mobileNumber;
    @FXML
    private TextField emailId;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField gender;
    @FXML
    private TextField college;
    @FXML
    private TextField branch;
    @FXML
    private TextField occupation;
    @FXML
    private TextField organization;
    @FXML
    private TextField designation;
    @FXML
    private TextField domain;
    @FXML
    private TextField yearOfGraduation;
    @FXML
    private TextField role;
    @FXML
    private TextField experience;
    @FXML
    private TextField courseInterestedIn;
    @FXML
    private TextField coursesAlreadyDone;
    @FXML
    private TextField suggestions;
    @FXML
    private CheckBox activeStatus;
    @FXML
    private Button cancel;
    @FXML
    private Button reset;
    @FXML
    private Button submitFrame;
    @FXML
    private ChoiceBox<String> degree = new ChoiceBox<>();
    String [] choices = {"Fy","Sy","Ty","Btech"};
    
    @FXML
    void validateActiveStatus(ActionEvent event) {}
    @FXML
    void validateBranch(ActionEvent event) {}
    @FXML
    void validateCollege(ActionEvent event) {}
    @FXML
    void validateCourseInterestedIn(ActionEvent event) {}
    @FXML
    void validateCoursesAlreadyDone(ActionEvent event) {}
    @FXML
    void validateDegree(MouseEvent event) {}
    @FXML
    void validateDesignation(ActionEvent event) {}
    @FXML
    void validateDob(ActionEvent event) {}
    @FXML
    void validateDomain(ActionEvent event) {}
    @FXML
    void validateEmailId(ActionEvent event) {}
    @FXML
    void validateExperience(ActionEvent event) {}
    @FXML
    void validateFirstName(ActionEvent event) {}
    @FXML
    void validateGender(ActionEvent event) {}
    @FXML
    void validateLastName(ActionEvent event) {}
    @FXML
    void validateMobileNumber(ActionEvent event) {}
    @FXML
    void validateOccupation(ActionEvent event) {}
    @FXML
    void validateOrganization(ActionEvent event) {}
    @FXML
    void validateRole(ActionEvent event) {}
    @FXML
    void validateSuggestions(ActionEvent event) {}
    @FXML
    void validateYearOfGraduation(ActionEvent event) {}
    
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
    	
    	yearOfGraduation.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                	yearOfGraduation.setText(oldValue);
                }
            }
        });
    	
    	// Setting the Degree Choice Box :
    	degree.getItems().addAll(choices);
    	// Adding the logo :
    	super.initialize(location, resources);
		logo.setImage(logoImage);
	}
    
    @FXML
    void validateSubmitFrame(ActionEvent event) throws SQLException {
    	
    	// Active Status Choice Box : 
    	if (activeStatus.isSelected()) 
    		activeStatus.setSelected(true);
        else
        	activeStatus.setSelected(false); 
    	/*************************************************************************************************/
    	
    	Integer enquiryId = enquiryDetails.getEnquiryId();
		String firstName1 = firstName.getText();
		String lastName1 = lastName.getText();
		String emailId1 = emailId.getText();
		String mobileNo1 = mobileNumber.getText();
		String college1 =  college.getText();
		String degree1 = degree.getValue();
		String branch1 = branch.getText();
		String occupation1 = occupation.getText(); 
		String organisation1 = organization.getText(); 
		String designation1 = designation.getText();
		String domain1 = domain.getText();
		String role1 = role.getText();
		Integer experience1 = Integer.parseInt(experience.getText());
		String gender1 = gender.getText();
		Integer yearOfGraduation1 = Integer.parseInt(yearOfGraduation.getText());
		String coursesInterestedIn1 = courseInterestedIn.getText();
		String coursesAlreadyDone1 = coursesAlreadyDone.getText();
		String suggestion = suggestions.getText();
		Boolean activeStatus1 = activeStatus.isSelected();
		
		if(		
			firstName1 != null &&
			lastName1 != null &&
			emailId1 != null &&
		    mobileNo1 != null &&
			college1 != null &&
			degree1 != null &&
			branch1 != null &&
			gender1 != null &&
			yearOfGraduation1 != null &&
			activeStatus1 != null		
						) {	
		
	    	// Setting the values in the bean : 
			EnquiryDetails enquiryDetailsObject = new EnquiryDetails(enquiryId, firstName1,lastName1,emailId1,
					mobileNo1,college1,degree1,branch1,occupation1,organisation1,designation1,domain1,
					role1,experience1,gender1,yearOfGraduation1,coursesInterestedIn1,coursesAlreadyDone1,suggestion,activeStatus1);
	    	new EnquiryDetailsHelper().update(enquiryDetailsObject);
	    	// Navigation Next Screen : 
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
			try {
				myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml").openStream());
				Stage stage = (Stage) submitFrame.getScene().getWindow();
		    	Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show();  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// Navigation for the next Screen : 
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
			try {
				myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/ErrorMessage.fxml").openStream());
				Stage stage = (Stage) submitFrame.getScene().getWindow();
		    	Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("My New Scene");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
    }
    
    @FXML
    void resetClick(ActionEvent event) {
    	
    	 firstName.clear();
      	 lastName.clear();
      	 emailId.clear();
      	 gender.clear();
      	 mobileNumber.clear();
      	 dob.setValue(null);
      	 college.clear();
      	 degree.setValue(null);
      	 branch.clear();
      	 yearOfGraduation.clear();
      	 courseInterestedIn.clear();
      	 occupation.clear();
      	 organization.clear();
      	 designation.clear();
      	 domain.clear();
      	 activeStatus.setVisible(true);;
      	 suggestions.clear();
      	 role.clear();
      	 experience.clear();
      	 coursesAlreadyDone.clear();
      	 activeStatus.setSelected(false);
      	
    }
    
    @FXML
    void cancelClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml").openStream());
			Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public void setStudentDetail(EnquiryDetails enquiryDetail) {
		this.enquiryDetails = enquiryDetail;
		displayEnquiryDetails();
	}

	// Converting the Date :
	public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
	
	// To set all the Text field on the Screen :
	private void displayEnquiryDetails() {

		String date = enquiryDetails.getBirthDate().toString();	
		
		try {
	        dob.setValue(LOCAL_DATE(date));
	    } catch (NullPointerException e) {
	    	e.printStackTrace();
	    }
			
		firstName.setText(enquiryDetails.getFirstName());
		lastName.setText(enquiryDetails.getLastName());
		mobileNumber.setText(enquiryDetails.getMobileNumber());
		emailId.setText(enquiryDetails.getEmail());
		gender.setText(enquiryDetails.getGender());
		college.setText(enquiryDetails.getCollege());
		degree.setValue(enquiryDetails.getDegree());
		branch.setText(enquiryDetails.getBranch());
		occupation.setText(enquiryDetails.getOccupation());
		organization.setText(enquiryDetails.getOrganisation());
		designation.setText(enquiryDetails.getDesignation());
		domain.setText(enquiryDetails.getDomain());
		yearOfGraduation.setText(enquiryDetails.getYearOfGraduation().toString());
		role.setText(enquiryDetails.getRole());
		experience.setText(enquiryDetails.getExperience().toString());
		courseInterestedIn.setText(enquiryDetails.getCoursesInterestedIn());	
		coursesAlreadyDone.setText(enquiryDetails.getCourseAlreadyDone());
		suggestions.setText(enquiryDetails.getSuggestion());
		activeStatus.setSelected(enquiryDetails.getActiveStatus());		
	}
}




