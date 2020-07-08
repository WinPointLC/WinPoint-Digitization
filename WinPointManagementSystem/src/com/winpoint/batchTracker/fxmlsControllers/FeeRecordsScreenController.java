package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.StudentCourseInstallmentDetails;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.dao.StudentCourseDetailsDao;
import com.winpoint.common.dao.StudentCourseInstallmentDetailsDao;
import com.winpoint.common.helpers.StudentCourseDetailsHelper;
import com.winpoint.common.helpers.StudentCourseInstallmentHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.FeeRecordsScreenWrapper;

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
    private TableView<FeeRecordsScreenWrapper> feeTable;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, String> feeTableNameColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, String> feeTableFeeStatusColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, String> feeTablePaymentModeColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTablePlannedInstallment1Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTablePlannedInstallment1DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTableActualInstallment1Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTableActualInstallment1DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTablePlannedInstallment2Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTablePlannedInstallment2DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTableActualInstallment2Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTableActualInstallment2DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTablePlannedInstallment3Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTablePlannedInstallment3DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTableActualInstallment3Column;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Date> feeTableActualInstallment3DateColumn;

    @FXML
    private TableColumn<FeeRecordsScreenWrapper, Integer> feeTableDueAmountColumn;
    
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
    	
    	feeTableNameColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, String>("name")); 
    	feeTableFeeStatusColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, String>("feeStatus"));
    	feeTablePaymentModeColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, String>("paymentMode"));
    	feeTablePlannedInstallment1Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("plannedInstallment1"));
    	feeTablePlannedInstallment1DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("plannedInstallment1Date"));
    	feeTableActualInstallment1Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("actualInstallment1"));
    	feeTableActualInstallment1DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("actualInstallment1Date"));
    	feeTablePlannedInstallment2Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("plannedInstallment2"));
    	feeTablePlannedInstallment2DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("plannedInstallment2Date"));
    	feeTableActualInstallment2Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("actualInstallment2"));
    	feeTableActualInstallment2DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("actualInstallment2Date"));
    	feeTablePlannedInstallment3Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("plannedInstallment3"));
    	feeTablePlannedInstallment3DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("plannedInstallment3Date"));
    	feeTableActualInstallment3Column.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("actualInstallment3"));
    	feeTableActualInstallment3DateColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Date>("actualInstallment3Date"));
    	feeTableDueAmountColumn.setCellValueFactory(new PropertyValueFactory<FeeRecordsScreenWrapper, Integer>("dueAmount"));
    	
//    	Date d1 = new Date(0);
//    	FeeRecordsScreenWrapper record1 = new FeeRecordsScreenWrapper(10, 5, "paid", "cash", 5000, d1, 5000, null, 4000, null, 3500, null, 1000, null, 0, null, 1500);
//    	FeeRecordsScreenWrapper record2 = new FeeRecordsScreenWrapper(11, 5, "paid", "cash", 5000, d1, 5000, null, 4000, null, 3500, null, 1000, null, 0, null, 1500);
//		
//    	ObservableList<FeeRecordsScreenWrapper> data = FXCollections.observableArrayList(record1, record2);
//    	feeTable.setItems((ObservableList<FeeRecordsScreenWrapper>)data);
    	
    	ArrayList<StudentCourseDetails> studentCourseDetailsList = new StudentCourseDetailsHelper().getStudentCourseDetailsList();
		ArrayList<StudentCourseInstallmentDetails> studentCourseInstallmentDetailsList = new StudentCourseInstallmentHelper().getStudentCourseInstallmentDetailsList();
		ArrayList<UserProfile> userProfileList = new UserProfileHelper().getUsersForBatchTracker();
		
		int i = 0;
		ArrayList<FeeRecordsScreenWrapper> feeRecordsScreenWrapperList = new ArrayList<FeeRecordsScreenWrapper>();
		while(userProfileList.size() > i) {
			FeeRecordsScreenWrapper feeRecordsScreenWrapper = new FeeRecordsScreenWrapper(userProfileList.get(i).getUserId(), 
					userProfileList.get(i).getFirstName()+" "+userProfileList.get(i).getLastName(), studentCourseDetailsList.get(i).getFeeStatus(),
					"Cash", userProfileList.get(i).getEmail(), userProfileList.get(i).getMobileNumber(), studentCourseInstallmentDetailsList.get(i));
			
			i++;
			feeRecordsScreenWrapperList.add(feeRecordsScreenWrapper);
		}
		
		ObservableList<FeeRecordsScreenWrapper> data = FXCollections.observableArrayList(feeRecordsScreenWrapperList);
		feeTable.setItems(data);
    	

		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}