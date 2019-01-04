package com.phda.controller;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phda.service.ProducerService;
import com.phda.service.ProducerService02;

@Controller
// @RestController
//@RequestMapping(value="/")
public class MQController {
	private Logger log = LoggerFactory.getLogger(MQController.class);
	
	@Resource
	private ProducerService producer;
	@Resource
	private ProducerService02 producer02;
	
	/**
	 * 进入消息发送页面
	 * @return
	 */
	@RequestMapping(value="/index")
	public String sendMQ() {
		return "hello";
	}
	
	@RequestMapping(value="/sendMessage")
	public @ResponseBody String sendMessage(@RequestParam("msg")String msg,
											@RequestParam("type")String type) {
		
		log.info("发送消息:"+msg+" "+type);
		if("pointToPoint".equals(type)) {
			log.info("消息模型:pointToPoint");
			producer.sendMessage(msg);//采用默认Destination发送消息
		}else {
			log.info("消息模型:pub/sub");
			producer02.sendMessage(msg);//采用默认Destination发送消息
		}
		//向指定队列发送消息
//		ActiveMQQueue queue = new ActiveMQQueue("phda_mq");
//		msg="第二种消息";
//		producer.sendMessage(queue, msg);
		
		return "hello";
	}
	
	
	
	
	
	
	


}
