package com.kirangs.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kirangs.payload.User;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "firstTopic", groupId = "myGroup")
	public void consumeObjectFromTopic(User user) {

		log.info("Message Received : " + user);
	}

}
