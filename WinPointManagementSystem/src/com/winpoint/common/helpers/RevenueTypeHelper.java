package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.dao.RevenueTypeDao;

public class RevenueTypeHelper {

	public List<RevenueType> getRevenueTypeList(){
		return new RevenueTypeDao().getRevenueTypeList();
	}
	
	public void createRevenueTypeList(ArrayList<RevenueType> newRevenueTypeArrayList) {
		 new RevenueTypeDao().createRevenueTypeList(newRevenueTypeArrayList);
	}
	
	public void deleteRevenueTypeList(ArrayList<Integer> deleteRevenueTypeArrayList) {
		 new RevenueTypeDao().deleteRevenueTypeList(deleteRevenueTypeArrayList);
	}


}
