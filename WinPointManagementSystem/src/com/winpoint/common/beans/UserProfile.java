package com.winpoint.common.beans;

import java.util.Date;

import javafx.collections.ObservableList;

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
	private Integer timeSlotsId;
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
	
	
	
	public UserProfile(String firstName,  String email, String mobileNumber) {
		super();
		
		this.firstName = firstName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	
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
		/*this.createdBy = createdBy;
		this.createDate = createDate;*/
	}

//	public UserProfile(String email, String password) {
//		// TODO Auto-generated constructor stub
//		this.email = email;
//		this.password = password;
//	}

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
	
	
	public UserProfile(Integer userId, String firstName, String lastName, String email, String mobileNumber,
			String address, Date birthDate, String college, String degree, String branch, Integer yearOfGraduation,
			String photoLocation, String password, String gender, Integer securityQuestionId, String securityQuestion,
			String securityAnswer, Integer userCategoryId, String occupation, String organisation, String designation,
			String domain, String role, Integer experience, Integer createdBy, Date createDate, Integer timeSlotsId,
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

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
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
