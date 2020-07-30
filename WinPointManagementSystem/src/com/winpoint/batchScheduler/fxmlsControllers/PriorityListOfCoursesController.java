package com.winpoint.batchScheduler.fxmlsControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PriorityListOfCoursesController extends ParentFXMLController{
		
	
		private String descriptionForPreferedTime;
		private String descriptionForFacultyName;
		private Integer courseTypeNameId;
		private Integer availableTimeId = 1;
		private Integer segmentTypeId = 1;
		private Integer timeSlotsId;
		private Integer facultySkillsId;
				
		ObservableList<PriorityListOfCoursesWrapper> data;		
		
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>> registeredStudentsCourseMap;
		
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>> enquiredStudentsCourseMap;
		
		HashMap<Course, ArrayList<UserCoursesDoneWrapper>> totalEligibleStudentCourseMap;

		
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
    	
    	    	
    	totalEligibleStudentCourseMap = new HashMap<Course, ArrayList<UserCoursesDoneWrapper>>();
    	
    	totalEligibleStudentCourseMap.putAll(registeredStudentsCourseMap);
    	
    	

    	HashMap<Course, ArrayList<UserCoursesDoneWrapper>> tempMap = new HashMap<Course, ArrayList<UserCoursesDoneWrapper>>();
    	    	
    	
    	for(Course courseEnquiry : enquiredStudentsCourseMap.keySet()) {
    		boolean courseFound = false;
    		for(Course course : totalEligibleStudentCourseMap.keySet()) {
	    		if(course.getCourseId() == courseEnquiry.getCourseId()) {
	    			
	    			totalEligibleStudentCourseMap.get(course).addAll(enquiredStudentsCourseMap.get(courseEnquiry));	    			
                    courseFound = true;
                    break;
	    		}	   
    		}
            if(!courseFound)
            tempMap.put(courseEnquiry,enquiredStudentsCourseMap.get(courseEnquiry));
    	}
    	totalEligibleStudentCourseMap.putAll(tempMap);
    	
    	System.out.println("Total Size : "+totalEligibleStudentCourseMap.size());
    	System.out.println("Registered Size : "+registeredStudentsCourseMap.size());
    	System.out.println("Enquired Size : "+enquiredStudentsCourseMap.size());
    	
    	
    	//Course Type choice box : 
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

	            for(Course course : totalEligibleStudentCourseMap.keySet()) {  	
	            	
	            	
	            	for(Course courseEnquiry : enquiredStudentsCourseMap.keySet()) {
	            		System.out.println("Enquiry Course Name : "+courseEnquiry.getCourseName());	            	
		            	System.out.println("Enquiry Size : "+enquiredStudentsCourseMap.get(courseEnquiry).size());
		            	System.out.println("Enquiry Data : "+enquiredStudentsCourseMap.get(courseEnquiry));
	            	}
	            		            	
	           		for(SegmentType segmentType : segmentTypeList) {
	           				           			
	           			count = 0;
	    	    		timeWiseCount = 0;
	    	    		
	    	    		Button launchButton = new Button("Launch");
	    	    		
	    	    		Hyperlink numberOfStudent = new Hyperlink();
	    	    		
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
	    	                   	descriptionForPreferedTime = timeSlotsList.get(index).getTimeSlotsDescription();
	    	
	    	                    getTimewiseNumberOfStudents(course, segmentType, timeSlotsId, availableTime, true, facultyName, launchButton, numberOfStudent);
	    	                    	      	                    	
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
	    		            	descriptionForFacultyName = facultyList.get(index).getFirstName();
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
	    		            		BatchLauncherController batchLauncherController = loader.getController();			
	    		            		ArrayList<String> dataForAttendanceScreen = new ArrayList<String>();
	    		            		batchLauncherController.setStudentDetail(course, totalEligibleStudentCourseMap, descriptionForPreferedTime, descriptionForFacultyName);
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
	    		        // Hyper Link for the Number of the Student : 
	    		        
	    		        
//	    		        NumberOfStudentsController numberOfStudentsController = loader.getController();			
//	            		numberOfStudentsController.displayBatchDetails(course ,totalEligibleStudentCourseMap);
//	            		
	    		        
	    		        EventHandler <ActionEvent> eventNumberOfStudent = new EventHandler<ActionEvent>() {
	    					@Override
	    					public void handle(ActionEvent e) 
	    	                { 
	    	                    Parent myNewScene = null;
	    	    				try {
	    	    					FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/NumberOfStudents.fxml"));
	    	    					myNewScene = loader.load();
	    	    					
	    	    					NumberOfStudentsController numberOfStudentsController = loader.getController();
	    	    					
	    	    					Course courseEnquiry = null;
	    	    					
	    	    					for(Course courseEnquiry1 : enquiredStudentsCourseMap.keySet()) {
	    	    						
	    	    						if(courseEnquiry1.getCourseId()==course.getCourseId()) {
	    	    							courseEnquiry = courseEnquiry1;
	    	    							break;
	    	    						}
	    	    	            	
	    	    	            	}
	    	    					System.out.println("Size of registered Array List : "+registeredStudentsCourseMap.get(course).size());
	    	 	            		numberOfStudentsController.displayBatchDetails(registeredStudentsCourseMap.get(course), enquiredStudentsCourseMap.get(courseEnquiry));
	    	    					
	    	    	            	
	    	    				} catch (IOException e1) {
	    	    					e1.printStackTrace();
	    	    				}
	    	                	Stage stage = (Stage) numberOfStudent.getScene().getWindow();
	    	                	Scene scene = new Scene(myNewScene);
	    	                	stage.setScene(scene);
	    	                	stage.setTitle("Main Scene");
	    	                	stage.show();
	    	                } 
	    				};
	    				numberOfStudent.setOnAction(eventNumberOfStudent); 	
	    	    			   	    			    	                
	    	            rowNumber = getTimewiseNumberOfStudents(course, segmentType, 4, availableTime, false, facultyName, launchButton, numberOfStudent);		    	            
	    	            
	            	}
	    	   	}	    	    		
            	
	    	    data =FXCollections.observableArrayList(priorityListOfCoursesWrapperList);
	    	    priorityCoursesListTable.setItems(data);      
	    	   
            }                  
        }; 	
        courseType.setOnAction(eventCourseType);

    	coursesCol.setCellValueFactory(new PropertyValueFactory<>("Course"));
    	segmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("SegmentType"));
    	avaialbleTimeCol.setCellValueFactory(new PropertyValueFactory<>("AvailableTime"));
    	noOfStudentsCol.setCellValueFactory(new PropertyValueFactory<>("NumberOfStudentsLink"));
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
    		ChoiceBox<String> availableTime, boolean isRowToBeRemoved, ChoiceBox<String> facultyName, Button launchButton, Hyperlink numberOfStudent) {    // 1,2,3,4	
    	
    	int rowNumber = Integer.parseInt(availableTime.getId());
    
    	if(course.getCourseTypeId()==courseTypeNameId) {
    		count = 0; 
    		
			ArrayList<UserCoursesDoneWrapper> studentDetailsList = totalEligibleStudentCourseMap.get(course);
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

				numberOfStudent.setText(ratioOfCount);
				
				PriorityListOfCoursesWrapper priorityListOfCoursesWrapperRow = new PriorityListOfCoursesWrapper(course.getCourseId()
		        		,course.getCourseName(),course.getCourseTypeId() , segmentType.getSegmentTypeName(), availableTime,
		        		numberOfStudent, date, facultyName,
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









