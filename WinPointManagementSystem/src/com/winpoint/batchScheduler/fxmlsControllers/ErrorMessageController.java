package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorMessageController {

    @FXML
    private Button cancel;

    @FXML
    void cancelClcik(ActionEvent event) {
    	Parent myNewScene = null;		
    	Stage stage = (Stage) cancel.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/SignUpForm.fxml"));
		try {
			myNewScene = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(myNewScene);
		stage.setScene(scene);
    	stage.setTitle("Sign Up Form");
    	stage.show();
    }
}
