package com.winpoint.common.helpers;

import java.util.ArrayList;

import com.winpoint.common.beans.StudentCourseFeesBean;
import com.winpoint.common.dao.FeeDetailsDao;

public class FeeDetailsHelper {
	public ArrayList<StudentCourseFeesBean> getFeeDetails() {
		return new FeeDetailsDao().getFeeDetails();
	}
}
