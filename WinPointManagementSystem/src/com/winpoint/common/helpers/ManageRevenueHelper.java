package com.winpoint.common.helpers;

import com.winpoint.common.beans.ManageRevenue;
import com.winpoint.common.dao.ManageRevenueDao;


public class ManageRevenueHelper {
	public void getRevenueDetailList(ManageRevenue revenueDetail){
		 new ManageRevenueDao().getRevenueDetailList(revenueDetail);
	}
}
