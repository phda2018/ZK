package com.phda.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {

	public InetTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws UnknownHostException {
		
		Inet4Address inet4 =(Inet4Address)InetAddress.getByName("www.baidu.com");
		
		System.out.println(inet4.getHostAddress()+" local:"+inet4.getLocalHost());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		
		
	}
	
	
}
