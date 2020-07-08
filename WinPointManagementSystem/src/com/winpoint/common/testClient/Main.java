package com.winpoint.common.testClient;


import com.winpoint.common.dao.PriorityCoursesListDao;

public class Main {

	public static void main(String[] args) {
		new PriorityCoursesListDao().registered();
		
		new PriorityCoursesListDao().preRequisite();
		
	}

}
    