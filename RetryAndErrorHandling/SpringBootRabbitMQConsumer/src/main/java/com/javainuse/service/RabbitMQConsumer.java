package com.javainuse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javainuse.exception.InvalidSalaryException;
import com.javainuse.model.Employee;

@Component
public class RabbitMQConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@RabbitListener(queues = "son.queue")
	public void receivedMessage(Employee employee) throws InvalidSalaryException {
		logger.info("Received Message From RabbitMQ: " + employee);
		if (employee.getSalary() < 0) {
			throw new InvalidSalaryException();
		}
	}
}