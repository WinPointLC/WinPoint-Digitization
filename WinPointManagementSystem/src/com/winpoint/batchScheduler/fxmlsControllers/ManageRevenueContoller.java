package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageRevenueContoller extends ParentFXMLController{

    @FXML
    private ChoiceBox<String> segmentType = new ChoiceBox<>();
    String[] segmentTypeChoiceBox = {"Student","Freasher","Working Professionals"};

    @FXML
    private TextField recieptNumber;

    @FXML
    private TextField payerDescription;

    @FXML
    private TextField batchNumber;

    @FXML
    private ChoiceBox<String> revenueType = new ChoiceBox<>();
    String[] revenueTypeChoiceBox = {"Traning","Consultation","Project"};

    @FXML
    private ChoiceBox<String> organization = new ChoiceBox<>();
    String[] organizationChoiceBox = {"Corporate","Individaul","Student"};

    @FXML
    private ChoiceBox<String> paymentMode = new ChoiceBox<>();
    String[] paymentModeChoiceBox = {"Cash","Cheque","Net Banking"};

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
    	
    	LocalDate ldFirstPaymentDate = firstAmountDate.getValue();
    	Calendar cFirstPaymentDate =  Calendar.getInstance();
    	cFirstPaymentDate.set(ldFirstPaymentDate.getYear(), ldFirstPaymentDate.getMonthValue(), ldFirstPaymentDate.getDayOfMonth());
    	Date firstPaymentDate1 = cFirstPaymentDate.getTime();
    	
    	LocalDate ldRecieptDate = recieptDate.getValue();
    	Calendar cRecieptDate =  Calendar.getInstance();
    	cRecieptDate.set(ldRecieptDate.getYear(), ldRecieptDate.getMonthValue(), ldRecieptDate.getDayOfMonth());
    	Date recieptDate1 = cFirstPaymentDate.getTime();
    	
    	//
    	int segmentTypeId = 0;
    	if(segmentType.getValue().equals("Student")) {
    		segmentTypeId = 1;
    	}
    	else if(segmentType.getValue().equals("College")) {
    		segmentTypeId = 2;
    	}
    	else if(segmentType.getValue().equals("Working Professionals")) {
    		segmentTypeId = 3;
    	}
    	
    	int timeSlotId = 0;
    	if(revenueType.getValue().equals("Traning")) {
    		timeSlotId = 1;
    	}
    	else if(revenueType.getValue().equals("Consultation")) {
    		timeSlotId = 2;
    	}
    	else if(revenueType.getValue().equals("Project")) {
    		timeSlotId = 3;
    	}

    	
    	Integer segmentType = segmentTypeId;
    	String recieptNumber;
    	Date recieptDate = recieptDate1;
    	String payerDescription;
    	String batchNumber;
    	String revenueType;
    	String organization;
    	String paymentMode;
    	String checkNumber;
    	float revenueAmount;
    	Date firstPaymentDate = firstPaymentDate1;
    	
    	
    	
    	
    	
    	
    	
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/CoursesName.fxml").openStream());
    	Stage stage = (Stage) submit.getScene().getWindow();
    	Scene scene = new Scene(myNewScene);
    	stage.setScene(scene);
    	stage.setTitle("My New Scene");
    	stage.show();
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
    	
    	//Abhishek
    	organization.getItems().addAll(organizationChoiceBox);
    	paymentMode.getItems().addAll(paymentModeChoiceBox);
    	revenueType.getItems().addAll(revenueTypeChoiceBox);
    	segmentType.getItems().addAll(segmentTypeChoiceBox);
    	
    	
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
