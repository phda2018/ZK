package com.phda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class BaseController {
	
	protected void responseContent(HttpServletResponse resp,Object content) {
		resp.setContentType("text/plain");
		try {
			PrintWriter pw = resp.getWriter();
			pw.print(JSONObject.toJSONString(content));
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
