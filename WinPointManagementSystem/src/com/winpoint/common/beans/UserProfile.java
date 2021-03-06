package com.winpoint.common.beans;

import java.util.Date;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class UserProfile {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String address;
	private Date birthDate;
	private String college;
	private String degree;
	private String branch;
	private Integer yearOfGraduation;
	private String photoLocation;
	private String password;
	private String gender;
	private Integer securityQuestionId;
	private String securityQuestion;
	private String securityAnswer;
	private Integer userCategoryId;
	private String occupation;
	private String organisation;
	private String designation;
	private String domain;
	private String role;
	private Integer experience;
	private Integer createdBy;
	private Date createDate;
	private String timeSlotsId;
	private Integer segmentTypeId;
	private String courseAlreadyDone;
	private Boolean activeStatus;
	
	

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param address
	 * @param birthDate
	 * @param college
	 * @param degree
	 * @param branch
	 * @param yearOfGraduation
	 * @param photoLocation
	 * @param password
	 * @param gender
	 * @param securityQuestionId
	 * @param securityAnswer
	 * @param userCategoryId
	 * @param occupation
	 * @param organisation
	 * @param designation
	 * @param domain
	 * @param role
	 * @param experience
	 * @param createdBy
	 * @param createDate
	 * @param photoLocation
	 * @param timeSlotsId
	 * @param segmentTypeId
	 * @param courseAlreadyDone
	 * @param activeStatus
	 */
	
	public UserProfile(
			int userId,
			String firstName, 
			String lastName, 
			String email, 
			String mobileNumber,
			String address,
			java.sql.Date birthDate, 
			String college, 
			String degree, 
			String branch,
			String photoLocation, 
			String password,
			int securityQuestionId, 
			String securityAnswer,
			int userCategoryId, 
			String occupation,
			String organisation, 
			String designation, 
			String domain,
			String role, 
			int experience, 
			int createdBy,
			java.sql.Date createDate,
			String gender, 
			int yearOfGraduation, 
			String timeSlotsId,
			int segmentTypeId, 
			String courseAlreadyDone, 
			boolean activeStatus) {
		// TODO Auto-generated constructor stub
		
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.yearOfGraduation = yearOfGraduation;
		this.photoLocation = photoLocation;
		this.password = password;
		this.gender = gender;
		this.securityQuestionId = securityQuestionId;
		this.securityAnswer = securityAnswer;
		this.userCategoryId = userCategoryId;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.createdBy = createdBy;
		this.createDate = createDate;
		this.timeSlotsId = timeSlotsId;
		this.segmentTypeId = segmentTypeId;
		this.courseAlreadyDone = courseAlreadyDone;
		this.activeStatus = activeStatus;
		
		
	}
	
	
		public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, Integer yearOfGraduation,
			String photoLocation, String password, String gender, Integer securityQuestionId, String securityQuestion,
			String securityAnswer, Integer userCategoryId, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, Integer createdBy, Date createDate, String timeSlotsId,
			Integer segmentTypeId, String courseAlreadyDone, Boolean activeStatus) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.yearOfGraduation = yearOfGraduation;
		this.photoLocation = photoLocation;
		this.password = password;
		this.gender = gender;
		this.securityQuestionId = securityQuestionId;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.userCategoryId = userCategoryId;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.createdBy = createdBy;
		this.createDate = createDate;
		this.timeSlotsId = timeSlotsId;
		this.segmentTypeId = segmentTypeId;
		this.courseAlreadyDone = courseAlreadyDone;
		this.activeStatus = activeStatus;
	}

	
