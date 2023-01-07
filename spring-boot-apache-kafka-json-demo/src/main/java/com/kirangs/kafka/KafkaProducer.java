package com.kirangs.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kirangs.payload.User;

@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendObjectToTopic(User user) {
		
		
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "firstTopic")
				.build();
		
		kafkaTemplate.send(message);
		
//		kafkaTemplate.send("firstTopic", user);
		
		log.info("Message sent : " + user);
	}

}
