package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseFeesBean;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.controllers.ParentFXMLController;

//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleObjectProperty;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FeeRecordsScreenController extends ParentFXMLController{

	@FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TextField feeUniqueId;

    @FXML
    private TextField feeName;

    @FXML
    private TextField feeEmailID;

    @FXML
    private TextField feeMobileNumber;

    @FXML
    private TextField feeReminderCount;

    @FXML
    private TextField feeDueAmount;

    @FXML
    private TableView<Wrapper> feeTable;

    @FXML
    private TableColumn<Wrapper, String> feeTableNameColumn;

    @FXML
    private TableColumn<Wrapper, String> feeTableFeeStatusColumn;

    @FXML
    private TableColumn<Wrapper, String> feeTablePaymentModeColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTablePlannedInstallment1Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTablePlannedInstallment1DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTableActualInstallment1Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTableActualInstallment1DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTablePlannedInstallment2Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTablePlannedInstallment2DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTableActualInstallment2Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTableActualInstallment2DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTablePlannedInstallment3Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTablePlannedInstallment3DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTableActualInstallment3Column;

    @FXML
    private TableColumn<Wrapper, Date> feeTableActualInstallment3DateColumn;

    @FXML
    private TableColumn<Wrapper, Integer> feeTableDueAmountColumn;
    
    public void setRecievedData(ArrayList<String> recievedData) {
        for(String data : recievedData) {
            System.out.println(data);
        }
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Lecture Screen");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	feeTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName")); 
    	feeTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("feeStatus"));
    	feeTablePaymentModeColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, String>("paymentMode"));
    	feeTablePlannedInstallment1Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("plannedInstallment1"));
    	feeTablePlannedInstallment1DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("plannedInstallment1Date"));
    	feeTableActualInstallment1Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("actualInstallment1"));
    	feeTableActualInstallment1DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("actualInstallment1Date"));
    	feeTablePlannedInstallment2Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("plannedInstallment2"));
    	feeTablePlannedInstallment2DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("plannedInstallment2Date"));
    	feeTableActualInstallment2Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("actualInstallment2"));
    	feeTableActualInstallment2DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("actualInstallment2Date"));
    	feeTablePlannedInstallment3Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("plannedInstallment3"));
    	feeTablePlannedInstallment3DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("plannedInstallment3Date"));
    	feeTableActualInstallment3Column.setCellValueFactory(new PropertyValueFactory<Wrapper, Integer>("actualInstallment3"));
    	feeTableActualInstallment3DateColumn.setCellValueFactory(new PropertyValueFactory<Wrapper, Date>("actualInstallment3Date"));
    	feeTableDueAmountColumn.setCellValueFactory(new PropertyValueFactory<>("dueAmount"));
    	
   
    		/*
    		StudentCourseInstallmentDetails obj=new StudentCourseInstallmentDetails(2000, null, 
    				3000, null,
    				5999, null,5000);
    		StudentCourseInstallmentDetails obj1=new StudentCourseInstallmentDetails(5000, null, 
    				6750, null,
    				8099, null, 5000);
    		
			ObservableList<StudentCourseInstallmentDetails> data =FXCollections.observableArrayList(obj,obj1);
			
			feeTable.setItems(data);
			*/
    	Wrapper record1 = new Wrapper(10, 5, "cash", 5000, null, 5000, null, 4000, null, 3500, null, 1000, null, 0, null, 1500);
    	Wrapper record2 = new Wrapper(11, 5, "cash", 5000, null, 5000, null, 4000, null, 3500, null, 1000, null, 0, null, 1500);
		
    	ObservableList<Wrapper> data = FXCollections.observableArrayList(record1, record2);
    	
    	feeTable.setItems(data);
    	
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}

class Wrapper{
	StudentCourseInstallmentDetails studentCourseInstallmentDetailsObject;
	StudentCourseDetails studentCourseDetailsObject;
	
	public Wrapper(Integer userId, Integer batchId, String feeStatus,
			Integer plannedInstallment1, Date plannedInstallment1Date, Integer actualInstallment1, Date actualInstallment1Date,
			Integer plannedInstallment2, Date plannedInstallment2Date, Integer actualInstallment2, Date actualInstallment2Date,
			Integer plannedInstallment3, Date plannedInstallment3Date, Integer actualInstallment3, Date actualInstallment3Date,
			Integer dueAmount) {
		studentCourseDetailsObject = new StudentCourseDetails(userId, null, null, null, 
				null, null, batchId, null, null, null, null, 
				feeStatus, null, null, null, null, null, 
				null, null);
		
		studentCourseInstallmentDetailsObject = new StudentCourseInstallmentDetails(userId, null, 
				plannedInstallment1, plannedInstallment1Date, actualInstallment1, actualInstallment1Date, 
				plannedInstallment2, plannedInstallment2Date, actualInstallment2, actualInstallment2Date, 
				plannedInstallment3, plannedInstallment3Date, actualInstallment3, actualInstallment3Date, dueAmount);
	}
	
}
