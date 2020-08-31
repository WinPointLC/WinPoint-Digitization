package com.winpoint.common.testClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class test {

	public static void main(String args[]) {
	
		HashMap<Integer, String> id = new HashMap<>();

		String courseInterestedIn = "1-A,2-B,3-C,4-D,5-E";
		String array[] = courseInterestedIn.split(",");
		
		for(String s: array) {
			String[] split = s.split("-");
			id.put(Integer.parseInt(split[0]), split[1]);
		}
		
		for(Integer i: id.keySet()) {
			System.out.println(i);
		}
		
	}
}
