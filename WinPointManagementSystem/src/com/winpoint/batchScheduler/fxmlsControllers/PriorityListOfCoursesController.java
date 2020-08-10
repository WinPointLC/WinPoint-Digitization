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
import com.winpoint.common.beans.FacultySkills;
import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.beans.TimeSlots;
import com.winpoint.common.beans.UserProfile;
import com.winpoint.common.controllers.ParentFXMLController;
import com.winpoint.common.dao.EnquiryDetailsDao;
import com.winpoint.common.helpers.BatchDetailsHelper;
import com.winpoint.common.helpers.CourseTypeHelper;
import com.winpoint.common.helpers.FacultySkillsHelper;
import com.winpoint.common.helpers.PriorityCoursesListHelper;
import com.winpoint.common.helpers.SegmentTypeHelper;
import com.winpoint.common.helpers.TimeSlotsHelper;
import com.winpoint.common.helpers.UserProfileHelper;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PriorityListOfCoursesController extends ParentFXMLController{
		
		boolean doLaunch = false;
		private String descriptionForPreferedTime;
		private String descriptionForFacultyName;
		private Integer courseTypeNameId;
		private Integer timeSlotsId;
		private Integer facultyUserId;
				
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

	    @FXML
	    private ChoiceBox<String> courseType;
	    
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
	    	
	    	for(Course course : registeredStudentsCourseMap.keySet()) {	    		
	    		ArrayList<UserCoursesDoneWrapper> registeredList = new ArrayList<UserCoursesDoneWrapper>(registeredStudentsCourseMap.get(course));	
	    		totalEligibleStudentCourseMap.put(course,registeredList);
	    	}	
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
		                      	
		           		for(SegmentType segmentType : segmentTypeList) {
		           				           			
		           			count = 0;
		    	    		timeWiseCount = 0;
		    	    		
		    	    		Button launchButton = new Button("Launch");
		    	    		
		    	    		Hyperlink numberOfStudent = new Hyperlink();
		    	    		
		    	    		ChoiceBox<String> facultyName = null;
		    
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
		    	
		    	                	ChoiceBox<String> facultyName = new ChoiceBox<String>();
		    	    				//Faculty Ids Choice Box :
		    	    		    	List<UserProfile> facultyList = new UserProfileHelper().getFaculty();    	 
		    	    		    	List<FacultySkills> userIdList = new FacultySkillsHelper().getAvailableFaculty(timeSlotsId,course.getCourseId());
		    	    		    	
		    	    		    	
		    	    		    	for(UserProfile faculty : facultyList) {
		    	    	            	for(FacultySkills id : userIdList) {
		    	    	            		int User = faculty.getUserId();
		    	    	            		int id1 = id.getUserId();
		    	    	            		if(User==id1) {
		    	    	            			facultyName.getItems().add(faculty.getFirstName());
		    	    	            			break;
		    	    	            		}
		    	    	            	}
		    	    	            }	    	    	         
		    	    	            
		    	    		    	EventHandler<ActionEvent> eventCreatedBy = new EventHandler<ActionEvent>() { 
		    	    		            public void handle(ActionEvent e) { 
		    	    		            	int index = facultyName.getItems().indexOf(facultyName.getValue());
		    	    		            	descriptionForFacultyName = facultyName.getValue();
		    	    		            	facultyUserId = userIdList.get(index).getUserId();
		    	    		            }
		    	    		        }; 	
		    	    		        facultyName.setOnAction(eventCreatedBy);        
		    	    		    	/*******************************************************/
		    	                   	
		    	                    getTimewiseNumberOfStudents(course, segmentType, timeSlotsId, availableTime, true, facultyName, launchButton, numberOfStudent);
		    	                    	      	                    	
		    	                 }
		    	            }; 	
		    	            availableTime.setOnAction(eventAvailable);
		    	            // Launch Button Event Handler	    	           
		    		    	EventHandler <ActionEvent> eventLaunchButton = new EventHandler<ActionEvent>() {
		    					@Override
		    					public void handle(ActionEvent event) {
		    						boolean batchExist = new BatchDetailsHelper().doBatchExist(course.getCourseId(),timeSlotsId,facultyUserId,segmentType.getSegmentTypeId());
		    						if(!batchExist) {
		    							doLaunch = true;
			    		            	Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			    		            	Parent myNewScene;
			    		            	try {
			    		            		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../batchScheduler/fxmls/BatchLauncher.fxml"));
			    		            		myNewScene = loader.load();			    		            		
			    		            		
			    		            		BatchLauncherController batchLauncherController = loader.getController();	
			    		            				    	    					
			    	    					Course courseEnquiry = null;
			    	    					
			    	    					for(Course courseEnquiry1 : enquiredStudentsCourseMap.keySet()) {
			    	    						
			    	    						if(courseEnquiry1.getCourseId()==course.getCourseId()) {
			    	    							courseEnquiry = courseEnquiry1;
			    	    							break;
			    	    						}			    	    	            	
			    	    	            	}

			    		            		batchLauncherController.setBatchDetail(		    		            				
			    		            				course, 
			    		            				registeredStudentsCourseMap.get(course), 
			    	    							enquiredStudentsCourseMap.get(courseEnquiry),
			    	    							segmentType,	    		            				
			    		            				descriptionForPreferedTime,
			    		            				descriptionForFacultyName);
			    		            		
			    		            		Scene scene = new Scene(myNewScene);
			    		                	stage.setScene(scene);
			    		                	stage.setTitle("Attendance Records");
			    		                	stage.show();
			    		            	} catch (IOException ee) {
			    		            		ee.printStackTrace();
			    		            	}
			    		            }
		    						else {
		    							Stage stage = (Stage) launchButton.getScene().getWindow();
		    					    	Parent myNewScene;
		    							try {
		    								myNewScene = FXMLLoader.load(getClass().getResource("../../batchScheduler/fxmls/ExistBatchPopUpWindow.fxml"));
		    								Scene scene = new Scene(myNewScene);
		    						    	stage.setScene(scene);
		    						    	stage.setTitle("My New Scene");
		    						    	stage.show();
		    							} catch (IOException e) {
		    								e.printStackTrace();
		    							}
		    						}
		    					}
		    				};
		    				launchButton.setOnAction(eventLaunchButton); 
		    		    	/*******************************************************/ 
		    		        // Hyper Link for the Number of the Student : 	    		        
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
		    	    					numberOfStudentsController.displayBatchDetails(
		    	    							registeredStudentsCourseMap.get(course), 
		    	    							enquiredStudentsCourseMap.get(courseEnquiry));
		    	    					
		    	    	            	
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

    public void start(final Stage primaryStage) {
	    Button btn = new Button();
	    btn.setText("Open Dialog");
	    btn.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().add(new Text("This is a Dialog"));
	                Scene dialogScene = new Scene(dialogVbox, 300, 200);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    }
    
    public int getTimewiseNumberOfStudents(Course course, SegmentType segmentType, Integer timeSlotId,
    		ChoiceBox<String> availableTime, boolean isRowToBeRemoved, ChoiceBox<String> facultyName, Button launchButton, Hyperlink numberOfStudent) {    // 1,2,3,4	
    	
    	int rowNumber = Integer.parseInt(availableTime.getId());
    
    	if(course.getCourseTypeId()==courseTypeNameId) {
    		count = 0; 
    		
			ArrayList<UserCoursesDoneWrapper> studentDetailsList = totalEligibleStudentCourseMap.get(course);

				for(UserCoursesDoneWrapper userCoursesDoneWrapper : studentDetailsList){
					if(userCoursesDoneWrapper.getUserProfile().getSegmentTypeId() == segmentType.getSegmentTypeId()) {
							count++;

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
				EnquiryDetails startDate = new EnquiryDetailsDao().getStartDate();
				Date date = startDate.getStartDate();
			
				numberOfStudent.setText(ratioOfCount);
				
				PriorityListOfCoursesWrapper priorityListOfCoursesWrapperRow = new PriorityListOfCoursesWrapper(course.getCourseId()
		        		,course.getCourseName(),course.getCourseTypeId() , segmentType.getSegmentTypeName(), availableTime,
		        		numberOfStudent, date, facultyName,
		        		ratioOfRevenue, launchButton);
				 			
				if( isRowToBeRemoved ) {
					priorityListOfCoursesWrapperList.remove(Integer.parseInt(availableTime.getId()));			
					priorityListOfCoursesWrapperList.add(Integer.parseInt(availableTime.getId()), priorityListOfCoursesWrapperRow);
				}else {
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









