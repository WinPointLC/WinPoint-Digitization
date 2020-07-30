package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.StudentCourseDetails;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.EnquiryDetailsHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.BatchDetailsWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BatchLauncherController extends ParentFXMLController {
		
		Course course = new Course();
	
		private HashMap<Course, ArrayList<UserCoursesDoneWrapper>> registeredStudentsCourseMap;// = new HashMap<Course, ArrayList<UserCoursesDoneWrapper>>;
		private HashMap<Course, ArrayList<EnquiryDetails>> enquiredStudentsCourseMap;

		private Integer totalHours;
		
		String courseName;// = course.getCourseName();
		int selectedCourseId;// = course.getCourseId();
		int courseTypeId;// = course.getCourseTypeId();
		
		String generatedBatchName;
		CourseType courseType_Name;// = new CourseTypeHelper().getCourseTypeName(courseTypeId);
		String courseTypeName ;//= courseType_Name.getCourseTypeName();
		String preferedTime;// = time;
		String facultyName;// = descriptionForFacultyName;
		
		
		
		
		
	    @FXML
	    private TextField lectureDuration;

	    @FXML
	    private DatePicker beginDate;

	    @FXML
	    private DatePicker endDate;

	    @FXML
	    private Label batchName;

	    @FXML
	    private Label facultyId;

	    @FXML
	    private Label timeChoice;

	    @FXML
	    private Label totalNumberOfLectures;

	    @FXML
	    private Button cancel;

	    @FXML
	    private Button launch;

	    @FXML
	    private ImageView logo;
	    
	    @FXML
	    private Button setLectureDuration;
	    
		private List<CourseType> courseTypeList;
		
	    @FXML
	    void validateLectureDuration(ActionEvent event) {
	    	
	    }
	    int lectureDuration1;
	    int totalNumberOfLectures1;
	    @FXML
	    void validateSetLectureDuration(ActionEvent event) {

	    	System.out.println("Total : "+totalHours);
	    	String lectureDurationString = lectureDuration.getText();
	    	lectureDuration1 = Integer.parseInt(lectureDurationString);		
	    	totalNumberOfLectures1 = (totalHours*60/lectureDuration1);	
			String totalNumberOfLecturesString = Integer.toString(totalNumberOfLectures1);
			totalNumberOfLectures.setText(totalNumberOfLecturesString);// Total Number Of Lectures
			
			int totalNumberOfDays;
			if(timeChoice.getText().equals("MORNING")||timeChoice.getText().equals("EVENING"))
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 1.4);
			else
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 3.5);
			
			//Given Date in String format
			String oldDate = "2020-09-23";  
			System.out.println("Date before Addition: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, totalNumberOfDays);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
			
			try {
		        endDate.setValue(LOCAL_DATE(newDate));
		    } catch (NullPointerException e) {
		    }
	    	
	    }
	
	    @FXML
	    void beginDateFrame(ActionEvent event) {

	    }


	    @FXML
	    void endDateFrame(ActionEvent event) {

	    }
	    

	    @FXML
	    void validateTimeChoice(MouseEvent event) {

	    }

	    @FXML
	    void validateFacultyId(ActionEvent event) {

	    }
	 
    
    @FXML
    void cancelFrame(ActionEvent event) {
    	Stage stage = (Stage) launch.getScene().getWindow();
    	Parent myNewScene;
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/PriorityListOfCourses.fxml"));
			Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    
    @FXML
    void launchFrame(ActionEvent event) throws SQLException {
    	

        HashMap<String, Integer> timeSlotsMap = new HashMap<String, Integer>();
    	for(TimeSlots timeSlot :  new TimeSlotsHelper().getTimeSlotsList()) {
    		timeSlotsMap.put(timeSlot.getTimeSlotsDescription(), timeSlot.getTimeSlotsId());
       	}
    	HashMap<String, Integer> facultyList = new HashMap<String, Integer>();
    	for(UserProfile faculty : new UserProfileHelper().getFaculty()) {
    		timeSlotsMap.put(faculty.getFirstName()+" "+faculty.getLastName(), faculty.getUserId());
    	}
    	LocalDate ldBeginDate = beginDate.getValue();
       	Calendar cBeginDate =  Calendar.getInstance();
       	cBeginDate.set(ldBeginDate.getYear(), ldBeginDate.getMonthValue(), ldBeginDate.getDayOfMonth());
       	Date dateBeginDate = cBeginDate.getTime();
       	LocalDate ldEndDate = endDate.getValue();
       	Calendar cEndDate  =  Calendar.getInstance();
       	cEndDate .set(ldEndDate .getYear(), ldEndDate .getMonthValue(), ldEndDate .getDayOfMonth());
       	Date dateEndDate = cEndDate .getTime();
       	
    	
    	String batchName = generatedBatchName;
    	Integer batchTime = timeSlotsMap.get(preferedTime);    	
       	Integer courseId = selectedCourseId;       	
       	Integer facultyId = timeSlotsMap.get(facultyName);       	
       	Date startDate = dateBeginDate;   	
       	Integer currentLectureNumber = 0;
       	Integer lectureDuration = lectureDuration1; 
       	Integer totalNumberOfLectures = totalNumberOfLectures1;
       	Integer segmentTypeId = selectedSegmentTypeId;       	
       	Date endDate = dateEndDate;   	
    	Integer createdBy = null;
    	Date createdDate = null;
    	

    	// Object Passing to the bean class : 
		BatchDetails batchDetails = new BatchDetails(batchName,batchTime,courseId,facultyId,startDate,currentLectureNumber,
				lectureDuration,totalNumberOfLectures,segmentTypeId,endDate,createdBy,createdDate);
    	// Helper Method Call : 
    	new BatchDetailsHelper().create(batchDetails);
    	
		// Navigation for the next Screen : 
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../../batchScheduler/fxmls/EnquiryDetails.fxml").openStream());
			Stage stage = (Stage) launch.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("My New Scene");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    private void displayBatchDetails(String courseName, int courseId, int courseTypeId, String courseTypeName, String preferedTime, String descriptionForFacultyName) {
		
    	Date d=new Date();  
        @SuppressWarnings("deprecation")
        int year=d.getYear();  
        int currentYear=year+1900;  
          
        BatchDetailsWrapper countBatch = new BatchDetailsHelper().countNumberOfBatches(courseId);
        int count = countBatch.getCount()+1;
        generatedBatchName = courseTypeName.toUpperCase()+"-"+courseName.toUpperCase()+"-"+currentYear+"-"+count;       
       
        
    	batchName.setText(generatedBatchName);
       	timeChoice.setText(preferedTime.toUpperCase());
    	facultyId.setText(descriptionForFacultyName.toUpperCase());
	}
    
    public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
    
    int selectedSegmentTypeId;
	public void setStudentDetail(Course course, HashMap<Course, ArrayList<UserCoursesDoneWrapper>> totalEligibleStudentCourseMap,
			HashMap<Course, ArrayList<UserCoursesDoneWrapper>> enquiredStudentsCourseMap2, 
			SegmentType segmentType, String time, String descriptionForFacultyName) {
	
		selectedSegmentTypeId = segmentType.getSegmentTypeId();
		courseName = course.getCourseName();
		selectedCourseId = course.getCourseId();
		courseTypeId = course.getCourseTypeId();
		totalHours = course.getCourseDuration();
		CourseType courseType_Name = new CourseTypeHelper().getCourseTypeName(courseTypeId);
		courseTypeName = courseType_Name.getCourseTypeName();
		preferedTime = time;
		facultyName = descriptionForFacultyName;
		
		displayBatchDetails(courseName,selectedCourseId,courseTypeId,courseTypeName,preferedTime,facultyName);
	}
	
	@Override
   	public void initialize(URL location, ResourceBundle resources) {
		try {
	        beginDate.setValue(LOCAL_DATE("2020-09-23"));
	    } catch (NullPointerException e) {
	    }
	
   		super.initialize(location, resources);
   		logo.setImage(logoImage); 
   	}

}

//LocalDate ldBeginDate = beginDate.getValue();
//Calendar cBeginDate =  Calendar.getInstance();
//cBeginDate.set(ldBeginDate.getYear(), ldBeginDate.getMonthValue(), ldBeginDate.getDayOfMonth());
//Date dateBeginDate = cBeginDate.getTime();
//
//LocalDate ldEndDate = endDate.getValue();
//Calendar cEndDate  =  Calendar.getInstance();
//cEndDate .set(ldEndDate .getYear(), ldEndDate .getMonthValue(), ldEndDate .getDayOfMonth());
//Date dateEndDate = cEndDate .getTime();
//	
//EventHandler <ActionEvent> eventLaunchButton = new EventHandler<ActionEvent>() {
//	@Override
//	public void handle(ActionEvent event) {
//    	Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//    	Parent myNewScene;
//    	try {
//    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/BatchLauncher.fxml"));
//    		myNewScene = loader.load();
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		
//    		// Object Passing to the bean class : 
//    		BatchDetails batchDetails = new BatchDetails();
//        	// Helper Method Call : 
//        	new EnquiryDetailsHelper().
//    		
//    		Scene scene = new Scene(myNewScene);
//        	stage.setScene(scene);
//        	stage.setTitle("Attendance Records");
//        	stage.show();
//    	} catch (IOException ee) {
//    		ee.printStackTrace();
//    	}
//    }	
//};
//launch.setOnAction(eventLaunchButton); 

