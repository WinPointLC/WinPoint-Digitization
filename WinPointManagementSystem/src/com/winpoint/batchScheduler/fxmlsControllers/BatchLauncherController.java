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
import java.util.ResourceBundle;

import com.winpoint.common.beans.BatchDetails;
import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.BatchDetailsWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.event.ActionEvent;
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
			
	// Declaring the required variable :
		String courseName;
		String courseTypeName ;
		String preferedTime;
		String facultyName;
		String generatedBatchName;
		String selectedcourseName;
		String prefreredTimeName;
		int selectedSegmentTypeId;
		int selectedCourseId;
		int courseTypeId;
		int lectureDuration1;
	    int totalNumberOfLectures1;
		private ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents1;
		private ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents1;
		private Integer totalHours;	
		CourseType courseType_Name;
		Course course = new Course();				
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
	    @FXML
	    void validateLectureDuration(ActionEvent event) {}
	    @FXML
	    void beginDateFrame(ActionEvent event) {}
	    @FXML
	    void endDateFrame(ActionEvent event) {}	    
	    @FXML
	    void validateTimeChoice(MouseEvent event) {}
	    @FXML
	    void validateFacultyId(ActionEvent event) {}
	/*******************************************************************************************************************/
	    
	    @FXML
	    void setClick(ActionEvent event) {

	    	String lectureDurationString = lectureDuration.getText();
	    	lectureDuration1 = Integer.parseInt(lectureDurationString);		
	    	totalNumberOfLectures1 = (totalHours*60/lectureDuration1);	
			String totalNumberOfLecturesString = Integer.toString(totalNumberOfLectures1);
			totalNumberOfLectures.setText(totalNumberOfLecturesString);
	
			int totalNumberOfDays;
			if(timeChoice.getText().equals("MORNING")||timeChoice.getText().equals("EVENING"))
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 1.4);
			else
				totalNumberOfDays = (int) (totalNumberOfLectures1 * 3.5);
			
			//Given Date in String format
			String oldDate = "2020-09-23";  
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
			
			try {
		        endDate.setValue(LOCAL_DATE(newDate));
		    } catch (NullPointerException e) {
		    
		    }	    	
	    }
	
	    @FXML
	    void cancelClick(ActionEvent event) {
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
	    void launchClick(ActionEvent event) throws SQLException {	
	
	    	// Accessing Data :
	    	// Accessing the timeSlots -
	        HashMap<String, Integer> timeSlotsMap = new HashMap<String, Integer>();
	    	for(TimeSlots timeSlot :  new TimeSlotsHelper().getTimeSlotsList()) {
	    		timeSlotsMap.put(timeSlot.getTimeSlotsDescription(), timeSlot.getTimeSlotsId());
	       	}
	    	// Accessing the Faculty Names -
	    	for(UserProfile faculty : new UserProfileHelper().getFaculty()) {
	    		timeSlotsMap.put(faculty.getFirstName(), faculty.getUserId());
	    	}
	    	// Converting the Begin Date -
	    	LocalDate ldBeginDate = beginDate.getValue();
	       	Calendar cBeginDate =  Calendar.getInstance();
	       	cBeginDate.set(ldBeginDate.getYear(), ldBeginDate.getMonthValue(), ldBeginDate.getDayOfMonth());
	       	Date dateBeginDate = cBeginDate.getTime();
	       	// Converting the End Date -
	       	LocalDate ldEndDate = endDate.getValue();
	       	Calendar cEndDate  =  Calendar.getInstance();
	       	cEndDate .set(ldEndDate .getYear(), ldEndDate .getMonthValue(), ldEndDate .getDayOfMonth());
	       	Date dateEndDate = cEndDate .getTime();	  
	       	// Date Time conversion to the date - DataType.
	       	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    	Date javaDate = null;
			try {
				javaDate = sdf.parse("06/10/2013 18:29:09");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	    	java.sql.Date date = new java.sql.Date(javaDate.getTime());
	    	
	       	// setting the accessed Data into respected variables -
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
	    	Integer createdBy = 1;
	    	Date createdDate = date;
	
	    	// Object Passing to the bean class : 
			BatchDetails batchDetails = new BatchDetails(batchName,batchTime,courseId,
					facultyId,startDate,currentLectureNumber,
					lectureDuration,totalNumberOfLectures,segmentTypeId,
					endDate,createdBy,createdDate);
	    	// Helper Method Call : 
	    	new BatchDetailsHelper().create(batchDetails);
	    		    	
			Parent myNewScene = null;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/BatchDetails.fxml"));
				myNewScene = loader.load();
				// Passing the Data to the next Screen.
				BatchDetailsController batchDetailsController =  loader.getController();
			   	batchDetailsController.setListOfStudent(
				   			listOfRegisteredStudents1, 
				   			listOfEnquiredStudents1, 
				   			courseId, 
				   			selectedSegmentTypeId, 
				   			batchTime,
				   			facultyId,
				   			generatedBatchName,
				   			selectedcourseName,
				   			prefreredTimeName
				   			);		            	
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
	           	Stage stage = (Stage) launch.getScene().getWindow();
	           	Scene scene = new Scene(myNewScene);
	           	stage.setScene(scene);
	           	stage.setTitle("Main Scene");
            	stage.show();
	    }
	    
	    // Converting the Date in the Local Date format -
	    public static final LocalDate LOCAL_DATE (String dateString){
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    LocalDate localDate = LocalDate.parse(dateString, formatter);
		    return localDate;
		}
		
	    /* Setting data to the Variables 
	     * accessed from the Previous Screen.
	     *  */
		public void setBatchDetail(Course course, ArrayList<UserCoursesDoneWrapper> listOfRegisteredStudents,
			ArrayList<UserCoursesDoneWrapper> listOfEnquiredStudents, 
			SegmentType segmentType, String time, String descriptionForFacultyName) {
		
			// Initialization of the ArrayLists :
			listOfRegisteredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
			listOfEnquiredStudents1 = new ArrayList<UserCoursesDoneWrapper>();
			
			// Adding the lists to the ArrayLists from previous screen :
			listOfRegisteredStudents1.addAll(listOfRegisteredStudents);
			listOfEnquiredStudents1.addAll(listOfEnquiredStudents);
			
			// Assigning the values to the variables :
			selectedSegmentTypeId = segmentType.getSegmentTypeId();
			courseName = course.getCourseName();
			selectedCourseId = course.getCourseId();
			courseTypeId = course.getCourseTypeId();
			totalHours = course.getCourseDuration();
			CourseType courseType_Name = new CourseTypeHelper().getCourseTypeName(courseTypeId);
			courseTypeName = courseType_Name.getCourseTypeName();
			preferedTime = time;
			facultyName = descriptionForFacultyName;
			
			// Passing the values to the display function :
			displayBatchDetails(courseName,selectedCourseId,courseTypeId,courseTypeName,preferedTime,facultyName);
		}
		
		// Setting the Data on the Screen -
		 private void displayBatchDetails(String courseName, int courseId, 
		    		int courseTypeId, String courseTypeName, String preferedTime, 
		    		String descriptionForFacultyName) {
				
		    	Date d=new Date();  
		        @SuppressWarnings("deprecation")
		        int year=d.getYear();  
		        int currentYear=year+1900;  
		         
		        // Setting data in the format we want -
		        BatchDetailsWrapper countBatch = new BatchDetailsHelper().countNumberOfBatches(courseId);
		        int count = countBatch.getCount()+1;
		        generatedBatchName = courseTypeName.toUpperCase()+"-"+courseName.toUpperCase()+"-"+currentYear+"-"+count;       	       	    
		        selectedcourseName = courseName;
		        prefreredTimeName = preferedTime;
		        
		        // Setting the data in the text field on the Screen -
		    	batchName.setText(generatedBatchName);
		       	timeChoice.setText(preferedTime.toUpperCase());
		    	facultyId.setText(descriptionForFacultyName.toUpperCase());
		}
		 
		 @Override
		   	public void initialize(URL location, ResourceBundle resources) {
				
				// Date accessed :
				try {
			        beginDate.setValue(LOCAL_DATE("2020-09-23"));
			    } catch (NullPointerException e) {
			    	
			    }
				
				// Adding the logo :
		   		super.initialize(location, resources);
		   		logo.setImage(logoImage); 
		   	}
}









