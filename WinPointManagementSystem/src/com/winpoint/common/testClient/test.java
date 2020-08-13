package com.winpoint.common.testClient;

public class test {

	public static void main(String args[]) {
	
		System.out.println("Function Call");
		int x = 1;
		String z = "khbvh";
		Boolean b = isInteger(z);
		System.out.println(b);
		System.out.println("End");
		
	}
	public static boolean isInteger(String s) {
	    return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
}