//	public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
//			String address, Date birthDate, String college, String degree, String branch, Integer yearOfGraduation,
//			String photoLocation, String password, String gender, Integer securityQuestionId, String securityQuestion,
//			String securityAnswer, Integer userCategoryId, String occupation, String organisation, String designation,
//			String domain, String role, Integer experience, Integer createdBy, Date createDate, String timeSlotsId,
//			Integer segmentTypeId, String courseAlreadyDone, Boolean activeStatus) {
//		super();
//		this.userId = userId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.mobileNumber = mobileNumber;
//		this.address = address;
//		this.birthDate = birthDate;
//		this.college = college;
//		this.degree = degree;
//		this.branch = branch;
//		this.yearOfGraduation = yearOfGraduation;
//		this.photoLocation = photoLocation;
//		this.password = password;
//		this.gender = gender;
//		this.securityQuestionId = securityQuestionId;
//		this.securityAnswer = securityAnswer;
//		this.userCategoryId = userCategoryId;
//		this.occupation = occupation;
//		this.organisation = organisation;
//		this.designation = designation;
//		this.domain = domain;
//		this.role = role;
//		this.experience = experience;
//		this.createdBy = createdBy;
//		this.createDate = createDate;
//		this.timeSlotsId = timeSlotsId;
//		this.segmentTypeId = segmentTypeId;
//		this.courseAlreadyDone = courseAlreadyDone;
//		this.activeStatus = activeStatus;
//	}
	
	public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, Integer yearOfGraduation,
			String photoLocation, String password, Integer securityQuestionId, String securityAnswer, Integer userCategoryId,
			String occupation, String organisation, String designation, String domain, String role, Integer experience,
			Integer createdBy, Date createDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.yearOfGraduation = yearOfGraduation;
		this.photoLocation = photoLocation;
		this.password = password;
		this.securityQuestionId = securityQuestionId;
		this.securityAnswer = securityAnswer;
		this.userCategoryId = userCategoryId;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.createdBy = createdBy;
		this.createDate = createDate;
	}

	
	public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, Integer yearOfGraduation,
			String photoLocation, String password, String gender, Integer securityQuestionId, String securityQuestion,
			String securityAnswer, Integer userCategoryId, String occupation, String organisation, String designation,
			String domain, String role, Integer experience) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.birthDate = birthDate;
		this.college = college;
		this.degree = degree;
		this.branch = branch;
		this.yearOfGraduation = yearOfGraduation;
		this.photoLocation = photoLocation;
		this.password = password;
		this.gender = gender;
		this.securityQuestionId = securityQuestionId;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.userCategoryId = userCategoryId;
		this.occupation = occupation;
		this.organisation = organisation;
		this.designation = designation;
		this.domain = domain;
		this.role = role;
		this.experience = experience;
		this.createdBy = createdBy;
		this.createDate = createDate;
	}
	// Abhishek
	public UserProfile(String firstName, String lastName, int userId) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
	}


	public UserProfile(String firstName, String lastName, Boolean empty) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserProfile(Date birthDate, Integer userId, String firstName, String lastName, String email, String mobileNumber,
			Integer userCategoryId, String timeSlotsId, Integer segmentTypeId) {
		super();
		this.birthDate = birthDate;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.userCategoryId = userCategoryId;
		this.timeSlotsId = timeSlotsId;
		this.segmentTypeId = segmentTypeId;
	}
	
	
	// Anjali ma'am
	public UserProfile(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}

	public UserProfile(int userId, String firstName, String lastName, String email, int userCategoryId, String photoLocation) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userCategoryId = userCategoryId;
		this.photoLocation = photoLocation;
	}

