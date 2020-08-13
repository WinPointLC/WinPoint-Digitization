package com.winpoint.common.testClient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.winpoint.batchScheduler.fxmlsControllers.SignUpFormController;
import com.winpoint.common.controllers.ParentFXMLController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FrontScreenController extends ParentFXMLController {


	    @FXML
	    private BorderPane borderPane;

	    @FXML
	    private ImageView logo;

	    @FXML
	    private Hyperlink takeEnquiryLink;

	    @FXML
	    private Hyperlink enquiryDetails;

	    @FXML
	    private Hyperlink categorisedRecommendedCoursesLink;

	    @FXML
	    private Hyperlink newBatchScheduler;

	    @FXML
	    private Hyperlink selectCourse;

	    @FXML
	    void getCourseScreen(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) selectCourse.getScene().getWindow();
	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchTracker/fxmls/CourseSelectScreen.fxml"));
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Course Select");
	    	stage.show();


	    }

	    @FXML
	    void openCategorisedRecommendedCourses(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) categorisedRecommendedCoursesLink.getScene().getWindow();
	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Categorised Course Recommender");
	    	stage.show();


	    }

	    @FXML
	    void openEnquiryDetails(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) enquiryDetails.getScene().getWindow();
	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml"));
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Enquiry Details");
	    	stage.show();


	    }

	    @FXML
	    void openNewBatchScheduler(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) newBatchScheduler.getScene().getWindow();
	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/NewBatchSchedular.fxml"));
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("New Batch Scheduler");
	    	stage.show();


	    }

	    @FXML
	    void openSignUpForm(ActionEvent event) throws IOException {
//	    	Stage stage = (Stage) takeEnquiryLink.getScene().getWindow();
//	    	Parent myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/SignUpForm.fxml"));
//	    	Scene scene = new Scene(myNewScene);
//	    	stage.setScene(scene);
//	    	stage.setTitle("Sign Up Form");
//	    	stage.show();
	    	
	    	Parent myNewScene = null;
			
	    	Stage stage = (Stage) takeEnquiryLink.getScene().getWindow();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/SignUpForm.fxml"));
			myNewScene = loader.load();
			
			SignUpFormController signUpFormController = loader.getController();
			//signUpFormController.setCourseInterestedInCheckComboBox(signUpFormController);//(signUpFormController);

			Scene scene = new Scene(myNewScene);
			
	    	stage.setScene(scene);
	    	stage.setTitle("Sign Up Form");
	    	stage.show();


	    }

    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
