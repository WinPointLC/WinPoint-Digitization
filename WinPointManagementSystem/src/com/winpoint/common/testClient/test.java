package com.winpoint.common.testClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.winpoint.common.dao.UserTestDetailsDao;
import com.winpoint.common.helpers.UserTestDetailsHelper;

public class test {

	public static void main(String args[]) {
			
	 System.out.println(reverse(12345));
		
	}

	public static int reverse(int number) {
		
		int reverse = 0;
        int original = number;
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
       
        return reverse;
		
	}
	
}
