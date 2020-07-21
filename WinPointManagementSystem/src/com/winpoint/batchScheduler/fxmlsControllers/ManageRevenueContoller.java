package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.ManageRevenueHelper;
import com.winpoint.common.helpers.OrganizationTypeHelper;
import com.winpoint.common.helpers.PaymentTypeHelper;
import com.winpoint.common.helpers.RevenueTypeHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.helpers.StudentCourseInstallmentHelper;

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

	private Integer segmentTypeId;
	private Integer revenueTypeId;
	private Integer organizationTypeId;
	private Integer paymentTypeId;
	
	
	
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
        	
    	// Declaration of required Variable :
    	Integer revenueDetailId = 6 ; // = object.getRevenueDetailId();
    	Integer revenueType1 = revenueTypeId;
    	String recieptNumber1 = recieptNumber.getText();
    	String payerDescription1 = payerDescription.getText();
    	Integer courseId = 1; // = objectOfBatchDetail.getCourseId();
    	Integer batchId = 1; // = objectOfBatchDetail.getBatchId();
    	float revenueAmount1= Float.parseFloat(revenueAmount.getText());
    	Integer paymentMode1 = paymentTypeId;
    	String checkNumber1= checkNumber.getText();
    	Integer segmentType1 = segmentTypeId;
    	Integer organization1 = organizationTypeId;
    	Integer userId = 1; // = objectOfUserProfile.getUserId();
    	Date recieveDate = recieveDate1;
    	Date firstPaymentDate = firstPaymentDate1;
    	
    	ManageRevenue manageRevenueObject = new ManageRevenue(revenueDetailId,revenueType1,recieptNumber1,payerDescription1,
    			courseId,batchId,revenueAmount1,paymentMode1,checkNumber1,segmentType1,organization1,userId,recieveDate);
    	
    	new ManageRevenueHelper().getRevenueDetailList(manageRevenueObject);
    	
       //********************************************//  It goes in studentcoursesinstallmentdetails
    	
    	
    	StudentCourseInstallmentDetails studentCourseInstallmentObject = new StudentCourseInstallmentDetails(firstPaymentDate);
    	
    	new StudentCourseInstallmentHelper().getPaymentDetail(studentCourseInstallmentObject);
    	
    	/***************************************************/   	
    	
    	// Navigation to the next Screen : 
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml").openStream());
    	Stage stage = (Stage) submit.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("My New Scene");
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
				String description = segmentTypeList.get(index).getSegmentTypeName();				
				System.out.println("Index : "+index);
            	System.out.println("SegementTypeId : "+ segmentTypeId);
            	System.out.println("Description : "+ description);
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
				String description = revenueTypeList.get(index).getRevenueTypeName();				
				System.out.println("Index : "+index);
            	System.out.println("RevenueTypeId : "+ segmentTypeId);
            	System.out.println("Description : "+ description);
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
				String description = organizationTypeList.get(index).getOrganizationTypeName();				
				System.out.println("Index : "+index);
            	System.out.println("RevenueTypeId : "+ organizationTypeId);
            	System.out.println("Description : "+ description);
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
				String description = paymentTypeList.get(index).getPaymentTypeName();				
				System.out.println("Index : "+index);
            	System.out.println("RevenueTypeId : "+ paymentTypeId);
	           	System.out.println("Description : "+ description);
	        }
		};
		paymentMode.setOnAction(eventPaymentType);
		/***************************************************/
		
		// adding the logo : 
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
