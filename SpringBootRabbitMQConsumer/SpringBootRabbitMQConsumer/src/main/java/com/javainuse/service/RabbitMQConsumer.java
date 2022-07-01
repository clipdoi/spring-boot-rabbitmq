package com.javainuse.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.javainuse.model.Employee;

@Component
public class RabbitMQConsumer {

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@RabbitListener(queues = "${son.rabbitmq.queue}")
	public void receivedMessage(Employee employee) {
		System.out.println("Received Message From RabbitMQ: " + employee);
	}
}