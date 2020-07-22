package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.PriorityCoursesListHelper;

import com.winpoint.common.wrappers.PriorityListOfCoursesWrapper;
import com.winpoint.common.wrappers.UserCoursesDoneWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PriorityListOfCoursesController extends ParentFXMLController{
	
		private Integer courseTypeNameId;
		
		private Integer availableTimeId = null;
		
		private Integer timeSlotsId;
		
		private Integer facultySkillsId;
		
		
		ObservableList<PriorityListOfCoursesWrapper> data;
		
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>> registeredStudentsCourseMap;
		
		HashMap<Course, ArrayList<EnquiryDetails>> enquiredStudentsCourseMap;
		
		List<PriorityListOfCoursesWrapper> priorityListOfCoursesWrapperList;
		
	    @FXML
	    private TableView<PriorityListOfCoursesWrapper> priorityCoursesListTable;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, String> coursesCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, String> segmentTypeCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, ChoiceBox<String>> avaialbleTimeCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, String> noOfStudentsCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, Date> beginDateCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, ChoiceBox<String>> facultyNameCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper,Integer> totalRevenueCol;

	    @FXML
	    private TableColumn<PriorityListOfCoursesWrapper, Button> launchCol;
	    
	    private Button launchButton;
	    
	    @FXML
	    private ChoiceBox<String> courseType;
	    
	    @FXML
	    private ChoiceBox<String> facultyName;
	    
	    @FXML
	    private ChoiceBox<String> availableTime;
	    
	    private int count;
	    
	    @FXML
	    void validateCourseType(MouseEvent event) {
	    	    	
	    }
	    
	    

	    @FXML
	    private ImageView logo;

	    @FXML
	    private Button cancel;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {

	    	System.out.println(event);
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Main Scene");
	    	stage.show();

	    	
	    }   
	    
	    
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
    	
    	 registeredStudentsCourseMap  = new PriorityCoursesListHelper().getRegisteredStudentListWithCourses();		//key is course bean and value UserCoursesDoneWrapper(userProfile beand and oursesDone)
    	 enquiredStudentsCourseMap = new PriorityCoursesListHelper().getEnquiredStudentListWithCourses();	//course bean and enquiry details array list    
    	 
    	//course Type choice box
    	List<CourseType> courseTypeList = new CourseTypeHelper().getCoursesType();    	 
    	for(CourseType courseId : courseTypeList) {
    		courseType.getItems().add(courseId.getCourseTypeName());
    	}
    	EventHandler<ActionEvent> eventCourseType = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) { 
            	int index = courseType.getItems().indexOf(courseType.getValue());
            	courseTypeNameId = courseTypeList.get(index).getCourseTypeId();
            	String description = courseTypeList.get(index).getCourseTypeName();
            	System.out.println("Index : " + index);
            	System.out.println("CategoryUserId : "+ courseTypeNameId);
            	System.out.println("Description : "+ description); 
            	
            
            	priorityListOfCoursesWrapperList  = new ArrayList<PriorityListOfCoursesWrapper>();
            			
            			
    	    		for(Course course : registeredStudentsCourseMap.keySet()) {
    	    			count = 0 ;
    	    			launchButton= new Button("Launch");
    	    			if(course.getCourseTypeId()==courseTypeNameId) {
//    	    				System.out.println(course.getCourseName());
    	    				ArrayList<UserCoursesDoneWrapper> studentDetailsList = registeredStudentsCourseMap.get(course);
    	    			
    	    		        for(UserCoursesDoneWrapper userCoursesDoneWrapper : studentDetailsList){
    	    		        	count++;
    	    		        }
    	    		        
    	    		        priorityListOfCoursesWrapperList.add(new PriorityListOfCoursesWrapper(course.getCourseId(),course.getCourseName() , 1, 1, count,null, count*course.getCourseFees(), launchButton));
    	    	        	
    	 
    	    			}
    	    		}
    	    		
    	    		for(Course course : enquiredStudentsCourseMap.keySet()) {
    	    			int innerCount=0;
    	    			if(course.getCourseTypeId() == courseTypeNameId) {
    	    				ArrayList<EnquiryDetails> studentDetailsList = enquiredStudentsCourseMap.get(course);
    	    				for(EnquiryDetails enquiryDetails : studentDetailsList) {  
    	    					innerCount ++;
    	    				}
    	    					for (PriorityListOfCoursesWrapper coursesWrapper : priorityListOfCoursesWrapperList) {			//accessing the prev 
    	    						if(coursesWrapper.getCourseId() == course.getCourseId()) {
    	    							coursesWrapper.setNoOfStudents(innerCount+coursesWrapper.getNoOfStudents());
    	    							coursesWrapper.setTotalRevenue(coursesWrapper.getNoOfStudents()*course.getCourseFees());
    	    							break;
    	    						}
    	    					}
    	    			}
    	    		}
    	    		
            	data =FXCollections.observableArrayList(priorityListOfCoursesWrapperList);
	        	priorityCoursesListTable.setItems(data);
            	
            }
            
        }; 	
        courseType.setOnAction(eventCourseType);
        
        
        
    	// TimeSlots Choice Box : 
