package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.wrappers.BatchDetailsWrapper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BatchSelectionScreenController extends ParentFXMLController {
	private Integer courseId;
	private String courseName;
	private VBox cell;
	private HBox facultyCell;
	private Button batchButton;
	private ImageView facultyImage;
	private Text facultyName;
    @FXML
    private Button backButton;

    @FXML
    private ImageView logo;

    @FXML
    private Text selectedCourseName;
    
    @FXML
    private GridPane gridPane;

    @FXML
    private Button batchID1;

    @FXML
    private ImageView facultyImage1;

    @FXML
    private Text facultyName1;

    @FXML
    private Button batchID2;

    @FXML
    private ImageView facultyImage2;

    @FXML
    private Text facultyName2;

    @FXML
    private Button batchID3;

    @FXML
    private ImageView facultyImage3;

    @FXML
    private Text facultyName3;

    //author purva , suhasi , sarthak
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	courseId = Integer.parseInt(recievedData.get(0));
    	courseName = recievedData.get(1);
    	
    	selectedCourseName.setText(courseName);
    	
    	gridPane.getChildren().clear();
    	updateButtons();
    }
    
    void updateButtons() {
    	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		    	Parent myNewScene;
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
				try {
					myNewScene = loader.load();
					LectureScreenController lectureScreenLecture = loader.getController();
					ArrayList<String> dataForLectureScreen = new ArrayList<String>();
					dataForLectureScreen.add(((Button)event.getSource()).getId().substring(7));
					dataForLectureScreen.add(((Button)event.getSource()).getText());
					dataForLectureScreen.add(courseId.toString());
					dataForLectureScreen.add(courseName);
					lectureScreenLecture.setRecievedData(dataForLectureScreen);
					
					Scene scene = new Scene(myNewScene);
			    	stage.setScene(scene);
			    	stage.setTitle("Lecture Screen");
			    	stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	};
    	
    	ArrayList<BatchDetailsWrapper> batchList = new BatchDetailsHelper().getWrapperListOfBatches(courseId);
    	Integer batchCount = batchList.size();
    	int i, j, k = 0;
		for(i = 0;i < Math.ceil(batchCount *0.25); i++) {
    		for(j = 0; j < 4 && (k < batchCount); j++) {
    			cell = setVboxValues();
    			batchButton = setButtonValues();
    			facultyCell = setHboxValues();
    			
    			facultyImage = new ImageView(batchList.get(k).getFacultyImageLocation());
    			//facultyImage = new ImageView(logoImage);
    			
    			facultyImage.setFitHeight(50);
    			facultyImage.setFitWidth(50);
    			
    			facultyName = new Text();
    			facultyName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
    			facultyName.setText(batchList.get(k).getFacultyName());
    			
    			cell.getChildren().add(batchButton);
    			cell.getChildren().add(facultyCell);
    			
    			facultyCell.getChildren().add(facultyImage);
    			facultyCell.getChildren().add(facultyName);
    			
    			batchButton.setId("batchId" + batchList.get(k).getBatchId().toString());
    			batchButton.setText(batchList.get(k).getBatchName());
    			batchButton.setOnAction(event);
    	    	gridPane.setValignment(batchButton, VPos.CENTER);
    	    	gridPane.setHalignment(batchButton, HPos.CENTER);
    			gridPane.add(cell, j, i);
    			k++;
    		}
    	}
    }

    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/CourseSelectScreen.fxml"));
		try {
			myNewScene = loader.load();
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Course Select");
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    Button setButtonValues(){
    	Button button = new Button();
    	button.setMinSize(200, 140);
    	button.setMaxSize(200, 140);
    	button.setPadding(new Insets(10, 10, 10, 10));
    	button.setWrapText(true);
    	button.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 28));
    	button.setAlignment(Pos.CENTER);
    	button.setTextAlignment(TextAlignment.CENTER);
    	button.setCursor(Cursor.HAND);
    	button.setFocusTraversable(true);
    	return button;
    }
    
    VBox setVboxValues() {
    	VBox vbox = new VBox();
    	vbox.setPadding(new Insets(10, 10, 10, 10));
    	vbox.setSpacing(5);
    	vbox.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    	vbox.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    	vbox.setPrefSize(100, 200);
    	vbox.setFillWidth(true);
    	return vbox;
    }
    
    HBox setHboxValues() {
    	HBox hbox = new HBox();
    	hbox.setAlignment(Pos.CENTER_LEFT);
    	hbox.setPadding(new Insets(0, 5, 0, 5));
    	hbox.setSpacing(5);
    	hbox.setPrefSize(100, 50);
    	return hbox;
    }
    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
