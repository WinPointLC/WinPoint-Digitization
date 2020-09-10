package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.dao.SegmentTypeDao;


public class SegmentTypeHelper {
	
	public List<SegmentType> getSegmentTypeList() {
		return new SegmentTypeDao().getSegmentTypeList();
	}
	
	public void createSegmentTypeList(ArrayList<SegmentType> newSegmentTypeArrayList) {
		 new SegmentTypeDao().createSegmentTypeList(newSegmentTypeArrayList);
	}
	
	public void deleteSegmentTypeList(ArrayList<Integer> deleteSegmentTypeArrayList) {
		new SegmentTypeDao().deleteSegmentTypeList(deleteSegmentTypeArrayList);
	}

}
