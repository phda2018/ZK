package com.phda.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {

	private Logger log = LoggerFactory.getLogger(TestService.class);
	
	public TestService() {
		log.info("初始化服务层:"+TestService.class.getName());
	}

}