//    	List<TimeSlots> timeSlotsList = new TimeSlotsHelper().getTimeSlotsList();    	    	
//    	for(TimeSlots timeSlot : timeSlotsList) {
//    		availableTime.getItems().add(timeSlot.getTimeSlotsId()-1, timeSlot.getTimeSlotsDescription());
//    	}
//    	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
//            public void handle(ActionEvent e) { 
//            	int index = availableTime.getItems().indexOf(availableTime.getValue());
//            	timeSlotsId = timeSlotsList.get(index).getTimeSlotsId();
//           	String description = timeSlotsList.get(index).getTimeSlotsDescription();
//            	System.out.println("Index : "+index);
//            	System.out.println("TimeSlotId : "+ timeSlotsId);
//            	System.out.println("Description : "+ description);        
//            }
//        }; 	
//    	availableTime.setOnAction(event);
    	
    	
    	
    	
    	
    	
    	/*******************************************************/
    	
    	//Faculty Ids Choice Box :
//    	List<UserProfile> facultyList = new UserProfileHelper().getFaculty();    	 
//    	for(UserProfile faculty : facultyList) {
//    		facultyName.getItems().add(faculty.getFirstName()+" "+faculty.getLastName());
//    	}
//    	EventHandler<ActionEvent> eventCreatedBy = new EventHandler<ActionEvent>() { 
//            public void handle(ActionEvent e) { 
//            	int index = facultyName.getItems().indexOf(facultyName.getValue());
//            	facultySkillsId = facultyList.get(index).getUserId();
//            	String description = facultyList.get(index).getFirstName();
//            	System.out.println("Index : "+index);
//            	System.out.println("CategoryUserId : "+ facultySkillsId);
//            	System.out.println("Description : "+ description);        
//            }
//        }; 	
//        facultyName.setOnAction(eventCreatedBy);
        
    	/*******************************************************/
    	
    	
    	
    	
    	
    	
    	
    	
    	coursesCol.setCellValueFactory(new PropertyValueFactory<>("Course"));
    	segmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("SegmentType"));
    	avaialbleTimeCol.setCellValueFactory(new PropertyValueFactory<>("AvailableTime"));
    	noOfStudentsCol.setCellValueFactory(new PropertyValueFactory<>("NoOfStudents"));
    	beginDateCol.setCellValueFactory(new PropertyValueFactory<>("BeginDate"));
    	facultyNameCol.setCellValueFactory(new PropertyValueFactory<>("FacultyName"));
    	totalRevenueCol.setCellValueFactory(new PropertyValueFactory<>("TotalRevenue"));
    	launchCol.setCellValueFactory(new PropertyValueFactory<>("Launch"));
    	
    	
    	
    	priorityListOfCoursesWrapperList  = new ArrayList<PriorityListOfCoursesWrapper>();
    	data =FXCollections.observableArrayList(priorityListOfCoursesWrapperList);
    	priorityCoursesListTable.setItems(data);

    	
    	super.initialize(location, resources);
   		logo.setImage(logoImage);
   	}

}
