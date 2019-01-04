package com.phda.filter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class MQListenter implements MessageListener{

	Logger log = LoggerFactory.getLogger(MQListenter.class);
	private String className = MQListenter.class.getName();
	
	public MQListenter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMessage(Message message) {
		//message.getStringProperty("dd")
		try {
			
			message.getJMSType();
			ActiveMQTextMessage textMsg  = (ActiveMQTextMessage)message;;
			String text = textMsg.getText();
			log.info("整个消息对象:["+className+"]"+JSONObject.toJSONString(text));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
