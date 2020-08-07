package com.winpoint.common.beans;

import java.util.Date;

/**
 * @author shraddhapadalkar
 *
 */

public class EnquiryDetails extends UserProfile {
	
	public Integer enquiryId;
	private Date dateOfEnquiry;
	private String recommendation;
	private Boolean eligibility;
	private String coursesInterestedIn;
	private String reference;
	private Date startDate;
	private String suggestion;


	/**
	@param enquiryId;
	@param firstName;
	@param lastName;
 	@param email;
	@param mobileNumber;
	@param address;
	@param birthDate;
	@param college;
	@param degree;
	@param branch;
	@param occupation;
	@param organisation;
	@param designation;
	@param domain;
	@param role;
	@param experience;
	@param createdBy;
	@param dateofEnquiry;
	@param gender;
	@param yearOfGraduation;
	@param recommendation;
	@param eligibility;
	@param coursesInterestedIn;
	@param reference;
	@param timeSlotsId;
	@param courseAlreadyDone;
	@param startDate;
	@param segmentTypeId;
	@param suggestion;
	@param activeStatus;
	*/	
	
	public EnquiryDetails(String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, String occupation,
			String organisation, String designation, String domain, String role, Integer experience, Integer createdBy,
			Date dateofEnquiry, String gender, Integer yearOfGraduation, String recommendation, Boolean eligibility,
			String coursesInterestedIn, String reference, String timeSlotsId, String courseAlreadyDone,
			Date startDate, Integer segmentTypeId, String suggestion, Boolean activeStatus) {
		super(firstName,lastName,email,mobileNumber,address,birthDate,college,degree,branch,occupation,
				organisation,designation,domain,role,experience,createdBy,gender,yearOfGraduation,
				timeSlotsId,courseAlreadyDone,segmentTypeId,activeStatus);

		this.dateOfEnquiry = dateofEnquiry;
		this.recommendation = recommendation;
		this.eligibility = eligibility;
		this.coursesInterestedIn = coursesInterestedIn;
		this.reference = reference;
		this.startDate = startDate;
		this.suggestion = suggestion;
		}	


	public EnquiryDetails(String firstName, String lastName, String email, String mobileNumber, String address) {
		super(firstName, lastName, email, mobileNumber, address);
	}


	public EnquiryDetails(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		super(firstName,lastName);
	}

	public EnquiryDetails(int enquiryId, String firstName, String lastName, String coursesInterestedIn,boolean eligibility,String suggestion) {
		// TODO Auto-generated constructor stub
		super(firstName,lastName);
		this.enquiryId = enquiryId;
		this.coursesInterestedIn = coursesInterestedIn;
		this.eligibility = eligibility;
		this.suggestion = suggestion;
	} 

	
	public EnquiryDetails(Integer enquiryId, String firstName, String lastName, String emailId, String mobileNo, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			Integer coursesInterestedIn, String courseAlreadyDone, Boolean activeStatus) {
		
		// TODO Auto-generated constructor stub
	
		
		super(firstName,lastName,emailId,
				mobileNo,college,degree,branch,occupation,
				organisation,designation,domain,role,experience,gender,yearOfGraduation,courseAlreadyDone,activeStatus);
		this.enquiryId = enquiryId;
			
	}

	public EnquiryDetails(String firstName, String lastName, String email, String mobileNumber, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			String coursesInterestedIn, String coursesAlreadyDone, Boolean activeStatus) {
		
		super(firstName,lastName,email,mobileNumber,college,degree,branch,occupation,organisation,designation
				,domain,role,experience,gender,yearOfGraduation,activeStatus);

		this.coursesInterestedIn = coursesInterestedIn;
	}


	/**
	 * @return the enquiryId
	 */
	public Integer getEnquiryId() {
		return enquiryId;
	}

