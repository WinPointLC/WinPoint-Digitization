package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.RevenueType;
import com.winpoint.common.dao.RevenueTypeDao;

public class RevenueTypeHelper {

	public List<RevenueType> getRevenueTypeList(){
		return new RevenueTypeDao().getRevenueTypeList();
	}
	
	public void createRevenueTypeList(Object[] newRevenueTypeList) {
		ArrayList<RevenueType> newRevenueTypeArrayList = new ArrayList<>();
		for(Object object: newRevenueTypeList) {
			String string = object.toString();
			newRevenueTypeArrayList.add(new RevenueType(string.substring(1, string.length()-1)));
		}
 
		new RevenueTypeDao().createRevenueTypeList(newRevenueTypeArrayList);
	}
	
	public void deleteRevenueTypeList(Object[] deleteRevenueTypeList) {
		ArrayList<Integer> deleteRevenueTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteRevenueTypeList) {
			deleteRevenueTypeArrayList.add(Integer.parseInt(id.toString()));
		}
		if(deleteRevenueTypeArrayList.size()!=0) {
			new RevenueTypeDao().deleteRevenueTypeList(deleteRevenueTypeArrayList);
		}
	}


}
