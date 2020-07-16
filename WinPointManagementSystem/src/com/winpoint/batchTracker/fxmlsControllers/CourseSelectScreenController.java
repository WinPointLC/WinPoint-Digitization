package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.Stream;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.StreamHelper;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CourseSelectScreenController extends ParentFXMLController{
	private Integer courseTypeId;
	private Integer streamId;
	private Button courseButton;
	private List<CourseType> courseTypeList ;
	
	@FXML
	private Button backButton;
    
	@FXML
    private ComboBox<String> selectStream = new ComboBox<>();

    @FXML
    private ComboBox<String> selectCourseType = new ComboBox<>();

    @FXML
    private ImageView logo;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    void getCourseType(ActionEvent event) {
    	gridPane.getChildren().clear();
    	//courseTypeId = new CourseTypeHelper().getCourseTypeId(selectCourseType.getValue());
    	int i, index = -1;
    	for(i = 0; i < courseTypeList.size(); i++) {
    		if(courseTypeList.get(i) != null && courseTypeList.get(i).getCourseTypeName().equals(selectCourseType.getValue())) {
    			index = i;
    			break;
    		}
    	}
    	
    	courseTypeId = courseTypeList.get(index).getCourseTypeId();
    	
    	System.out.println(courseTypeId);
    	gridPane.getChildren().clear();
    	getButtonsUpdate();
    }

    @FXML
    void getStream(ActionEvent event) {
    	selectCourseType.getItems().clear();
    	gridPane.getChildren().clear();
    	//courseTypeList.clear();
    	streamId = new StreamHelper().getStreamId(selectStream.getValue());
    	courseTypeList = new CourseTypeHelper().getCourseTypeList(streamId);
    	int i = 0;
    	while(i < courseTypeList.size())
    	{
    		selectCourseType.getItems().add(courseTypeList.get(i).getCourseTypeName());
    		i++;
    	}
    }
    
    @FXML
    void getPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	Parent myNewScene;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml"));
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
    
    void getButtonsUpdate() {    	
    	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		    	Parent myNewScene;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/BatchSelectionScreen.fxml"));
					myNewScene = loader.load();
					BatchSelectionScreenController batchSelectionScreenController = loader.getController();
					
					ArrayList<String> dataForBatchSelection = new ArrayList<String>();
					dataForBatchSelection.add(((Button)event.getSource()).getId().substring(8));
					dataForBatchSelection.add(((Button)event.getSource()).getText());
					
					batchSelectionScreenController.setRecievedData(dataForBatchSelection);
					
					Scene scene = new Scene(myNewScene);
			    	stage.setScene(scene);
			    	stage.setTitle("Batch Select");
			    	stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(((Button)event.getSource()).getText());
				//System.out.println(((Button)event.getSource()).getId() + "\n");
			}
    	}; 
    	//System.out.println("Buttons updated");
    	//if(streamId != null && courseTypeId != null) {
    		List<Course> courseDetailsList = new CourseHelper().getCourseList(streamId, courseTypeId);
    		Integer courseCount = courseDetailsList.size();
    		int i, j, k = 0;
    		for(i = 0;i < Math.ceil(courseCount *0.25); i++) {
        		for(j = 0; j < 4; j++) {
        			courseButton = new Button();
        			courseButton.setId("courseId" + courseDetailsList.get(k).getCourseId().toString());
        	    	courseButton.setText(courseDetailsList.get(k).getCourseName());
        	    	courseButton.setMinSize(200, 150);
        	    	courseButton.setMaxSize(200, 150);
        	    	courseButton.setPadding(new Insets(10, 10, 10, 10));
        	    	courseButton.setCursor(Cursor.HAND);
        	    	courseButton.setWrapText(true);
        	    	courseButton.setFocusTraversable(true);
        	    	courseButton.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 28));
        	    	courseButton.setAlignment(Pos.CENTER);
        	    	courseButton.setTextAlignment(TextAlignment.CENTER);
        	    	courseButton.setOnAction(event);
        	    	gridPane.setValignment(courseButton, VPos.CENTER);
        	    	gridPane.setHalignment(courseButton, HPos.CENTER);
        			gridPane.add(courseButton, j, i);
        			k++;
        		}
        	}
    		//System.out.println("\n\n");
    	//}else {
    		//System.out.println("Stream Id:" + streamId + "\nCourseType Id:" + courseTypeId + "\n\n");
    	//}    	    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {    	
    	List<Stream> streamList = new StreamHelper().getStreamList();
    	int i = 0;
    	while(i < streamList.size())
    	{
    		selectStream.getItems().add(streamList.get(i).getStreamName());
    		i++;
    	}
    	
//    	List<CourseType> courseTypeList = new CourseTypeHelper().getCourseTypeList();
//    	i = 0;
//    	while(i < courseTypeList.size())
//    	{
//    		selectCourseType.getItems().add(courseTypeList.get(i).getCourseTypeName());
//    		i++;
//    	}
    	
    	//getButtonsUpdate();
    	
		// TODO Auto-generated method stub
		super.initialize(location, resources);
		logo.setImage(logoImage);
	}
}
