package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.winpoint.common.beans.Course;
import com.winpoint.common.beans.CourseType;
import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.dao.EnquiryDetailsDao;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.PriorityCoursesListHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
import com.winpoint.common.wrappers.EnquiryDetailsWrapper;
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
		private Integer availableTimeId = 1;
		private Integer segmentTypeId = 1;
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
	    
//	    private Button launchButton;
	    
	    @FXML
	    private ChoiceBox<String> courseType;
	    
//	    @FXML
//	    private ChoiceBox<String> facultyName;
	    
	    @FXML
	   // private ChoiceBox<String> availableTime;	    
	    private int count;
	    private int timeWiseCount;
	    @FXML
	    void validateCourseType(MouseEvent event) {
	    	    	
	    }

	    @FXML
	    private ImageView logo;

	    @FXML
	    private Button cancelbutton;

	    @FXML
	    void cancelFrame(ActionEvent event) throws IOException {

	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene = loader.load(getClass().getResource("../../common/testClient/FrontScreenFxml.fxml").openStream());
	    	Stage stage = (Stage) cancelbutton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Main Scene");
	    	stage.show();
	    	
	    }   
 
    @Override
   	public void initialize(URL location, ResourceBundle resources) {

      
    	
       	registeredStudentsCourseMap  = new PriorityCoursesListHelper().getRegisteredStudentListWithCourses();//key is course bean and value UserCoursesDoneWrapper(userProfile beand and oursesDone)
    	enquiredStudentsCourseMap = new PriorityCoursesListHelper().getEnquiredStudentListWithCourses();//course bean and enquiry details array list    
    	
    	//course Type choice box : 
    	List<CourseType> courseTypeList = new CourseTypeHelper().getCoursesType();    	 
    	for(CourseType courseId : courseTypeList) {
    		courseType.getItems().add(courseId.getCourseTypeName());
    	}
    	
    	EventHandler<ActionEvent> eventCourseType = new EventHandler<ActionEvent>() { 
    		
            public void handle(ActionEvent e) { 
            	int index = courseType.getItems().indexOf(courseType.getValue());
            	courseTypeNameId = courseTypeList.get(index).getCourseTypeId();
            	priorityListOfCoursesWrapperList  = new ArrayList<PriorityListOfCoursesWrapper>();  
            	
            	Integer rowNumber = 0;
            	
            	ArrayList<SegmentType> segmentTypeList = (ArrayList<SegmentType>) new SegmentTypeHelper().getSegmentTypeList();
            	
            	
            	
	            for(Course course : registeredStudentsCourseMap.keySet()) {
	            		
	           		for(SegmentType segmentType : segmentTypeList) {
	           				           			
	           			count = 0;
	    	    		timeWiseCount = 0;
	    	    		
	    	    		Button launchButton = new Button("Launch");
	    	    		
	    				ChoiceBox<String> facultyName = new ChoiceBox<String>();
	    
	    	    		ChoiceBox<String> availableTime = new ChoiceBox<String>();    	    			
	    	    		availableTime.setId(""+rowNumber);
	    		    	// TimeSlots Choice Box : 
	    	            List<TimeSlots> timeSlotsList = new TimeSlotsHelper().getTimeSlotsList();    
	    	            //availableTime.setValue("ALL");
	    	            for(TimeSlots timeSlot : timeSlotsList) {
	    	            	availableTime.getItems().add(timeSlot.getTimeSlotsDescription());
	    	            		
	    	            }
	    	            	
	    	            EventHandler<ActionEvent> eventAvailable = new EventHandler<ActionEvent>() { 
	    	                public void handle(ActionEvent e) { 
	    		               	int index = availableTime.getItems().indexOf(availableTime.getValue());
	    	                   
	    	                   	timeSlotsId = timeSlotsList.get(index).getTimeSlotsId();
	    	                   	String description = timeSlotsList.get(index).getTimeSlotsDescription();
	    	
	    	                    getTimewiseNumberOfStudents(course, segmentType, timeSlotsId, availableTime, true, facultyName, launchButton);
	    	                    	      	                    	
	    	                 }
	    	            }; 	
	    	            availableTime.setOnAction(eventAvailable);
	    				
	    				//Faculty Ids Choice Box :
	    		    	List<UserProfile> facultyList = new UserProfileHelper().getFaculty();    	 
	    		    	for(UserProfile faculty : facultyList) {
	    			    		facultyName.getItems().add(faculty.getFirstName());
	    		    	}
	    		    	EventHandler<ActionEvent> eventCreatedBy = new EventHandler<ActionEvent>() { 
	    		            public void handle(ActionEvent e) { 
	    		            	int index = facultyName.getItems().indexOf(facultyName.getValue());
	    		            	facultySkillsId = facultyList.get(index).getUserId();
	    		            	String description = facultyList.get(index).getFirstName();
	    		            }
	    		        }; 	
	    		        facultyName.setOnAction(eventCreatedBy);        
	    		    	/*******************************************************/
	    		    	EventHandler <ActionEvent> eventLaunchButton = new EventHandler<ActionEvent>() {
	    					@Override
	    					public void handle(ActionEvent event) {
	    		            	Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
	    		            	Parent myNewScene;
	    		            	try {
	    		            		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/BatchLauncher.fxml"));
	    		            		myNewScene = loader.load();
	    		            		BatchLauncherController attendanceScreenController = loader.getController();			
	    		            		ArrayList<String> dataForAttendanceScreen = new ArrayList<String>();
	    		            		attendanceScreenController.setStudentDetail(course, registeredStudentsCourseMap, enquiredStudentsCourseMap);
	    		            		Scene scene = new Scene(myNewScene);
	    		                	stage.setScene(scene);
	    		                	stage.setTitle("Attendance Records");
	    		                	stage.show();
	    		            	} catch (IOException ee) {
	    		            		ee.printStackTrace();
	    		            	}
	    		            }	
	    				};
	    		        launchButton.setOnAction(eventLaunchButton); 	
	    		    	/*******************************************************/ 
	    	    			   	    			    	                
	    	            rowNumber = getTimewiseNumberOfStudents(course, segmentType, 4, availableTime, false, facultyName, launchButton);		    	            
	    	            
	            	}
	    	   	}
            	
//	    	    for(Course course : enquiredStudentsCourseMap.keySet()) {
//	    	    	int innerCount=0;
//	     			if(course.getCourseTypeId() == courseTypeNameId) {
////	    	   			ArrayList<EnquiryDetails> studentDetailsList = enquiredStudentsCourseMap.get(course);
////	    	    		System.out.println("Enquired Students : "+course.getCourseName());
//	    	    		for(EnquiryDetails enquiryDetails : enquiredStudentsCourseMap.get(course)) { 
////	    	    			System.out.println("For Loop : ");
//	    	    			innerCount ++; 
////	    	    			System.out.println(innerCount);
////	    	    			System.out.println(enquiryDetails.getFirstName()+"  "+enquiryDetails.getSegmentTypeId()+"  "+enquiryDetails.getTimeSlotsId());
////	    	    			System.out.println();
//	    	    		}
//	    	    		for (PriorityListOfCoursesWrapper coursesWrapper : priorityListOfCoursesWrapperList) {//accessing the prev 
//	    	    			if(coursesWrapper.getCourseId() == course.getCourseId()) {
//	    	    				coursesWrapper.setNoOfStudents(innerCount+coursesWrapper.getNoOfStudents());
//	    	    				coursesWrapper.setTotalRevenue(coursesWrapper.getNoOfStudents()*course.getCourseFees());
//	    	    				break;
//	    	    			}
//	    	    		}
//	    	    	}
//	    	    }	    	    		
            	
	    	    data =FXCollections.observableArrayList(priorityListOfCoursesWrapperList);
	    	    priorityCoursesListTable.setItems(data);      
	    	   
            }                  
        }; 	
        courseType.setOnAction(eventCourseType);

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

    public int getTimewiseNumberOfStudents(Course course, SegmentType segmentType, Integer timeSlotId,
    		ChoiceBox<String> availableTime, boolean isRowToBeRemoved, ChoiceBox<String> facultyName, Button launchButton) {    // 1,2,3,4	
    	
    	int rowNumber = Integer.parseInt(availableTime.getId());
    
    	if(course.getCourseTypeId()==courseTypeNameId) {
    		count = 0; 
    		
			ArrayList<UserCoursesDoneWrapper> studentDetailsList = registeredStudentsCourseMap.get(course);
			System.out.println("User Profile : "+course.getCourseName()+" RowNumber : "+availableTimeId);
			
	        
				for(UserCoursesDoneWrapper userCoursesDoneWrapper : studentDetailsList){
					if(userCoursesDoneWrapper.getUserProfile().getSegmentTypeId() == segmentType.getSegmentTypeId()) {
							count++;
			        	System.out.println(userCoursesDoneWrapper.getUserProfile().getFirstName()
			        			+"   "+userCoursesDoneWrapper.getUserProfile().getSegmentTypeId()
			        			+"   "+userCoursesDoneWrapper.getUserProfile().getTimeSlotsId());
			        	
			        	HashSet<Integer> timeSlotsIdsSet = new HashSet<Integer>();
			        	String timeSlotsIdString = userCoursesDoneWrapper.getUserProfile().getTimeSlotsId();
						StringTokenizer st = new StringTokenizer(timeSlotsIdString,",");
						while(st.hasMoreTokens()) {
							int timeSlotIdOfStudent=Integer.parseInt(st.nextToken());
							timeSlotsIdsSet.add(timeSlotIdOfStudent);	
						} 
						
						for(Integer id : timeSlotsIdsSet) {
							if(timeSlotId == id || id == 4) {
								timeWiseCount++;
							}								
						}
					}
				}	  

				String ratioOfCount = timeWiseCount +"/"+count;
				String ratioOfRevenue = timeWiseCount*course.getCourseFees() +"/"+count*course.getCourseFees();
				System.out.println("Time Wise Count : "+timeWiseCount);
				System.out.println("ratio : "+ratioOfCount);
		        EnquiryDetails startDate = new EnquiryDetailsDao().getStartDate();
				Date date = startDate.getStartDate();
				
				System.out.println("*****("+availableTime.getId());

				PriorityListOfCoursesWrapper priorityListOfCoursesWrapperRow = new PriorityListOfCoursesWrapper(course.getCourseId()
		        		,course.getCourseName(),course.getCourseTypeId() , segmentType.getSegmentTypeName(), availableTime,
		        		ratioOfCount, date, facultyName,
		        		ratioOfRevenue, launchButton);
				 			
				if( isRowToBeRemoved ) {
					System.out.println("############"+availableTime.getId());
					priorityListOfCoursesWrapperList.remove(Integer.parseInt(availableTime.getId()));			
					priorityListOfCoursesWrapperList.add(Integer.parseInt(availableTime.getId()), priorityListOfCoursesWrapperRow);
				}else {
					System.out.println("Else : "+availableTime.getId());
					priorityListOfCoursesWrapperList.add(priorityListOfCoursesWrapperRow);	
					rowNumber++;
				}
		        
		        
		        data =FXCollections.observableArrayList(priorityListOfCoursesWrapperList);
		        
		        priorityCoursesListTable.setItems(data);      
		        
		        timeWiseCount = 0;

    	}
    	return rowNumber;
    }
}









