package com.javainuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${son.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${son.rabbitmq.routingKey}")
	private String routingKey;
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingKey, company);
		System.out.println("Send msg = " + company);
	    
	}
}