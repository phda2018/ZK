package com.phda.filter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class MQListenter05 implements MessageListener{

	private String className = MQListenter05.class.getName();
	
	Logger log = LoggerFactory.getLogger(MQListenter05.class);
	
	public MQListenter05() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMessage(Message message) {
		//message.getStringProperty("dd")
		try {
			ActiveMQTextMessage textMsg  = (ActiveMQTextMessage)message;;
			String text = textMsg.getText();
			log.info("整个消息对象:["+className+"]"+JSONObject.toJSONString(text));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
