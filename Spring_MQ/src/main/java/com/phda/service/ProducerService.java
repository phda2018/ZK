package com.phda.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 消息发送服务层
 * 消息模型：点对点模型
 * @author phda
 *
 */
@Service("producerService")
public class ProducerService {

	 @Resource(name="jmsTemplate")
	 private JmsTemplate jmsTemplate;
	 /**
	  * 点对点消息
	  * @param destination
	  * @param msg
	  */
	 public void sendMessage(Destination destination,final String msg){
	        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
	        jmsTemplate.send(destination, new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(msg);
	            }
	        });
	    }

	 /**
	  * 广播消息
	  * @param msg
	  */
	 public void sendMessage(final String msg){
		 	//jmsTemplate.get
		 
	        String destination = jmsTemplate.getDefaultDestinationName();
	        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
	        jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
//	            	session.createMapMessage().setString(name, value);//创建键值对消息
	                return session.createTextMessage(msg);
	            }
	        });
	    }
	
	

}
