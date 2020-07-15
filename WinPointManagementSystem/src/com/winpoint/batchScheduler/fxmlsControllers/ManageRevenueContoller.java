package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.OrganizationTypeHelper;
import com.winpoint.common.helpers.RevenueTypeHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;

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
    	Date recieptDate1 = cFirstPaymentDate.getTime();
    	/***************************************************/
        	
    	// Declaration of required Variable :
    	Integer segmentType1 = segmentTypeId;
    	String recieptNumber1 = recieptNumber.getText() ;
    	Date recieptDate = recieptDate1;
    	String payerDescription1 = payerDescription.getText();
    	String batchNumber1 = batchNumber.getText();
    	Integer revenueType1 = revenueTypeId;
    	Integer organization1 ;
    	Integer paymentMode1;
    	String checkNumber1;
    	float revenueAmount1;
    	Date firstPaymentDate = firstPaymentDate1;
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
    	
    	
    	//Abhishek
    	//organization.getItems().addAll(organizationChoiceBox);
    	//paymentMode.getItems().addAll(paymentModeChoiceBox);
    	//revenueType.getItems().addAll(revenueTypeChoiceBox);
    	//segmentType.getItems().addAll(segmentTypeChoiceBox);
    	
    	
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
