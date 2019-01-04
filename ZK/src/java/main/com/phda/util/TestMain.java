package com.phda.util;

public class TestMain {

	public static void main(String[] args) {
		
		
		String a ="adb";
		String b = new String(a);
		a ="ad"+"b";
		
		System.out.println(a == b);
		System.out.println(a.equals(b) );

	}

}
