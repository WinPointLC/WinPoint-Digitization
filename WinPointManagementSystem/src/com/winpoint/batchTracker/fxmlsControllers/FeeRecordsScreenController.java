package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Receiver;
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
	private static Integer batchId;
	private static String batchNameValue;
	private static Integer courseId;
	private static String courseName;

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
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	courseId = Integer.parseInt(recievedData.get(2));
    	courseName = recievedData.get(3);
//    	for(String data : recievedData) {
//    		System.out.println(data);
//    	}
    	batchName.setText(batchNameValue);
    	displayTable();
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage)backButton.getScene().getWindow();
    	Parent myNewScene;
    	LectureScreenController lectureScreenController = new LectureScreenController();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			myNewScene = loader.load();
			lectureScreenController = loader.getController();
			
			ArrayList<String> dataForLectureScreen = new ArrayList<String>();
			dataForLectureScreen.add(batchId.toString());
			dataForLectureScreen.add(batchNameValue);
			dataForLectureScreen.add(courseId.toString());
			dataForLectureScreen.add(courseName);
			
			lectureScreenController.setRecievedData(dataForLectureScreen);
			
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Lecture Screen");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void displayTable() {
    	ObservableList<FeeRecordsScreenWrapper> data = FXCollections.observableArrayList(new StudentCourseInstallmentHelper().getFeeRecordsScreenWrapperList(batchId));
		feeTable.setItems(data);
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
		
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}