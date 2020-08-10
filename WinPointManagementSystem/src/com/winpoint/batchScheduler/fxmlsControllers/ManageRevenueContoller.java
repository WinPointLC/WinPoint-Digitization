package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.DaoHelper;
import com.winpoint.common.helpers.OrganizationTypeHelper;
import com.winpoint.common.helpers.PaymentTypeHelper;
import com.winpoint.common.helpers.RevenueTypeHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageRevenueContoller extends ParentFXMLController{

	
	UserCoursesDoneWrapper user;  // name to be changed
	ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
	ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
	int selectedCourseId;
	int selectedSegmentTypeId;
	int preferedTime;
	int facultyId;
	boolean isEnquired;
	int selectedbatchId;
	
	private Integer segmentTypeId;
	private Integer revenueTypeId;
	private Integer organizationTypeId;
	private Integer paymentTypeId;
	private Integer userProfileId;
	
	private String generatedBatchName1;
	//private Integer selectedCourseId1;
	
	@FXML
    private TextField recieptNumber;

    @FXML
    private TextField payerDescription;

    @FXML
    private TextField batchNumber;
    
    @FXML
    private ChoiceBox<String> segmentType = new ChoiceBox<>();
    
    @FXML
    private ChoiceBox<String> revenueType = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> organization = new ChoiceBox<>();
  
    @FXML
    private ChoiceBox<String> paymentMode = new ChoiceBox<>();
    
    @FXML
    private TextField checkNumber;

    @FXML
    private TextField revenueAmount;

    @FXML
    private DatePicker recieptDate;
    
    @FXML
    private DatePicker firstAmountDate;

    @FXML
    private ImageView logo;

    @FXML
    private Button submit;
	private int userProfile;

    @FXML
    void validateBatchNumber(ActionEvent event) {

    }

    @FXML
    void validateCheckNumber(ActionEvent event) {

    }

    @FXML
    void validateFirstAmountDate(ActionEvent event) {

    }

    @FXML
    void validatePayerDescription(ActionEvent event) {

    }

    @FXML
    void validateRecieptNumber(ActionEvent event) {

    }

    @FXML
    void validateRevenueAmount(ActionEvent event) {

    }

    @FXML
    void validateRevenueType(MouseEvent event) {

    }

    @FXML
    void validateReciepteDate(ActionEvent event) {

    }
    
    //Abhishek 
    @FXML
    void submitFrame(ActionEvent event) throws IOException {
    	
    	
    	// Converting in the date Format : 
    	LocalDate ldFirstPaymentDate = firstAmountDate.getValue();
    	Calendar cFirstPaymentDate =  Calendar.getInstance();
    	cFirstPaymentDate.set(ldFirstPaymentDate.getYear(), ldFirstPaymentDate.getMonthValue(), ldFirstPaymentDate.getDayOfMonth());
    	Date firstPaymentDate1 = cFirstPaymentDate.getTime();
    	
    	LocalDate ldRecieptDate = recieptDate.getValue();
    	Calendar cRecieptDate =  Calendar.getInstance();
    	cRecieptDate.set(ldRecieptDate.getYear(), ldRecieptDate.getMonthValue(), ldRecieptDate.getDayOfMonth());
    	Date recieveDate1 = cFirstPaymentDate.getTime();
    	/***************************************************/
        	
    	HashMap<String, Integer> segmentTypeMap = new HashMap<String, Integer>();
    	for(SegmentType segmentType :  new SegmentTypeHelper().getSegmentTypeList()) {
    		segmentTypeMap.put(segmentType.getSegmentTypeName(), segmentType.getSegmentTypeId());
       	}  	
    	
    	// Declaration of required Variable :
    	Integer revenueDetailId = 6; // = object.getRevenueDetailId();
    	Integer revenueType1 = revenueTypeId;
    	String recieptNumber1 = recieptNumber.getText();
    	String payerDescription1 = payerDescription.getText();
    	Integer courseId = selectedCourseId; // = objectOfBatchDetail.getCourseId();
    	Integer batchId = selectedbatchId; // = objectOfBatchDetail.getBatchId();
    	float revenueAmount1= Float.parseFloat(revenueAmount.getText());
    	Integer paymentMode1 = paymentTypeId;
    	String checkNumber1= checkNumber.getText();
    	Integer segmentType1 = segmentTypeId;
    	Integer organization1 = organizationTypeId;
    	Integer userId = userProfileId;//userProfileId; 
    	Date recieveDate = recieveDate1;
    	Date firstPaymentDate = firstPaymentDate1;
    	
    	
    	
    	
    	if(isEnquired) {
			/* 
			 * 
			 * 
			 * ENQUIRY_ID through all data to be accessed. 
			 * Enquiry object
			 * Data accessed successfully
			 * 
			 * call a dao ( new dao )
			 * 
			 * method - transaction begin ( function )
			 * 
			 *  1). insert into userprofile
			 *  2). insert into studentcourseDetail
			 *  3). delete from enquirydetail
			 * 
			 * transaction end ( function )
			 *
			 * 
			 * */
			//EnquiryDetailsHelper enquiryDetailsHelper = new EnquiryDetailsHelper();
			
			DaoHelper daoHelper = new DaoHelper();
			//daoHelper.function(this.userId,enquiryDetailsHelper.getEnquiryDetailsOfStudent(this.userId),courseId,batchId);
			try {
			
		    	int latestUserId = new DaoHelper().accessLatestUserId();
		    	
		    	ManageRevenue manageRevenueObject = new ManageRevenue(revenueDetailId,revenueType1,recieptNumber1,payerDescription1,
		    			courseId,batchId,revenueAmount1,paymentMode1,checkNumber1,segmentType1,organization1,latestUserId,recieveDate);
		    	
		    	StudentCourseInstallmentDetails studentCourseInstallmentObject = new StudentCourseInstallmentDetails(latestUserId,courseId,firstPaymentDate);    	
		        
		    	/***************************************************/   
		    	
				daoHelper.functionEnquiredStudent(this.user,courseId,batchId,manageRevenueObject,studentCourseInstallmentObject);
				
				
		    	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * 
			 * remove the data from the list and pass it back again
			 * 
			 * */
			
			listOfEnquiredStudents1.remove(this.user);

		}else {
	    	
	    	ManageRevenue manageRevenueObject = new ManageRevenue(revenueDetailId,revenueType1,recieptNumber1,payerDescription1,
	    			courseId,batchId,revenueAmount1,paymentMode1,checkNumber1,segmentType1,organization1,userProfileId,recieveDate);
	    	
	    	StudentCourseInstallmentDetails studentCourseInstallmentObject = new StudentCourseInstallmentDetails(userProfileId,courseId,firstPaymentDate);    	
			
//	    	daoHelper.function(this.user,courseId,batchId,manageRevenueObject,studentCourseInstallmentObject);
	    	
			listOfRegisteredStudents1.remove(this.user);
		}
    	
    	Parent myNewScene = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml"));
		try {
			myNewScene = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		CoursesNameController coursesNameController = loader.getController();
		coursesNameController.setListOfStudents(
				listOfRegisteredStudents1, 
				listOfEnquiredStudents1,
				selectedCourseId,
				selectedSegmentTypeId,
				preferedTime,
				facultyId,
				generatedBatchName1,
				selectedbatchId, null, null, null
		);
		
    	Stage stage = (Stage) submit.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("Main Scene");
    	stage.show();
    	/***************************************************/
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	// SegmentType choice Box : 
    	List<SegmentType> segmentTypeList = new SegmentTypeHelper().getSegmentTypeList();    	    	
    	for(SegmentType segmentTypeObject : segmentTypeList) {
    		segmentType.getItems().add(segmentTypeObject.getSegmentTypeName());
    	}
    	EventHandler<ActionEvent> eventSegmentType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = segmentType.getItems().indexOf(segmentType.getValue());
				segmentTypeId = segmentTypeList.get(index).getSegmentTypeId();
			}
		};
    	segmentType.setOnAction(eventSegmentType);
    	/***************************************************/
    	
    	// RevenueType choice Box : 
    	List<RevenueType> revenueTypeList = new RevenueTypeHelper().getRevenueTypeList();    	    	    	
    	for(RevenueType revenueTypeObject : revenueTypeList) {
    		revenueType.getItems().add(revenueTypeObject.getRevenueTypeName());
    	}    	
    	EventHandler<ActionEvent> eventRevenueType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = revenueType.getItems().indexOf(revenueType.getValue());
				revenueTypeId = revenueTypeList.get(index).getRevenueTypeId();
			}
		};
		revenueType.setOnAction(eventRevenueType);
    	/***************************************************/
    	
    	// Organization Type choice Box : 
		List<OrganizationType> organizationTypeList = new  OrganizationTypeHelper().getOrganizationTypeList();
		for(OrganizationType organizationTypeObject : organizationTypeList) {
			organization.getItems().add(organizationTypeObject.getOrganizationTypeName());
		}
		EventHandler<ActionEvent> eventOrganizationType = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int index = organization.getItems().indexOf(organization.getValue());
				organizationTypeId = organizationTypeList.get(index).getOrganizationTypeId();
			}
		};
		organization.setOnAction(eventOrganizationType);
		/***************************************************/
    	
		// Payment Type choice Box : 
		List<PaymentType> paymentTypeList = new  PaymentTypeHelper().getPaymentTypeDaoList();
		for(PaymentType paymentTypeObject : paymentTypeList) {
			paymentMode.getItems().add(paymentTypeObject.getPaymentTypeName());
		}
		EventHandler<ActionEvent> eventPaymentType = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int index = paymentMode.getItems().indexOf(paymentMode.getValue());
				paymentTypeId = paymentTypeList.get(index).getPaymentTypeId();
	        }
		};
		paymentMode.setOnAction(eventPaymentType);
		/***************************************************/
		
		// adding the logo : 
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

	public void setStudentData(
			UserCoursesDoneWrapper enquiredStudent, 
			ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1,
			ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1, 
			int selectedCourseId1, 
			int selectedSegmentTypeId,
			int preferedTime, 
			int facultyId,
			boolean isEnquired, 
			String generatedBatchName, 
			Integer selectedbatchId2
			) {
				
		this.userProfile = userProfile;
		this.generatedBatchName1 = generatedBatchName;
		this.selectedbatchId = selectedbatchId2;
		this.isEnquired = isEnquired;
		this.user = enquiredStudent;
		this.listOfRegisteredStudents1.addAll(listOfRegisteredStudents1);
		this.listOfEnquiredStudents1.addAll(listOfEnquiredStudents1);
		this.selectedCourseId = selectedCourseId1;
		this.selectedSegmentTypeId = selectedSegmentTypeId;
		this.preferedTime = preferedTime;
		this.facultyId = facultyId;
		
		batchNumber.setText(generatedBatchName1);
	}

}










