package com.winpoint.common.beans;

import java.util.Date;

import javafx.scene.control.Button;

/**
 * @author shraddhapadalkar
 *
 */

public class EnquiryDetails extends UserProfile {
	
	public Integer enquiryId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String address;
	private Date birthDate;
	private String college;
	private String degree;
	private String branch;
	private String occupation;
	private String organisation;
	private String designation;
	private String domain;
	private String role;
	private Integer experience;
	private Integer createdBy;
	private Date dateOfEnquiry;
	private String gender;
	private Integer yearOfGraduation;
	private String recommendation;
	private Boolean eligibility;
	private String coursesInterestedIn;
	private String reference;
	private Integer timeSlotsId;
	private String courseAlreadyDone;
	private Date startDate;
	private Integer segmentTypeId;
	private String suggestion;
	private Boolean activeStatus;

	private String student;
	
	private String enquired;
	private String registered;
	

	public String getEnquired() {
		return enquired;
	}

	public void setEnquired(String enquired) {
		this.enquired = enquired;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

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
	
	public EnquiryDetails(String student) {
		this.setStudent(student);
	}
	

	public EnquiryDetails(Integer enquiryId, String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, String occupation,
			String organisation, String designation, String domain, String role, Integer experience, Integer createdBy,
			Date dateofEnquiry, String gender, Integer yearOfGraduation, String recommendation, Boolean eligibility,
			String coursesInterestedIn, String reference, Integer timeSlotsId, String courseAlreadyDone,
			Date startDate, Integer segmentTypeId, String suggestion, Boolean activeStatus) {
		super();
		this.enquiryId = enquiryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = email;
		this.mobileNo = mobileNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.createdBy = createdBy;
		this.dateOfEnquiry = dateofEnquiry;
		this.gender = gender;
		this.yearOfGraduation = yearOfGraduation;
		this.recommendation = recommendation;
		this.eligibility = eligibility;
		this.coursesInterestedIn = coursesInterestedIn;
		this.reference = reference;
		this.timeSlotsId = timeSlotsId;
		this.courseAlreadyDone = courseAlreadyDone;
		this.startDate = startDate;
		this.segmentTypeId = segmentTypeId;
		this.suggestion = suggestion;
		this.activeStatus = activeStatus;
	}	


	public EnquiryDetails(String firstName, String lastName, String email, String mobileNumber, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = email;
		this.mobileNo = mobileNumber;
		this.address = address;
	}


	public EnquiryDetails(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public EnquiryDetails(String firstName, String lastName, String coursesInterestedIn,boolean eligibility,String suggestion) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.coursesInterestedIn = coursesInterestedIn;
		this.eligibility = eligibility;
		this.suggestion = suggestion;
	} 

	
	public EnquiryDetails(String firstName, String lastName, String emailId, String mobileNo, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			Integer coursesInterestedIn, String courseAlreadyDone, Boolean activeStatus) {
		
		// TODO Auto-generated constructor stub
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.gender = gender;
		this.yearOfGraduation = yearOfGraduation;
		this.courseAlreadyDone = courseAlreadyDone;
		this.activeStatus = activeStatus;
	
	}

	public EnquiryDetails(String firstName, String lastName, String email, String mobileNumber, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			String coursesInterestedIn, String coursesAlreadyDone, Boolean activeStatus) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = email;
		this.mobileNo = mobileNumber;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.gender = gender;
		this.yearOfGraduation = yearOfGraduation;
		this.coursesInterestedIn = coursesInterestedIn;
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the enquiryId
	 */
	public Integer getEnquiryId() {
		return enquiryId;
	}

	
	/**
	 * @param enquiryId the enquiryId to set
	 */
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return emailId;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.emailId = email;
	}


	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNo;
	}


	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNo = mobileNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}


	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the organization
	 */
	public String getOrganisation() {
		return organisation;
	}

	/**
	 * @param organisation the organization to set
	 */
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}


	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}


	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the yearOfGraduation
	 */
	public Integer getYearOfGraduation() {
		return yearOfGraduation;
	}


	/**
	 * @param yearOfGraduation the yearOfGraduation to set
	 */
	public void setYearOfGraduation(Integer yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
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
	 * @return the timeSlotsId
	 */
	public Integer getTimeSlotsId() {
		return timeSlotsId;
	}

	/**
	 * @param timeSlotsId the timeSlotsId to set
	 */
	public void setTimeSlotsId(Integer timeSlotsId) {
		this.timeSlotsId = timeSlotsId;
	}

	/**
	 * @return the courseAlreadyDone
	 */
	public String getCourseAlreadyDone() {
		return courseAlreadyDone;
	}

	/**
	 * @param courseAlreadyDone the courseAlreadyDone to set
	 */
	public void setCourseAlreadyDone(String courseAlreadyDone) {
		this.courseAlreadyDone = courseAlreadyDone;
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
	 * @return the segmentTypeId
	 */
	public Integer getSegmentTypeId() {
		return segmentTypeId;
	}

	/**
	 * @param segmentTypeId the segmentTypeId to set
	 */
	public void setSegmentTypeId(Integer segmentTypeId) {
		this.segmentTypeId = segmentTypeId;
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

	/**
	 * @return the activeStatus
	 */
	public Boolean getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	public String getStudent() {
		return student;
	}


	public void setStudent(String student) {
		this.student = student;
	}

	
	
	

}
