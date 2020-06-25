package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private TableView<StudentCourseInstallmentDetails> feeTable;

    @FXML
    private TableColumn<String, StudentCourseFeesBean> feeTableNameColumn;

    @FXML
    private TableColumn<String, StudentCourseFeesBean> feeTableFeeStatusColumn;

    @FXML
    private TableColumn<?, ?> feeTablePaymentModeColumn;

    @FXML
    private TableColumn<Integer, StudentCourseInstallmentDetails > feeTableInstallment1Column;

    @FXML
    private TableColumn<Date, StudentCourseInstallmentDetails> feeTableDueDate1Column;

    @FXML
    private TableColumn<Integer, StudentCourseInstallmentDetails> feeTableInstallment2Column;

    @FXML
    private TableColumn<Date, StudentCourseInstallmentDetails> feeTableDueDate2Column;

    @FXML
    private TableColumn<Integer, StudentCourseInstallmentDetails> feeTableInstallment3Column;

    @FXML
    private TableColumn<Date, StudentCourseInstallmentDetails> feeTableDueDate3Column;

    @FXML
    private TableColumn<Integer,StudentCourseInstallmentDetails > feeTableDueAmountColumn;
    
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
    	
    	feeTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("fisrtName")); 
    	feeTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("feeStatus"));
    	feeTableInstallment1Column.setCellValueFactory(new PropertyValueFactory<>("actualInstallment1"));
    	feeTableDueDate1Column.setCellValueFactory(new PropertyValueFactory<>("atualInstallment1Date"));
    	feeTableInstallment2Column.setCellValueFactory(new PropertyValueFactory<>("actualInstallment2"));
    	feeTableDueDate2Column.setCellValueFactory(new PropertyValueFactory<>("atualInstallment2Date")); 
    	feeTableInstallment3Column.setCellValueFactory(new PropertyValueFactory<>("actualInstallment3"));
    	feeTableDueDate3Column.setCellValueFactory(new PropertyValueFactory<>("atualInstallment3Date")); 
    	feeTableDueAmountColumn.setCellValueFactory(new PropertyValueFactory<>("dueAmount"));
    	
   
    	
    		StudentCourseInstallmentDetails obj=new StudentCourseInstallmentDetails(2000, null, 
    				3000, null,
    				5999, null,5000);
    		StudentCourseInstallmentDetails obj1=new StudentCourseInstallmentDetails(5000, null, 
    				6750, null,
    				8099, null, 5000);
			ObservableList<StudentCourseInstallmentDetails> data =FXCollections.observableArrayList(obj,obj1);
			
			feeTable.setItems(data);
			
		
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
