package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.SegmentType;
import com.winpoint.common.dao.SegmentTypeDao;


public class SegmentTypeHelper {
	
	public List<SegmentType> getSegmentTypeList() {
		return new SegmentTypeDao().getSegmentTypeList();
	}
	
}
