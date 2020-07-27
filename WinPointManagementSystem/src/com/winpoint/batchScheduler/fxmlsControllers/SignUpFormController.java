package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.SignUpFormCourseListWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SignUpFormController extends ParentFXMLController {

	SignUpFormController signUpFormController;// = new SignUpFormController();
	
	private Integer timeSlotsId1;
	private Integer createdByUserId;
	private Integer segmentTypeId;
	
	ObservableList<String> coursesList = FXCollections.observableArrayList();
	HashSet<Integer> courseInterestedInSetOfIds = new HashSet<Integer>();
	HashSet<Integer> courseAlreadyDoneSetOfIds = new HashSet<Integer>();
	
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
    private DatePicker dateOfEnquiry;
    @FXML
    private DatePicker startDate;
    @FXML
    private TextField recommendation;   
    @FXML
    private TextField yearOfGraduation;
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;    
    @FXML
    private ImageView logo;
    @FXML
    private ChoiceBox<String> createdBy = new ChoiceBox<>();
    @FXML
    private CheckBox eligible = new CheckBox();
    @FXML
    private CheckBox active = new CheckBox();
    @FXML
    private HBox coursesInterestedInHbox; 
    @FXML
    private HBox courseAlreadyDoneHbox;    
    @FXML
    private ChoiceBox<String> availableTime = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> segmentType = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> degreeChoice = new ChoiceBox<>(); 
    String[] choices= {"F.Y","S.E","T.E", "F.E"};
    
    
    
    @FXML
    void validateActiveStatus(ActionEvent event) {}
    @FXML
    void validateAddress(ActionEvent event) {}
    @FXML
    void validateAvailableTime(MouseEvent event) {}
    @FXML
    void validateBranch(ActionEvent event) {}
    @FXML
    void validateCollege(ActionEvent event) {}
    @FXML
    void validateCourseInterestedIn(ActionEvent event) {}
    @FXML
    void validateCreatedBy(ActionEvent event) {}
    @FXML
    void validateDegreeChoice(MouseEvent event) {}
    @FXML
    void validateDesignation(ActionEvent event) {}
    @FXML
    void validateDob(ActionEvent event) {}
    @FXML
    void validateEligibility(ActionEvent event) {}
    @FXML
    void validateEmailId(ActionEvent event) {}
    @FXML
    void validateExperience(ActionEvent event) {}
    @FXML
    void validateFirstName(ActionEvent event) {}
    @FXML
    void validateGender(ActionEvent event) {}
    @FXML
    void validateLastframe(ActionEvent event) {}
    @FXML
    void validateMobileNumber(ActionEvent event) {}
    @FXML
    void validateOrganization(ActionEvent event) {}
    @FXML
    void validateRecommendation(ActionEvent event) {}
    @FXML
    void validateReferance(ActionEvent event) {}
    @FXML
    void validateRole(ActionEvent event) {}
    @FXML
    void validateSegmentType(MouseEvent event) {}
    @FXML
    void validateStartDate(ActionEvent event) {}
    @FXML
    void validateSuggestion(ActionEvent event) {}
    @FXML
    void validateYearOfGraduation(ActionEvent event) {}
    @FXML
    void validatecourseAlreadyDone(ActionEvent event) {}
    @FXML
    void validationDomain(ActionEvent event) {}
    @FXML
    void validatrOccupation(ActionEvent event) {}
    @FXML
    void validateEligible(ActionEvent event) {}
    @FXML
    void validateActive(ActionEvent event) {}
    @FXML
    void cancelClick(ActionEvent event) throws IOException {
    	
        
    	//list for  course Interested IN
    	System.out.println("SetOfIds : "+courseInterestedInSetOfIds);
    			String courseInterestedInfinalString = "";
    			for(Integer string : courseInterestedInSetOfIds) {
    				if(string!=null)
    				courseInterestedInfinalString += string.toString()+",";
    				System.out.println("String : "+string);
    			}
    			courseInterestedInfinalString = courseInterestedInfinalString.substring(0,courseInterestedInfinalString.length()-1);
    			
		System.out.println("Course LIst : "+courseInterestedInfinalString);

    	
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

    	// Choice Boxes if else Conditions : 
    	// Eligible
        if (eligible.isSelected()) 
        	eligible.setSelected(true);
        else
            eligible.setSelected(false); 
        // Active Status
        if (active.isSelected()) 
            active.setSelected(true);
        else
            active.setSelected(false);
    	/*******************************************************/ 

    	
    	// Conversion of the Date Functions : 
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
    	/*******************************************************/
    	
    	// Declaration of the required Variables : 
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
		Integer createdBy1 = createdByUserId; 
		Date dateOfEnquiry1 = dateDateOfEnquiry;
		String gender1 = gender.getText();
		Integer yearOfGraduation1 = Integer.parseInt(yearOfGraduation.getText());
		String recommendation1 = recommendation.getText(); 
		Boolean eligibility1 = eligible.isSelected();
		
//		//list for  course Interested IN
//		String courseInterestedInfinalString = "";
//		for(Integer string : courseInterestedInSetOfIds) {
//			courseInterestedInfinalString += string.toString()+",";
//			System.out.println("String : "+string);
//		}
//		courseInterestedInfinalString = courseInterestedInfinalString.substring(0,courseInterestedInfinalString.length()-1);
		
		String coursesInterestedIn1 = "";
		String reference1 = referance.getText();
		System.out.println("TimeSlotId : "+ timeSlotsId1);
		Integer time = timeSlotsId1;
		
		// list for course Already Done
		String coursesAlreadyDonefinalString = "";
		for(Integer string : courseAlreadyDoneSetOfIds) {
			coursesAlreadyDonefinalString += string.toString()+",";
			System.out.println("String : "+string);
		}
		coursesAlreadyDonefinalString = coursesAlreadyDonefinalString.substring(0,coursesAlreadyDonefinalString.length()-1);
		String courseAlreadyDone1= coursesAlreadyDonefinalString;
		
		Date startDate1 = dateStartDate;
		Integer segmentTypeId1 = segmentTypeId; 
		String suggestion1 = suggestion.getText(); 
		Boolean activeStatus1 = active.isSelected();
		

		
    	/*******************************************************/
				
		// Object Passing to the bean class : 
    	EnquiryDetails enquiryDetails1 = new EnquiryDetails(firstName1,lastName1,emailId1,mobileNo1,
    			address1,birthDate1,college1,degree1,branch1,occupation1,organisation1,designation1,
    			domain1,role1,experience1,createdBy1,dateOfEnquiry1,gender1,yearOfGraduation1,
    			recommendation1,eligibility1,coursesInterestedIn1,reference1,time,courseAlreadyDone1,
    			startDate1,segmentTypeId1,suggestion1,activeStatus1);
    	// Helper Method Call : 
    	new EnquiryDetailsHelper().create(enquiryDetails1);
    	
    	// Navigation for the next Screen : 
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

    	//Faculty Ids Choice Box :
    	List<UserProfile> facultyList = new UserProfileHelper().getFaculty();    	 
    	for(UserProfile faculty : facultyList) {
    		createdBy.getItems().add(faculty.getFirstName()+" "+faculty.getLastName());
    	}
    	EventHandler<ActionEvent> eventCreatedBy = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
            	int index = createdBy.getItems().indexOf(createdBy.getValue());
            	createdByUserId = facultyList.get(index).getUserId();
            	String description = facultyList.get(index).getFirstName();
            	System.out.println("Index : "+index);
            	System.out.println("CategoryUserId : "+ createdByUserId);
            	System.out.println("Description : "+ description);        
            }
        }; 	
        createdBy.setOnAction(eventCreatedBy);
    	/*******************************************************/
    	    	
    	// TimeSlots Choice Box : 
    	List<TimeSlots> timeSlotsList = new TimeSlotsHelper().getTimeSlotsList();    	    	
    	for(TimeSlots timeSlot : timeSlotsList) {
    		availableTime.getItems().add(timeSlot.getTimeSlotsId()-1, timeSlot.getTimeSlotsDescription());;
    	}
    	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
            	int index = availableTime.getItems().indexOf(availableTime.getValue());
            	timeSlotsId1 = timeSlotsList.get(index).getTimeSlotsId();
