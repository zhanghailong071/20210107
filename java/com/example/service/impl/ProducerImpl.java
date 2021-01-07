package com.example.service.impl;

import com.example.po.Mail;
import com.example.service.Producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("producer")
public class ProducerImpl implements Producer {
	@Autowired
	RabbitTemplate rabbitTemplate;
	public void sendMail(String queue, Mail mail) {
		rabbitTemplate.setQueue(queue);
		rabbitTemplate.convertAndSend(queue,mail);
	}

}
