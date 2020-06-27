package com.winpoint.common.wrappers;

import com.winpoint.common.beans.EnquiryDetails;
import com.winpoint.common.beans.UserProfile;

public class CoursesNameWrapper {

	private String fullName;
	private String enquired;
	private String registered;
	
	EnquiryDetails enquiryDetailsObject;
	UserProfile userProfileObject;
	
	public CoursesNameWrapper(String firstName, String lastName, String enquired, String registered) {
		if(enquired.equals("yes"))
		enquiryDetailsObject = new EnquiryDetails(firstName, lastName, enquired, null);
		else
		userProfileObject = new UserProfile(firstName, lastName, null, registered);
		
		fullName = firstName + " " + lastName;
		this.enquired = enquired;
		this.registered = registered;
	}
	
	public String getName() {
		return fullName;
	}
	public void setName(String name) {
		this.fullName = name;
	}
	
	/**
	 * @return the enquiryId
	 */
	public Integer getEnquiryId() {
		return enquiryDetailsObject.getEnquiryId();
	}

	
	/**
	 * @param enquiryId the enquiryId to set
	 */
	public void setEnquiryId(Integer enquiryId) {
		enquiryDetailsObject.setEnquiryId(enquiryId);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return enquiryDetailsObject.getFirstName();
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		enquiryDetailsObject.setFirstName(firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return enquiryDetailsObject.getLastName();
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		enquiryDetailsObject.setLastName(lastName);
		
	}
	
	public String getEnquired() {
		return this.enquired;
	}
	
	public String getRegistered() {
		return this.registered;	
	}
	
}