//           	String description = timeSlotsList.get(index).getTimeSlotsDescription();
//            	System.out.println("Index : "+index);
//            	System.out.println("TimeSlotId : "+ timeSlotsId1);
//            	System.out.println("Description : "+ description);        
            }
        }; 	
    	availableTime.setOnAction(event);
    	/*******************************************************/
    	
    	// SegmentType Choice Box : 
    	List<SegmentType> segmentTypeList = new SegmentTypeHelper().getSegmentTypeList();    	    	    	
    	for(SegmentType segmentTypeObject : segmentTypeList) {
    		segmentType.getItems().add(segmentTypeObject.getSegmentTypeName());
    	}	
    	EventHandler<ActionEvent> eventSegmentType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = segmentType.getItems().indexOf(segmentType.getValue());
				segmentTypeId = segmentTypeList.get(index).getSegmentTypeId();
//				String description = segmentTypeList.get(index).getSegmentTypeName();				
//				System.out.println("Index : "+index);
//            	System.out.println("TimeSlotId : "+ segmentTypeId);
//            	System.out.println("Description : "+ description);
			}
		};
    	segmentType.setOnAction(eventSegmentType);
    	/*******************************************************/    	
    	//Courses Interested In Combo Box :     	
      	List<SignUpFormCourseListWrapper> CoursesList = new CourseHelper().getCourseNamesList();   // getAllCoursesList	
      	HashMap<String, Integer> courseInterestedInSet = new HashMap<String, Integer>(); 
      	HashMap<String, Integer> courseAlreadyDoneSet = new HashMap<String, Integer>();
    	for(SignUpFormCourseListWrapper courses : CoursesList) {
    		coursesList.add(courses.getCourseTypeName()+"-"+courses.getCourseName());//courses.getCoursetyoeNmae + " - " +courses.getCourseName
    		courseInterestedInSet.put(courses.getCourseTypeName()+"-"+courses.getCourseName(), courses.getCourseId());
    		courseAlreadyDoneSet.put(courses.getCourseName(), courses.getCourseId());
    	}    	
    	CheckComboBox<String> coursesInterestedIn = new CheckComboBox<>(coursesList);
    	HashSet<String> tempCoursesInterestedInList = new HashSet<String>();    	
      	coursesInterestedIn.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
    	     public void onChanged(ListChangeListener.Change<? extends String> c) {
    	        // System.out.println(coursesInterestedIn.getCheckModel().getCheckedItems()); 
    	    	 tempCoursesInterestedInList.addAll(coursesInterestedIn.getCheckModel().getCheckedItems());
    	    	// System.out.println("temp : "+tempCoursesInterestedInList);
    	         for(String course : tempCoursesInterestedInList) {
    	     		//System.out.println(course);
    	     		courseInterestedInSetOfIds.add(courseInterestedInSet.get(course));
    	     		//System.out.println(courseInterestedInSetOfIds);
    	     	} 	         
    	     }
    	 });
    	coursesInterestedInHbox.getChildren().add(coursesInterestedIn); 	
    	/*******************************************************/        
        //Courses Already Done  :    
       	CheckComboBox<String> coursesAlreadyDone = new CheckComboBox<>(coursesList);
    	HashSet<String> tempCourseAlreadyDoneList = new HashSet<String>();
    	coursesAlreadyDone.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
    	     public void onChanged(ListChangeListener.Change<? extends String> c) {
    	         //System.out.println(coursesAlreadyDone.getCheckModel().getCheckedItems());
    	         tempCourseAlreadyDoneList.addAll(coursesAlreadyDone.getCheckModel().getCheckedItems());
    	         for(String course : tempCourseAlreadyDoneList) {
    	        	 System.out.println(course);
    	        	 courseAlreadyDoneSetOfIds.add(courseAlreadyDoneSet.get(course));
    	         }
    	     }
    	 });
      	courseAlreadyDoneHbox.getChildren().add(coursesAlreadyDone);
    	/*******************************************************/
   
        // Degree Choice Box : 
        degreeChoice.getItems().addAll(choices);
    	
        // Adding the logo : 
       	super.initialize(location, resources);
    	logo.setImage(logoImage);
    	  	
    }
          
}