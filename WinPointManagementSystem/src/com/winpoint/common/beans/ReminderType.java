package com.winpoint.common.beans;

public class ReminderType {
private Integer reminderTypeId;
private String reminderTypeCategory;
public ReminderType(Integer reminderTypeId, String reminderTypeCategory) {
	super();
	this.reminderTypeId = reminderTypeId;
	this.reminderTypeCategory = reminderTypeCategory;
}
public Integer getReminderTypeId() {
	return reminderTypeId;
}
public void setReminderTypeId(Integer reminderTypeId) {
	this.reminderTypeId = reminderTypeId;
}
public String getReminderTypeCategory() {
	return reminderTypeCategory;
}
public void setReminderTypeCategory(String reminderTypeCategory) {
	this.reminderTypeCategory = reminderTypeCategory;
}

}
