package com.phda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("testController")
@RequestMapping(value="/phda")
public class TestController extends BaseController {
	
	private Logger log = LoggerFactory.getLogger(TestController.class);
	
	@ResponseBody
	@RequestMapping(value="/sayHello")
	public void sayHello(HttpServletRequest req,HttpServletResponse resp) {
		log.info("调用sayHello");
		this.responseContent(resp, "hello");
	}
	
	
	
}