	public EnquiryDetails(
			Integer enquiryId, 
			String firstName2,
			String lastName2, 
			String emailId, 
			String mobileNo, 
			String address2, 
			Date birthDate2, 
			String college2,			
			String degree2, 
			String branch2, 
			String occupation2, 
			String organisation2, 
			String designation2,
			String domain2, 
			String role2, 
			Integer experience2, 
			Integer createdBy2, 
			Date dateOfEnquiry, 
			String gender,
			Integer yearOfGraduation2, 
			String recommendation, 
			Boolean eligibility, 
			String coursesInterestedIn,
			String reference, 
			String timeSlotsId, 
			String courseAlreadyDone, 
			Date startDate, 
			Integer segmentTypeId,
			String suggestion, 
			Boolean activeStatus) {

		super(firstName2,lastName2,emailId,mobileNo,address2,birthDate2,college2,degree2,branch2,occupation2,organisation2,designation2
				,domain2,role2,experience2,createdBy2,gender,yearOfGraduation2,timeSlotsId,courseAlreadyDone,segmentTypeId,activeStatus);
		
		this.enquiryId = enquiryId;
		this.dateOfEnquiry = dateOfEnquiry;
		this.recommendation = recommendation;
		this.eligibility = eligibility;
		this.coursesInterestedIn = coursesInterestedIn;
		this.reference = reference;
		this.startDate = startDate;
		this.suggestion = suggestion;
		
	}

	// new for update Screen
	public EnquiryDetails(Integer enquiryId, String firstName1, String lastName1, String emailId1, String mobileNo1,
			String college1, String degree1, String branch1, String occupation1, String organisation1,
			String designation1, String domain1, String role1, Integer experience1, String gender1,
			Integer yearOfGraduation1, String coursesInterestedIn1, String coursesAlreadyDone1,String suggestion1, Boolean activeStatus1) {
		// TODO Auto-generated constructor stub
		super(firstName1,lastName1,emailId1,mobileNo1,college1,degree1,branch1,occupation1,organisation1,designation1,
				domain1,role1,experience1,gender1,yearOfGraduation1,coursesAlreadyDone1,coursesAlreadyDone1,activeStatus1);
		this.enquiryId = enquiryId;
		this.coursesInterestedIn = coursesInterestedIn1;
		this.suggestion = suggestion1;
	}
	
	
//	"SELECT ENQUIRY_ID,FIRST_NAME,LAST_NAME,EMAIL_ID,MOBILE_NO,\n" + 
//	"ELIGIBILITY,COURSE_INTERESTED_IN,TIME_SLOTS_ID,COURSE_ALREADY_DONE,\n" + 
//	" SEGMENT_TYPE_ID FROM ENQUIRY_DETAILS\n" + 
//	"WHERE ACTIVE_STATUS = 1"; 


	public EnquiryDetails(int enquiryId, String firstName, String lastName, String emailId, Date birthDate, String mobileNo, Boolean eligibility,
			String coursesInterestedIn, String timeSlotsId, String coursesAlreadyDone, int segmetTypeId) {
		super(firstName,lastName,emailId,birthDate,mobileNo,timeSlotsId,coursesAlreadyDone,segmetTypeId);
		this.enquiryId= enquiryId;
		this.eligibility=eligibility;
		this.coursesInterestedIn=coursesInterestedIn;	
	}


	public EnquiryDetails(String coursesInterestedIn2, Boolean eligibility2) {
		// TODO Auto-generated constructor stub
		this.coursesInterestedIn = coursesInterestedIn2;
		this.eligibility = eligibility2;
	}


	public EnquiryDetails() {
		// TODO Auto-generated constructor stub
	}


	public EnquiryDetails(java.sql.Date startDate) {
		// TODO Auto-generated constructor stub
		this.startDate = startDate;
	}


	/**
	 * @param enquiryId the enquiryId to set
	 */
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	/**
	 * @return the dateofEnquiry
	 */
	public Date getDateofEnquiry() {
		return dateOfEnquiry;
	}

	/**
	 * @param dateofEnquiry the dateofEnquiry to set
	 */
	public void setDateofEnquiry(Date dateofEnquiry) {
		this.dateOfEnquiry = dateofEnquiry;
	}

	/**
	 * @return the recommendation
	 */
	public String getRecommendation() {
		return recommendation;
	}

	/**
	 * @param  recommendation the  recommendation to set
	 */
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	/**
	 * @return the eligibility
	 */
	public Boolean getEligibility() {
		return eligibility;
	}

	/**
	 * @param eligibility the eligibility to set
	 */
	public void setEligibility(Boolean eligibility) {
		this.eligibility = eligibility;
	}

	/**
	 * @return the coursesInterestedIn
	 */
	public String getCoursesInterestedIn() {
		return coursesInterestedIn;
	}

	/**
	 * @param coursesInterestedIn the coursesInterestedIn to set
	 */
	public void setCoursesInterestedIn(String coursesInterestedIn) {
		this.coursesInterestedIn = coursesInterestedIn;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the  suggestion
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * @param suggestion the suggestion to set
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

}
