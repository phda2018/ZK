package com.phda.proxy;

public class Programer implements Common {

	private static String role = "程序员";
	
	
	@Override
	public void Code(String role) {
		// TODO Auto-generated method stub
		System.out.println(Programer.role+" 写代码");
	}

	@Override
	public void Hello(String role) {
		// TODO Auto-generated method stub
		System.out.println(Programer.role+" 问候客户");
	}

}
