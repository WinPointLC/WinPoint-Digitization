package com.winpoint.batchTracker.fxmlsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FeeRecordsScreenController extends ParentFXMLController {

    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private TextField uniqueID;

    @FXML
    private TextField name1;

    @FXML
    private TextField email;

    @FXML
    private TextField mobileNumber;

    @FXML
    private TextField reminderCount;

    @FXML
    private TextField dueAmount;

    @FXML
    private TableView<?> feeTable;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> feestatus;

    @FXML
    private TableColumn<?, ?> paymentmode;

    @FXML
    private TableColumn<?, ?> installment1;

    @FXML
    private TableColumn<?, ?> duedate1;

    @FXML
    private TableColumn<?, ?> installment2;

    @FXML
    private TableColumn<?, ?> duedate2;

    @FXML
    private TableColumn<?, ?> installment3;

    @FXML
    private TableColumn<?, ?> duedate3;

    @FXML
    private TableColumn<?, ?> dueamount;

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