public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
			String college) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.college = college;
	}


	
	
	

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String firstName, String lastName, String email, String mobileNumber, String address,
			Date birthDate, String college, String degree, String branch, String occupation, String organisation,
			String designation, String domain, String role, Integer experience, Integer createdBy, String gender,
			Integer yearOfGraduation, String timeSlotsId, String courseAlreadyDone, Integer segmentTypeId,
			Boolean activeStatus) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
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
		this.gender = gender;
		this.yearOfGraduation = yearOfGraduation;
		this.timeSlotsId = timeSlotsId;
		this.courseAlreadyDone = courseAlreadyDone;
		this.segmentTypeId = segmentTypeId;
		this.activeStatus = activeStatus;
		
		
		
	}
	
	public UserProfile(String firstName, String lastName, String email, String mobileNumber, String address) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		
	}

	public UserProfile(String firstName, String lastName, String emailId, String mobileNo, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			String courseAlreadyDone, Boolean activeStatus) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = emailId;
		this.mobileNumber = mobileNo;
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

	public UserProfile(String firstName, String lastName, String email, String mobileNumber, String college,
			String degree, String branch, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, String gender, Integer yearOfGraduation,
			Boolean activeStatus) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
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
		this.activeStatus = activeStatus;

	}

	public UserProfile(String firstName2, String lastName2, String emailId, String mobileNo, String address2,
			Date birthDate2, String college2, String degree2, String branch2, String occupation2, String organisation2,
			String designation2, String domain2, String role2, Integer experience2, Integer createdBy2, String gender2,
			Integer yearOfGraduation2, Integer timeSlotsId2, String courseAlreadyDone2, Integer segmentTypeId2,
			Boolean activeStatus2) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.email = emailId;
		this.mobileNumber = mobileNo;
		this.address = address2;
		this.birthDate = birthDate2;
		this.college = college2;
		this.degree = degree2;
		this.branch = branch2;
		this.occupation = occupation2;
		this.organisation = organisation2;
		this.designation = designation2;
		this.domain = domain2;
		this.role = role2;
		this.experience = experience2;
		this.createdBy = createdBy2;
		this.gender = gender2;
		this.yearOfGraduation = yearOfGraduation2;
		this.courseAlreadyDone = courseAlreadyDone2;
		this.segmentTypeId = segmentTypeId2;
		this.activeStatus = activeStatus2;
		
	}

	public UserProfile(String firstName1, String lastName1, String emailId1, String mobileNo1, String college1,
			String degree1, String branch1, String occupation1, String organisation1, String designation1,
			String domain1, String role1, Integer experience1, String gender1, Integer yearOfGraduation1,
			String coursesAlreadyDone1, String coursesAlreadyDone12, Boolean activeStatus1) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName1;
		this.lastName = lastName1;
		this.email = emailId1;
		this.mobileNumber = mobileNo1;
		this.college = college1;
		this.degree = degree1;
		this.branch = branch1;
		this.occupation = occupation1;
		this.organisation = organisation1;
		this.designation = designation1;
		this.domain = domain1;
		this.role = role1;
		this.experience = experience1;
		this.gender = gender1;
		this.yearOfGraduation = yearOfGraduation1;
		this.courseAlreadyDone = coursesAlreadyDone1;
		this.activeStatus = activeStatus1;
		
	}

	public UserProfile(String firstName2, String lastName2, String emailId, Date birthDate, String mobileNo, String timeSlotsId2,
			String coursesAlreadyDone, int segmetTypeId) {
		// TODO Auto-generated constructor stub
		this.firstName=firstName2;
		this.lastName=lastName2;
		this.email=emailId;
		this.birthDate=birthDate;
		this.mobileNumber=mobileNo;
		this.timeSlotsId=timeSlotsId2;
		this.courseAlreadyDone=coursesAlreadyDone;
		this.segmentTypeId=segmetTypeId;
	}

	public UserProfile(String Name, int userId) {
		// TODO Auto-generated constructor stub
		this.firstName = Name;
		this.userId = userId;
	}

	public UserProfile(int userId) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
	}


	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	 * @return the photo
	 */
	public String getPhotoLocation() {
		return photoLocation;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photoLocation) {
		this.photoLocation = photoLocation;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the securityQuestionId
	 */
	public Integer getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId the securityQuestionId to set
	 */
	public void setSecurityQuestionId(Integer securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the securityAnswer
	 */
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	/**
	 * @param securityAnswer the securityAnswer to set
	 */
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	/**
	 * @return the userCategoryId
	 */
	public Integer getUserCategoryId() {
		return userCategoryId;
	}

	/**
	 * @param userCategoryId the userCategoryId to set
	 */
	public void setUserCategoryId(Integer userCategoryId) {
		this.userCategoryId = userCategoryId;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
		//return null;
	}
	/**
	 * @param gender the gender to set
	 */

	public void setGender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
	}

	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}



	/**
	 * @param securityQuestion the securityQuestion to set
	 */

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}


	public void setPhotoLocation(String photoLocation) {
		this.photoLocation = photoLocation;
	}

	/**
	 * @return the timeSlotsId
	 */

	public String getTimeSlotsId() {
		return timeSlotsId;
	}


	/**
	 * @param timeSlotsId the timeSlotsId to set
	 */

	public void setTimeSlotsId(String timeSlotsId) {
		this.timeSlotsId = timeSlotsId;
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


	public static void setItems(ObservableList<UserProfile> data) {
		// TODO Auto-generated method stub

	}
}
