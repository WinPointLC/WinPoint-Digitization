package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> feeTable;

    @FXML
    private TableColumn<?, ?> feeTableNameColumn;

    @FXML
    private TableColumn<?, ?> feeTableFeeStatusColumn;

    @FXML
    private TableColumn<?, ?> feeTablePaymentModeColumn;

    @FXML
    private TableColumn<?, ?> feeTableInstallment1Column;

    @FXML
    private TableColumn<?, ?> feeTableDueDate1Column;

    @FXML
    private TableColumn<?, ?> feeTableInstallment2Column;

    @FXML
    private TableColumn<?, ?> feeTableDueDate2Column;

    @FXML
    private TableColumn<?, ?> feeTableInstallment3Column;

    @FXML
    private TableColumn<?, ?> feeTableDueDate3Column;

    @FXML
    private TableColumn<?, ?> feeTableDueAmountColumn;

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
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
