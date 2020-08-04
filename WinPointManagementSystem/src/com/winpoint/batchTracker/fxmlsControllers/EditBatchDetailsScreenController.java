package com.winpoint.batchTracker.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import com.winpoint.common.beans.Stream;
import com.winpoint.common.beans.Topic;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.LectureHelper;
import com.winpoint.common.helpers.StreamHelper;
import com.winpoint.common.helpers.StudentCourseInstallmentHelper;
import com.winpoint.common.helpers.TopicsHelper;
import com.winpoint.common.wrappers.EditBatchDetailsWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditBatchDetailsScreenController extends ParentFXMLController {
	private Integer batchId;
	private String batchNameValue;
	private Integer courseId;
	private String courseName;
	EditBatchDetailsWrapper editBatchDetails=null;
	HashMap<Integer,String> allTopicsMap= new HashMap<>();
	ArrayList<EditBatchDetailsWrapper> allTopicsList=new ArrayList<EditBatchDetailsWrapper>();
	ObservableList<String> topicsList = FXCollections.observableArrayList();
	ArrayList<String> recievedData= new ArrayList<String>() ;
	int lecnum;
    @FXML
    private Button backButton;

    @FXML
    private Text batchName;

    @FXML
    private ImageView logo;

    @FXML
    private DatePicker batchStartDate;

    @FXML
    private DatePicker batchEndDate;

    @FXML
    private TextField estimateLectureDuration;

    @FXML
    private Button removeLecture;

    @FXML
    private Button addLecture;

    @FXML
    private Button addStudent;

    @FXML
    private Button editStudent;

    @FXML
    private Button saveBatchDetails;

    @FXML
    
    private ComboBox<String> selectLecture = new ComboBox<>();
    @FXML
    private CheckComboBox<String> topicsCoveredComboBox ;
    @FXML
    private DatePicker lectureDate;

    @FXML
    private TextField lectureStartTime;

    @FXML
    private TextField lectureSessionDuration;

    @FXML
    private TextArea lectureComments;
    @FXML
    private Button resetLecture;

    @FXML
    private Button saveLecture;
    @FXML
    private HBox lectureCoverageHBox;
    
    public void setRecievedData(ArrayList<String> recievedData) {
    	batchId = Integer.parseInt(recievedData.get(0));
    	batchNameValue = recievedData.get(1);
    	courseId = Integer.parseInt(recievedData.get(2));
    	courseName = recievedData.get(3);
    	batchName.setText(batchNameValue);
    	//int lecnum;
    	List<EditBatchDetailsWrapper> lectureList = new LectureHelper().getLectureNumber(batchId);
   		for(EditBatchDetailsWrapper e :lectureList) {
   			selectLecture.getItems().add("Lecture "+e.getLectureNumber().toString());
   			
   		}
   		EventHandler<ActionEvent> lectureDetails = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent event) {
            	int index=selectLecture.getItems().indexOf(selectLecture.getValue());
            	lecnum=lectureList.get(index).getLectureNumber();
            	editBatchDetails= new LectureHelper().getLectureDetails(courseId,lecnum,batchId);
            	
            		String lecDate = editBatchDetails.getLectureDate().toString();
            		try {
            			lectureDate.setValue(LOCAL_DATE(lecDate));
            	    }
            		catch (NullPointerException e) {
            	    }
                	lectureStartTime.setText(editBatchDetails.getStartTime());
                	lectureSessionDuration.setText(getDuration(new Integer(editBatchDetails.getLectureDuration())).toString());
                	lectureComments.setText(editBatchDetails.getComments());
                	
                	
                	EditBatchDetailsWrapper editBatchDetails= new LectureHelper().getLectureDetails(courseId, lecnum, batchId);
               		ArrayList<Integer> topicsIdsList = editBatchDetails.getTopicsList();
               		for(Integer topicId : topicsIdsList) {
               			System.out.println(topicId);
               			
               			topicsCoveredComboBox.getCheckModel().check(allTopicsMap.get(topicId));
               			//topicsNamesList.add(topicId.getTopicName());
               		}
            	
            }
            
            
   		};
   		
   		selectLecture.setOnAction(lectureDetails);

   		ArrayList<Topic> allTopicsList= new TopicsHelper().getTopicNamesForComboBox(courseId);
   		ObservableList<String>allTopicsNamesList=FXCollections.observableArrayList();
   		for(Topic topic : allTopicsList) {
   			allTopicsNamesList.add(topic.getTopicName());
   			allTopicsMap.put(topic.getTopicId(), topic.getTopicName());
   		}
   		
   		topicsCoveredComboBox=new CheckComboBox<String>(allTopicsNamesList);
   		//topicsCoveredComboBox.getCheckModel().checkIndices(0, 1);
   		topicsCoveredComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
   	     public void onChanged(ListChangeListener.Change<? extends String> c) {
   	    	System.out.println(topicsCoveredComboBox.getCheckModel().getCheckedItems()); 
   	         }
   	 });
   		lectureCoverageHBox.getChildren().add(topicsCoveredComboBox);
   		
   	}
    

    @FXML
    void addLectureToBatch(ActionEvent event) {

    }

    @FXML
    void addStudentToLecture(ActionEvent event) {

    }

    @FXML
    void editStudentInLecture(ActionEvent event) {

    }
    
    @FXML
    void getLectureList(ActionEvent event) {
    	
    	
    }
   

    @FXML
    void goToPreviousScreen(ActionEvent event) {
    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	Parent myNewScene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchTracker/fxmls/LectureScreen.fxml"));
			myNewScene = loader.load();
			LectureScreenController lectureScreenLecture = loader.getController();
			ArrayList<String> dataForLectureScreen = new ArrayList<String>();
			dataForLectureScreen.add(batchId.toString());
			dataForLectureScreen.add(batchNameValue);
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

    @FXML
    void lectureCoverageList(ActionEvent event) {

    }

    @FXML
    void removeLectureFromBatch(ActionEvent event) {

    }
    
    @FXML
    void resetLectureDetails(ActionEvent event) {

    }

    @FXML
    void saveLectureDetails(ActionEvent event) {
//    	LocalDate lecDate = lectureDate.getValue();
//    	Calendar cBeginDate =  Calendar.getInstance();
//    	cBeginDate.set(lecDate.getYear(), lecDate.getMonthValue(), lecDate.getDayOfMonth());
//    	Date lecBeginDate = cBeginDate.getTime();
//    	String lecTime=lectureStartTime.getText();
//    	String duration=lectureSessionDuration.getText();
//    	String lecComments=lectureComments.getText();
//    	EditBatchDetailsWrapper updateLecDetails=new EditBatchDetailsWrapper(lecBeginDate,lecTime,duration,lecComments);
//    	new LectureHelper().updateLectureDetails(updateLecDetails);
//    	//Date lecDate=lectureDate.getValue();
    }
   
    @FXML
    void saveUpdatedBatchDetails(ActionEvent event) {

    }
    Float getDuration(Integer lecDuration) {
		float duration=0f;
		int minutes=lecDuration%100;
		int hours=lecDuration/100;
		duration=(hours+(minutes/60.0f));
		return duration;
	}
    public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		super.initialize(location, resources);
   		logo.setImage(logoImage);
    }
    

}
