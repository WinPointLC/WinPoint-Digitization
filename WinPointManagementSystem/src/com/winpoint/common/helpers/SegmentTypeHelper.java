package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.dao.SegmentTypeDao;


public class SegmentTypeHelper {
	
	public List<SegmentType> getSegmentTypeList() {
		return new SegmentTypeDao().getSegmentTypeList();
	}
	
	public void createSegmentTypeList(Object[] newSegmentTypeList) {
		ArrayList<SegmentType> newSegmentTypeArrayList = new ArrayList<SegmentType>();
		for(Object object: newSegmentTypeList) {
			String string = object.toString();
			newSegmentTypeArrayList.add(new SegmentType(string.substring(1, string.length()-1)));
		}
		 new SegmentTypeDao().createSegmentTypeList(newSegmentTypeArrayList);
	}
	
	public void deleteSegmentTypeList(Object[] deleteSegmentTypeList) {
		ArrayList<Integer> deleteSegmentTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteSegmentTypeList) {
			deleteSegmentTypeArrayList.add(Integer.parseInt(id.toString()));
		}
		if(deleteSegmentTypeArrayList.size()!=0) {
			new SegmentTypeDao().deleteSegmentTypeList(deleteSegmentTypeArrayList);
		}
	}

}
