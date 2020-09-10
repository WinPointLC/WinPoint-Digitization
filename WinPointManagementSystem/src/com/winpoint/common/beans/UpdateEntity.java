package com.winpoint.common.beans;

public class UpdateEntity {

	Object addRows[];
	int delRowIds[];
	
	public UpdateEntity() {
		
	}
	public UpdateEntity(Object[] addRows, int[] delRowIds) {
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
	public int[] getDelRowIds() {
		return delRowIds;
	}
	public void setDelRowIds(int[] delRowIds) {
		this.delRowIds = delRowIds;
	}
	
}
