package com.phda.proxy;

public class Teacher implements Common {

	private static String role = "老师";
	
	@Override
	public void Code(String role) {
		
		System.out.println(Teacher.role+" 写课件");

	}

	@Override
	public void Hello(String role) {
		// TODO Auto-generated method stub
		System.out.println(Teacher.role+" hello,everyone");
	}

}
