package com.winpoint.common.beans;

public class UpdateEntity {

	Object addRows[];
	Integer delRowIds[];
	
	public UpdateEntity() {
		
	}
	public UpdateEntity(Object[] addRows, Integer[] delRowIds) {
		super();
		this.addRows = addRows;
		this.delRowIds = delRowIds;
	}
	public Object[] getAddRows() {
		return addRows;
	}
	public void setAddRows(Object[] addRows) {
		this.addRows = addRows;
	}
	public Integer[] getDelRowIds() {
		return delRowIds;
	}
	public void setDelRowIds(Integer[] delRowIds) {
		this.delRowIds = delRowIds;
	}
	
}
