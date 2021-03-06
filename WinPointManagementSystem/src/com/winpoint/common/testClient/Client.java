package com.winpoint.common.testClient;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Client extends Application {
	@Override
	public void start(Stage primaryStage) {
		//System.out.println("Hello");
		try {
			BorderPane root =(BorderPane) FXMLLoader.load(getClass().getResource("FrontScreenFxml.fxml"));
			
		    //BorderPane root =(BorderPane) FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/AttendanceScreen.fxml"));

		    //BorderPane root =(BorderPane) FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/NumberOfStudents.fxml"));
			
		    
		    Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
