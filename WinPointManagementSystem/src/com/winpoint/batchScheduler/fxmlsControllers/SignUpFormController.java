package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class SignUpFormController extends ParentFXMLController {
    
	private Integer timeSlotsId1;
	
	private Integer segmentTypeId;
	
	@FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField emailId;

    @FXML
    private TextField address;

    @FXML
    private TextField gender;

    @FXML
    private TextField mobileNumber;

    @FXML
    private TextField college;
    
    @FXML
    private TextField branch;

    @FXML
    private DatePicker dobBox;

    @FXML
    private TextField yearOfGraduation;

    @FXML
    private TextField courseInterestedIn;

    @FXML
    private TextField courseAlreadyDone;

    @FXML
    private TextField referance;

    @FXML
    private TextField occupation;

    @FXML
    private TextField organization;

    @FXML
    private TextField designation;

    @FXML
    private TextField domain;

    @FXML
    private TextField suggestion;

    @FXML
    private TextField role;

    @FXML
    private TextField experience;

    @FXML
    private TextField createdBy;

    @FXML
    private DatePicker dateOfEnquiry;

    @FXML
    private DatePicker startDate;

    @FXML
    private TextField recommendation;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;
    
    @FXML
    private CheckBox eligible = new CheckBox();

    @FXML
    private CheckBox active = new CheckBox();

    @FXML
    private ImageView logo;

    @FXML
    void validateActiveStatus(ActionEvent event) {

    }

    @FXML
    void validateAddress(ActionEvent event) {

    }

    @FXML
    void validateAvailableTime(MouseEvent event) {

    }

    @FXML
    void validateBranch(ActionEvent event) {

    }

    @FXML
    void validateCollege(ActionEvent event) {

    }

    @FXML
    void validateCourseInterestedIn(ActionEvent event) {

    }

    @FXML
    void validateCreatedBy(ActionEvent event) {

    }

    @FXML
    void validateDegreeChoice(MouseEvent event) {

    }

    @FXML
    void validateDesignation(ActionEvent event) {

    }

    @FXML
    void validateDob(ActionEvent event) {

    }

    @FXML
    void validateEligibility(ActionEvent event) {

    }

    @FXML
    void validateEmailId(ActionEvent event) {

    }

    @FXML
    void validateExperience(ActionEvent event) {

    }

    @FXML
    void validateFirstName(ActionEvent event) {

    }

    @FXML
    void validateGender(ActionEvent event) {

    }

    @FXML
    void validateLastframe(ActionEvent event) {

    }

    @FXML
    void validateMobileNumber(ActionEvent event) {

    }

    @FXML
    void validateOrganization(ActionEvent event) {

    }

    @FXML
    void validateRecommendation(ActionEvent event) {

    }

    @FXML
    void validateReferance(ActionEvent event) {

    }

    @FXML
    void validateRole(ActionEvent event) {

    }

    @FXML
    void validateSegmentType(MouseEvent event) {

    }

    @FXML
    void validateStartDate(ActionEvent event) {

    }

    @FXML
    void validateSuggestion(ActionEvent event) {

    }

    @FXML
    void validateYearOfGraduation(ActionEvent event) {

    }

    @FXML
    void validatecourseAlreadyDone(ActionEvent event) {

    }

    @FXML
    void validationDomain(ActionEvent event) {

    }

    @FXML
    void validatrOccupation(ActionEvent event) {

    }
    
    @FXML
    void validateEligible(ActionEvent event) {

    }

    @FXML
    void validateActive(ActionEvent event) {

    }
    
    
    @FXML
    private ChoiceBox<String> availableTime = new ChoiceBox<>();
    
    @FXML
    private ChoiceBox<String> degreeChoice = new ChoiceBox<>(); 
    String[] choices= {"F.Y","S.E","T.E", "F.E"};


    @FXML
    private ChoiceBox<String> segmentType = new ChoiceBox<>();
    //String[] choiceSegmentType = {"Student","College","Working Professionals"};

    
    @FXML
    void cancelClick(ActionEvent event) throws IOException {
    	System.out.println(event);
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    }
  
    @FXML
    void submitClick(ActionEvent event) throws ParseException,IOException, SQLException{


        if (eligible.isSelected()) 
        	eligible.setSelected(true);
        else
            eligible.setSelected(false); 

        if (active.isSelected()) 
            active.setSelected(true);
        else
            active.setSelected(false); 

    	
    	
    	LocalDate ldDobBox = dobBox.getValue();
    	Calendar cDobBox =  Calendar.getInstance();
    	cDobBox.set(ldDobBox.getYear(), ldDobBox.getMonthValue(), ldDobBox.getDayOfMonth());
    	Date dateDobBox = cDobBox.getTime();
    	
    	LocalDate ldDateOfEnquiry = dobBox.getValue();
    	Calendar cDateOfEnquiry =  Calendar.getInstance();
    	cDateOfEnquiry.set(ldDateOfEnquiry.getYear(), ldDateOfEnquiry.getMonthValue(), ldDateOfEnquiry.getDayOfMonth());
    	Date dateDateOfEnquiry = cDateOfEnquiry.getTime();
    	
    	LocalDate ldStartDate = dobBox.getValue();
    	Calendar cStartDate =  Calendar.getInstance();
    	cStartDate.set(ldStartDate.getYear(), ldStartDate.getMonthValue(), ldStartDate.getDayOfMonth());
    	Date dateStartDate = cDateOfEnquiry.getTime();
    	
   		String firstName1 = firstName.getText();
		String lastName1 = lastName.getText();
		String emailId1 = emailId.getText();
		String mobileNo1 = mobileNumber.getText();
		String address1 = address.getText();
		Date birthDate1 = dateDobBox;
		String college1 =  college.getText();
		String degree1 = degreeChoice.getValue();
		String branch1 = branch.getText();
		String occupation1 = occupation.getText(); 
		String organisation1 = organization.getText(); 
		String designation1 = designation.getText();
		String domain1 = domain.getText();
		String role1 = role.getText();
		Integer experience1 = Integer.parseInt(experience.getText());
		Integer createdBy1 = Integer.parseInt(createdBy.getText()); 
		Date dateOfEnquiry1 = dateDateOfEnquiry;
		String gender1 = gender.getText();
		Integer yearOfGraduation1 = Integer.parseInt(yearOfGraduation.getText());
		String recommendation1 = recommendation.getText(); 
		Boolean eligibility1 = eligible.isSelected();
		String coursesInterestedIn1 = courseInterestedIn.getText();
		String reference1 = referance.getText();
		System.out.println("TimeSlotId : "+ timeSlotsId1);
		Integer time = timeSlotsId1;
		String courseAlreadyDone1 = courseAlreadyDone.getText();
		Date startDate1 = dateStartDate;
		Integer segmentTypeId1 = segmentTypeId; 
		String suggestion1 = suggestion.getText(); 
		Boolean activeStatus1 = active.isSelected();
				
		

		
    	EnquiryDetails enquiryDetails1 = new EnquiryDetails(firstName1,lastName1,emailId1,mobileNo1,address1,birthDate1,college1,degree1,branch1,occupation1,organisation1,designation1,domain1,role1,experience1,createdBy1,dateOfEnquiry1,gender1,yearOfGraduation1,recommendation1,eligibility1,coursesInterestedIn1,reference1,time,courseAlreadyDone1,startDate1,segmentTypeId1,suggestion1,activeStatus1);
    
    	new EnquiryDetailsHelper().create(enquiryDetails1);
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml").openStream());
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
    	
    	List<TimeSlots> timeSlotsList = new TimeSlotsHelper().getTimeSlotsList();    	    	
    	
    	for(TimeSlots timeSlot : timeSlotsList) {
    		availableTime.getItems().add(timeSlot.getTimeSlotsId()-1, timeSlot.getTimeSlotsDescription());;
    	}
    	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 

            	int index = availableTime.getItems().indexOf(availableTime.getValue());
            	timeSlotsId1 = timeSlotsList.get(index).getTimeSlotsId();
            	String description = timeSlotsList.get(index).getTimeSlotsDescription();
            	
            	System.out.println("Index : "+index);
            	System.out.println("TimeSlotId : "+ timeSlotsId1);
            	System.out.println("Description : "+ description);
            
            }
        }; 	
    	availableTime.setOnAction(event);
    	
    	List<SegmentType> segmentTypeList = new SegmentTypeHelper().getSegmentTypeList();    	    	
    	
    	for(SegmentType segmentTypeObject : segmentTypeList) {
    		segmentType.getItems().add(segmentTypeObject.getSegmentTypeId()-1,segmentTypeObject.getSegmentTypeName());
    	}
    	EventHandler<ActionEvent> eventSegmentType = new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				int index = segmentType.getItems().indexOf(segmentType.getValue());
				segmentTypeId = segmentTypeList.get(index).getSegmentTypeId();
				String description = segmentTypeList.get(index).getSegmentTypeName();
				
				System.out.println("Index : "+index);
            	System.out.println("TimeSlotId : "+ segmentTypeId);
            	System.out.println("Description : "+ description);
			}
		};
    	segmentType.setOnAction(eventSegmentType);
		
    	degreeChoice.getItems().addAll(choices);
    	
       	super.initialize(location, resources);
    	logo.setImage(logoImage);
    	  	
    }
      
}