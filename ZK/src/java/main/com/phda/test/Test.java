package com.phda.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
		
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = sdf.parse("2019-01-27 08:00:00");
		System.out.println(d.getTime());
		System.out.println(System.currentTimeMillis());
		
		System.out.println(new Date(1546691400000l));
		
		
		
		
		
		
	}

}
