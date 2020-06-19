package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FeeRecordsScreenController extends ParentFXMLController{

    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private TextField FeeUniqueId;

    @FXML
    private TextField FeeName;

    @FXML
    private TextField FeeEmailID;

    @FXML
    private TextField FeeMobileNumber;

    @FXML
    private TextField FeeReminderCount;

    @FXML
    private TextField FeeDueAmount;

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
    	System.out.println(event);
    }
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}

}
