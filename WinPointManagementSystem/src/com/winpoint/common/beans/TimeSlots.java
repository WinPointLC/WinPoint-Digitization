package com.winpoint.common.beans;

public class TimeSlots {
	private Integer timeSlotsId;
	private String timeSlotsDescription;
	
	/**
	 * 
	 * @param timeSlotsId
	 * @param timeSlotsDescription
	 */
	
	public TimeSlots(Integer timeSlotsId, String timeSlotsDescription) {
		super();
		this.timeSlotsId = timeSlotsId;
		this.timeSlotsDescription = timeSlotsDescription;
	}
	
	/**
	 * @return the timeSlotsId
	 */
	public Integer getTimeSlotsId() {
		return timeSlotsId;
	}

	/* @param timeSlotsId the timeSlotsId to set
	 * 
	 */
	public void setTimeSlotsId(Integer timeSlotsId) {
		this.timeSlotsId = timeSlotsId;
	}

	/**
	 * @return the timeSlotsDescription
	 */
	public String getTimeSlotsDescription() {
		return timeSlotsDescription;
	}

	/* @param timeSlotsDescription the timeSlotsDescription to set
	 * 
	 */
	public void setTimeSlotsDescription(String timeSlotsDescription) {
		this.timeSlotsDescription = timeSlotsDescription;
	}
	
	
	
	
	

}
